package com.niit.HomeControl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.DAO.SupplierDao;
import com.niit.backend.model.Supplier;

@Controller
@Repository()
public class SupplierController {
	@Autowired
	private SupplierDao supplierDao;
	

	@RequestMapping("/addsupplier")
	public ModelAndView newSupplier() {
		return new ModelAndView("newSupplier");
	 }
	
	@RequestMapping("/newSupplier")
	public ModelAndView newSupplier(@ModelAttribute Supplier supplier) {
		supplierDao.save(supplier);
	  return new ModelAndView("admin");
	 }
	
	
	@RequestMapping("/viewSuppliers")
	public ModelAndView viewSuppliers() {

	//	System.out.println("getAllSuppliers");
		
		List<Supplier> supplierList = supplierDao.list();
		
		ModelAndView mv = new ModelAndView("viewSupplier");
		mv.addObject("supplierList", supplierList);
		mv.addObject("isViewCategoriesClicked", true);
		return mv;
		
	}
		@RequestMapping("/editSupplier/{id}")
		public ModelAndView viewSupplier(@PathVariable ("id") String id) {
				Supplier supplier = supplierDao.get(id);
				ModelAndView mv = new ModelAndView("editSupplier");
				mv.addObject("supplier", supplier);
		  return mv;
		  
		 }
		
		@RequestMapping("/editSupplier")
		public ModelAndView editAndSave(@ModelAttribute ("Supplier") Supplier supplier){
			supplierDao.saveorupdate(supplier);
			List<Supplier> supplierList = supplierDao.list();
			
			ModelAndView mv = new ModelAndView("/viewSupplier");
			mv.addObject("supplierList", supplierList);
			return mv;

		}
		
		@RequestMapping("/deleteSupplier/{id}")
		public String deleteSupplier(@PathVariable ("id") String id){
			
			supplierDao.delete(id);
			
			return "redirect:/viewSuppliers";
		}
		
		@ModelAttribute
		public void commonToSupplier(Model model){
			 model.addAttribute("isLoggedInAdmin", true);
		}
}
