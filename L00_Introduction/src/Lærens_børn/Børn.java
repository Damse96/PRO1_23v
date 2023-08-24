package Lærens_børn;

public class Børn {
    private double alder;

    private String navn;
    private boolean piger;

    private boolean drenge;

    public Børn(double alder, String navn, boolean piger, boolean drenge) {
        this.alder = alder;
        this.navn = navn;
        this.piger = piger;
        this.drenge = drenge;
    }

    public double getAlder() {
        return alder;
    }

    public void setAlder(double alder) {
        this.alder = alder;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public boolean isPiger() {
        return piger;
    }

    public void setPiger(boolean piger) {
        this.piger = piger;
    }

    public boolean isDrenge() {
        return drenge;
    }

    public void setDrenge(boolean drenge) {
        this.drenge = drenge;
    }
}
