package ru.webproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.webproject.Domain.Teacher;
import ru.webproject.Service.TeacherService;

@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("teachers")
    public String allTeachers(Model model) {
        model.addAttribute("teachers", teacherService.findAllTeacher());
        return "teachers";
    }

    @GetMapping("teachers/add")
    public String addTeacher() {
        return "create-teacher";
    }

    @PostMapping("teacher/create")
    public String createTeacher(@RequestParam("fio") String fio, @RequestParam("about") String about) {
        teacherService.saveTeacher(new Teacher(fio, about));
        return "redirect:teachers";
    }
}