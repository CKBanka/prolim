package bankapp.model;

public abstract class BankAccount {
    protected String accountNumber;
    protected String accountHolderName;
    
    public BankAccount(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
    }
    
    public abstract double calculateInterest();
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolderName() {
        return accountHolderName;
    }
}
