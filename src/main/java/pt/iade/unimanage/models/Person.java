package pt.iade.unimanage.models;

import java.time.LocalDate;

public abstract class Person {
    
    protected String name;
    protected LocalDate birthDate;
    protected String email;
    protected char gender;

    public abstract String getReference();
 
    public abstract String getName();
    
    public abstract String getEmail();
 
}
