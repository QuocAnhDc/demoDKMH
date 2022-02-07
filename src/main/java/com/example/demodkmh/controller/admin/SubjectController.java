package com.example.demodkmh.controller.admin;

import com.example.demodkmh.model.Subjects;
import com.example.demodkmh.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/editsubject")
    public String viewHomePage(Model model) {
        return findPaginated(1, "name", "asc", model);
    }

    @GetMapping("/showNewSubjectForm")
    public String showNewSubjectForm(Model model) {
        // create model attribute to bind form data
        Subjects subject = new Subjects();
        model.addAttribute("subject", subject);
        return "new_subject";
    }

    @PostMapping("/saveSubject")
    public String saveSubject(@ModelAttribute("subject") Subjects subjects) {
        // save employee to database
        try{
            subjectService.saveSubject(subjects);
            return "redirect:/editsubject";
        }
        catch (Exception e){
            return "redirect:/showNewSubjectForm?error";
        }
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

        Subjects subject = subjectService.getSubjectById(id);

        model.addAttribute("subject", subject);
        return "update_subject";
    }

    @GetMapping("/deleteSubject/{id}")
    public String deleteSubject(@PathVariable (value = "id") long id) {

        // call delete employee method
        this.subjectService.deleteSubjectById(id);
        return "redirect:/editsubject";
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Subjects> page = subjectService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Subjects> listSubject = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listSubject", listSubject);
        return "edit_subject";
    }
}
