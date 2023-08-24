package opgave2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Jens",true, new int[]{12, 3, 4});
        Student student2= new Student("Thor",true, new int[]{1,3,6});
        Student student3 = new Student("Anders",true, new int[]{1,10, 4});
        Student student4 = new Student("Lucas",true, new int[]{1,3, 4});
        Student student5 = new Student("Mark",true, new int[]{1,3, 5});
        Student student6 = new Student("Sebastian",true, new int[]{1,3, 5});


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

        System.out.println("den højeste karakter er: " + student2.highestGrade());

        System.out.println("gennemsnits karakteren er: " + student2.averageGrade());

        System.out.println(team.averageTeamGrade());

        System.out.println(Arrays.toString(team.highScoreStudents(5)));

        System.out.println(Arrays.toString(student1.answerGeneration()));

        System.out.println(student1.correctAnswers(student1.answerGeneration()));

        System.out.println(team.classStudents());

        int[] spørgsmål = team.enkelteKorrektSvar();

        for (int i = 0; i < 10; i++ ){
            System.out.println("spørgsmål: " + (i+1) + " rigtige svar: " + spørgsmål[i]);
        }

    }
}
