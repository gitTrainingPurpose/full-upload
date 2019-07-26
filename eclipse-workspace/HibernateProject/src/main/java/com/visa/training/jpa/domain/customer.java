package com.visa.training.jpa.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private int id;   

	@OneToMany(mappedBy = "cust", fetch = FetchType.EAGER)
	List<account> accounts=new ArrayList();
	public List<account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "customer [id=" + id + ", firstname=" + firstname + ", middlename=" + middlename + ", lastname="
				+ lastname + ", dateofjoin=" + dateofjoin + "]";
	}

	private String firstname  ;
	private String middlename ;
	private String lastname   ;
	private Date dateofjoin ;
	public customer (String firstname, String middlename, String lastname, Date dateofjoin) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.dateofjoin = dateofjoin;
	}
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "customer_address",joinColumns = @JoinColumn(name="cust_id"), inverseJoinColumns = @JoinColumn(name = "address_id"))
	List<Address> addresses = new ArrayList<>();
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDateofjoin() {
		return dateofjoin;
	}

	public void setDateofjoin(Date dateofjoin) {
		this.dateofjoin = dateofjoin;
	}

	public customer() {
		
	}

}
