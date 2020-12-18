package org.wecancodeit.schoolteacherdemo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.schoolteacherdemo.models.Subject;
import org.wecancodeit.schoolteacherdemo.repositories.SubjectRepository;


import javax.annotation.Resource;
import java.util.Optional;

@Controller
public class SubjectController {


    @Resource
    private SubjectRepository subjectRepo;

    @RequestMapping("/subjects")
    public String displaySubjects(Model model){
        model.addAttribute("subjects", subjectRepo.findAll());
        return "subjectsVeiw";
    }

    @RequestMapping("/subjects/{id}")
    public String displaySingleSubject(@PathVariable long id, Model model){
        Optional<Subject> retrievedSubject = subjectRepo.findById(id);
        Subject foundSubject = retrievedSubject.get();
        model.addAttribute("subject", retrievedSubject);
        return "subjectView";
    }
}
