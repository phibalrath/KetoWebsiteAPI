package com.tts.KetoWeb.Repository;

import org.springframework.stereotype.Repository;

import com.tts.KetoWeb.Model.Recipe;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long>{
	
	Recipe getById(Long id);
}
