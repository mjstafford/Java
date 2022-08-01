import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private int accountNumber;
    private static int accountCount;
    private static double totalAccountBalance;

    public BankAccount(){
        accountCount++;
        this.setRandAccountNumber();
    }

    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    public void makeDeposit(String accountType, double amount){
        if(accountType.equals("checking")){
            this.checkingBalance += amount;
        }else if (accountType.equals("savings")){
            this.savingsBalance += amount;
        }
        //increase totalAccountBalance on any deposit
        totalAccountBalance += amount;
    }

    public static double getTotalAccountBalance(){
        return totalAccountBalance;
    }

    public static int getAccountCount(){
        return accountCount;
    }

    private void setRandAccountNumber(){
        Random random = new Random();
        this.accountNumber = random.nextInt(999999999) + 1000000000;
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }
}