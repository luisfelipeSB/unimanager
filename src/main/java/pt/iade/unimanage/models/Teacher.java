package pt.iade.unimanage.models;

import java.util.ArrayList;

public class Teacher extends Person {
  private static int nextNumber = 0;
  private int mecNumber;
  private String name;
  private String email;
  private ArrayList<Unit> units;

  public Teacher(int mecNumber, String name, String email, ArrayList<Unit> units) {
    this.mecNumber = mecNumber;
    this.name = name;
    this.email = email;
    this.units = units;
  }

  public int getMecNumber() {
    return mecNumber;
  }

  public ArrayList<Unit> getUnits() {
    return units;
  }

  public void assign(Unit unit) {
    units.add(unit);
    unit.setTeacher(this);
  }

  public void unassign(Unit unit) {
    units.remove(unit);
    unit.setTeacher(null);
  }


  @Override
  public String getReference() {
    return "T<" + mecNumber + ">";
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getEmail() {
    return email;
  }
}