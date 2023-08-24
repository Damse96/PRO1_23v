package opgave1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] prim = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Hvilket nr. primtal skal vises?: ");
            int n = scan.nextInt();
            System.out.println("Primtal nr. " + n + " er "
                    + prim[n - 1] + "\n");
        } catch (ArrayIndexOutOfBoundsException ea){
            System.out.println("index er out of bounds");
        } catch (InputMismatchException ea){
            System.out.println("Det er ikke et tal søde ven");
        } catch (Exception e){
            System.out.println("mellem 1 og 10 ven");
        }
    }
}
