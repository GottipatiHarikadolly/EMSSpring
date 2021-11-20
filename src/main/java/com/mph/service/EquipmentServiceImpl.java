package com.mph.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.EquipmentDao;

import com.mph.entity.Equipment;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService
{   
	@Autowired
	EquipmentDao equipmentDao;
	
	public List<Equipment> deleteEquipment(int equipmentid)
	{
		return equipmentDao.deleteEquipment(equipmentid);
	}
	
	public List<Equipment> updateEquipment(Equipment equipment)
	{
		return equipmentDao.updateEquipment(equipment);
	}

	public void createEquipment(Equipment equipment)
	{
		equipmentDao.createEquipment(equipment);
	}

	public List<Equipment> getEquipmentList()
	{
		return equipmentDao.getEquipmentList();
	}


}
