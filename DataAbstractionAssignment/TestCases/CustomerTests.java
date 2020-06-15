import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CustomerTests {
    Deposit testDeposit;
    Withdraw testWithdraw;
    double amount;
    Date date;
    Customer customer;

    @Before
    public void setup(){
        amount = Math.floor(Math.random() * 10000) / 100;
        date = new Date();

        customer = new Customer("John", 12345);
    }

    @Test
    public void testDepositWhenBlankChecking(){
        assertEquals(amount, customer.deposit(amount, date, Customer.CHECKING), 0);
    }

    @Test
    public void testDepositTwiceChecking(){
        customer.deposit(amount, date, Customer.CHECKING);
        assertEquals(amount * 2, customer.deposit(amount, date, Customer.CHECKING), 0);
    }

    @Test
    public void testWithdrawWhenBlankChecking(){
        assertEquals(-1 * amount, customer.withdraw(amount, date, Customer.CHECKING), 0);
    }

    @Test
    public void testWithdrawTwiceChecking(){
        customer.deposit(amount, date, Customer.CHECKING);
        assertEquals(0, customer.withdraw(amount, date, Customer.CHECKING), 0);
        assertEquals(-1 * amount, customer.withdraw(amount, date, Customer.CHECKING), 0);
    }

    @Test
    public void testWithdrawOverdraftChecking(){
        assertEquals(0, customer.withdraw(101, date, Customer.CHECKING), 0);
    }

    @Test
    public void testDepositWhenBlankSaving(){
        assertEquals(amount, customer.deposit(amount, date, Customer.SAVING), 0);
    }

    @Test
    public void testDepositTwiceSaving(){
        customer.deposit(amount, date, Customer.SAVING);
        assertEquals(amount * 2, customer.deposit(amount, date, Customer.SAVING), 0);
    }

    @Test
    public void testWithdrawWhenBlankSaving(){
        assertEquals(-1 * amount, customer.withdraw(amount, date, Customer.SAVING), 0);
    }

    @Test
    public void testWithdrawTwiceSaving(){
        customer.deposit(amount, date, Customer.SAVING);
        assertEquals(0, customer.withdraw(amount, date, Customer.SAVING), 0);
        assertEquals(-1 * amount, customer.withdraw(amount, date, Customer.SAVING), 0);
    }

    @Test
    public void testWithdrawOverdraftSaving(){
        assertEquals(0, customer.withdraw(101, date, Customer.SAVING), 0);
    }
}
