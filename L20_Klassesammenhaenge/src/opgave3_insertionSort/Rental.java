package opgave3_insertionSort;

import java.util.ArrayList;

public class Rental {
    private int number;
    private int days;

    private String date;

    private final ArrayList<Car> cars = new ArrayList<>();

    public Rental(int number, int days, String date) {
        this.number = number;
        this.days = days;
        this.date = date;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void removeCar(Car car){
        cars.remove(car);
    }

    public int getNumber() {
        return number;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getDate() {
        return date;
    }

    public double getPrice(){
        double totalPris = 0;
        for (Car c : cars){
            totalPris += c.getPricePerDay();
        }
        return totalPris * days;
    }
}
