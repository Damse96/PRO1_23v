package opgave6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Opgave6App {
    public static void main(String[] args) {


    }
        //	String fileName = "C:/MAD/Ud/tal7.txt";
        //	String fileName = "C:\\MAD\\Workspace\\IntelliJJava\\PRO1_22S\\tal.txt";
        public static void randomTal(){
        String fileName = "tal.txt";
        try {
            PrintWriter printWriter = new PrintWriter(fileName);

            // indlaes antal tal i filen
            Scanner scan = new Scanner(System.in);
            System.out.print("Antal tal der skal skrives i filen: ");
            int antal = scan.nextInt();

            // skab tilfældige tal generator Random
            Random rnd = new Random();

            // generer og skriv de tilfældige tal
            for (int n = 1; n <= antal; n++) {
                int tal = rnd.nextInt(10000);
                printWriter.println(tal);
            }

            // skriv filen
            printWriter.close();
            scan.close();

            System.out.println("Filen er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    //public static int max(String filename)throws IOEcxeption

}
