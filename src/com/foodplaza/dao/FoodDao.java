package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Food;

public interface FoodDao
{
	boolean addFood(Food f);
	boolean updateFood(Food f);
	boolean deleteFood(int FoodId);
	Food  displayFoodById(int FoodId);
	List<Food>displayAllFood();
}
