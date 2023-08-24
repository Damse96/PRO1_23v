package opgave3_insertionSort;

public class App {
    public static void main(String[] args) {
        Car car1 = new Car("AAA",1000,1996);
        Car car2 = new Car("BBB", 1500,2000);
        Car car3 = new Car("CCC", 2000,2016);
        Car car4 = new Car("DDD", 3000,2020);
        Car car5 = new Car("EEE",5000,2023);

        Rental rental1 = new Rental(2,20,"07/07/2023");
        Rental rental2 = new Rental(4,15,"04/02/2023");

        rental2.addCar(car1);
        rental2.addCar(car3);
        rental1.addCar(car2);
        rental1.addCar(car4);

        System.out.println(rental1.getPrice());
    }
}
