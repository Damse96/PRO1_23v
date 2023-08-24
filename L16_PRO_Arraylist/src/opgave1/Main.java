package opgave1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> navn = new ArrayList<>(List.of("Hans", "Viggo", "Jens", "Bente", "Bent"));

        System.out.println("længden af listen er " + navn.size());

        navn.set(2,"Jane");

        System.out.println(navn);

        navn.remove(1);
        System.out.println(navn);

        navn.add(0,"Pia");

        navn.add("Ib");

        System.out.println(navn);

        navn.set(2,"Hansi");

        System.out.println(navn.size());

        System.out.println(navn);

        for (int i = 0; i < navn.size(); i++){
            String names = navn.get(i);
            System.out.println(names.length());
        }

        System.out.println();

        String allNames = "";
        for (String str : navn){
            System.out.println(str.length());
        }
    }
}
