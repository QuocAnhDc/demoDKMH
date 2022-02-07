package com.example.demodkmh.controller.user;

import com.example.demodkmh.service.SubjectService;
import com.example.demodkmh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RegisterSubject {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showPage(Model model){
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "index";
    }

    @GetMapping("/resgisterSubject/{id}/{email}")
    public String registerSubject(Model model,@PathVariable Long id, @PathVariable String email){
        try{
            userService.registerSubject(id,email);
            model.addAttribute("subjects", subjectService.getAllSubjects());
            return "index";
        }
        catch (Exception e){
            return "403";
        }
    }
    @GetMapping("/show/{email}")
    public  String show(Model model,@PathVariable String email){
        model.addAttribute("subject_register",subjectService.getAllSubjectRegister(email));
        return "show";
    }
    @GetMapping("/deleteSubject/{id}/{email}")
    public String deleteSubject(Model model,@PathVariable Long id, @PathVariable String email){
        userService.removeSubject(email,id);
        return show(model,email);
    }
}
