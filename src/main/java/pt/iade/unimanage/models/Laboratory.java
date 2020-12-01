package pt.iade.unimanage.models;

import java.util.ArrayList;

public class Laboratory extends Room {
     
    protected ArrayList<Material> materials;

    public Laboratory(String designation, int capacity, ArrayList<Material> materials) {
        super(designation, capacity);
        this.materials = materials;
    }

    public ArrayList<Material> getMaterials() { return materials; }
}
