import org.example.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BankAccountAssertionsTest")
public class BankAccountAssertionsTest {
    @Test
    @DisplayName("Withdraw 500 successfully")
    public void testwithdraw(){
        BankAccount bankAccount = new BankAccount(500,-1000);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }
    @Test
    @DisplayName("Deposit 400 successfully")
    public void testDeposit(){
        BankAccount bankAccount = new BankAccount(400,0);
        bankAccount.deposit(500);
        assertEquals(900, bankAccount.getBalance());
    }
    @Test
    @DisplayName("WithdrawNotStuckAtZero")
    public void testWithdrawNotStuckAtZero(){
        BankAccount bankAccount = new BankAccount(500,-1000);
        bankAccount.withdraw(800);
        assertNotEquals(0, bankAccount.getBalance());
    }
    @Test
    @DisplayName("Test activation account after creation")
    public void testActive()
    {
        BankAccount bankAccount = new BankAccount(500,0);
        assertTrue(bankAccount.isActive());
    }
    @Test
    @DisplayName("Test set holder name")
    public void testHolderNameSet(){
        BankAccount bankAccount = new BankAccount(500, 0);
        bankAccount.setHolderName("Maaike");
        assertNotNull(bankAccount.getHolderName());
    }
    public void testNotWithdrawMinimum(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000));
    }
    @Test
    @DisplayName("Test no exceptions for withdraw and deposit")
   public void testWithdrawAndDepositWithoutExceptions(){
       BankAccount bankAccount = new BankAccount(500, -1000);
       //fail();
       assertAll(() -> bankAccount.deposit(200), () -> bankAccount.withdraw(450));
   }
   @Test
   @DisplayName("Test Speed deposit")
   public void testDepositTimeout(){
       BankAccount bankAccount = new BankAccount(400, 0);
       assertTimeout(Duration.ofNanos(10), () -> bankAccount.deposit(200));
       //assertEquals(0.33, 1/3, 0.01);
       //assertEquals(0.33, 1/3, "OOPS something went wrong!");


   }
}
