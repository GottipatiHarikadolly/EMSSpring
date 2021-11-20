package com.mph.service;

import java.util.List;

import com.mph.entity.FoodItem;

public interface FoodItemService 
{
	public List<FoodItem> getFoodItemList();

	public void createFoodItem(FoodItem fooditem);

	public List<FoodItem> updateFoodItem(FoodItem fooditem);

	public List<FoodItem> deleteFoodItem(int fooditemid);
}
