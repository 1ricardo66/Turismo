package com.ricardofelix.Turismo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomePage {
	
	@GetMapping(value="/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("home");
		return mv;
	}

}
