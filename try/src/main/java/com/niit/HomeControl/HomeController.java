package com.niit.HomeControl;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.DAO.CategoryDao;
import com.niit.backend.DAO.ProductDao;
import com.niit.backend.DAO.UserDao;
import com.niit.backend.model.Category;
import com.niit.backend.model.Product;
import com.niit.backend.model.User;





@Controller
public class HomeController {
	
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private Category category;
	@Autowired
	private Product product;
	
	
@RequestMapping(value="/")
public ModelAndView showindex(Model mod)
{
	mod.addAttribute("ch","true");
	ModelAndView mv=new ModelAndView("/index");
	List<Category> CategoryList = categoryDao.list();
	List<Product> List = productDao.list(); 
	mv.addObject("productList",List);
	mv.addObject("categoryList",CategoryList);
	return mv;

		
}
@RequestMapping(value="/managepage")
public ModelAndView showadminmanage(Model mod){
ModelAndView mv=new ModelAndView("admin");
return mv;

}
@RequestMapping(value="/home")
public String showHome(Model mod)
{
	mod.addAttribute("ch","true");
	return "home";
}
	
		@RequestMapping("/registeruser")
    public String registerUser(Model model) {

    	User user = new User();
       
        model.addAttribute("user", user);

        return "registeruser";

    }
		@RequestMapping("/register")
		public ModelAndView registerUser(@ModelAttribute User user, @RequestParam(value = "email") String email, ModelMap mod) {
			ModelAndView mv ;
		
		
			
			if(userDao.isAllReadyRegister(email, true))		{
				
				mod.addAttribute("isAllReadyRegister", "true");	
			
				mod.addAttribute("userexists","Your Email Id All Ready Registered");
				
					}
			else {
				user.setRole("ROLE_USER");
				
				userDao.saveorupdate(user);
				mod.addAttribute("isSignupClicked", "true");

				mod.addAttribute("success","You r Registered");
				
			
			}
			mv = new ModelAndView("registeruser");
			
			return mv;
		}
	/*		
    /*
     * registerUserPost method is used to register user into  the system and to show registration related errors
     *//*
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUserPost(@ModelAttribute("user") User user, BindingResult result,
                                       Model model) {
    	System.out.println("jithu");
        if (result.hasErrors()) {
            return "registeruser";
        }

            user.setRole("ROLE_USER");
        //usersDetail.setEnabled(true);
        //usersDetailService.addUser(usersDetail);
userDao.saveorupdate(user);
        return "success";

    }*/
    
   
    @RequestMapping("/Loginpage")

    public String Login()
    {
    	
    return "login";

    }
    
    @RequestMapping("/viewproduct/{name}")
	public ModelAndView viewCategoryItems(@PathVariable ("name") String name){
		List<Category> CategoryList = categoryDao.list();
		List<Product> productList = productDao.list(name);
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("productList", productList);
		mv.addObject("categoryList",CategoryList);
		return mv;
    }
    
    
    
}