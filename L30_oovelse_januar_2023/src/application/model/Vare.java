package application.model;

public class Vare {
    private Varekategori kategori;

    private String navn;

    private int udbudsPris;

    private boolean solgt;

    Salgsannonce salgsannonce;

    public Vare(Varekategori kategori, String navn, int udbudsPris, boolean solgt) {
        this.kategori = kategori;
        this.navn = navn;
        this.udbudsPris = udbudsPris;
        this.solgt = solgt;

    }

    public Varekategori getKategori() {
        return kategori;
    }

    public String getNavn() {
        return navn;
    }

    public int getUdbudsPris() {
        return udbudsPris;
    }

    public boolean isSolgt() {
        return solgt;
    }

    public Salgsannonce getSalgsannonce() {
        return salgsannonce;
    }

    public void setSalgsannonce(Salgsannonce salgsannonce) {
        if (this.salgsannonce != salgsannonce) {
            this.salgsannonce = salgsannonce;
            if (salgsannonce != null) {
                salgsannonce.addVare(this);
            }
        }
    }

    @Override
    public String toString() {
        return
                "kategori: " + kategori +
                ", navn: " + navn + '\'' +
                ", udbudsPris: " + udbudsPris;
    }
}
