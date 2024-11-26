package com.example.nimapbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nimapbackend.model.Products;
import com.example.nimapbackend.model.ResponseDTO;
import com.example.nimapbackend.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public ResponseDTO findAllProds(@RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageNo, @RequestParam(value = "pageSize", defaultValue = "2", required = false) int pageSize) {
		return productService.findAllProducts(pageNo,pageSize);
	}
	
	@GetMapping("/products/{di}")
	public Products findById(@PathVariable("di") int id) {
		return productService.findByProductsId(id);
	}
	
	@PostMapping("/products")
	public Products addProds(@RequestBody Products prod) {
		//TODO: process POST request
		
		return productService.addProducts(prod);
	}
	
	@DeleteMapping("/products/{di}")
	public int deleteproducts(@PathVariable("di") int id) {
		
			
			return productService.deleteProducts(id);
		
	}
	
	@PutMapping("/products/{di}")
	public int putMethodName(@PathVariable("di") int id, @RequestBody Products prod) {
		//TODO: process PUT request
		
		return productService.updateProducts(id, prod);
	}
	
	
	
	
	
	

}
