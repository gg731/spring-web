package ru.webproject.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.webproject.Domain.Authority;

import java.util.List;

public interface AuthorityRepository extends PagingAndSortingRepository<Authority, Long> {

    List<Authority> findAllByUsername(String username);

}
