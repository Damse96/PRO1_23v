package controller.model;


import java.util.ArrayList;

public class Prisgruppe {
    private String prisGruppe;


    private final ArrayList<Bil> biler = new ArrayList<>();

    public Prisgruppe(String prisGruppe) {
        this.prisGruppe = prisGruppe;
    }

    public String getPrisGruppe() {
        return prisGruppe;
    }

    public void setPrisGruppe(String prisGruppe) {
        this.prisGruppe = prisGruppe;
    }

    public void add(Bil bil) {
        biler.add(bil);
    }

    public void removeBil(Bil bil){
        biler.remove(bil);
    }
}
