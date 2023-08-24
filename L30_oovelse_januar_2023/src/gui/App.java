package gui;

import application.model.Salgsannonce;
import application.model.Sælger;
import application.model.Vare;
import application.model.Varekategori;

public class App {
    public static void main(String[] args) {

    }
        public static void initStorage() {

            Sælger Viktor = new Sælger("Viktor",23,"45344247");

            Sælger Gustav = new Sælger("Gustav", 35, "56124522");

            Vare Samsung = new Vare(Varekategori.MOBILTELEFON, "Samsung mobil", 1200,false);

            Vare Iphone = new Vare(Varekategori.MOBILTELEFON, "Iphone", 2000,false);

            Vare Java = new Vare(Varekategori.STUDIEBOG, "Java", 400,false);

            Vare Android = new Vare(Varekategori.STUDIEBOG, "Android", 300,false);

            Vare Python = new Vare(Varekategori.STUDIEBOG, "Python", 200,false);

            Vare regnJakke = new Vare(Varekategori.TØJ, "Regnjakke", 100,false);

            Vare regnBukser = new Vare(Varekategori.TØJ, "Regnbukser", 80,false);

          

        }
}
