package application.model;
import java.util.ArrayList;

public class Deltager {
    private String navn;
    private String adresse;
    private String land;
    private String tlfNr;
    private String firmaNavn;
    private String firmaTlfNr;
    private ArrayList<Tilmelding> tilmeldinger;
    private Ledsager ledsager;

    public Deltager(String navn, String adresse, String land, String tlfNr, String firmaNavn, String firmaTlfNr) {
        this.navn = navn;
        this.adresse = adresse;
        this.land = land;
        this.tlfNr = tlfNr;
        this.firmaNavn = firmaNavn;
        this.firmaTlfNr = firmaTlfNr;
        this.tilmeldinger = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getLand() {
        return land;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public String getFirmaNavn() {
        return firmaNavn;
    }

    public String getFirmaTlfNr() {
        return firmaTlfNr;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return tilmeldinger;
    }

    public Ledsager getLedsager() {
        return ledsager;
    }
    public Ledsager createLedsager(String navn, Deltager deltager) {
        this.ledsager = new Ledsager(navn, deltager);

        return this.ledsager;
    }

    public void addTilmelding(Tilmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
            tilmelding.setDeltager(this);
        }
    }
    public double getUdflugtPris() {
        double udflugtspris = 0;
        if (ledsager != null) {
            udflugtspris = ledsager.udflugtPris();
        }
        return udflugtspris;
    }

    @Override
    public String toString() {
        if (ledsager != null) {
            return navn + " (Ledsager: " + ledsager.getNavn() + ")";
        }
        else {
            return navn;
        }
    }
}
