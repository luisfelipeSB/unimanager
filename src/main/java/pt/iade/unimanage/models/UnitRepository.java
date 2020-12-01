package pt.iade.unimanage.models;

import java.util.ArrayList;
import java.util.List;

public final class UnitRepository {
    private static ArrayList<Unit> units = new ArrayList<Unit>();

    public static void populate() {
        units.add(new Unit(1, "Bases de Dados", 3, TeacherRepository.getTeacher(1)));
        units.add(new Unit(2, "Programação Orientada por Objetos", 6, TeacherRepository.getTeacher(2)));
        units.add(new Unit(3, "Sistemas Operativos", 6, TeacherRepository.getTeacher(3)));
        units.add(new Unit(4, "Matemática Discreta", 3, TeacherRepository.getTeacher(4)));
    }

    public static List<Unit> getUnits() { return units; }
 
    public static Unit getUnit(int id) {
        for (Unit unit : units) {
            if (unit.getId() == id)
                return unit;
        }
        return null;
    }
 
    public static void unassignTeacher(int id) {
        getUnit(id).setTeacher(null);
    }
}
