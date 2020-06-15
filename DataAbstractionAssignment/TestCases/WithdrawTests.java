import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

public class WithdrawTests {
    Withdraw testWithdraw;
    double amount;
    Date date;
    String account;

    @Before
    public void setup(){
        amount = 10;
        date = new Date();
        account = Customer.CHECKING;

        testWithdraw = new Withdraw(amount, date, account);
    }

    @Test
    public void testToString(){
        String withdrawString = testWithdraw.toString();
        assertEquals("Withdraw of: $" + amount + " Date: " + date + " from account: " + account, withdrawString);
    }
}
