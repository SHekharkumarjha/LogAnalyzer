package com.example.blueoptima.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String HomePage(){
        return "HomePage";
    }

    @PostMapping("/output")
    public String showResult(String msg, ModelMap map){
        map.put("msg", msg);
        return "result";
    }
}
