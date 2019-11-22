package com.tts.KetoWeb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tts.KetoWeb.Model.Recipe;
import com.tts.KetoWeb.Service.RecipeService;

@RestController
@RequestMapping("/api/recipe")
@CrossOrigin
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	//Create&Update Recipe
	@PostMapping("")
	public ResponseEntity<?> addToRecipe (@RequestBody Recipe recipe) {
		Recipe newRecipe = recipeService.saveOrUpdateRecipe(recipe);
		
		return new ResponseEntity<Recipe>(newRecipe, HttpStatus.CREATED);
	}
	
	//Read all recipe
	@GetMapping("/all")
	public Iterable<Recipe> getAllRecipe() {
		return recipeService.findAll();
	}
	
	//Find recipe by id
	@GetMapping("/{recipe_id}")
	public ResponseEntity<?> getRecipeById(@PathVariable Long recipe_id) {
		Recipe recipe = recipeService.findById(recipe_id);
		return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
	}
	
	//Delete Recipe
	@DeleteMapping("/{recipe_id}")
	public ResponseEntity<?> deleteRecipeById(@PathVariable Long recipe_id) {
		recipeService.delete(recipe_id);
		return new ResponseEntity<String>("Project Task Deleted", HttpStatus.OK);
	}
	
	//Filter By Category
	@GetMapping("/all/{category}")
	public List<Recipe> getRecipeByCategory(@PathVariable String category) {
		List<Recipe> recipe = recipeService.findByCategory(category);
		return recipe;
	}
}


