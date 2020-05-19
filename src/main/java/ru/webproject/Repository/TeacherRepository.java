package ru.webproject.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.webproject.Domain.Teacher;

import java.util.List;

public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Integer> {

    List<Teacher> findAllByFio(String fio);
}
