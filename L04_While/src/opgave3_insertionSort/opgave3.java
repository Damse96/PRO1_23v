package opgave3_insertionSort;

import java.util.Scanner;

public class opgave3 {
    public static int reverse(int number) {
        int reversed = 0;
        while (number != 0) {
            int cifre = number % 10;
            reversed = reversed * 10 + cifre;
            number = number / 10;


        }
        return reversed;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int indsæt = in.nextInt();
        System.out.println(reverse(indsæt));


    }

    public static int reversenumber(int n) {
        int digit;
        String reverseNumber = "";
        while (n > 0) {
            digit = n % 10;
            String stringDigit = Integer.toString(digit);
            reverseNumber = reverseNumber + stringDigit;
            n = n / 10;
        }
        return Integer.parseInt(reverseNumber);
    }
}
