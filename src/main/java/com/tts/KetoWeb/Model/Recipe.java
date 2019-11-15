package com.tts.KetoWeb.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="recipe")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@NotBlank(message = "Name cannot be blamk")
	@Column(name="name")
	private String name;
	
	@Column(name="number_of_ingredients")
	private int numberOfIngredients;
	
	@Column(name="cookTime")
	private int cookTime;
	
	@Column(name="carbs")
	private int carbs;
	
	@Column(name="images")
	private String images;

}