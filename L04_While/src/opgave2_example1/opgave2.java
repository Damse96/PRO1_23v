package opgave2_example1;

public class opgave2 {

    public static int sumDigits(int n) {
        int digit = 0;
        int sum = 0;
        while (n != 0) {
            digit = n %10;
            sum = sum + digit;
            n = n/10;
            }
        return sum;
        }


    public static void main(String[] args) {
        System.out.println(sumDigits(234));

    }
}
