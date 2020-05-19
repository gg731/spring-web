package ru.webproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webproject.Domain.Teacher;
import ru.webproject.Repository.TeacherRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    public Teacher findById(int id) {
        return repository.findById(id).get();
    }

    public List<Teacher> findByFio(String fio) {
        return repository.findAllByFio(fio);
    }

    public List<Teacher> findAllTeacher() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public void saveTeacher(Teacher teacher) {
        repository.save(teacher);
    }

}
