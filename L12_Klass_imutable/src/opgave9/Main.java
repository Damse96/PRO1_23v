package opgave9;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(1,1000,1.2, LocalDate.now());

        System.out.println(account.monthlyInterest(1.2));

        System.out.println(account.withdraw(500));

        System.out.println(account.deposit(1000));
    }
}