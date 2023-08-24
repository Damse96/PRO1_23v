package opgave3_insertionSort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Indtast et tal");
        double heltTal = in.nextDouble();
        System.out.println("indtast nr to tal");
        double heltTal1 = in.nextDouble();
        System.out.println("indtast nr 3 tal");
        double heltTal2 = in.nextDouble();
        if (heltTal < heltTal1 && heltTal1 < heltTal2 ) {
            System.out.println("voksende");
        } else if (heltTal > heltTal1 && heltTal1 > heltTal2) {
            System.out.println("faldende");
        } else if (heltTal < heltTal1 && heltTal1 > heltTal2) {
            System.out.println("Hverken eller");
        }

    }
}
