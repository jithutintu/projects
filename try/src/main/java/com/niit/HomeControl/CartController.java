package com.niit.HomeControl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.DAO.CartDao;
import com.niit.backend.DAO.ProductDao;
import com.niit.backend.DAO.UserDao;
import com.niit.backend.model.Cart;
import com.niit.backend.model.Product;
import com.niit.backend.model.User;



@Controller
@SessionAttributes("email")
public class CartController {
	@Autowired(required = true)
	private ProductDao productDao;
	
	@Autowired(required = true)
	private UserDao userDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private Cart cart;
	
	@RequestMapping("/cart/{id}")
	public ModelAndView viewProductDetails(@PathVariable("id") String Id, @ModelAttribute(value = "email") String email) {
		Product product = productDao.get(Id);
		ModelAndView mv = new ModelAndView("/success");
		mv.addObject("isProductClicked", true);
		mv.addObject("product", product);
		if(email != null){
			mv.addObject("isLoggedInUser", true);
		}
		//mv.addObject(username);
	  return mv;	  
	 }

	@RequestMapping("/addToCart/{email}/{product_Id}")
	public String addCart(@PathVariable("email") String email, @PathVariable("product_Id") String product_Id, Model model){
		
		Product product = productDao.get(product_Id);
		User user = userDao.get(email);
		
		if(product.getProduct_Stock() > 1){
			
			
			cart.setProductName(product.getProduct_Name());
			cart.setPrice(product.getProduct_Price());
			cart.setQuantity(1);
			cart.setStatus("N");
			cart.setUserName(user.getName());
			cart.setUserId(user.getEmail());
			
		
			
			int stock = product.getProduct_Stock() - 1;
			product.setProduct_Stock(stock);
			
			cartDao.saveOrUpdate(cart);
			productDao.saveOrUpdate(product);
			
			
			
		}
		
		
		return "redirect:/myCart/{email}";
	}
	
	@RequestMapping("/myCart/{email}")
	public  ModelAndView myCart(@PathVariable("email") String email,	Model model)
	{	
		User user = userDao.get(email);
		
		
	List<Cart> cartList = cartDao.list(user.getEmail());
	long total = cartDao.getTotalAmount(user.getEmail());
 		ModelAndView mv = new ModelAndView("success");
 	mv.addObject("isAddToCartClicked", true);
		mv.addObject("cartList", cartList);
		mv.addObject("total", total);
		
		
		
		return mv;
		}
	@RequestMapping("deletecart/{productName}")
	public String deleteCart(@PathVariable ("productName") String productName, Model model){
	
		cartDao.delete(productName);
		model.addAttribute("isMyCartClicked", true);
		
		model.addAttribute("isLoggedInUser", true);
		String message = "You Have Successfully Logged In";
		model.addAttribute("msg", message);
		return "success";
		
	}
	
	/*@ModelAttribute
	public void commonObject(Model model){	
		
		model.addAttribute("isLoggedInUser", true);
		String message = "You Have Successfully Logged In";
		model.addAttribute("msg", message);
	}*/
	
	
}

	

