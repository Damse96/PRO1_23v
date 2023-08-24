package opgave2_23;

import java.util.Scanner;

public class opgave2_23 {


    public static void main(String[] args) {
      //side 93 i pro bogen

        Scanner in = new Scanner(System.in);
        System.out.println("distance fx 900");
        double distance = in.nextDouble();
        System.out.println("mil pr. gallon");
        double MPG = in.nextDouble();
        System.out.println("Pris pr gallon");
        double PPG = in.nextDouble();
        double totalPris = (distance / MPG) * PPG;
        System.out.println("totalpris er " + totalPris);



    }
}
