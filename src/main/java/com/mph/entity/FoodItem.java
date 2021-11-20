package com.mph.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class FoodItem
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fooditemid;
	@Column
	private String fooditemname;
	@Column
	private int fooditemcost;
	public FoodItem() {
		super();
		
	}
	public FoodItem(int fooditemid, String fooditemname, int fooditemcost) {
		super();
		this.fooditemid = fooditemid;
		this.fooditemname = fooditemname;
		this.fooditemcost = fooditemcost;
	}
	public int getFooditemid() {
		return fooditemid;
	}
	public void setFooditemid(int fooditemid) {
		this.fooditemid = fooditemid;
	}
	public String getFooditemname() {
		return fooditemname;
	}
	public void setFooditemname(String fooditemname) {
		this.fooditemname = fooditemname;
	}
	public int getFooditemcost() {
		return fooditemcost;
	}
	public void setFooditemcost(int fooditemcost) {
		this.fooditemcost = fooditemcost;
	}
	@Override
	public String toString() {
		return "FoodItem [fooditemid=" + fooditemid + ", fooditem=" + fooditemname + ", fooditemcost=" + fooditemcost + "]";
	}
	
	
	
	

}
