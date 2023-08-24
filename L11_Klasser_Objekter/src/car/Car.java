package car;

import java.awt.*;

public class Car {
    private Color color;
    private int doors;
    private int wheels;

    public Car(Color color, int doors, int wheels) {
        this.color = color;
        this.doors = doors;
        this.wheels = wheels;
    }

    public Car(){
        this.color = Color.RED;
        this.doors = 1;
        this.wheels = 3;
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getWindows() {
        return wheels;
    }

    public void setWindows(int windows) {
        this.wheels = windows;
    }

    @Override
    public String toString() {
        return "Bilens farve er: " + color +
                ", Bilen har " + doors + " dør og " + wheels +  " vinduer ";
    }
}
