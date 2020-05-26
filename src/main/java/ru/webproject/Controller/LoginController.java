package ru.webproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.webproject.Domain.Authority;
import ru.webproject.Domain.User;
import ru.webproject.MyUserPrincipial;
import ru.webproject.Repository.AuthorityRepository;
import ru.webproject.Repository.UserRepository;
import ru.webproject.Service.AuthorityService;
import ru.webproject.Service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.file.attribute.UserPrincipal;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;


@Controller
public class LoginController {


    @Resource(name = "authenticationManager")
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", defaultValue = "") String error, Model model) {
        if (error.equals("true")) {
            model.addAttribute("error", "Login or password incorrect!");
        }
        return "login";
    }


    @PostMapping("/authenticate")
    public String authenticate(@RequestParam("username") final String username,
                               @RequestParam("password") final String password,
                               final HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authReq
                = new UsernamePasswordAuthenticationToken(username, password);
        Authentication auth = null;
        try {
            auth = authenticationManager.authenticate(authReq);
        } catch (AuthenticationException e) {
            return "redirect:/login?error=true";
        }
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        HttpSession session = request.getSession(true);
        MyUserPrincipial principal = (MyUserPrincipial) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setAttribute("user", principal.getUsername());
        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
        return "redirect:/courses";
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }

    @PostMapping("register")
    public String registerProcess(@RequestParam("username") String username,
                                  @RequestParam("pas1") String pas1,
                                  @RequestParam("pas2") String pas2,
                                  Model model) {
        if (userService.findByUsername(username) != null) {
            model.addAttribute("error", "Username " + username + " is not available.");
            return "register";
        } else if (!pas1.equals(pas2)) {
            model.addAttribute("error", "The passwords do not and then retype the password.");
            return "register";
        } else {
            userService.saveUser(new User(username, new BCryptPasswordEncoder().encode(pas1), true));
            authorityService.setAuthority(new Authority(username, "ROLE_USER"));
            return "redirect:courses";
        }
    }


}

