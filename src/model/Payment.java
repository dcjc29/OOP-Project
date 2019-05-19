package model;

import java.util.Date;

public class Payment {

	int Item;
	int payee;
	int payer;
	String name;
	String address;
	Date date;
	String card;
	Double amount;
	
	
	public int getItem() {
		return Item;
	}
	public void setItem(int item) {
		Item = item;
	}
	public int getPayee() {
		return payee;
	}
	public void setPayee(int payee) {
		this.payee = payee;
	}
	public int getPayer() {
		return payer;
	}
	public void setPayer(int payer) {
		this.payer = payer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	
	
}
