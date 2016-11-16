package com.niit.HomeControl;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.DAO.CartDao;
import com.niit.backend.DAO.CategoryDao;
import com.niit.backend.DAO.ProductDao;
import com.niit.backend.DAO.SupplierDao;
import com.niit.backend.DAO.UserDao;
import com.niit.backend.model.Cart;
import com.niit.backend.model.Category;
import com.niit.backend.model.Product;
import com.niit.backend.model.Supplier;
import com.niit.backend.model.User;


@Controller
public class LoginandHomeControl {
	
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private SupplierDao supplierDao;
@Autowired
	private ProductDao productDao;
	
	@Autowired
	private Category category;
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private Product product;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private User user;
	
	@Autowired
	private Cart cart;
	@Autowired
	CartDao cartDao;
	
	

	
	@RequestMapping("/login")
	public ModelAndView login(Model mod,@ModelAttribute(value="email")String email,
			@ModelAttribute(value="password")String password)
	

	
	{	
		
		ModelAndView mv = new ModelAndView("login");
	
		
		
		user=null;
	
		user = userDao.isvalidUser(email, password);
		if( user == null){
			mod.addAttribute("login", "true");
			mv.addObject("errormessage","Pls Enter Valid Email & Password ");
		
			
		
		}else{
			if (user.getRole().equals("ROLE_ADMIN")){
			 mv = new ModelAndView("admin");
			 mod.addAttribute("adminhello","true");
			    session.setAttribute("Adminname", user.getName());
				session.setAttribute("categoryList", categoryDao.list());
				session.setAttribute("supplierList", supplierDao.list());
				session.setAttribute("productList", productDao.list());
				
				session.setAttribute("category", category);
				session.setAttribute("product", product);
				session.setAttribute("supplier", supplier);
				
			}else if(user.getRole().equals("ROLE_USER")){
		 mv = new ModelAndView("listedItem");
		 mv.addObject("isLoggedInUser", true);
				session.setAttribute("username",user.getName());
				session.setAttribute("email", user.getEmail());


			}
		}
		
		return mv;
	
}
	
	/*
	@RequestMapping("/logout1")
	
	public String logout(Model mod){
			
	mod.addAttribute("msg","successfully logged out");
			
	 mod.addAttribute("ch1","true");
	      
	 return "index";
	}*/

	
	 @RequestMapping("/aftersuccess")
	 public String aftersuccess(Model mod){
		 mod.addAttribute("ch1","true");
		 return "home";
	 }
		    
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("/login");
		//session.invalidate();
		session = request.getSession(true);
		session.setAttribute("category",category);
		session.setAttribute("categoryList",categoryDao.list());
		
		mv.addObject("errormessage1", "successfully LoggedOut");
		mv.addObject("logout","true");
		
		return mv;
	}
}