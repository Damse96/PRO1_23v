package opgave2_selectionsorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<Customer> kunder = new ArrayList<>();
        String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};

        selectionSortString(s);

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

        selectionSortStringArrayList(kunder);

        System.out.println(kunder);


    }


    private static void swap(String[] list, int i, int j) {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void selectionSortString(String[] list) {
        for (int i = 0; i < list.length; i++) {
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j].compareTo(list[currentMinIndex]) < 0) {
                    currentMinIndex = j;
                }

            }
            swap(list, i, currentMinIndex);
        }
    }

    public static void selectionSortStringArrayList(ArrayList<Customer> kunder) {
        for (int i = 0; i < kunder.size(); i++) {
            int currentMinIndex = i;
            for (int j = i + 1; j < kunder.size(); j++) {
                if (kunder.get(j).getFirstName().compareTo(kunder.get(currentMinIndex).getFirstName()) < 0) {
                    currentMinIndex = j;
                }

            }
            swappie(kunder, i, currentMinIndex);
        }
    }
    private static void swappie(ArrayList<Customer> kunder, int i, int j) {
        Customer temp = kunder.get(i);
        kunder.set(i,kunder.get(j));
        kunder.set(j,temp);
    }
}
