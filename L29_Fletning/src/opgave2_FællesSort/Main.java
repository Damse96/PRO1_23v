package opgave2_FællesSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        int[] ar1 = new int[]{2, 4, 6, 8, 10, 12, 14};
        int[] ar2 = new int[]{1, 2, 4, 5, 6, 9, 12, 17};

        System.out.println(Arrays.toString(fællesTal(ar1,ar2)));

    }

    public static int[] fællesTal(int[] ar1, int[] ar2) {
        int[] res = new int[ar1.length + ar2.length];
        int i1 = 0;
        int i2 = 0;
        int j = 0;
        while (i1 < ar1.length && i1 < ar2.length) {
            if (ar1[i1] < ar2[i2]) {
                i1++;
            } else if (ar1[i1] > ar2[i2]) {
                i2++;
            } else {
                res[j] = ar1[i1];
                i1++;
                i2++;
                j++;
            }
        }
        return Arrays.copyOf(res, j);
    }
}




