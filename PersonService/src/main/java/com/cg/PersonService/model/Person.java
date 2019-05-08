package com.cg.PersonService.model;

import java.util.List;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.validation.constraints.NotBlank;

public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotBlank(message = "Name is mandatory")
	private String name;

	@NotBlank(message = "last name is mandatory")
	private String lastName;

	private List accountList;

	public Person(int id) {

		this.id = id;

	}

	public Person() {

	}

	/**
	 * 
	 * @return the id
	 */

	public Integer getId() {

		return id;

	}

	/**
	 * 
	 * @param id
	 *            the id to set
	 */

	public void setId(Integer id) {

		this.id = id;

	}

	/**
	 * 
	 * @return the name
	 */

	public String getName() {

		return name;

	}

	/**
	 * 
	 * @param name
	 *            the name to set
	 */

	public void setName(String name) {

		this.name = name;

	}

	/**
	 * 
	 * @return the lastName
	 */

	public String getLastName() {

		return lastName;

	}

	/**
	 * 
	 * @param lastName
	 *            the lastName to set
	 */

	public void setLastName(String lastName) {

		this.lastName = lastName;

	}

	/**
	 * 
	 * @return the accountList
	 */

	public List getAccountList() {

		return accountList;

	}

	/**
	 * 
	 * @param accountList
	 *            the accountList to set
	 */

	public void setAccountList(List accountList) {

		this.accountList = accountList;

	}

}