package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sælger {
    private String navn;

    private int studiekortNummer;

    private String mobil;

    private final ArrayList<Salgsannonce> salgsannonces = new ArrayList<>();

    public Sælger(String navn, int studiekortNummer, String mobil) {
        this.navn = navn;
        this.studiekortNummer = studiekortNummer;
        this.mobil = mobil;
    }

    public String getNavn() {
        return navn;
    }

    public int getStudiekortNummer() {
        return studiekortNummer;
    }

    public String getMobil() {
        return mobil;
    }

    public ArrayList<Salgsannonce> getSalgsannonces() {
        return salgsannonces;
    }

    public void addSalgsAnnonce(Salgsannonce salgsannonce) {
        if (!salgsannonces.contains(salgsannonce)) {
            salgsannonces.add(salgsannonce);
            salgsannonce.setSælger(this);
        }
    }

    public void removeSalgsAnnonce(Salgsannonce salgsannonce) {
        if (salgsannonces.contains(salgsannonce)) {

            salgsannonces.remove(salgsannonce);
            salgsannonce.setSælger(null);
        }
    }

    public Salgsannonce createSalgsAnnonce(int antalAnnoncer, int annonceNummer, boolean aktiv, LocalDate udløbsDato) {
        Salgsannonce salgsannonce = new Salgsannonce(antalAnnoncer,annonceNummer,aktiv,udløbsDato);
        salgsannonces.add(salgsannonce);
        return salgsannonce;
    }

    public ArrayList<Vare> alleIkkeSolgteVarerIKategori(Varekategori kategori) {
        ArrayList<Vare> result = new ArrayList<>();
        for (Salgsannonce salgsannonce : salgsannonces) {
            for (Vare vare : salgsannonce.getVares()) {
                if (vare.getKategori() == kategori && !vare.isSolgt()) {
                    result.add(vare);
                }
            }
        } return result;
    }

    @Override
    public String toString() {
        return "Sælger: " +
                " navn: " + navn + '\'' +
                ", studiekortNummer: " + studiekortNummer +
                ", TelefonNummer: " + mobil;
    }
}