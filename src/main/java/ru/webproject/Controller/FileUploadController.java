package ru.webproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class FileUploadController {

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             @RequestParam("name") String name,
                             Model model) {

        if (!file.isEmpty()) {
            try (FileOutputStream fos = new FileOutputStream(name + ".jpeg")) {
                fos.write(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "redirect:uploadSuccess";
        }
        return "redirect:uploadError";
    }

    @GetMapping("/uploadSuccess")
    public String uploadsucces(Model model) {
        model.addAttribute("success", "Файл успешно загружен!");
        return "/jsp/create";
    }
}
