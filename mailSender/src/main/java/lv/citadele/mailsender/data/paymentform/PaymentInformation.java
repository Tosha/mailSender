package lv.citadele.mailsender.data.paymentform;

import java.util.Objects;

public class PaymentInformation {

    private String amountAndCurrency;
    private String bankFee;
    private String amountInWords;
    private String paymentType;
    private String exchangeRate;
    private String valueDate;
    private String codeOfExternalPayment;
    private String paymentDetails;

    public String getAmountAndCurrency() {
        return amountAndCurrency;
    }

    public void setAmountAndCurrency(String amountAndCurrency) {
        this.amountAndCurrency = amountAndCurrency;
    }

    public String getBankFee() {
        return bankFee;
    }

    public void setBankFee(String bankFee) {
        this.bankFee = bankFee;
    }

    public String getAmountInWords() {
        return amountInWords;
    }

    public void setAmountInWords(String amountInWords) {
        this.amountInWords = amountInWords;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public String getCodeOfExternalPayment() {
        return codeOfExternalPayment;
    }

    public void setCodeOfExternalPayment(String codeOfExternalPayment) {
        this.codeOfExternalPayment = codeOfExternalPayment;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentInformation that = (PaymentInformation) o;
        return Objects.equals(amountAndCurrency, that.amountAndCurrency) &&
                Objects.equals(bankFee, that.bankFee) &&
                Objects.equals(amountInWords, that.amountInWords) &&
                Objects.equals(paymentType, that.paymentType) &&
                Objects.equals(exchangeRate, that.exchangeRate) &&
                Objects.equals(valueDate, that.valueDate) &&
                Objects.equals(codeOfExternalPayment, that.codeOfExternalPayment) &&
                Objects.equals(paymentDetails, that.paymentDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountAndCurrency, bankFee, amountInWords, paymentType, exchangeRate, valueDate, codeOfExternalPayment, paymentDetails);
    }

    @Override
    public String toString() {
        return "PaymentInformation{" +
                "amountAndCurrency='" + amountAndCurrency + '\'' +
                ", bankFee='" + bankFee + '\'' +
                ", amountInWords='" + amountInWords + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", exchangeRate='" + exchangeRate + '\'' +
                ", valueDate='" + valueDate + '\'' +
                ", codeOfExternalPayment='" + codeOfExternalPayment + '\'' +
                ", paymentDetails='" + paymentDetails + '\'' +
                '}';
    }
}
