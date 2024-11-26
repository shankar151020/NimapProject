package com.example.nimapbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nimapbackend.model.Categories;
import com.example.nimapbackend.service.CategoriesService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoriesService categoriesService;
	
	@GetMapping("/categories")
	public List<Categories> findAllCategories()
	{
		return categoriesService.findAllCategories();
	}
	
	@GetMapping("/categories/{di}")
	public Categories findCategoryById(@PathVariable("di") int id)
	{
		return categoriesService.findByCategoryId(id);
	}
	@PostMapping("/categories")
	public Categories saveCategory(@RequestBody Categories cat)
	{
		return categoriesService.addCategory(cat);
		
		
	}
	
	@DeleteMapping("/categories/{di}")
	public int deleteById(@PathVariable("di") Integer id)
	{
		
		return categoriesService.deleteCategory(id);
	}
	
	@PutMapping("/categories/{di}")
	public int updateCategories(@PathVariable("di") int id,@RequestBody Categories cat)
	{
		return categoriesService.updateCategory(id, cat);
		
	}
}
