package pt.iade.unimanage.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class StudentRepository {
    private static ArrayList<Student> students = new ArrayList<Student>();

    public static void populate() {
        if (students.isEmpty()) {
            
            // John 0 | Unit 1, 2 | Grades 18, 16
            Student John = new Student("John", LocalDate.parse("2000-05-24"), 'M');
            John.setEmail("john@gmail.com");
            John.enroll(new Enrolment (John, UnitRepository.getUnit(1), 18));
            John.enroll(new Enrolment (John, UnitRepository.getUnit(2), 16));
            students.add(John);

            // Jane 1 | Unit 2    | Grade 20
            Student Jane = new Student("Jane", LocalDate.parse("1999-12-23"), 'F');
            Jane.setEmail("mary@gmail.com");
            Jane.enroll(new Enrolment (Jane, UnitRepository.getUnit(2), 20));
            students.add(Jane);

            // Jake 2 | Unit 2, 3 | Grades 14, 17
            Student Jake = new Student("Jake", LocalDate.parse("2001-07-02"), 'M');
            Jake.enroll(new Enrolment (Jake, UnitRepository.getUnit(2), 14));
            Jake.enroll(new Enrolment (Jake, UnitRepository.getUnit(3), 17));
            students.add(Jake);

            // Juno 3 | Unit 1,2,3,4  | Grades 15, 16, 17, 19
            Student Juno = new Student("Juno", LocalDate.parse("1997-02-10"), 'F');
            Juno.setEmail("juno@yahoomail.com");
            Juno.enroll(new Enrolment (Juno, UnitRepository.getUnit(1), 15));
            Juno.enroll(new Enrolment (Juno, UnitRepository.getUnit(2), 16));
            Juno.enroll(new Enrolment (Juno, UnitRepository.getUnit(3), 17));
            Juno.enroll(new Enrolment (Juno, UnitRepository.getUnit(4), 18));
            Juno.getEnrolmentByUnitId(4).setGrade(19);
            students.add(Juno);
        }
    } 

    public static List<Student> getStudents() {
        return students;
    }

    public static Student getStudent(int number) {
        for (Student student : students) {
            if (student.getNumber() == number)
                return student;
        }
        return null;
    }

    public static Boolean deleteStudent(int number) {
        return students.removeIf((s) -> s.getNumber() == number);
    }

    public static Student addStudent(Student student) {
        students.add(student);
        return student;
    }

}
