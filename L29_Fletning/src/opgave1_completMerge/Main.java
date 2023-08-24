package opgave1_completMerge;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        ArrayList<Customer> l1 = new ArrayList<>();
        ArrayList<Customer> l2 = new ArrayList<>();

        Customer c1 = new Customer("Mads", 26);
        Customer c2 = new Customer("Anders", 27);
        Customer c3 = new Customer("Mikkel", 23);
        Customer c4 = new Customer("Emil", 30);
        Customer c5 = new Customer("Patrick", 24);
        Customer c6 = new Customer("Mark", 28);


        l1.add(c1);
        l1.add(c2);
        l2.add(c3);
        l2.add(c4);
        l1.add(c5);
        l1.add(c6);
        Collections.sort(l1);
        Collections.sort(l2);
        System.out.println(l1);
        System.out.println(l2);

        System.out.println(fletAlleKunder(l1,l2));

    }

    public static ArrayList<Customer> fletAlleKunder(ArrayList<Customer> l1, ArrayList<Customer> l2) {
        ArrayList<Customer> res1 = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < l1.size() && i2 < l2.size()) {
            if (l1.get(i1).compareTo((l1.get(i2))) <= 0) {
                // s1's første tal er mindst
                res1.add(l1.get(i1));
                i1++;
            } else { // s2's første tal er mindst
                res1.add(l2.get(i2));
                i2++;
            }
        }
        // tøm den liste der ikke er tom
        while (i1 < l1.size()) {
            res1.add(l1.get(i1));
            i1++;
        }
        while (i2 < l2.size()) {
            res1.add(l2.get(i2));
            i2++;
        }
        return res1;
    }
}


