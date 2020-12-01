package pt.iade.unimanage.models;

import java.util.ArrayList;

public class Computer extends Material {
     
    protected ArrayList<String> specifications;

    public Computer(String name, MaterialState state, ArrayList<String> specifications) {
        super(name);
        this.specifications = specifications;
    }   
}
