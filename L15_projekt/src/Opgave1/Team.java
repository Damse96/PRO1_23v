package Opgave1;

public class Team {

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
        if (place != -1){
            studentCount--;
            Student[] temp = new Student[studentCount];
            for (int i = 0; i < studentCount; i++){
                if (i < place){
                    temp[i] = students[i];
                }
                else {
                    temp[i] = students[i + 1];
                }
            }
            students = temp;
        }
    }
}
