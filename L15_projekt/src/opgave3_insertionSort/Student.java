package opgave3_insertionSort;

import java.util.Arrays;


public class Student {

    private String name;

    private boolean active;

    private int[] grades;

    private char[] testSvar = answerGeneration();

    private char[] rigtigeSvar = {'A','B','C','D'};

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

    public char[] getTestAnswers(){
        return testSvar;
    }

    public int highestGrade(){
        int grade = 0;
        for (int i = 0; i < grades.length; i++)
            if(grades[i] > grade){
                grade = grades[i];
            }
        return grade;
    }

    public char[] answerGeneration() {
        char[] generatedAnswers = new char[10];

        for (int i = 0; i < generatedAnswers.length; i++) {
            int number = (int) Math.ceil(Math.random() * 4);
            if (number == 1) {
                generatedAnswers[i] = 'A';
            } else
            if (number == 2) {
                generatedAnswers[i] = 'B';
            } else
            if (number == 3) {
                generatedAnswers[i] = 'C';
            } else
            if (number == 4) {
                generatedAnswers[i] = 'D';
            }
        }

        return generatedAnswers;
    }


    public int correctAnswers(char[] correct) {
        int correctNr = 0;
        for (int i = 0; i < 10; i++)
            if (correct[i] == testSvar[i]) {
                correctNr++;
            }
        return correctNr;
    }



    public double averageGrade() {
        double gradeSum = 0;
        for (int i = 0; i < grades.length; i++) {
            gradeSum = gradeSum + grades[i];
        }
        return (gradeSum / grades.length);
    }


    @Override
    public String toString() {
        return "Studerende " +
                " navn: '" + name + '\'' +
                ", aktiv: " + active +
                ", grades: " + Arrays.toString(grades) + " ; ";
    }

}
