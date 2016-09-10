package com.Helllo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String showhome()
	{
		return "home";	
	}
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
public String welcome(Model m){
		m.addAttribute("mess", "Jithuuuuu");
	return "welcome";	
	}
	@RequestMapping("/index")
	public ModelAndView showindex()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("message", "This is IndeX");
		return mv;
	}
}
