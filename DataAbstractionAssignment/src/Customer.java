import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<Deposit>();
    private ArrayList<Withdraw> withdraws = new ArrayList<Withdraw>();
    private double checkBalance = 0;
    private double savingBalance = 0;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;
    // not used
    private double savingRate;

    // NOTE: we do not want to create a customer with an existing balance,
    // but instead initiate account with 0 balance.
    // also, every account must have a name and account number, thus, there
    // is no default constructor
    Customer(String name, int accountNumber){
        this.accountNumber = accountNumber;
        this.name = name;
    }

    // Requires: double amount, Date date, String account
    // Modifies: adds deposit to this.deposits, updates this.balance
    // Effects: returns balance
    public double deposit(double amt, Date date, String account){
        this.deposits.add(new Deposit(amt, date, account));
        if (account == CHECKING) {
            checkBalance += amt;
        } else if (account == SAVING) {
            savingBalance += amt;
        }

        return account == CHECKING ? checkBalance : savingBalance;
    }

    // Requires: double amount, Date date, String account
    // Modifies: adds withdraw to this.withdraws, updates this.balance, only if checkOverdraft is false
    // Effects: returns balance
    public double withdraw(double amt, Date date, String account){
        if (this.checkOverdraft(amt, account)) {
            return account == CHECKING ? checkBalance : savingBalance;
        }

        this.withdraws.add(new Withdraw(amt, date, account));

        if (account == CHECKING) {
            checkBalance -= amt;
        } else if (account == SAVING) {
            savingBalance -= amt;
        }

        return account == CHECKING ? checkBalance : savingBalance;
    }

    // Requires: double amt, String account
    // Modifies: nothing
    // Effects: returns boolean true if balance - amount smaller than OVERDRAFT
    private boolean checkOverdraft(double amt, String account){
        //your code here
        return ((account == CHECKING ? checkBalance : savingBalance) - amt) < OVERDRAFT;
    }

    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }

    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }
}
