package pt.iade.unimanage.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
 
public final class TeacherRepository {
    private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    public static void populate() {
        if (teachers.isEmpty()) {

            // Alice 1  | Unit 1,2  | Room: "programming lab"
            Teacher A = new Teacher(1, "Professor Alice", "", 'F', LocalDate.parse("1980-05-24"));
            A.assignUnit(UnitRepository.getUnit(1));    // DB
            A.assignUnit(UnitRepository.getUnit(2));    // POO
            A.assignClassroom(RoomRepository.getRoom("programming lab"));
            teachers.add(A);

            // Bob 2    | Unit 4    | Room: "maths"
            Teacher B = new Teacher(2, "Professor Bob", "", 'M', LocalDate.parse("1987-08-03"));
            B.assignClassroom(RoomRepository.getRoom("lecture hall"));
            B.unassignClassroom(RoomRepository.getRoom("lecture hall"));
            B.assignClassroom(RoomRepository.getRoom("maths"));
            B.assignUnit(UnitRepository.getUnit(4));    // MAT
            B.setEmail("bob@gmail.com");
            teachers.add(B);

            // Carrie 3 | Unit 3    | Room: "lecture hall"
            Teacher C = new Teacher(3, "Professor Carrie", "", 'F', LocalDate.parse("1982-09-11"));
            C.assignClassroom(RoomRepository.getRoom("lecture hall"));
            C.assignUnit(UnitRepository.getUnit(3));    // SO
            C.setEmail("carrie@gmail.com");
            teachers.add(C);

            // Duncan 4 | Unit 4    | Room: "physics lab"
            Teacher D = new Teacher(4, "Professor Duncan", "", 'M', LocalDate.parse("1975-11-19"));
            D.assignClassroom(RoomRepository.getRoom("physics lab"));
            D.assignUnit(UnitRepository.getUnit(4));
            teachers.add(D);
        }
    }

    public static List<Teacher> getTeachers() { return teachers; }

    public static Teacher getTeacher(int mecNumber) {
        for (Teacher teacher : teachers) {
            if (teacher.getMecNumber() == mecNumber)
                return teacher;
        }
        return null;
    }
 
    public static ArrayList<Unit> getUnitsByMecNumber(int mecNumber) {
        return getTeacher(mecNumber).getUnits();
    }
}
