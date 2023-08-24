package opgave3_insertionSort;

public class Car {
    private String license;

    private double pricePerDay;

    private int purchaseYear;

    public Car(String license, double pricePerDay, int purchaseYear) {
        this.license = license;
        this.pricePerDay = pricePerDay;
        this.purchaseYear = purchaseYear;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getLicense() {
        return license;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }
}
