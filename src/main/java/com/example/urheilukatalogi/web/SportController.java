package com.example.urheilukatalogi.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.urheilukatalogi.domain.CategoryRepository;
import com.example.urheilukatalogi.domain.SportRepository;
import com.example.urheilukatalogi.model.Sport;

@Controller
public class SportController {
	@Autowired
	private SportRepository sRepository;
	@Autowired
	private CategoryRepository cRepository;
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	 public String signUp() {
		return "redirect:signup";
	}
	
	// find all sports
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String sportList(Model model) {
		model.addAttribute("sports", sRepository.findAll());
		return "index";
	}
	
	//add new sport category
	@RequestMapping(value="/add")
	public String addSport(Model model) {
		model.addAttribute("sport", new Sport());
		model.addAttribute("sportcategory", cRepository.findAll());
		return "addsport";	
	}
	
	//save sport
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Sport sport){
        sRepository.save(sport);
        return "redirect:index";
    }    
    
    //delete sport
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteSport(@PathVariable("id") Long sportId, Model model) {
    	sRepository.deleteById(sportId);
        return "redirect:../index";
    }
    
    //edit sport
    @RequestMapping(value = "/edit/{id}")
    public String editSport(@PathVariable("id") Long sportId, Model model){
         model.addAttribute("sport", sRepository.findById(sportId));
         model.addAttribute("categories", cRepository.findAll());
         return "editsport";
    }
    
 // RESTful service to get all sports
    @RequestMapping(value="/sports", method = RequestMethod.GET)
    public @ResponseBody List<Sport> sportListRest() {	
        return (List<Sport>) sRepository.findAll();
    }    

	// RESTful service to get sport by id
    @RequestMapping(value="/sport/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Sport> sportFindRest(@PathVariable("id") Long sportId) {	
    	return sRepository.findById(sportId);
    }

	
	
}
