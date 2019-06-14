package com.cs401.alpha.crossAI;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping("/test")
	public String test()
	{
		System.out.println("Welcome test");
		return "test";
	}
	
	@RequestMapping("/Aboutus")
	public String aboutus(Model model)
	{
		System.out.println("Welcome about us");
		AboutusBusinesslogic business = new AboutusBusinesslogic();
		List<Aboutus> listus  = business.getAboutusList();
		model.addAttribute("aboutus", listus);
		
		return "aboutus";
	}
	
	
}
