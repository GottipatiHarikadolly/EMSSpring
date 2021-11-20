package com.mph.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.mph.entity.FoodItem;


@Repository
public class FoodItemDaoImpl implements FoodItemDao{

	@Autowired
	private SessionFactory sessionFactory;
	

	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<FoodItem> getFoodItemList() {
		Query qry = getSession().createQuery("from FoodItem");
		List<FoodItem> filist = qry.list();
		return filist;
	}

	

	@Override
	public void createFoodItem(FoodItem fooditem) 
	{
		getSession().saveOrUpdate(fooditem);
		System.out.println("FoodItem Stored Successfully :)");
		
	}

	@Override
	public List<FoodItem> updateFoodItem(FoodItem fooditem) {
		Query qry = getSession().createQuery("update FoodItem set fooditemname=:fnam,fooditemcost=:fcost where fooditemid=:fid");
		qry.setParameter("fnam", fooditem.getFooditemname());
		qry.setParameter("fcost", fooditem.getFooditemcost());
		qry.setParameter("fid", fooditem.getFooditemid());
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Update is successful !!!");
		}
		return getFoodItemList();
	}

	@Override
	public List<FoodItem> deleteFoodItem(int fooditemid) {
		Query qry = getSession().createQuery("delete FoodItem where fooditemid=:fid");		
		qry.setParameter("fid", fooditemid);		
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + fooditemid + "successfully !!!");
		}
		return getFoodItemList();
	}




}