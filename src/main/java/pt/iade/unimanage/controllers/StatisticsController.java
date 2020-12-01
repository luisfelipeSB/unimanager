package pt.iade.unimanage.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimanage.models.GroupResult;
import pt.iade.unimanage.models.HistogramSlot;
import pt.iade.unimanage.models.StatisticResult;
import pt.iade.unimanage.models.Statistical;
import pt.iade.unimanage.models.StudentRepository;
import pt.iade.unimanage.models.Teacher;
import pt.iade.unimanage.models.TeacherRepository;
import pt.iade.unimanage.models.Unit;
import pt.iade.unimanage.models.UnitRepository;

@RestController
@RequestMapping(path = "/api/statistics")
public class StatisticsController {
    private Logger logger = LoggerFactory.getLogger(TeacherController.class);
    private static final int GRADERANGE = 20;
    private static final int NHISLOTS = 5;

    // getting statistical object
    private Statistical getStatistical(String type, int number) {
        Statistical stats;
        if (type.equalsIgnoreCase("student"))
            stats = StudentRepository.getStudent(number);
        else if ((type.equalsIgnoreCase("unit")))
            stats = UnitRepository.getUnit(number);
        else return null;
        return stats;
    }
    
    // getting histogram
    @GetMapping(path = "histogram/{type}/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HistogramSlot[] getHistogram(@PathVariable("type") String type, @PathVariable("number") int number) {
        logger.info("Obtaining histogram info");
        return getStatistical(type, number).getHistogram(NHISLOTS, GRADERANGE);
    }

    // getting statistical results for a student or unit
    @GetMapping(path = "{type}/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StatisticResult getStatistics(@PathVariable("type") String type, @PathVariable("number") int number) {
        logger.info("Obtaining statistical results for a student or unit");
        Statistical stats;
        if (type.equalsIgnoreCase("student"))
            stats = StudentRepository.getStudent(number);
        else stats = UnitRepository.getUnit(number);

        StatisticResult result = new StatisticResult(stats.getAverage(), stats.getMax(), stats.getMin(), stats.getRange());

        return result;
    }

    // getting average of averages for the teachers or units
    @GetMapping(path = "group/average/{type}/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GroupResult getAverageOfAverages(@PathVariable("type") String type, @PathVariable("number") int number) {
        ArrayList<Statistical> group = new ArrayList<Statistical>();
        GroupResult result;

        if (type.equalsIgnoreCase("teacher")) {
            Teacher t = TeacherRepository.getTeacher(number);
            group.addAll(t.getUnits());
            result = new GroupResult(t, Statistical.getGroupAvg(group), group.size());
        } else if (type.equalsIgnoreCase("unit")) {
            Unit u = UnitRepository.getUnit(number);
            group.addAll(u.getStudents());
            result = new GroupResult(u, Statistical.getGroupAvg(group), group.size());
        } else {
            return null;
        }
        return result;
    }
}
