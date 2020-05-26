package ru.webproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.webproject.Domain.Authority;
import ru.webproject.Domain.User;
import ru.webproject.Repository.AuthorityRepository;
import ru.webproject.Repository.UserRepository;
import ru.webproject.MyUserPrincipial;

import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

       List<Authority> f = authorityRepository.findAllByUsername(user.getUsername());
        return new MyUserPrincipial(user,f);
    }
}
