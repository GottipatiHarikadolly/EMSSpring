package com.mph.service;

import java.util.List;

import com.mph.entity.Equipment;

public interface EquipmentService 
{
	public List<Equipment> getEquipmentList();

	public void createEquipment(Equipment equipment);

	public List<Equipment> updateEquipment(Equipment equipment);

	public List<Equipment> deleteEquipment(int equipmentid);

}
