package com.food.dao;

import com.food.pojo.Food;

import java.util.List;

public interface FoodDao {

    public boolean addFood(Food f);

    public boolean updateFood(Food f);

    public boolean deleteFood(Integer foodId);

    public List<Food> searchFoodByCategory(String foodCategory);

    public List<Food> searchFoodByName(String foodName);

    public List<Food> searchFoodByType(String foodType);

    public Food searchFoodById(Integer foodId);

    public List<Food> fetchAllFood();

    public void updateFoodMenu();

}
