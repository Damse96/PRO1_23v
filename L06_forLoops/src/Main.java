public class Main {
    public static void main(String[] args) {

        System.out.println(gange(5,5));


    }

    public static int opliftetI(int a, int b) {
        int resultat = a;
        for (int i = 0; i < b; i++) {
            resultat *= a;
        }
        return resultat;
    }

    public static int gange(int a, int b) {
        int resultat = 0;
        for (int i = 0; i < b; i++) {
            resultat += a;
        }
        return resultat;
    }
}