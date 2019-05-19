package service;

import java.util.ArrayList;
import model.Bid;
import model.Payment;

public interface BidService extends SuperService {

	boolean placeBid(Bid bid);

	ArrayList<Bid> getBidsByUserId(int id);
	
	ArrayList<Bid> getRecentBids();

	boolean updateBid(Bid bid);

	boolean deleteBid(Bid bid);

	ArrayList<Bid> getWonBidsByUserId(int id);

	ArrayList<Payment> getPaymentsByUserId(int id);

	String makePayment(Payment payment);
	
	


}
