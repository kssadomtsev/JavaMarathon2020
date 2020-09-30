package day9.Task1;

public class Task1 {
    public static void main(String[] args) {
        Student student = new Student("Bob", "1A");
        Teacher teacher = new Teacher("Alice", "Art");
        System.out.println(student.getGroup());
        System.out.println(teacher.getSubject());
        student.printInfo();
        teacher.printInfo();
    }
}
