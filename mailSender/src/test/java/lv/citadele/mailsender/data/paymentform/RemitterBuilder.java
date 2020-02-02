package lv.citadele.mailsender.data.paymentform;

public final class RemitterBuilder {
    private String remitterName;
    private String code;
    private String accountNumber;

    private RemitterBuilder() {
    }

    public static RemitterBuilder aRemitter() {
        return new RemitterBuilder();
    }

    public RemitterBuilder withRemitterName(String remitterName) {
        this.remitterName = remitterName;
        return this;
    }

    public RemitterBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public RemitterBuilder withAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public Remitter build() {
        Remitter remitter = new Remitter();
        remitter.setRemitterName(remitterName);
        remitter.setCode(code);
        remitter.setAccountNumber(accountNumber);
        return remitter;
    }
}
