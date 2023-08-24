package Opgave1;

import java.util.Arrays;

public class Student {

    private String name;

    private boolean active;

    private int[] grades;

    public Student(String name, boolean active, int[] grades) {
        this.name = name;
        this.active = active;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Studerende " +
                " navn: '" + name + '\'' +
                ", aktiv: " + active +
                ", grades: " + Arrays.toString(grades) + " ; ";
    }
}
