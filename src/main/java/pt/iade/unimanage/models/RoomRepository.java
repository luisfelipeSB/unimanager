package pt.iade.unimanage.models;

import java.util.ArrayList;

public final class RoomRepository {

    private static ArrayList<Room> rooms = new ArrayList<Room>();
    private static ArrayList<Material> materials = new ArrayList<Material>();

    public static void populate() {
        if (rooms.isEmpty()) {
            materials.add(new Material("whiteboard"));
            materials.get(0).setState(MaterialState.OK);        // material 0: Whiteboard   | OK
            materials.add(new Material("smartboard"));
            materials.get(1).setState(MaterialState.REPAIR);    // material 1: Smartboard   | REPAIR 
            materials.add(new Material("projector"));
            materials.get(2).setState(MaterialState.BROKEN);    // material 2: Projector    | BROKEN
            materials.add(new Material("balance"));
            materials.get(3).setState(MaterialState.LENT);      // material 3: Balance      | LENT
            ArrayList<String> specs = new ArrayList<String>();
            specs.add("Intel Core I5, 2.0GHz"); 
            specs.add("4GB DDR SDRAM"); 
            specs.add("Windows 10, x86-64");
            materials.add(new Computer("Dell Inspiron", MaterialState.OK, specs));  // material 4: Computer | OK

            // programming lab materials
            ArrayList<Material> csMaterials = new ArrayList<Material>();
            csMaterials.add(materials.get(1));  // smartboard
            csMaterials.add(materials.get(4));  // computer

            // physics lab materials
            ArrayList<Material> pyMaterials = new ArrayList<Material>();
            pyMaterials.add(materials.get(0));  // whiteboard
            pyMaterials.add(materials.get(2));  // projector
            pyMaterials.add(materials.get(3));  // balance

            rooms.add(new Room("maths", 30));                                   // room 0: Math
            rooms.add(new Room("lecture hall", 25));                            // room 1: Lecture Hall
            rooms.add(new Laboratory("programming lab", 15, csMaterials));      // room 2: [Lab] Programming
            rooms.add(new Laboratory("physics lab", 10, pyMaterials));          // room 3: [Lab] Physics
        }
    }

    public static ArrayList<Room> getRooms() { return rooms; }

    public static Room getRoom(String designation) {
        for (Room room : rooms) {
            if (room.getDesignation().equals(designation))
                return room;
        }
        return null;
    }

    public static ArrayList<Material> getMaterials(String designation) {
        Room room = getRoom(designation);
        return (room instanceof Laboratory) ? ((Laboratory)room).materials : null;
    }

}
