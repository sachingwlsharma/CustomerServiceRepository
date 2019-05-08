package com.cg.PersonService.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.PositiveOrZero;

public class Account {

	private int actId;

	@PositiveOrZero(message = "CustomerId is mandatory")
	private int custId;

	private int balance;

	@NotNull(message = "initialCredit is mandatory")
	@PositiveOrZero
	private int initialCredit;

	private List tnxList;

	public Account(int actId, int balance) {

		this.actId = actId;

		this.balance = balance;

	}

	public Account() {

	}

	public int getActId() {

		return actId;

	}

	public void setActId(int actId) {

		this.actId = actId;

	}

	public int getBalance() {

		return balance;

	}

	public void setBalance(int balance) {

		this.balance = balance;

	}

	/**
	 * 
	 * @return the custId
	 */

	public int getCustId() {

		return custId;

	}

	/**
	 * 
	 * @param custId
	 *            the custId to set
	 */

	public void setCustId(int custId) {

		this.custId = custId;

	}

	/**
	 * 
	 * @return the initialCredit
	 */

	public int getInitialCredit() {

		return initialCredit;

	}

	/**
	 * 
	 * @param initialCredit
	 *            the initialCredit to set
	 */

	public void setInitialCredit(int initialCredit) {

		this.initialCredit = initialCredit;

	}

	/**
	 * 
	 * @return the tnxList
	 */

	public List getTnxList() {

		return tnxList;

	}

	/**
	 * 
	 * @param tnxList
	 *            the tnxList to set
	 */

	public void setTnxList(List tnxList) {

		this.tnxList = tnxList;

	}

}
