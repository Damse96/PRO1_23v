package opgave2;


import java.util.ArrayList;
import java.util.List;

public class Ex2 {
    /**
     * Tests all the methods.
     */
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(12);
        ints.add(0);
        ints.add(45);
        ints.add(7);
        ints.add(-16);
        ints.add(0);
        ints.add(23);
        ints.add(-10);

        System.out.println(sum(ints));
       // ints.addAll(List.of(12, 0, 45, 7, -16, 0, 23, -10));
        System.out.println("ints: " + ints);
        System.out.println();
       // Test of sum1() method: correct sum is 61.
        int total = sum1(ints);
        System.out.println("Sum: " + total);
        System.out.println(minimum(ints));
        // Test of sum() method: correct sum is 61.
       // Test of minimum() method: correct minimum is -16.
       // Test of maximum() method: correct maximum is 45.
        // Test of average() method: correct average is 7.625.
       // Test of zeroes() method: correct number of zeroes is 2.
        // Test of evens() method: correct result is [12, 0, -16, 0, -10].
    }

    // sum made with for statement
    public static int sum1(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            sum += number;
        }
        return sum;
    }

    public static int sum(ArrayList<Integer> list){
        int summen = 0;
        for (int nummer : list){
            summen = nummer + summen;
        }
        return summen;
    }

    public static int minimum(ArrayList<Integer> list){
        int minimum = 0;
        for (int nummer : list){
            if (nummer < minimum){
                minimum = nummer;
            }
        }
        return minimum;
    }

    public static int maximum(ArrayList<Integer> list){
        int max = 0;
        for (int nummer : list){
            if (nummer > max){
                max = nummer;
            }
        }
        return max;
    }

    public static double average(ArrayList<Integer> ints) {
        double average = 0;

        for (Integer n : ints) {
            average += n;
        }
        return average / ints.size();
    }

    public static int zeroes(ArrayList<Integer> ints) {
        int count = 0;

        for (Integer n : ints) {
            if (n == 0) {
                count++;
            }
        }
        return count;
    }


    public static ArrayList<Integer> evens(ArrayList<Integer> ints) {
        ArrayList<Integer> evens = new ArrayList<>();
        for (Integer n : ints) {
            if(n % 2 == 0) {
                evens.add(n);
            }
        }
        return evens;
    }

}


