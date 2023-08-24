package opgave7;

import java.util.Scanner;

public class Main {
    public static String inOrder(int heltTal, int heltTal1, int heltTal2) {
       String tal = "";
        if (heltTal < heltTal1 && heltTal1 < heltTal2) {
            System.out.println("de her tal er voksende");
        } else if (heltTal > heltTal1 && heltTal1 > heltTal2) {
            System.out.println("de her tal er faldende");
        } else if (heltTal < heltTal1 && heltTal1 > heltTal2) {
            System.out.println("de her tal er Hverken eller");
        }
        return tal;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //System.out.println("Indtast et tal");
        //double heltTal = in.nextDouble();
        //System.out.println("indtast nr to tal");
        //double heltTal1 = in.nextDouble();
        //System.out.println("indtast nr 3 tal");
       // double heltTal2 = in.nextDouble();
        int tal1 = in.nextInt();
        int tal2 = in.nextInt();
        int tal3 = in.nextInt();

        System.out.println(" hvis tallene er 5, 6, 7 " + inOrder(tal1, tal2, tal3));
    }
}
