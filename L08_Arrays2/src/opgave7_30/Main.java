package opgave7_30;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);


            System.out.print("Enter the number of values: ");
            int[] values = new int[input.nextInt()];


            System.out.print("Enter the values: ");
            for (int i = 0; i < values.length; i++)
                values[i] = input.nextInt();


            System.out.println("The list has" +
                    (isConsecutiveFour(values) ? " " : " no ") + "consecutive fours");
        }

        public static boolean isConsecutiveFour(int[] values) {
            int count = 1;

            for (int i = 0; i < values.length - 1; i++) {
                if (values[i] == values[i + 1])
                    count++;

                if (count >= 4)
                    return true;

                if (values[i] != values[i + 1])
                    count = 1;
            }
            return false;
        }

        public static boolean isSorted(int[] values){
            boolean isSorted = false;
            for (int i = 0; i < values.length - 1; i++){
                if (values[i] <= values[i+1]){
                    isSorted = true;
                } else {
                    isSorted = false;
                    return  isSorted;
                }
            } return isSorted;
        }
    }