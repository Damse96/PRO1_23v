package aflevering;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("indtast klassens navn: ");
        String navn = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Indtast løn: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("indtast alder: ");
        int alder = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Jespers nye løn er: ");
        if (alder >= 50) {
            System.out.println(salary = salary * 1.10);
        } else if (alder >= 35 && alder <= 50) {
            System.out.println(salary = salary * 1.08);
        } else if (alder <= 35) {
            System.out.println(salary = salary * 1.05);
        }
    }
}