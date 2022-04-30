package com.example.day4.encapsulation;

import java.util.Arrays;

public class Food {
	private String texture;
	private String color;
	private String flavor;
	private String name;
	private int length;
	private int calories;
	private String smell;
	private Food[] ingredients;
	
	public Food(String texture, String color, String flavor, String name, int length, int calories, String smell,
			Food[] ingredients) {
		super();
		this.texture = texture;
		this.color = color;
		this.flavor = flavor;
		this.name = name;
		this.length = length;
		this.calories = calories;
		this.smell = smell;
		this.ingredients = ingredients;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getSmell() {
		return smell;
	}

	public void setSmell(String smell) {
		this.smell = smell;
	}

	public Food[] getIngredients() {
		return ingredients;
	}

	public void setIngredients(Food[] ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Food [texture=" + texture + ", color=" + color + ", flavor=" + flavor + ", name=" + name + ", length="
				+ length + ", calories=" + calories + ", smell=" + smell + ", ingredients="
				+ Arrays.toString(ingredients) + "]";
	}
	
	
}
