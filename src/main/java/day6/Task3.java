package day6;

public class Task3 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Ivan Ivanon", "Art");
        Student student = new Student("Jhon Newman");
        teacher.evaluate(student, 2);
        teacher.evaluate(student, 3);
        teacher.evaluate(student, 4);
        teacher.evaluate(student, 5);
        teacher.evaluate(student, -1);
    }
}
