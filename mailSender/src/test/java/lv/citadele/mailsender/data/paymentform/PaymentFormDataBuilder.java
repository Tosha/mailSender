package lv.citadele.mailsender.data.paymentform;

public final class PaymentFormDataBuilder {
    private String customerNumber;
    private String currentDate;
    private Remitter remitter;
    private Beneficiary beneficiary;

    private PaymentFormDataBuilder() {
    }

    public static PaymentFormDataBuilder aPaymentFormData() {
        return new PaymentFormDataBuilder();
    }

    public PaymentFormDataBuilder withCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
        return this;
    }

    public PaymentFormDataBuilder withCurrentDate(String currentDate) {
        this.currentDate = currentDate;
        return this;
    }

    public PaymentFormDataBuilder withRemitter(Remitter remitter) {
        this.remitter = remitter;
        return this;
    }

    public PaymentFormDataBuilder withBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
        return this;
    }

    public PaymentFormData build() {
        PaymentFormData paymentFormData = new PaymentFormData();
        paymentFormData.setCustomerNumber(customerNumber);
        paymentFormData.setCurrentDate(currentDate);
        paymentFormData.setRemitter(remitter);
        paymentFormData.setBeneficiary(beneficiary);
        return paymentFormData;
    }
}
