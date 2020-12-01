package pt.iade.unimanage.models;

public class Material {
     
    protected String name;
    protected MaterialState state;

    public Material(String name) {
        this.name = name;
        this.state = MaterialState.OK;
    } 

    public String getName() { return name; }

    public MaterialState getState() { return state; }

    public void setState(MaterialState state) { 
        this.state = state;
    }
}
