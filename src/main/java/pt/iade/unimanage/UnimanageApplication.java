package pt.iade.unimanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pt.iade.unimanage.models.Enrolment;
import pt.iade.unimanage.models.RoomRepository;
import pt.iade.unimanage.models.Student;
import pt.iade.unimanage.models.StudentRepository;
import pt.iade.unimanage.models.TeacherRepository;
import pt.iade.unimanage.models.Unit;
import pt.iade.unimanage.models.UnitRepository;

@SpringBootApplication
public class UnimanageApplication {

	public static void main(String[] args) {
		UnitRepository.populate();
		StudentRepository.populate();
		RoomRepository.populate();
		TeacherRepository.populate();
		SpringApplication.run(UnimanageApplication.class, args);
	}

}
