package com.mph.dao;

import java.util.List;

import com.mph.entity.FoodItem;

public interface FoodItemDao {

	public List<FoodItem> getFoodItemList();

	public void createFoodItem(FoodItem fooditem);

	public List<FoodItem> updateFoodItem(FoodItem fooditem);

	public List<FoodItem> deleteFoodItem(int fooditemid);

}
