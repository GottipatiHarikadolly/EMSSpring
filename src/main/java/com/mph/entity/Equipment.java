package com.mph.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int equipmentid;
	@Column
	private String equipmentname;
	@Column
	private long equipmentcost;
	public Equipment() {
		super();
	}
	public Equipment(int equipmentid, String equipmentname, long equipmentcost) {
		super();
		this.equipmentid = equipmentid;
		this.equipmentname = equipmentname;
		this.equipmentcost = equipmentcost;
	}
	public int getEquipmentid() {
		return equipmentid;
	}
	public void setEquipmentid(int equipmentid) {
		this.equipmentid = equipmentid;
	}
	public String getEquipmentname() {
		return equipmentname;
	}
	public void setEquipmentname(String equipmentname) {
		this.equipmentname = equipmentname;
	}
	public long getEquipmentcost() {
		return equipmentcost;
	}
	public void setEquipmentcost(long equipmentcost) {
		this.equipmentcost = equipmentcost;
	}
	@Override
	public String toString() {
		return "Equipment [equipmentid=" + equipmentid + ", equipmentname=" + equipmentname + ", equipmentcost="
				+ equipmentcost + "]";
	}
	
	

}
