package pt.iade.unimanage.models;

import java.util.ArrayList;

public class Unit {
    private int id;
    private String name;
    private int credits;
    private ArrayList<Student> students;
    private Teacher teacher;
    private ArrayList<Enrolment> enrolments;

    public Unit(int id, String name, int credits, ArrayList<Student> students, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.students = students;
        this.teacher = teacher;
        enrolments = new ArrayList<Enrolment>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
 
    public ArrayList<Enrolment> getEnrolments() {
        return enrolments;
    }
    
}
