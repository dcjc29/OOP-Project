package model;

public class Bid {
	private int itemID;
	private int bidderID;
	private Double bidAmount;
	private String message;
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public int getBidderID() {
		return bidderID;
	}
	public void setBidderID(int bidderID) {
		this.bidderID = bidderID;
	}
	public Double getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(Double bidAmount) {
		this.bidAmount = bidAmount;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
