package lv.citadele.mailsender.data.paymentform;

import java.util.Objects;

public class Remitter {

    private String remitterName;
    private String code;
    private String accountNumber;

    public String getRemitterName() {
        return remitterName;
    }

    public void setRemitterName(String remitterName) {
        this.remitterName = remitterName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Remitter remitter = (Remitter) o;
        return Objects.equals(remitterName, remitter.remitterName) &&
                Objects.equals(code, remitter.code) &&
                Objects.equals(accountNumber, remitter.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(remitterName, code, accountNumber);
    }

    @Override
    public String toString() {
        return "Remitter{" +
                "name='" + remitterName + '\'' +
                ", code='" + code + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
