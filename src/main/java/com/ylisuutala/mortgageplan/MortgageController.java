package com.ylisuutala.mortgageplan;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MortgageController {
    
    @Autowired
    private ProspectRepository prospectRepository;
    
    @GetMapping(path="/")
    public String index(Model model) {
	Iterable<Prospect> prospects = prospectRepository.findAll();
	model.addAttribute("prospects", prospects);
	model.addAttribute("prospectObject", new Prospect());
	return "index";
    }
    
    @PostMapping(path="/add")
    public String addProspect(@Valid Prospect prospect, BindingResult result, Model model) {
	if (!result.hasErrors()) {
	    prospectRepository.save(prospect);
	}
	return "redirect:/";
    }
}
