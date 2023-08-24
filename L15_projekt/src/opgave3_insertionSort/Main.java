package opgave3_insertionSort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String breaker = "ja";
        String teamName = "";
        String teamRoom = "";

        while (breaker.equals("ja")) {
            System.out.println("Vil du oprette et team? (ja / nej)");
            breaker = scan.nextLine().toLowerCase();
            if (breaker.equals("nej")) {
                break;
            } else {
                System.out.println("Hvad skal teamet hedde?");
                teamName = scan.nextLine();

                System.out.println("Hvilket lokale skal teamet være i?");
                teamRoom = scan.nextLine();

                Team team = new Team(teamName, teamRoom);

                for (int i = 0; i < 2; i++) {
                    System.out.println("Navn på studerende:");
                    String studentName = scan.nextLine();

                    System.out.println("Er den studerende aktiv:");
                    boolean studentActive = scan.nextBoolean();

                    System.out.println("Hvor mange karakterer har den studerende fået:");
                    int studentGradeNumber = scan.nextInt();

                    int[] studentGrades = new int[studentGradeNumber];

                    System.out.println("Den studerendes karakterer adskilt med blanke");
                    for (int j = 0; j < studentGradeNumber; j++) {
                        int grade = scan.nextInt();
                        studentGrades[j] = grade;
                    }

                    scan.nextLine();

                    Student student = new Student(studentName, studentActive, studentGrades);
                    team.addStudent(student);
                }

                System.out.println(Arrays.toString(team.getAllStudents()));
            }
        }
    }
}
//
//      /*  Scanner scan = new Scanner(System.in);
//        System.out.println("vil du oprette et team?");
//        String answer = scan.nextLine();
//        boolean svar = true;
//        while (!answer.equals("nej")){
//            System.out.println("hvad skal teamet hedde: ");
//            String teamNavn = scan.next();
//            System.out.println("hvilket lokale skal teamet være i: ");
//            String teamRoom = scan.nextLine();
//            Team team1 = new Team(teamNavn,teamRoom);
//            System.out.println("Hvor mange studerende vil du lave?: ");
//            int antalStuderende = scan.nextInt();
//            scan.nextLine();
//            for (int i = 0; i < antalStuderende; i++){
//                System.out.println("navn på den studerende: ");
//                String name = scan.next();
//                scan.nextLine();
//                System.out.println("er den studerende aktiv: ");
//                boolean aktiv = scan.nextBoolean();
//                scan.nextLine();
//                System.out.println("Hvor mange karakterer har den studerende fået?: ");
//                int antalKarakter = scan.nextInt();
//                scan.nextLine();
//                int[] studentGrades = new int[antalKarakter];
//                System.out.println("Hvilke karakter har eleven fået? adskilt med blanke: ");
//                for (int j = 0; j < antalKarakter; j++){
//                    int grade = scan.nextInt();
//                    studentGrades[j] = grade;
//                }
//                scan.nextLine();
//
//                stu
//            }
//
//
//            System.out.println();
//        }*/
//
//
//
//
//
//
//        Student student1 = new Student("Jens",true, new int[]{12, 3, 4});
//        Student student2= new Student("Thor",true, new int[]{1,3,6});
//        Student student3 = new Student("Anders",true, new int[]{1,10, 4});
//        Student student4 = new Student("Lucas",true, new int[]{1,3, 4});
//        Student student5 = new Student("Mark",true, new int[]{1,3, 5});
//        Student student6 = new Student("Sebastian",true, new int[]{1,3, 5});
//
//
//        Team team = new Team("Klasse1","42");
//        Team team2 = new Team("Klasse2", "21");
//
//        team.addStudent(student1);
//        team.addStudent(student2);
//        team.addStudent(student3);
//        team2.addStudent(student4);
//        team2.addStudent(student5);
//        team2.addStudent(student6);
//        System.out.println(Arrays.toString(team.getAllStudents()));
//        System.out.println(Arrays.toString(team2.getAllStudents()));
//
//
//        team.removeStudent("Thor");
//        System.out.println(Arrays.toString(team.getAllStudents()));
//
//        team2.removeStudent("Lucas");
//        System.out.println(Arrays.toString(team2.getAllStudents()));
//
//        System.out.println(Arrays.toString(team.getAllStudents()));
//
//        System.out.println("den højeste karakter er: " + student2.highestGrade());
//
//        System.out.println("gennemsnits karakteren er: " + student2.averageGrade());
//
//        System.out.println(team.averageTeamGrade());
//
//        System.out.println(Arrays.toString(team.highScoreStudents(5)));
//
//        System.out.println(Arrays.toString(student1.answerGeneration()));
//
//        System.out.println(student1.correctAnswers(student1.answerGeneration()));
//
//        System.out.println(team.classStudents());
//
//        team.enkelteKorrektSvar();
//    }
//}
