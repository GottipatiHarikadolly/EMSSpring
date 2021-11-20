package com.mph.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.FoodItemDao;
import com.mph.entity.FoodItem;

@Service
@Transactional
public class FoodItemServiceImpl implements FoodItemService
{   
	@Autowired
	FoodItemDao fooditemDao;
	
	public List<FoodItem> deleteFoodItem(int venueid)
	{
		return fooditemDao.deleteFoodItem(venueid);
	}
	
	public List<FoodItem> updateFoodItem(FoodItem venue)
	{
		return fooditemDao.updateFoodItem(venue);
	}

	public void createFoodItem(FoodItem fooditem)
	{
		fooditemDao.createFoodItem(fooditem);
	}

	public List<FoodItem> getFoodItemList()
	{
		return fooditemDao.getFoodItemList();
	}


}
