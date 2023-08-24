package opgave2_example1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Indtast et tal: ");
        double heltTal = in.nextDouble();
        System.out.println("Indtast et tal");
        if (heltTal > 0) {
            System.out.println("positiv");
        } else if (heltTal == 0) {
            System.out.println("nul");
        } else if (heltTal < 0) {
            System.out.println("negativt");
        }

    }
}
