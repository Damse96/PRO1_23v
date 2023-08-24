package opgave5;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Opgave5 {


    public static void main(String[] args) {
        File file = new File("Opgave5.txt");
        try {
            PrintWriter printWriter = new PrintWriter(file);
            Scanner scan = new Scanner(System.in);
            System.out.print("Indtast tal ");
            int n = 0;
            while (n != -1){
                n = scan.nextInt();
                printWriter.println(n);
                System.out.println("Indtast næste tal, for at stop skriv -1");
            }
            printWriter.close();
            scan.close();
            System.out.println("Filen er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}