package opgave3_insertionSort;

import java.util.Arrays;

public class opgave3 {
    public static void main(String[] args) {
        int[] a = {4,6,7,2,3};
        int[] b = {4,6,8,2,6};
        int[] sumArrays = sumArrays(a,b);
        System.out.println("summen er lig med " + Arrays.toString(sumArrays));


    }

    public static int[] sumArrays(int[] a, int[] b){
        int[] sum = new int [a.length];
        for (int i = 0; i < a.length; i++){
            sum[i] = a[i] + b[i];
        }
        return sum;
    }
}
