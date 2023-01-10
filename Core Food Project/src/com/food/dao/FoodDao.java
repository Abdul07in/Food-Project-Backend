package com.food.dao;

import java.util.List;

import com.food.pojo.Food;

public interface FoodDao {
    
    public List<Food> showAll();
    public boolean updateItem(Food food);
    public boolean insertItem(Food food);
    public boolean deleteItem(Food food);

    public Food searchById(Integer foodId);
    public Food searchByName(String foodName);
    public List<Food> searchByType(Integer foodId);
    
}
