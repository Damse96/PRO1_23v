package Lærens_børn;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Børn barn1 = new Børn(6,"frede",false,true);
        Børn barn2 = new Børn(6,"mads",false,true);
        Børn barn3 = new Børn(8,"Peter",false,true);
        Børn barn4 = new Børn(15,"frederikke",true,false);
        Børn barn5 = new Børn(16,"Mette",true,false);
        Børn barn6 = new Børn(18,"Bente",true,false);

        ArrayList<Børn> børns = new ArrayList<>();
        ArrayList<Børn> teenagere = new ArrayList<>();

        børns.add(barn1);
        børns.add(barn2);
        børns.add(barn3);

        teenagere.add(barn4);
        teenagere.add(barn5);
        teenagere.add(barn6);

        System.out.println((barn1.getAlder() + barn2.getAlder() + barn3.getAlder() + barn4.getAlder() + barn5.getAlder() + barn6.getAlder())
         / 6);
        System.out.println();
        System.out.println((barn1.getAlder() + barn2.getAlder() + barn3.getAlder()) /  3);
        System.out.println();
        System.out.println((barn4.getAlder() + barn5.getAlder() + barn6.getAlder()) / 3);
        System.out.println();
        System.out.println((børns.size()) * 200);
        System.out.println();
        System.out.println((teenagere.size()) * 200);
        System.out.println();



    }
}
