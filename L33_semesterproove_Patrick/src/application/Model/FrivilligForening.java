package application.Model;

// subclass of Frivillig
public class FrivilligForening extends Frivillig {
    // attributes
    private String foreningsnavn;
    private int antalPersoner;

    // constructor for FrivilligForening
    public FrivilligForening(String navn, String mobil, int maksAntalTimer, String foreningsnavn, int antalPersoner) {
        super(navn, mobil, maksAntalTimer); // super constructor
        this.foreningsnavn = foreningsnavn;
        this.antalPersoner = antalPersoner;
    }

    // attribute --> foreningsnavn (GET)
    public String getForeningsnavn() {
        return foreningsnavn;
    }

    // attribute --> antalPersoner (GET)
    public int getAntalPersoner() {
        return antalPersoner;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
