package ru.webproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webproject.Domain.Authority;
import ru.webproject.Repository.AuthorityRepository;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public void setAuthority(Authority authority) {
        authorityRepository.save(authority);
    }

}
