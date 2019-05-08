package com.cg.PersonService.model;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tnxId;

	private int tnxValue;

	private String tnxStatus;

	private int actId;

	private int custId;

	private String tnxDesc;

	public int getTnxId() {

		return tnxId;

	}

	public void setTnxId(int tnxId) {

		this.tnxId = tnxId;

	}

	public String getTnxStatus() {

		return tnxStatus;

	}

	public void setTnxStatus(String tnxStatus) {

		this.tnxStatus = tnxStatus;

	}

	public String getTnxDesc() {

		return tnxDesc;

	}

	public void setTnxDesc(String tnxDesc) {

		this.tnxDesc = tnxDesc;

	}

	public int getTnxValue() {

		return tnxValue;

	}

	public void setTnxValue(int tnxValue) {

		this.tnxValue = tnxValue;

	}

	/**
	 * 
	 * @return the actId
	 */

	public int getActId() {

		return actId;

	}

	/**
	 * 
	 * @param actId
	 *            the actId to set
	 */

	public void setActId(int actId) {

		this.actId = actId;

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

}