package ru.webproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {


    @GetMapping("/error")
    public ModelAndView errorPage(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView("error");
        String err = "";
        int errCode = (int) request.getAttribute("javax.servlet.error.status_code");
        switch (errCode) {
            case 403:
                err = "У вас нет доступа в данный раздел сайта";
                break;
            case 404:
                err = "Старница не найдена";
                break;
            case 500:
                err = "Ошибка на сервере";
                break;
        }
        modelAndView.addObject("err", err);
        return modelAndView;
    }
}
