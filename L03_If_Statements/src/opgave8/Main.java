package opgave8;

import java.util.Scanner;

public class Main {
    public static String Season(int måned, int dag) {
       String result = "";
       if (måned <= 3){
           result = "Vinter";
       } else if (måned <= 6){
           result = "Forår";
       } else if (måned <= 9){
           result = "Sommer";
       } else if(måned <= 12){
           result = "Efterår";
       } if (måned % 3 == 0 && dag >= 21){
           if (result.contentEquals("Vinter")){
               result = "Forår";
           } else if (måned % 6 == 0 && dag >= 21){
               if (result.contentEquals("Forår")){
                   result = "Sommer";
               } else if (måned % 9 == 0 && dag >= 21){
                   if (result.contentEquals("Sommer")){
                       result = "Efterår";
                   } else if (måned % 12 == 0 && dag >= 21) {
                       if (result.contentEquals("Efterår")){
                           result = "Vinter";
                       }
                   }
               }
           }
        }
       return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

    }
}
