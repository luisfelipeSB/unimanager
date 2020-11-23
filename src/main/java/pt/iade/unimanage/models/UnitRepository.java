package pt.iade.unimanage.models;

import java.util.ArrayList;
import java.util.List;

public class UnitRepository {
    private static ArrayList<Unit> units = new ArrayList<Unit>();

    public static List<Unit> getUnits() {
        return units;
    }

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
