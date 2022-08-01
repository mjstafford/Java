

public class BankAccountTest {
    public static void main(String[] args){
        BankAccount bankAccount1 = new BankAccount();
        BankAccount bankAccount2 = new BankAccount();

        bankAccount1.makeDeposit("checking", 100);
        bankAccount1.makeDeposit("savings", 500);

        bankAccount2.makeDeposit("checking", 2000);
        bankAccount2.makeDeposit("savings", 1000);

        System.out.println(bankAccount1.getCheckingBalance());
        System.out.println(bankAccount1.getSavingsBalance());

        System.out.println(bankAccount2.getCheckingBalance());
        System.out.println(bankAccount2.getSavingsBalance());

        System.out.println(BankAccount.getTotalAccountBalance());
        System.out.println(BankAccount.getAccountCount());

        System.out.println(bankAccount1.getAccountNumber());
        System.out.println(bankAccount2.getAccountNumber());
    }
}