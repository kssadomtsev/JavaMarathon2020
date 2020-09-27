package day6;

public class Teacher {
    private String name;
    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void evaluate(Student student, int grade) {
        String output;
        switch (grade) {
            case 2:
                output = createOutput(student, "неудовлетворительно");
                break;
            case 3:
                output = createOutput(student, "удовлетворительно");
                break;
            case 4:
                output = createOutput(student, "хорошо");
                break;
            case 5:
                output = createOutput(student, "отлично");
                break;
            default:
                output = "Неправильная оценка";
        }
        System.out.println(output);
    }

    private String createOutput(Student student, String grade) {
        return "Преподаватель " + this.name + " оценил студента с именем " + student.getName() + " по предмету " + this.subject + " на оценку " + grade + ".";
    }
}
