package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Forestilling {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;
    private ArrayList<Bestilling> bestillinger = new ArrayList<>();


    public Forestilling(String navn, LocalDate startDato, LocalDate slutDato){
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public ArrayList<Bestilling> getBestillinger() {
        return bestillinger;
    }

    public Bestilling createBestilling(LocalDate dato){
        Bestilling bestilling = new Bestilling(dato, this);
        bestillinger.add(bestilling);
        return bestilling;

    }

    public void removeBestilling(Bestilling bestilling){
        if(bestillinger.contains(bestilling)){
            bestillinger.remove(bestilling);
        }
    }

    public boolean erPladsLedig(int række, int nr, LocalDate dato){
        for ( Bestilling bestilling : bestillinger){
            if(dato == bestilling.getDato()){
                for (int i = 0; i < bestilling.getPladser().size(); i++) {
                    if(række == bestilling.getPladser().get(i).getRække() && nr == bestilling.getPladser().get(i).getNr()){
                        return false;
                    }
                }
            }
        }
        return true;

    }

    public LocalDate getStartDate() {
        return startDato;
    }

    public LocalDate getSlutDate() {
        return slutDato;
    }

    public String getName() {
        return navn;
    }

    public int antalBestiltePladserPåDag(LocalDate dato){
        int bestiltePladser = 0;
        for (int i = 0; i < bestillinger.size(); i++) {
            if (dato.equals(bestillinger.get(i).getDato())){
                bestiltePladser += bestillinger.get(i).getPladser().size();
            }
        }
        return bestiltePladser;
    }

    public LocalDate succesDato(){
        int højesteSucces = 0;
        for (int i = 0; i < bestillinger.size(); i++) {
            if (bestillinger.get(i).getPladser().size() > højesteSucces){
                højesteSucces = i;
            }

        }
        return bestillinger.get(højesteSucces).getDato();
    }


    @Override
    public String toString() {
        return navn + " (" + startDato + " til " + slutDato + ")";
    }
}
