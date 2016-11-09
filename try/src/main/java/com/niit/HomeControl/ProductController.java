package com.niit.HomeControl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.niit.backend.DAO.CategoryDao;
import com.niit.backend.DAO.ProductDao;
import com.niit.backend.DAO.SupplierDao;
import com.niit.backend.model.Category;
import com.niit.backend.model.Product;
import com.niit.backend.model.Supplier;

@Controller
@Repository("/product")
public class ProductController {
	@Autowired(required = true)
	private ProductDao productDao;
	
	@Autowired(required = true)
	private CategoryDao categoryDao;
	
	@Autowired(required = true)
	private SupplierDao supplierDao;
	
	
	@RequestMapping("/addproduct")
	public ModelAndView newProduct() {
		
		List<Category> categoryList = categoryDao.list();
		List<Supplier> supplierList = supplierDao.list();
	ModelAndView mv = new ModelAndView("/newProduct");
	mv.addObject("categoryList", categoryList);
	mv.addObject("supplierList", supplierList);
	return mv;
	 }
	/*
	@RequestMapping(value="/newProducts", method = RequestMethod.POST)
    public String addItemPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
                                 HttpServletRequest request,Model model) {
    	
        if(result.hasErrors()) {
            return "addproduct";
        }

       productDao.saveOrUpdate(product);

        MultipartFile Image = product.getImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\images\\"+product.getProduct_Id()+".png");


        if (Image != null && !Image.isEmpty()) {
            try {
            Image.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("item image saving failed.", e);
            
        }
return "admin";
       // return "redirect:/admin/furnitureinventory";
    }*/
	
	
	

	@RequestMapping(value = "/newProduct", method=RequestMethod.POST)
	public ModelAndView newProduct( @ModelAttribute ("Product") Product product, @RequestParam("file") MultipartFile file  ) {
	productDao.saveOrUpdate(product);
	
	String path = "C://Users/jithu/workspace/try/src/main/webapp/WEB-INF/images/";
	
	FileUtil.upload(path, file, product.getProduct_Id()+".jpg");
	
	  return new ModelAndView("admin");
	 }
	
	@RequestMapping("/viewProducts")
	public ModelAndView viewProducts() {

		List<Product> List = productDao.list();
		
		ModelAndView mv = new ModelAndView("/viewProduct");
		mv.addObject("productList", List);

		return mv;
	}
	
	
	
	@RequestMapping("/editProduct/{id}")
	public ModelAndView editProduct(@PathVariable ("id") String id){
		Product product = productDao.get(id);
		ModelAndView mv = new ModelAndView("/editProduct");
		mv.addObject("Product", product);
		return mv;
	}	
	

	@RequestMapping(value="/edit",method = RequestMethod.POST)
	public ModelAndView editAndSave(@ModelAttribute ("Product") Product product){
		productDao.saveOrUpdate(product);
		List<Product> List = productDao.list();
		ModelAndView mv = new ModelAndView("viewProduct");
		mv.addObject("productList", List);
		return mv;
	}
	
	
	
	
	@RequestMapping("deleteProduct/{id}")
	public String deleteProduct(@PathVariable ("id") String id){
	
	productDao.delete(id);
	return "redirect:/viewProducts";
	}
	
	
	@ModelAttribute
	public void commonToProduct(Model model){
		 model.addAttribute("isLoggedInAdmin", true);
	}
	
}