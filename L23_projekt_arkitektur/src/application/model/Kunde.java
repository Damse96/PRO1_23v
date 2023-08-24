package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Kunde {

    private String navn;
    private String mobil;
    private ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Kunde(String navn, String mobil){
        this.navn = navn;
        this.mobil = mobil;
    }

    public ArrayList<Bestilling> getBestillinger(){
        return bestillinger;
    }

    public void addBestilling(Bestilling bestilling){
        if(!bestillinger.contains(bestilling)){
            bestillinger.add(bestilling);
            bestilling.setKunde(this);
        }
    }

    public void removeBestilling(Bestilling bestilling){
        if(bestillinger.contains(bestilling)){
            bestillinger.remove(bestilling);
            bestilling.setKunde(null);
        }
    }

    public ArrayList<Plads> bestiltePladserTilForestillingPåDag(Forestilling forestilling, LocalDate dato) {
        ArrayList<Plads> kundensPladser = new ArrayList<>();
        for (int i = 0; i < bestillinger.size(); i++) {
            if (forestilling.equals(bestillinger.get(i).getForestilling()) && dato.equals(bestillinger.get(i).getDato()));
            for (int j = 0; j < bestillinger.get(i).getPladser().size(); j++) {
                kundensPladser.add(bestillinger.get(i).getPladser().get(j));
            }
        }
        return kundensPladser;
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public String getName() {
        return navn;
    }

    @Override
    public String toString() {
        return navn + "(" + mobil + ")";
    }
}
