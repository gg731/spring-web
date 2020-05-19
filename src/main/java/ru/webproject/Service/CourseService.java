package ru.webproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webproject.Domain.Course;
import ru.webproject.Domain.Teacher;
import ru.webproject.Repository.CourseRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public Course findById(int id) {
        return repository.findById(id).get();
    }

    public List<Course> findByName(String name) {
        return repository.findAllByName(name);
    }

    public List<Course> findAllCourse() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public void saveCourse(Course course) {
        repository.save(course);
    }

    public List<Teacher> findTeacherByCourseName(String name) {
        return repository.findAllByName(name).stream().map(course -> course.getTeacher()).collect(Collectors.toList());
    }


}
