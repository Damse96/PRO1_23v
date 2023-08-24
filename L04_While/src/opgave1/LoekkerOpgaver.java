package opgave1;

import java.util.Scanner;

public class LoekkerOpgaver {


//        Kald af metoder der afprøver opgave 1

//        System.out.println(summerEven(100));
//        System.out.println(summerSquare(10));
//        System.out.println(sumOdd(3, 19));
//        allPowers(20);


    // Metoden returnerer summen af alle lige tal mellem 2 og n
    public static int summerEven(int n) {
        int sum = 0;
        int i = 2;
        while (i <= n){
            i++;
            if (i%2 == 0){
                sum = sum + i;
            }
        }
        return sum;
    }

    // Metoden returnerer summen af alle kvdrater mellem 1*1 og n*n
    public static int summerSquare(int n) {
        int sum = 0;
        int i = 0;
        System.out.println("Indsæt et tal");
        while(i <= n){
            sum = sum + i * i;
            i++;
        }
        return sum;
    }

    // Metoden returnerer summen af alle ulige tal mellem a og b
    public static int sumOdd(int a, int b) {
        int sum = 0;
        int i = a;
        while (i <= b) {
            if (i%2 != 0){
                sum = sum + i;
            }
            i++;
        }
        return sum;
    }

    // Metoden udskriver 2 potenser fra  f
    public static void allPowers(int n) {
        int i = 0;
        int resultat = 1;
        while (i <= n){
            System.out.println(resultat);
            resultat = resultat * 2;
            i++;
        }
    }

    public static void main(String[] args) {

        //Scanner in = new Scanner(System.in);
        //int indsæt = in.nextInt();
        //System.out.println("indsæt et tal ");
        //System.out.println("når n = 100 skal sum være 2550 = " + summerEven(indsæt));
        //System.out.println("dette er opløftet i, når n = 10 skal sum være 385 = " + summerSquare(indsæt));
        //System.out.println("her skal du gange 2 ulige tal a = 3 og b = 19 " + sumOdd(3, 19));
        allPowers(20);
    }

}
