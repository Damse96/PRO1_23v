package opgave2_6_rigtig;

import java.util.Scanner;

public class opgave2_6 {


    public static void main(String[] args) {
      //side 93 i pro bogen

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int sum = num%10 + num/10%10+num/100;
        System.out.println(sum);



    }
}
