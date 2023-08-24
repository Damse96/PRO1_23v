package opgave3_insertionSort;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<Customer> kunder = new ArrayList<>();
        String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};


        insertioneSort(s);

        System.out.println(Arrays.toString(s));

        Customer customer1 = new Customer("Dam","Anders",26);
        Customer customer2 = new Customer("Andersen","Mikkel",23);
        Customer customer3 = new Customer("Tully","Sebastian",22);
        Customer customer4 = new Customer("Madsen","Emil",32);
        Customer customer5 = new Customer("Dam","Kathrine",23);
        Customer customer6 = new Customer("Dam","Kristian",15);



        kunder.add(customer1);
        kunder.add(customer2);
        kunder.add(customer3);
        kunder.add(customer4);
        kunder.add(customer5);
        kunder.add(customer6);

        insertioneSortArraylist(kunder);
        System.out.println(kunder);


    }

    public static void insertioneSort(String[] s) {
        for (int i = 1; i < s.length; i++) {
            String currentElement = s[i];
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (currentElement.compareTo(s[j - 1]) > 0) {
                    found = true;
                } else {
                    s[j] = s[j - 1];
                    j--;
                }
            }
            s[j] = currentElement;
        }
    }

    public static void insertioneSortArraylist(ArrayList<Customer> kunder) {
        for (int i = 1; i < kunder.size(); i++) {
            Customer currentElement = kunder.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (kunder.get(j-1).getFirstName().compareTo(currentElement.getFirstName()) < 0) {
                    found = true;
                } else {
                    kunder.set(j, kunder.get(j-1));
                    j--;
                }
            }
            kunder.set(j,currentElement);
        }
    }
}
