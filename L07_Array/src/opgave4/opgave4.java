package opgave4;

import java.util.Arrays;

public class opgave4 {
    public static void main(String[] args) {
        int[] t1 = {4, 6, 7, 2, 3};
        int[] t2 = {4, 6, 8, 2, 6};
        System.out.println(hasUneven(t1));
        System.out.println(hasUneven(t2));


    }

    public static boolean hasUneven(int[] t) {
        boolean hasUneven = true;
        for (int i = 0; i < t.length; i++) {
            if (t[i] % 2 != 0){
                hasUneven = true;
            } else {
                hasUneven = false;
            }
        }
        return hasUneven;
    }
}
