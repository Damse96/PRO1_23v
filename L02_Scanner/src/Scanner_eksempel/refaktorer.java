package Scanner_eksempel;

import java.util.Scanner;

public class refaktorer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double pi = 3.14159;
        System.out.println("indtast en radius: ");
        double radius = in.nextDouble();
        double omkreds = 2 * radius * pi;
        System.out.println(omkreds);
    }
}
