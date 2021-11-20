package com.mph.entity;



import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
public class Customer implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerid;
	@Column
	private String customername;
	@Column
	private long contactno;
	@Column
	private String emailid;
	@Column
	private String password;
	
	
    public Customer() 
    {
		super();
	}
	
	public Customer(int customerid,String customername, long contactno, String emailid, String password) 
	{
		super();
		this.customerid=customerid;
		this.customername = customername;
		this.contactno = contactno;
		this.emailid = emailid;
		this.password = password;
		
	}



	
public int getCustomerid() {
		return customerid;
	}



	public void setCustomerid(int customerid) 
	{
		this.customerid = customerid;

	}



	public String getCustomername() {
		return customername;
	}



	public void setCustomername(String customername) {
		this.customername = customername;
	}



	public long getContactno() 
	{
		return contactno;
	}



	public void setContactno(long contactno) {
		this.contactno = contactno;
	}



	public String getEmailid() {
		return emailid;
	}



	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	
public String getPassword() 
{
			return password;
}
	 
	public void setPassword(String password) 
	{
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customername=" + customername + ", contactno=" + contactno
				+ ", emailid=" + emailid + ", password=" + password + "]";
	}
	
	

    
}

