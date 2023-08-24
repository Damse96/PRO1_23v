package opgave2.application.model;

public class Customer {
    private String navn;

    Company company;

    public Customer(String navn) {
        this.navn = navn;
    }


    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company newCompany){
        this.company = newCompany;
    }

    @Override
    public String toString() {
        return "" + navn;
    }
}
