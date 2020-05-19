package ru.webproject.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.webproject.Domain.Student;

import java.util.List;

public interface StudentRepository extends PagingAndSortingRepository<Student,Integer> {

    List<Student> findAllByName(String name);
}
