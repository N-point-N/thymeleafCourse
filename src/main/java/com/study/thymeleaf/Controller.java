package com.study.thymeleaf;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("")
    public ModelAndView homepage(){
        HashMap<String, Object> model = new HashMap<>();
        model.put("username","Matt");
        model.put("id", 176);
        return new ModelAndView("homepage","model",model);
    }


    @RequestMapping("/profile")
    public ModelAndView viewProfile(){
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("title", "Mr");
        model.put("firstName", "Matt");
        model.put("lastName", "Greencroft");
        model.put("dateOfBirth", new GregorianCalendar(2006,3, 9).getTime());
        model.put("description"," a <strong>fantastic</fantastic> java Programmer");

        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("French");
        languages.add("Spanish");
        languages.add("Danish");

        model.put("languages", languages);
        return new ModelAndView("profile", "model", model);
    }
}
