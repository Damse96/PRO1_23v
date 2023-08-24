package opgave3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        ArrayList<Customer> bank1 = new ArrayList<>();

        Customer c1 = new Customer("Mads", 26);
        Customer c2 = new Customer("Anders", 27);
        Customer c3 = new Customer("Mikkel", 23);
        Customer c4 = new Customer("Emil", 30);
        Customer c5 = new Customer("Patrick", 24);
        Customer c6 = new Customer("Mark", 28);

        Customer[] bank2 = new Customer[]{ c4, c5};


        bank1.add(c1);
        bank1.add(c2);
        bank1.add(c3);
        bank1.add(c6);
        Collections.sort(bank1);
        Arrays.sort(bank2);

        ArrayList<Customer> result = goodCustomers(bank1,bank2);
        System.out.println(result);
    }

    public static ArrayList goodCustomers(ArrayList<Customer> bank1, Customer[] bank2) {
        ArrayList<Customer> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < bank1.size() && i2 < bank2.length) {
            if (bank1.get(i1).compareTo(bank2[i2]) < 0) {
                result.add(bank1.get(i1));
                i1++;
            } else if (bank1.get(i1).compareTo(bank2[i2]) > 0) {
                i2++;
            } else {
                i1++;
                i2++;
            }
        }
        return result;
    }
}