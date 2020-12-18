package org.wecancodeit.schoolteacherdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.schoolteacherdemo.models.School;
import org.wecancodeit.schoolteacherdemo.repositories.SchoolRepository;

import javax.annotation.Resource;

@Controller
public class SchoolController {


    @Resource
    private SchoolRepository schoolRepo;

    @RequestMapping({"/schools","/", ""})
    public String displaySchools(Model model){
        model.addAttribute("schools", schoolRepo.findAll());
        return "schoolsVeiw";
    }

    @GetMapping("/schools/{location}")
    public String displaySingleSchool(@PathVariable String location, Model model){
        School retrievedSchool = schoolRepo.findSchoolByLocation(location);
        model.addAttribute("school", retrievedSchool);
        return "schoolView";
    }



}
