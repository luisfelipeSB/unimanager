package pt.iade.unimanage.controllers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimanage.models.Laboratory;
import pt.iade.unimanage.models.Material;
import pt.iade.unimanage.models.Room;
import pt.iade.unimanage.models.RoomRepository;
import pt.iade.unimanage.models.Teacher;
import pt.iade.unimanage.models.exceptions.NotFoundException;

@RestController
@RequestMapping(path = "/api/rooms")
public class RoomController {
    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    // get all rooms
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Room> getRooms() {
        logger.info("Sending all rooms");
        return RoomRepository.getRooms();
    }

    // get a room
    @GetMapping(path = "{designation}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Room getRoom(@PathVariable("designation") String designation) throws NotFoundException {
        logger.info("Sending room with designation " + designation);
        Room room = RoomRepository.getRoom(designation);
        if (room != null)
            return room;
        else
            throw new NotFoundException("" + designation, "Room", "¯\\_(ツ)_/¯");
    }

    // get materials
    @GetMapping(path = "{designation}/materials", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Material> getMaterials(@PathVariable("designation") String designation) {
        logger.info("Sending materials from room with designation " + designation);
        Room room = RoomRepository.getRoom(designation);
        return (room instanceof Laboratory) ? ((Laboratory)room).getMaterials() : null;
    }

    // assign a teacher
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public void assignTeacher(@RequestBody Teacher teacher, @RequestBody Room room) {
        logger.info("assigning teacher " + teacher.getMecNumber() + " to " + room.getDesignation() + " room.");
        teacher.assignClassroom(room);
    }
}