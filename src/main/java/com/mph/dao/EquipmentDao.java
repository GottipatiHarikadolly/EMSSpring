package com.mph.dao;

import java.util.List;

import com.mph.entity.Equipment;

public interface EquipmentDao {

	public List<Equipment> getEquipmentList();

	public void createEquipment(Equipment equipment);

	public List<Equipment> updateEquipment(Equipment equipment);

	public List<Equipment> deleteEquipment(int equipmentid);

}
