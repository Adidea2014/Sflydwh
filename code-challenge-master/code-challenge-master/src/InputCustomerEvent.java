package com.vzw.is.vzwutils.httpclient.util;

public class InputCustomerEvent {
	private String key;
	private String last_name;
	private String adr_city;
	private String adr_state;
	private double total_amount;

	public InputCustomerEvent(String key, String last_name, 
			double total_amount) {
		super();
		this.key = key;
		this.last_name = last_name;
		this.total_amount = total_amount;
	}
	
	
	public String getLast_name() {
		return last_name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAdr_city() {
		return adr_city;
	}
	public void setAdr_city(String adr_city) {
		this.adr_city = adr_city;
	}
	public String getAdr_state() {
		return adr_state;
	}
	public void setAdr_state(String adr_state) {
		this.adr_state = adr_state;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	

}
