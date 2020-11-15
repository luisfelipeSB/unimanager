package pt.iade.unimanage.controllers;

import java.util.List;

import javax.xml.transform.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimanage.models.Student;
import pt.iade.unimanage.models.StudentRepository;
import pt.iade.unimanage.models.exceptions.NotFoundException;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController {
    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getStudents() {
        logger.info("Sending all students");
        return StudentRepository.getStudents();
    }

    @GetMapping(path = "{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudent(@PathVariable("number") int number) throws NotFoundException {
        logger.info("Sending student with number " + number);
        Student student = StudentRepository.getStudent(number);
        if (student != null)
            return student;
        else
            throw new NotFoundException("" + number, "Student", "number");
    }

    // ADDED THE (RESULT) CAST SO VSCODE STOPS REDLINING, DON'T KNOW IF IT RIGHT 
    @DeleteMapping(path = "{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result deleteStudent(@PathVariable("number") int number) {
        logger.info("deleting student with number " + number);
        if (StudentRepository.deleteStudent(number))
            return (Result) new Response(number + " was deleted.", null);
        else
            return (Result) new Response(number + " not found.", null);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student addStudent(@RequestBody Student student) {
        return student;
    }
}
