package com.tts.KetoWeb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.KetoWeb.Model.Recipe;
import com.tts.KetoWeb.Repository.RecipeRepository;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	//PostMapping Method-Create
	public Recipe saveOrUpdateRecipe (Recipe recipe) {
		return recipeRepository.save(recipe);
	}
	
	//GetMapping - Get All Recipes
	public Iterable<Recipe> findAll() {
		return recipeRepository.findAll();
	}
	
	//GetMapping - Get Recipe By ID
	public Recipe findById(Long id) {
		return recipeRepository.getById(id);
	}
	
	//DeleteMapping - Delete Recipe By ID
	public void delete(Long id) {
		Recipe recipe = findById(id);
		recipeRepository.delete(recipe);
	}
	
	
	

}
