package opgave2;

import java.util.Spliterator;

public class opgave2 {
    public static void main(String[] args) {
        int[] t = {4,6,7,2,3};
        int sum = sum(t);
        System.out.println("summen er lig med " + sum);


    }

    public static int sum(int[] t){
        int sum = 0;
        for (int i = 0; i < t.length; i++){
            sum += t[i];
        }
        return sum;
    }
}
