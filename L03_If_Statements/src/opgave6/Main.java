package opgave6;

import java.util.Scanner;

public class Main {
    public static String sign(int heltTal){
        String tal = " ";
        if (heltTal > 0) {
            tal = "positiv";
        } else if (heltTal == 0) {
            tal = "nul";
        } else if (heltTal < 0) {
            tal = "negativt";
        }
        return tal;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Indtast et tal");
        int heltTal = in.nextInt();

        System.out.println(" tallet 2 er " + sign(heltTal));
        System.out.println(" tallet -4 er " + sign(heltTal));
        System.out.println(" tallet 0 er "+ sign(heltTal));

    }
}
