package lv.citadele.mailsender.textprocessor;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import lv.citadele.mailsender.data.paymentform.PaymentFormData;
import lv.citadele.mailsender.exception.HTMLGenerationException;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class HTMLGenerator {

    public static final String TEMPLATE_LOCATION = "templates/payment_form_template.mustache";
    public static final String TEMPORARY_FILE_NAME = "temp";

    public String generateHtmlWithAttributes(PaymentFormData data) {
        try {
            File temp = File.createTempFile(TEMPORARY_FILE_NAME, Long.toString(System.nanoTime()));
            try (Writer writer = new FileWriter(temp.getPath())) {
                MustacheFactory mf = new DefaultMustacheFactory();
                Mustache mustache = mf.compile(TEMPLATE_LOCATION);
                mustache.execute(writer, data);
            }
            return temp.getPath();
        } catch (IOException e) {
            throw new HTMLGenerationException("HTML generation failed");
        }
    }

}
