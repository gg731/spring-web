package ru.webproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.webproject.Domain.Student;
import ru.webproject.Service.StudentService;

import java.util.Date;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;


    @GetMapping("/students")
    public String students(@RequestParam(name = "nPage", defaultValue = "0") Integer nPage,
                           @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                           Model model) {
        model.addAttribute("students", service.getPage(nPage, pageSize));
        model.addAttribute("pages", new Integer[(int) Math.ceil((double) service.count() / 5)]);
        return "students";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/students/add")
    public String addStudent() {
        return "create-students";
    }

    @PostMapping("/createStudent")
    public String createStudent(@RequestParam("name") String name,
                                @RequestParam("birth") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birth,
                                @RequestParam("score") int score) {

        service.saveStudent(new Student(name, birth, (long) score));
        System.out.println(name + birth + score);
        return "redirect:/students";
    }


}
