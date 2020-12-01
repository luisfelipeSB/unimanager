package pt.iade.unimanage.models;

import java.time.LocalDate;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Teacher extends Person {
  private static int nextNumber = 0;
  private int mecNumber;
  @JsonIgnore
  private ArrayList<Unit> units;
  private Room room;

  public Teacher(int mecNumber, String name, String email, char gender, LocalDate birthDate) {
    this.mecNumber = mecNumber;
    this.name = name;
    this.email = email;
    this.gender = gender;
    this.birthDate = birthDate;
    this.units = new ArrayList<Unit>();
    this.room = null;
  }

  public int getMecNumber() {
    return mecNumber;
  }
 
  public ArrayList<Unit> getUnits() {
    return units;
  }

  public void assignUnit(Unit unit) {
    units.add(unit);
    unit.setTeacher(this);
  }

  public void unassignUnit(Unit unit) {
    units.remove(unit);
    unit.setTeacher(null);
  }

  public void assignClassroom(Room room) {
    this.room = room;
    room.setTeacher(this);
  }

  public void unassignClassroom(Room room) {
    this.room = null;
    room.setTeacher(null);
  }

  @Override
  public String getReference() {
    return "T" + mecNumber;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}