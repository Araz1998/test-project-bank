package com.badalovaraz.testProjectBank.testprojectbank.controller;

import java.util.List;

import com.badalovaraz.testProjectBank.testprojectbank.business.service.ProductService;
import com.badalovaraz.testProjectBank.testprojectbank.data.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@Autowired
	private ProductService service;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
//		List<Product> listProducts = service.listAll();
//		System.err.println(listProducts.size() + " -PRODUCT SIZW");
//		System.out.println(listProducts.size());
//		model.addAttribute("listProducts", listProducts);
		List<Product> products = service.listAll();
		model.addAttribute("products", products);
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_product");
		
		Product product = service.get(id);
		mav.addObject("product", product);
		
		return mav;
	}	
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		service.delete(id);
		
		return "redirect:/";
	}

	@RequestMapping("/product")
	public String getProduct(Model model) {
		List<Product> products = service.listAll();
		model.addAttribute("products", products);
		return "product";
	}
}
