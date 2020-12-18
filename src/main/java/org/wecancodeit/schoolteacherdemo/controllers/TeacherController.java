package org.wecancodeit.schoolteacherdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.schoolteacherdemo.repositories.TeacherRepository;

import javax.annotation.Resource;

@Controller
public class TeacherController {

    @Resource
    private TeacherRepository teacherRepo;

    @RequestMapping({"/Teacher"})
    public String displayTeachers(Model model){
        model.addAttribute("teacher", teacherRepo.findAll());
        return "teachersVeiw";
    }
}
