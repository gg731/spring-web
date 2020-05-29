package ru.webproject.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.webproject.Domain.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String userName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users u SET u.email = ? , u.name = ?  WHERE u.username = ?", nativeQuery = true)
    int updateUser(String mail, String name, String username);

}
