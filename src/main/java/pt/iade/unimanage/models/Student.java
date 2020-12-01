package pt.iade.unimanage.models;

import java.time.LocalDate;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
 
public class Student extends Person implements Statistical {
    private static int nextNumber = 0;
    private int number;
    @JsonIgnore
    private ArrayList<Enrolment> enrolments;

    public Student(String name, LocalDate birthDate, char gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.number = nextNumber;
        nextNumber++;
        email = "";
        enrolments = new ArrayList<Enrolment>();
    }

    /*--- Getters & Setters ---*/
    
    @Override
    public String getName() { return name; }

    public LocalDate getBirthDate() { return birthDate; }

    @Override
    public String getEmail() { return email; }

    @Override
    public String getReference() { return "S" + number; }

    public void setEmail(String email) { this.email = email; }

    public char getGender() { return gender; }

    public int getNumber() { return number; }

    public ArrayList<Enrolment> getEnrolments() { return enrolments; }

    /*--- Enrolment methods ---*/ 

    public Enrolment getEnrolmentByUnitId(int unitId) {
        for (Enrolment enr : enrolments)
            if (enr.getUnit().getId()==unitId) return enr;
        return null;
    }

    public void enroll(Enrolment enrolment) {
        enrolments.add(enrolment);
        enrolment.getUnit().getEnrolments().add(enrolment);
    }

    public void grade(int unitId, double grade) {
        for (Enrolment enr : enrolments)
            if (enr.getUnit().getId()==unitId) enr.setGrade(grade);;
    }

    /*--- Statistical Methods --*/

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
