package com.study.thymeleaf;


import com.study.thymeleaf.Model.UserModel;
import com.study.thymeleaf.Validate.UserModelValidator;
import org.apache.catalina.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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

        model.put("color", "#ccc");
        return new ModelAndView("profile", "model", model);
    }

    @RequestMapping("/addUser")
    public ModelAndView addUser(){
        HashMap<String, Object> model = new HashMap<>();
        return new ModelAndView("newUser", "userModel", new UserModel());
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@Valid UserModel userModel, BindingResult bindingResult){
        new UserModelValidator().validate(userModel, bindingResult);
        if (bindingResult.hasErrors()){
            return "newUser";
        }
        return"userAdded";
    }

}
