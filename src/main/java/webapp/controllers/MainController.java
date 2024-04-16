package webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("tittle", "Регистрация");
        return "registration";
    }
    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("main", "Главная страница");
        return "main";
    }
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("about", "cтраница про нас");
        return "about";
    }
    @GetMapping("/selection")
    public String selection(Model model) {
        model.addAttribute("selection", "подбор");
        return "selection";
    }
}
