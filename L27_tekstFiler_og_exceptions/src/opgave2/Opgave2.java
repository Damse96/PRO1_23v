package opgave2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Opgave2 {
    public static void main(String[] args) {
        File filein = new File("/Users/andersdam/Desktop/tekstTilOpgave2.txt");

        try {
            Scanner scan = new Scanner(filein);
            while (scan.hasNext()) {
                int n = Integer.parseInt(scan.nextLine()) * 2;
                System.out.println(n);
            }
            scan.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


