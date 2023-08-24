package opgave3;

public class Customer implements Comparable<Customer>{
    private String navn;

    private int alder;


    public Customer(String navn, int alder) {
        this.navn = navn;
        this.alder = alder;
    }

    public String getNavn() {
        return navn;
    }



    public int getAlder() {
        return alder;
    }

    @Override
    public String toString() {
        return  navn + " " +
                 alder;
    }

   @Override
    public int compareTo(Customer o) {
        return this.navn.compareTo(o.navn);
    }

   // @Override
    //public int compareTo(Customer o) {
      //  return this.alder - o.alder;
    //}
}
