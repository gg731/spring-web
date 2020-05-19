package ru.webproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webproject.Domain.Course;
import ru.webproject.Domain.Student;
import ru.webproject.Repository.StudentRepository;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student findById(int id) {
        return repository.findById(id).get();
    }

    public List<Student> findByName(String name) {
        return repository.findAllByName(name);
    }

    public List<Student> findAllStudent() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public void saveStudent(Student student) {
        repository.save(student);
    }

    public List<Student> findStudentByCourseName(String name) {
        return new CourseService().findByName(name).stream().map(course -> course.getStudent()).collect(Collectors.toList());
    }
}
