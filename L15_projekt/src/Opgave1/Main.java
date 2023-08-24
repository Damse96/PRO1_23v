package Opgave1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Jens",true, new int[]{1, 3});
        Student student2= new Student("Thor",true, new int[]{1,3});
        Student student3 = new Student("Anders",true, new int[]{1,3});
        Student student4 = new Student("Lucas",true, new int[]{1,3});
        Student student5 = new Student("Mark",true, new int[]{1,3});
        Student student6 = new Student("Sebastian",true, new int[]{1,3});


        Team team = new Team("Klasse1","42");
        Team team2 = new Team("Klasse2", "21");

        team.addStudent(student1);
        team.addStudent(student2);
        team.addStudent(student3);
        team2.addStudent(student4);
        team2.addStudent(student5);
        team2.addStudent(student6);
        System.out.println(Arrays.toString(team.getAllStudents()));
        System.out.println(Arrays.toString(team2.getAllStudents()));


        team.removeStudent("Thor");
        System.out.println(Arrays.toString(team.getAllStudents()));

        team2.removeStudent("Lucas");
        System.out.println(Arrays.toString(team2.getAllStudents()));

        System.out.println(Arrays.toString(team.getAllStudents()));
    }
}
