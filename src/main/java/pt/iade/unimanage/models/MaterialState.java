package pt.iade.unimanage.models;

public enum MaterialState {
    OK (true), 
    LENT (false), 
    REPAIR (false), 
    BROKEN (false), 
    BLOCKED (false);

    private Boolean usable;

    private MaterialState(Boolean usable) {
        this.usable = usable;
    }

    public Boolean isUsable() { return usable; }
}
