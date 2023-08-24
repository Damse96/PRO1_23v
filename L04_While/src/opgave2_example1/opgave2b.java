package opgave2_example1;

public class opgave2b {
    public static int UligeDigits(int n) {
        int digit = 0;
        int sum = 0;
        while (n != 0) {
            digit = n % 10;
            if (digit % 2 != 0) {
                sum = sum + digit;

            } n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(UligeDigits(32677));

    }
}
