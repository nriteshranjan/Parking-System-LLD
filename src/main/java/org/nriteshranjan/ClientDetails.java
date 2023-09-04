package org.nriteshranjan;

public final class ClientDetails {

    private final String clientName;
    private final String bankName;
    private final String accountNumber;
    private final String ifscCode;

    public ClientDetails(String clientName, String bankName, String accountNumber, String ifscCode) {
        this.clientName = clientName;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
    }

    public String getClientName() {
        return clientName;
    }

    public String getBankName() {
        return bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    @Override
    public String toString() {
        return "ClientDetails{" + "clientName='" + clientName + '\'' + ", bankName='" + bankName + '\'' + ", accountNumber='" + accountNumber + '\'' + ", ifscCode='" + ifscCode + '\'' + '}';
    }
}
