package main.java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rahul on 4/2/2017.
 */
@Controller
public class AvailableShopsController {

    @RequestMapping(value = "/home.do", method = RequestMethod.GET)
    public String welcome(){
        return "welcome";
    }
}