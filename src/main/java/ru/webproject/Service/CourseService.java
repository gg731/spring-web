package ru.webproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.webproject.Domain.Course;
import ru.webproject.Domain.Teacher;
import ru.webproject.Repository.CourseRepository;

import java.util.*;
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

    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    public List<Teacher> findTeacherByCourseName(String name) {
        return repository.findAllByName(name).stream().map(course -> course.getTeacher()).collect(Collectors.toList());
    }

    public long count() {
        return repository.count();
    }

    public List<Course> getPage(Integer nPage, Integer pageSize) {
        Pageable pageable = PageRequest.of(nPage, pageSize);
        Page<Course> page = repository.findAll(pageable);
        if (page.hasContent()) return page.getContent();
        else return Collections.EMPTY_LIST;
    }


}
