package pt.iade.unimanage.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import pt.iade.unimanage.models.Person;
import pt.iade.unimanage.models.StudentRepository;
import pt.iade.unimanage.models.TeacherRepository;

public class PersonController {
    private Logger logger = LoggerFactory.getLogger(PersonController.class);

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getPersons() {
        logger.info("Sending all persons");
        ArrayList<Person> persons = getAllPersons();
        return persons;
    }
    private ArrayList<Person> getAllPersons() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.addAll(StudentRepository.getStudents());
        persons.addAll(TeacherRepository.getTeachers());
        return persons;
    }

    // getting person from reference
    @GetMapping(path = "/{reference}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPerson(@PathVariable("reference")String reference) {
        ArrayList<Person> persons = getAllPersons();
        for (Person person : persons) {
            if (person.getReference().equals(reference))
                return person;
        }
        return null;
    }

    // search for person
    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> searchPersons(@RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "email", defaultValue = "") String email) {
        ArrayList<Person> persons = getAllPersons();
        persons.removeIf((p) -> !(p.getName().contains(name) && p.getEmail().contains(email)));
        return persons;
    }
}
