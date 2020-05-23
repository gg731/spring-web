package ru.webproject.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.webproject.Domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(String userName);


}
