package opgave3_insertionSort;

public class opgave3 {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 9, 13, 7, 9, 13};
        int[] arr2 = new int[]{7, 9, 13, 13, 9, 7};
        int[] arr3 = new int[]{7, 9, 13, 13, 2, 9, 7};

        System.out.println(sameAdjecent(arr));
        System.out.println(sameAdjecent(arr2));
        System.out.println(sameNumber(arr3, 3));
    }

    public static boolean sameAdjecent(int[] arr) {
        boolean sameAdjacent = false;
        int i = 0;
        while (!sameAdjacent && i < arr.length - 1) {
            int k = arr[i];
            if (k == arr[i + 1]) {
                sameAdjacent = true;
            } else {
                i++;
            }
        }
        return sameAdjacent;
    }

    public static boolean sameNumber(int[] arr, int n) {
        boolean sameNumber = false;
        for (int i = 0; i < arr.length; i++) {
            int k = arr[i];
            for (int j = i; j <= n; j++) {
                int k1 = arr[j + 1];
                if (k1 == k) {
                    sameNumber = true;
                } else {
                    sameNumber = false;
                }
            }
        }
        return sameNumber;
    }
}

