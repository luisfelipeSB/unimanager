package pt.iade.unimanage.models;

public class Enrolment {
    private Student student;
    private Unit unit;
    private double grade;

    public Enrolment(Student student, Unit unit, double grade) {
        this.student = student;
        this.unit = unit;
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public Unit getUnit() {
        return unit;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
