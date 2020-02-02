package lv.citadele.mailsender.email;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lv.citadele.mailsender.data.paymentform.PaymentFormData;
import org.junit.jupiter.api.Test;

import static lv.citadele.mailsender.data.paymentform.BeneficiaryBuilder.aBeneficiary;
import static lv.citadele.mailsender.data.paymentform.PaymentFormDataBuilder.aPaymentFormData;
import static lv.citadele.mailsender.data.paymentform.RemitterBuilder.aRemitter;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class EMailServiceTest {

    @Test
    public void checkJsonContent() throws JsonProcessingException {
        PaymentFormData date = aPaymentFormData()
                .withBeneficiary(
                        aBeneficiary()
                                .withAccountNumber("ACC532959235")
                                .withBankCode("LV94UNLA494")
                                .withBankName("MegaBank Ltd.")
                                .withBeneficiaryName("Boris Moiseev")
                                .withRegistrationNumber("REG5342523")
                                .build())
                .withRemitter(aRemitter()
                        .withAccountNumber("ACC3325235")
                        .withRemitterName("Leonid Agutin")
                        .withCode("CD34523")
                        .build())
                .withCurrentDate("9 января 2020")
                .withCustomerNumber("053252359")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(date);

        assertThat(result, is("{\"customerNumber\":\"053252359\",\"currentDate\":\"9 января 2020\",\"remitter\":{\"remitterName\":\"Leonid Agutin\",\"code\":\"CD34523\",\"accountNumber\":\"ACC3325235\"},\"beneficiary\":{\"beneficiaryName\":\"Boris Moiseev\",\"registrationNumber\":\"REG5342523\",\"accountNumber\":\"ACC532959235\",\"residenceCountry\":null,\"bankName\":\"MegaBank Ltd.\",\"bankCode\":\"LV94UNLA494\"}}"));
    }

}