package ru.webproject.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.webproject.Domain.Course;
import ru.webproject.Service.CourseService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Controller
public class CourseController {

    @Autowired
    CourseService service;


    @GetMapping("/courses")
    public String courses(Model model) {
        model.addAttribute("courses", service.findAllCourse());
        return "/jsp/courses";
    }

    @GetMapping("/courseName")
    public String teacherByCourseName(@RequestParam(value = "name", defaultValue = "java") String name, Model model) {
        model.addAttribute("courses", service.findTeacherByCourseName(name));
        return "/jsp/courses";
    }

    @PostMapping("/courses/add")
    public void addCourse(@RequestBody Course course) {
        service.saveCourse(course);
    }
}
