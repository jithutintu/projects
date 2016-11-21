package com.niit.HomeControl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@SuppressWarnings("unused")
	@Autowired
	private Cart cart;
	
	@RequestMapping("/cart/{id}")
	public ModelAndView viewProductDetails(@PathVariable("id") String Id) {
		Product product = productDao.get(Id);
		ModelAndView mv = new ModelAndView("/success");
		mv.addObject("isProductClicked", true);
		mv.addObject("isLoggedInUser", true);
		mv.addObject("product", product);
		
	  return mv;	  
	 }

	@RequestMapping("/addToCart/{email}/{product_Id}")
	public String addCart(@PathVariable("email") String email, @PathVariable("product_Id") String product_Id ,Model model){
		
		Product product = productDao.get(product_Id);
		User user = userDao.get(email);
	
		
			 
			if(product.getProduct_Stock() > 1){
				
				Cart cart = new Cart();
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
			return "redirect:/myCart";
	
	}
	@RequestMapping(value="/myCart",method = RequestMethod.GET)
	public String viewCart(Model model,HttpSession session)
	{
		
		model.addAttribute("cart", new Cart());
		String emailid=(String)session.getAttribute("email");
		long count = cartDao.getCount(emailid);
		model.addAttribute("numberOfProduct", count);
			model.addAttribute("cartList",cartDao.list(emailid));
			model.addAttribute("total",cartDao.getTotalAmount(emailid));
			model.addAttribute("isAddToCartClicked", "true");
			model.addAttribute("isMyCartClicked", "true");
		return "success";
	}
	@RequestMapping("/deletecart/{productName}")
	public String deleteCart(@PathVariable ("productName") String productName, Model model){
	
		cartDao.delete(productName);
		model.addAttribute("isMyCartClicked", true);
		
		model.addAttribute("isLoggedInUser", true);
		//String message = "You Have Successfully Logged In";
		//model.addAttribute("msg", message);
		return "success";
		
	} 
	
	/*@ModelAttribute
	public void commonObject(Model model){	
		
		model.addAttribute("isLoggedInUser", true);
		String message = "You Have Successfully Logged In";
		model.addAttribute("msg", message);
	}*/
	
	
}

	

