package lv.citadele.mailsender.rest;

import lv.citadele.mailsender.email.EMailService;
import lv.citadele.mailsender.data.paymentform.PaymentFormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailSenderRestResource {

    @Autowired private EMailService service;

    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody PaymentFormData data) {
        service.send(data);
    }

}
