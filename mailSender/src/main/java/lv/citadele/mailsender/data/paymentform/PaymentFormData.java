package lv.citadele.mailsender.data.paymentform;

public class PaymentFormData {

    private String customerNumber;
    private String currentDate;
    private Remitter remitter;
    private Beneficiary beneficiary;

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public Remitter getRemitter() {
        return remitter;
    }

    public void setRemitter(Remitter remitter) {
        this.remitter = remitter;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }
}
