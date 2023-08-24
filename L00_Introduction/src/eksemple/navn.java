package eksemple;

public class navn {
    private String navn;

    public navn(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return navn;
    }
}
