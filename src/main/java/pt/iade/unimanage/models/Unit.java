package pt.iade.unimanage.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Unit implements Statistical {
    private int id;
    private String name;
    private int credits;
    private Teacher teacher;
    @JsonIgnore
    private ArrayList<Enrolment> enrolments;

    public Unit(int id, String name, int credits, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.teacher = teacher;
        enrolments = new ArrayList<Enrolment>();
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public int getCredits() { return credits; }
 
    public Teacher getTeacher() { return teacher; }

    public void setTeacher(Teacher teacher) { 
        this.teacher = teacher; 
    }
 
    public ArrayList<Enrolment> getEnrolments() { return enrolments; }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        for (Enrolment enr : enrolments)
            students.add(enr.getStudent());
        return students;
	}

    /*--- Statistical Methods ---*/

    @Override
    public double getAverage() {
        double sum = 0; int n = 0;
        for (Enrolment enr : enrolments) {
            if (enr.getGrade() > 0) {
                n++;
                sum += enr.getGrade();
            }
        }
        return sum/n;
    }

    @Override
    public double getMax() {
        double max = 0;
        for (Enrolment enr : enrolments) {
            if (enr.getGrade() > max) max = enr.getGrade();
        }
        return max;
    }

    @Override
    public double getMin() {
        double min = 10000;
        for (Enrolment enr : enrolments) {
            if (enr.getGrade() < min) min = enr.getGrade();
        }
        return min;
    }

    @Override
    public HistogramSlot[] getHistogram(int nSlots, double gradeRange) {
        HistogramSlot[] histogram = new HistogramSlot[nSlots];

        double slotSize = gradeRange/nSlots;
        double start = 0; double end = 0; double value = 0;

        for (int i = 0; i < nSlots; i++) {
            value = 0;
            start = slotSize*i;
            end = start + slotSize;

            for (Enrolment enr : enrolments) {
                if (enr.getGrade() > start && enr.getGrade() <= end)
                    value++;
            }

            histogram[i] = new HistogramSlot(start, end, value);
        }
        return histogram;
    }
    
}
