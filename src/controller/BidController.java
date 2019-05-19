package controller;


import java.util.ArrayList;

import model.Bid;
import model.Payment;
import service.BidService;
import service.ServiceFactory;
import service.ServiceFactoryImpl;

public class BidController {
	
	 public static boolean placeBid(Bid bid){
	        BidService bidService = (BidService) ServiceFactoryImpl.getInstance()
	                .getService(ServiceFactory.ServiceType.BID);
	        return bidService.placeBid(bid);
	    }

	    public static boolean updateBid(Bid bid){
	        BidService bidService = (BidService) ServiceFactoryImpl.getInstance()
	                .getService(ServiceFactory.ServiceType.BID);
	        return bidService.updateBid(bid);
	    }

	    public static boolean deleteBid(Bid bid){
	        BidService bidService = (BidService) ServiceFactoryImpl.getInstance()
	                .getService(ServiceFactory.ServiceType.BID);
	        return bidService.deleteBid(bid);
	    }

	    public static ArrayList<Bid> getBidsByUserId(int id){
	        BidService bidService = (BidService) ServiceFactoryImpl.getInstance()
	                .getService(ServiceFactory.ServiceType.BID);
	        return bidService.getBidsByUserId(id);
	    }
	    
	    public static ArrayList<Bid> getRecentBIDs(){
	        BidService bidService = (BidService) ServiceFactoryImpl.getInstance()
	                .getService(ServiceFactory.ServiceType.BID);
	        return bidService.getRecentBids();
	    }

	    public static ArrayList<Payment> getPaymentsByUserId(int id){
	        BidService bidService = (BidService) ServiceFactoryImpl.getInstance()
	                .getService(ServiceFactory.ServiceType.BID);
	        return bidService.getPaymentsByUserId(id);
	    }
	    
	    public static ArrayList<Bid> getWonBidsByUserId(int id){
	        BidService bidService = (BidService) ServiceFactoryImpl.getInstance()
	                .getService(ServiceFactory.ServiceType.BID);
	        return bidService.getWonBidsByUserId(id);
	    }

}
