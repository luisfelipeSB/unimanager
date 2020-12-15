package pt.iade.unimanage.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "")
public class GreeterController {
    private Logger logger = LoggerFactory.getLogger(GreeterController.class);

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting() {
        logger.info("Greeting user");
        return "Hello, welcome to the unimanager app. by adding /api/rooms, persons, students, teachers, or units to the URL, you'll receive information about the respective objects in this imaginary university's repositories. Have fun exploring!";
    }
}