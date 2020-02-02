package lv.citadele.mailsender.data.paymentform;

import java.util.Objects;

public class Beneficiary {

    private String beneficiaryName;
    private String registrationNumber;
    private String accountNumber;
    private String residenceCountry;
    private String bankName;
    private String bankCode;

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getResidenceCountry() {
        return residenceCountry;
    }

    public void setResidenceCountry(String residenceCountry) {
        this.residenceCountry = residenceCountry;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beneficiary that = (Beneficiary) o;
        return Objects.equals(beneficiaryName, that.beneficiaryName) &&
                Objects.equals(registrationNumber, that.registrationNumber) &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(residenceCountry, that.residenceCountry) &&
                Objects.equals(bankName, that.bankName) &&
                Objects.equals(bankCode, that.bankCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beneficiaryName, registrationNumber, accountNumber, residenceCountry, bankName, bankCode);
    }

    @Override
    public String toString() {
        return "Beneficiary{" +
                "name='" + beneficiaryName + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", residenceCountry='" + residenceCountry + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankCode='" + bankCode + '\'' +
                '}';
    }
}
