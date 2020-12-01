package pt.iade.unimanage.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimanage.models.Unit;
import pt.iade.unimanage.models.UnitRepository;

@RestController
@RequestMapping(path = "/api/units")
public class UnitController {
    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    // get all units
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Unit> getUnits() {
        logger.info("Sending all units");
        return UnitRepository.getUnits();
    }

    // get a specific unit
    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Unit getUnit(@PathVariable("id") int courseID) {
        logger.info("Sending unit with ID " + courseID);
        return UnitRepository.getUnit(courseID);
    }
}