package opgave2_7;

import java.util.Scanner;

public class opgave2_7 {


    public static void main(String[] args) {
      //side 93 i pro bogen
        int minPrYear = 525600;
        Scanner in = new Scanner(System.in);
        int min = in.nextInt();
        int years = min / minPrYear;
        int minRem = min%years;
        System.out.println(minRem);


    }
}
