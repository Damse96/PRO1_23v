package opgave2;

import java.util.Arrays;
import java.util.UnknownFormatConversionException;

public class Team {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static final char[] summaryList = new char[]{'A', 'B', 'C', 'A', 'B', 'C', 'A', 'B', 'C', 'A'};

    private String name;

    private String room;

    private Student[] students = new Student[32];

    private int studentCount = 0;

    public Team(String name, String room) {
        this.name = name;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void addStudent(Student student) {
        students[studentCount] = student;
        studentCount++;
    }


    public Student[] getAllStudents() {
        Student[] currentStudents = new Student[studentCount];
        for (int i = 0; i < studentCount; i++) {
            currentStudents[i] = students[i];
        }
        return currentStudents;
    }

    public void removeStudent(String name) {
        int place = -1;
        for (int i = 0; i < studentCount && place == -1; i++) {
            if (students[i].getName().equals(name)) {
                place = i;
            }
        }
        if (place != -1) {
            studentCount--;
            Student[] temp = new Student[studentCount];
            for (int i = 0; i < studentCount; i++) {
                if (i < place) {
                    temp[i] = students[i];
                } else {
                    temp[i] = students[i + 1];
                }
            }
            students = temp;
        }
    }

    public double averageTeamGrade() {
        double gradeTeamSum = 0;
        for (int i = 0; i < studentCount; i++) {
            gradeTeamSum += gradeTeamSum + students[i].averageGrade();
        }
        return (gradeTeamSum / studentCount);
    }

    public Student[] highScoreStudents(double minAverage) {
        Student[] egnetStuderende = new Student[studentCount];
        for (int i = 0; i < studentCount; i++) {
            if (students[i].isActive() && minAverage <= students[i].averageGrade()) {
                egnetStuderende[i] = students[i];
            }
        }
        return egnetStuderende;
    }

    public String[] classStudents() {
        String[] people = new String[studentCount];

        for (int i = 0; i < studentCount; i++) {
            people[i] = System.lineSeparator() + ANSI_BLUE + "Navn: " + students[i].getName() + ANSI_RESET + System.lineSeparator()
                    + "--   Grades: " + Arrays.toString(students[i].getGrades()) + " " + System.lineSeparator()
                    + "--   Grade average: " + students[i].averageGrade() + System.lineSeparator()
                    + "--   Correct answers on test: " + students[i].correctAnswers(summaryList) + System.lineSeparator();
        }

        return people;
    }

    public int[] enkelteKorrektSvar() {
        int[] spørgsmål = new int[10];
        for (int i = 0; i < studentCount; i++) {
            for (int j = 0; j < summaryList.length; j++) {
                if (students[i].getTestAnswers()[j] == summaryList[j]) {
                    spørgsmål[j]++;
                }
            }
        }

        return spørgsmål;

    }
}
