package model;

import java.io.InputStream;
import java.sql.Blob;

public class Item {
	private int itemId;
	private String itemTitle;
	private int noOfItem;
	private int itemCondition;
	private String Category;
	private String itemDescription;
	private String itemDelivery;
	private double minBid;
	private String startDate;
	private String endDate;
	private Blob itemIn;
	
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public int getNoOfItem() {
		return noOfItem;
	}
	public void setNoOfItem(int no) {
		this.noOfItem = no;
	}
	public int getItemCondition() {
		return itemCondition;
	}
	public void setItemCondition(int itemCondition) {
		this.itemCondition = itemCondition;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	public double getMinBid() {
		return minBid;
	}
	public void setMinBid(double minBid) {
		this.minBid = minBid;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getItemDelivery() {
		return itemDelivery;
	}
	public void setItemDelivery(String itemDelivery) {
		this.itemDelivery = itemDelivery;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public Blob getItemIn() {
		return itemIn;
	}
	public void setItemIn(Blob blob) {
		this.itemIn= blob;
	}
	
}
