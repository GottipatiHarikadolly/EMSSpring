package com.mph.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Equipment;


@Repository
public class EquipmentDaoImpl implements EquipmentDao{

	@Autowired
	private SessionFactory sessionFactory;
	

	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Equipment> getEquipmentList() {
		Query qry = getSession().createQuery("from Equipment");
		List<Equipment> eqlist = qry.list();
		return eqlist;
	}

	

	@Override
	public void createEquipment(Equipment equipment) 
	{
		getSession().saveOrUpdate(equipment);
		System.out.println("Equipment Stored Successfully :)");
		
	}

	@Override
	public List<Equipment> updateEquipment(Equipment equipment) {
		Query qry = getSession().createQuery("update Equipment set equipmentname=:enam,equipmentcost=:ecost where equipmentid=:eid");
		qry.setParameter("enam", equipment.getEquipmentname());
		qry.setParameter("ecost", equipment.getEquipmentcost());
		qry.setParameter("eid", equipment.getEquipmentid());
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Update is successful !!!");
		}
		return getEquipmentList();
	}

	@Override
	public List<Equipment> deleteEquipment(int equipmentid) {
		Query qry = getSession().createQuery("delete Equipment where equipmentid=:equipid");		
		qry.setParameter("equipid", equipmentid);		
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + equipmentid + "successfully !!!");
		}
		return getEquipmentList();
	}




}
