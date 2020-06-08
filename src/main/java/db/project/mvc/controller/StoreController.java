package db.project.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StoreController {

    @RequestMapping("/")
    private String home() throws Exception{
        return "home";
    }

}
