package com.niit.HomeControl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.DAO.CategoryDao;
import com.niit.backend.DAO.ProductDao;
import com.niit.backend.model.Category;
import com.niit.backend.model.Product;
import com.niit.util.Util;

@Controller
public class CategoryControlller {
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private Category category;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private Product product;
	
	
	@RequestMapping("/addcategory")
	public ModelAndView addCategory() {
		ModelAndView mv = new ModelAndView("newCategory");
		mv.addObject("isAddCategoryClicked", true);
	  return mv;
	 }
	
	@RequestMapping("/newCategory")
	public ModelAndView newCategory(@ModelAttribute Category category) {
		categoryDao.saveorupdate(category);
		ModelAndView mv = new ModelAndView("admin");
	
		return mv;
	 }
	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category) {

		Util util = new Util();
		String id=  util.replace(category.getId(), ",", "");
		category.setName(id);
		
		categoryDao.saveorupdate(category);

		//return "redirect:/category";
		return "category";
	}
	/*
	@RequestMapping("/orderedBy")
	public ModelAndView orderedBy(@RequestParam(value="search") String search ) {
		
		categoryDAO.search(search);
		
		List<Category> categoryList = categoryDAO.list();
		
		ModelAndView mv = new ModelAndView("viewCategory");
		
		mv.addObject("categoryList", categoryList);
		
		return mv;
		
	}*/
	
	
	@RequestMapping("/viewCategories")
	public ModelAndView viewCategories() {

		List<Category> categoryList = categoryDao.list();
		
		ModelAndView mv = new ModelAndView("viewCategory");
	
		mv.addObject("categoryList", categoryList);
		mv.addObject("isViewSupplierClicked", true);

		return mv;
	}
	
	
	
	
	
	@RequestMapping("/editcategory/{id}")
	public ModelAndView editCategory(@PathVariable("id") String id) {
	Category category = categoryDao.get(id);
		ModelAndView mv = new ModelAndView("/editCategory");
		mv.addObject("Category", category);
		return mv;
	}
	
	@RequestMapping(value="/editcategory",method = RequestMethod.POST)
	public ModelAndView editAndSave(@ModelAttribute ("Category") Category category){
		categoryDao.saveorupdate(category);
		List<Category> List = categoryDao.list();
		ModelAndView mv = new ModelAndView("viewCategory");
		mv.addObject("categoryList", List);
		return mv;
	}
	
	/*@RequestMapping("/editcategory/{id}")
	public ModelAndView editCategory(@PathVariable ("id") String id){
		Category category = categoryDao.get(id);
		categoryDao.saveorupdate(category);
		
		ModelAndView mv = new ModelAndView("/editCategory");
		mv.addObject("category", category);
		mv.addObject("ID", category.getId());
		mv.addObject("Name", category.getName());
		mv.addObject("Description", category.getDescription());
		return mv;
	}*/
	@RequestMapping("/deletecategory/{id}")
	public String deleteCategory(@PathVariable ("id") String id,ModelMap model){
		
		 categoryDao.delete(id);
		return "redirect:/viewCategories";
	
		
	}
	
	@ModelAttribute
	public void commonToCategory(Model model){
		 model.addAttribute("isLoggedInAdmin", true);
	}

}
