package ru.webproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.webproject.Domain.User;
import ru.webproject.Service.UserService;

import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;


    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }


    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping("/saveProfile")
    public String saveProfileChange(@RequestParam("name") String name,
                                    @RequestParam("email") String email,
                                    @RequestParam("pas1") String pas1,
                                    @RequestParam("pas2") String pas2,
                                    HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (!pas1.equals(pas2)) {
            return "redirect:profile?message=The+passwords+do+not+and+then+retype+the+password.";
        } else {
            userService.updateUser(email, name, user.getUsername());
            session.setAttribute("user", userService.findByUsername(user.getUsername()));
            return "redirect:profile?message=Successfully+updated.";
        }
    }


    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping("uploadPhoto")
    public String uploadPhoto(@RequestParam("file") MultipartFile file, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (!file.isEmpty()) {
            try {
                FileOutputStream fos = new FileOutputStream("./src/main/webapp/WEB-INF/view/static/avatar/" + user.getUsername() + ".jpeg");
                fos.write(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:profile?message=Photo+uploaded.";
    }


}
