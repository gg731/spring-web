package ru.webproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.webproject.Domain.Course;
import ru.webproject.Service.CourseService;

@Controller
public class CourseController {

    @Autowired
    CourseService service;


    @GetMapping("/courses")
    public String courses(@RequestParam(name = "nPage", defaultValue = "0") Integer nPage,
                          @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                          Model model) {
        model.addAttribute("courses", service.getPage(nPage, pageSize));
        model.addAttribute("pages", new Integer[(int) Math.ceil((double) service.count() / 5)]);
        return "courses";
    }


    @GetMapping("courses/add")
    public String addCourse() {
        return "create-course";
    }


    @Secured("ROLE_ADMIN")
    @PostMapping("/createCourse")
    public String create(@RequestParam("name") String name, @RequestParam("duration") Integer duration) {
        service.saveCourse(new Course(name, duration));
        return "redirect:/courses";
    }
}
