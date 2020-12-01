package pt.iade.unimanage.models;

public class Room {
    protected String designation;
    protected int capacity;
    protected Teacher teacher;
 
    public Room(String designation, int capacity) {
        this.designation = designation;
        this.capacity = capacity;
    }

    public String getDesignation() { return designation; }

    public Teacher getTeacher() { return teacher; }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
