package ru.webproject.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.webproject.Domain.Course;

import java.util.List;

public interface CourseRepository extends PagingAndSortingRepository<Course, Integer> {

    List<Course> findAllByName(String name);
}
