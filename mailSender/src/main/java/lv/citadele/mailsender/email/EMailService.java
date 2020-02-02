package lv.citadele.mailsender.email;

import com.itextpdf.text.DocumentException;
import lv.citadele.mailsender.data.paymentform.PaymentFormData;
import lv.citadele.mailsender.exception.EMailException;
import lv.citadele.mailsender.exception.PDFGenerationException;
import lv.citadele.mailsender.textprocessor.HTMLGenerator;
import lv.citadele.mailsender.textprocessor.PdfGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

@Component
public class EMailService {

    public static final String ATTACHED_FILE_NAME = "payment_form.pdf";

    @Autowired private PdfGenerationService pdfGenerationService;
    @Autowired private HTMLGenerator htmlProcessor;
    @Autowired private EmailConfiguration emailConfiguration;

    public void send(PaymentFormData data) {
        JavaMailSenderImpl mailSender = initializeEmailSender();
        mailSender.send(getEmailMessageWithAttachment(mailSender, data));
    }

    private JavaMailSenderImpl initializeEmailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailConfiguration.getHost());
        mailSender.setPort(emailConfiguration.getPort());
        mailSender.setUsername(emailConfiguration.getUserName());
        mailSender.setPassword(emailConfiguration.getPassword());
        initializeEmailSenderProperties(mailSender);
        return mailSender;
    }

    private void initializeEmailSenderProperties(JavaMailSenderImpl mailSender) {
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
    }

    private MimeMessage getEmailMessageWithAttachment(JavaMailSenderImpl mailSender, PaymentFormData data) {
        try {
            MimeMessage msg = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            populateEmailMetadata(helper);

            String path = htmlProcessor.generateHtmlWithAttributes(data);
            String pdfPath = pdfGenerationService.generatePDFFromHTML(path);
            helper.addAttachment(ATTACHED_FILE_NAME, new File(pdfPath));
            return msg;
        } catch (MessagingException e) {
            throw new EMailException("EMail sender initialization failed");
        }
    }

    private void populateEmailMetadata(MimeMessageHelper helper) throws MessagingException {
        helper.setFrom("info@citadele.lv");
        helper.setTo("zemskovsantons@mail.com");
        helper.setSubject("New payment information");
        helper.setText("Please check the payment information in the attachment.");
    }

}
