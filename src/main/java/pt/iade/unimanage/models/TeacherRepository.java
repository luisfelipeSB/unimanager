package pt.iade.unimanage.models;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepository {
    private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    public static List<Teacher> getTeachers() {
        return teachers;
    }

    public static Teacher getTeacher(int mecNumber) {
        for (Teacher teacher : teachers) {
            if (teacher.getMecNumber() == mecNumber)
                return teacher;
        }
        return null;
    }

    public static ArrayList<Unit> getUnits(int mecNumber) {
        return getTeacher(mecNumber).getUnits();
    }

    
}
