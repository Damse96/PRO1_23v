package opgave1;

import java.security.PublicKey;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("opgave 1a" + Arrays.toString(opgave1a()));
        System.out.println("opgave 1b " + Arrays.toString(opgave1b()));
        System.out.println("opgave 1c " + Arrays.toString(opgave1c()));
        System.out.println("opgave 1d " + Arrays.toString(opgave1d()));
        System.out.println("opgave 1e " + Arrays.toString(opgave1e()));
        System.out.println("opgave 1f " + Arrays.toString(opgave1f()) );

    }
    public static int[] opgave1a(){

          int[] values = new int[10];

          return values;
    }

    public static int[] opgave1b(){
        int[] values = {2,44,-23,99,8,-5,7,10,20,30};
        return values;
    }
    public static  int[] opgave1c(){
        int[] values = new int[10];
        for (int i = 0; i < values.length; i++){
            values[i] = i;
        }
        return values;
    }

    public static int[] opgave1d(){
        int[] values = new int[10];
        for (int i = 0; i < values.length; i++){
            values[i] = (i + 1) * 2;
        }
        return values;
    }

    public static int[] opgave1e(){
        int[] values = new int[10];
        for (int i = 0; i < values.length; i++){
            values[i] = (i + 1) * (i + 1);
        }
        return values;
    }

    public static int[] opgave1f(){
        int[] values = new int[10];
        for (int i = 0; i < values.length; i++){
            if (i % 2 == 0){
                values[i] = 0;
            } else {
                values[i] = 1;
            }
        } return values;
    }

}