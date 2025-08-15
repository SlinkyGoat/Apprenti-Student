public class BankAccount {

    private String owner;
    private double balance;

    /*
    -------------------
    CONSTRUCTORS
    -------------------
     */
    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    /*
    -------------------
    GETTERS & SETTERS
    -------------------
     */
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    /*
    -------------------
    CUSTOM METHODS
    -------------------
     */
    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        if(balance - amount > 0){
            balance -= amount;
        }
    }

}
