package com.niit.HomeControl;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


@RequestMapping(value="/index")
public String showHome(Model mod)
{
	mod.addAttribute("ch","true");
	return "index";
}
	
		@RequestMapping("/register")
    public String registerUser(Model model) {

    	User user = new User();
       
        model.addAttribute("user", user);

        return "registeruser";

    }
		
			
    /*
     * registerUserPost method is used to register user into  the system and to show registration related errors
     */
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

    }
    
    
    @RequestMapping("/Loginpage")

    public String Login()
    {
    	
    
    	
    return "login";

    }
}