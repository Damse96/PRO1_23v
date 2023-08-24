package konto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Account[] accounts = mirakel();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("ATM Main menu");
            System.out.println("-------------");
            System.out.println("Enter an account id:");
            int x = input.nextInt();
            System.out.println("1: check balance");
            System.out.println("2: withdraw");
            System.out.println("3: deposit");
            System.out.println("4: exit");
            System.out.println("Enter a choice: ");
            if (input.nextInt() == 1) {
                System.out.println(accounts[x].getBalance());
            } else if (input.nextInt() == 2) {
                System.out.println("Enter amount to withdraw: ");
                accounts[x].withdraw(input.nextInt());
                System.out.println("Your balance is now :" + accounts[x].getBalance());
            } else if (input.nextInt() == 3) {
                System.out.println("Enter amount to deposit: ");
                accounts[x].deposit(input.nextInt());
                System.out.println("Your balance is now :" + accounts[x].getBalance());
            } else if (input.nextInt() == 4) {
                return;
            }
        }
    }

    public static Account[] mirakel() {
        Account[] accounts = new Account[11];
        for (int i = 1; i < accounts.length; i++) {
            Account a = new Account(i, 100, 1.3, LocalDate.now());
            accounts[i] = a;
            System.out.println(a);
        }
        return accounts;
    }

}