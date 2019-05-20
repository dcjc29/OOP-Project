package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


import model.Bid;
import model.Payment;
import util.CommonConstants;
import util.DBConnectionUtil;
import util.QueryUtil;

public class BidServiceImpl implements BidService {
	public static final Logger log = Logger.getLogger(BidServiceImpl.class.getName());

	
	private static Connection conn;
    private static PreparedStatement ps;
    
   
    
	static {
		createBidsTable();
		createPaymentsTable();
	}
	
	private static void createBidsTable() {
		try {
		    conn = DBConnectionUtil.getDBConnection();
			ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.CREATE_BIDS_TABLE));
			ps.executeUpdate();
		}catch(Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			
			
		}
		
	}
	
	private static void createPaymentsTable() {
		try {
			conn = DBConnectionUtil.getDBConnection();
			ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.CREATE_PAYMENTS_TABLE));
			ps.executeUpdate();
		}catch(Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			
		}
		
	}
	
	@Override
	public void add(Object t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getByID(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object update(Object id, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean placeBid(Bid bid) {
		
		int i = 0;
		String id=null;
		boolean status=false;

		int itemId = bid.getItemID();
		int bidderId = bid.getBidderID();
		String msg = bid.getMessage();
		Double bidAmount = bid.getBidAmount();
		 conn = DBConnectionUtil.getDBConnection();
		
		
		
		if(conn!=null) {
			
			
			try {
			   
				PreparedStatement pre = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_BID_ID_MAX));
				ResultSet rs=pre.executeQuery();
				while(rs.next()) {
					
					id=rs.getString(1);
					if(id==null) {
						id="0";
					}
					
					
				}
				
				int bId=Integer.parseInt(id)+1;
				
				PreparedStatement ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_BID));
				ps.setInt(1, itemId);
				ps.setInt(2, bidderId);
				ps.setDouble(3, bidAmount);
				ps.setString(4, msg);
				ps.setInt(5, bId);
				
				i = ps.executeUpdate();
				
			
			} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
				log.log(Level.SEVERE, e.getMessage());
			}finally {
				
			
			}
			
			
		}
		
		if(i!=0) {
			 status =true;
		}
		else {
			status=false;
		}
		return status;
	}

	@Override
	public ArrayList<Bid> getBidsByUserId(int id) {
			
		ArrayList<Bid> list=new ArrayList<Bid>();
	    conn = DBConnectionUtil.getDBConnection();
		
		if(conn!=null) {
			try {
				PreparedStatement ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_BIDS_BY_CUSTOMERID));
				ps.setInt(1, id);
				
				ResultSet rs=ps.executeQuery();
				int i=0;
				
				while(rs.next()) {
					Bid bid=new Bid();
					bid.setItemID(rs.getInt("itemId"));
					bid.setBidderID(rs.getInt("customerId"));
					bid.setBidAmount(rs.getDouble("bidAmount"));
					bid.setMessage(rs.getString("message"));
					
					list.add(i,bid);
					i++;
				}
				
			} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
				log.log(Level.SEVERE, e.getMessage());
			}finally {
				
				
			}
			
		}
		
		return list;
	}
	
	public ArrayList<Bid> getRecentBids() {
		
		ArrayList<Bid> list=new ArrayList<Bid>();
		 conn = DBConnectionUtil.getDBConnection();
		
		if(conn!=null) {
			try {
				PreparedStatement ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RECENT_BIDS));
				ResultSet rs=ps.executeQuery();
				int i=0;
				
				while(rs.next()) {
					Bid bid=new Bid();
					bid.setItemID(rs.getInt("itemId"));
					bid.setBidderID(rs.getInt("customerId"));
					bid.setBidAmount(rs.getDouble("bidAmount"));
					bid.setMessage(rs.getString("message"));
					
					list.add(i,bid);
					i++;
				}
				
			} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
				log.log(Level.SEVERE, e.getMessage());
			}finally {
				
				
			}
			
		}
		
		return list;
	}

	@Override
	public boolean updateBid(Bid bid) {
		int i=0;
		boolean status=false;
		
		int itemId= bid.getItemID();
		int bidderId= bid.getBidderID();
		Double bidAmount= bid.getBidAmount();
		String msg=	bid.getMessage();
		
		 conn = DBConnectionUtil.getDBConnection();
		
		
		if(conn!=null) {
			
			
			try {
			
					PreparedStatement ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_BID));
					
					ps.setDouble(1, bidAmount);
					ps.setString(2, msg);
					ps.setInt(3, itemId);
					ps.setInt(4, bidderId);
				
					i = ps.executeUpdate();
					
				}
				
			
			catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
				log.log(Level.SEVERE, e.getMessage());
			}finally {
				
			}
			
			
		
		
		if(i!=0) {
			 status =true;
		}
		else {
			status=false;
		}
		
	}
	
		return status;
	}

	@Override
	public boolean deleteBid(Bid bid) {
		int i = 0;
		boolean status = false;
		int itemId = bid.getItemID();
		int bidderId = bid.getBidderID(); 
		
		
		 conn = DBConnectionUtil.getDBConnection();
		if(conn!=null) {
			
			
			try {
			
					PreparedStatement ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_BID));
					ps.setInt(1, itemId);
					ps.setInt(2, bidderId);
					i = ps.executeUpdate();
					
				}
				
			
			catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
				log.log(Level.SEVERE, e.getMessage());
			}finally {
				
			
			}
			
			
		
		
		if(i!=0) {
			 status =true;
		}
		else {
			status=false;
		}
		
	}
	
		return status;
	}

	@Override
	public ArrayList<Bid> getWonBidsByUserId(int id) {
		
		ArrayList<Bid> list=new ArrayList<Bid>();
		 conn = DBConnectionUtil.getDBConnection();
		
		if(conn!=null) {
			try {
				PreparedStatement ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_WON_BIDS_BY_CUSTOMERID));
				ps.setInt(1, id);
				
				ResultSet rs=ps.executeQuery();
				int i=0;
				
				while(rs.next()) {
					Bid bid=new Bid();
					bid.setItemID(rs.getInt("itemId"));
					bid.setBidderID(rs.getInt("customerId"));
					bid.setBidAmount(rs.getDouble("bidAmount"));
					bid.setMessage(rs.getString("message"));
					
					list.add(i,bid);
					i++;
				}
				
			} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
				log.log(Level.SEVERE, e.getMessage());
			}finally {
				
				
			}
			
		}
		
		return list;
	}

	@Override
	public ArrayList<Payment> getPaymentsByUserId(int id) {
		ArrayList<Payment> list=new ArrayList<Payment>();
		
		 conn = DBConnectionUtil.getDBConnection();
		if(conn!=null) {
			try {
				PreparedStatement ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_PAYMENTS_BY_PAYERID));
				ps.setInt(1, id);
				
				ResultSet rs=ps.executeQuery();
				int i=0;
				
				while(rs.next()) {
					Payment payment = new Payment();
				
					payment.setItem(rs.getInt("itemId"));
					payment.setPayee(rs.getInt("payeeId"));
					payment.setPayer(rs.getInt("payerId"));
					payment.setName(rs.getString("name"));
					payment.setCard(rs.getString("card"));
					payment.setAddress(rs.getString("address"));
					payment.setDate(rs.getDate("date"));
					payment.setAmount(rs.getDouble("amount"));
					list.add(i,payment);
					i++;
				}
				
			} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
				log.log(Level.SEVERE, e.getMessage());
			}finally {
				
				
			}
			
		}
		
		return list;
	}

	@Override
	public String makePayment(Payment payment) {
		int i = 0;
		String id=null;
		String status=null;

		int itemId = payment.getItem();
		int payee = payment.getPayee();
		int payer = payment.getPayer();
		String name = payment.getName();
		String address = payment.getAddress();
		String card = payment.getCard();
		Double amount = payment.getAmount();
		Date date = payment.getDate();
		
		 conn = DBConnectionUtil.getDBConnection();
		
		
		if(conn!=null) {
			
			
			try {
				
				
				PreparedStatement ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_PAYMENT));
				ps.setInt(1, itemId);
				ps.setInt(2, payee);
				ps.setInt(3, payer);
				ps.setString(4, name);
				ps.setString(5, address);
				ps.setDate(6, (java.sql.Date) date);
				ps.setString(7, card);
				ps.setDouble(8, amount);
				
				i = ps.executeUpdate();
				
			
			} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
				log.log(Level.SEVERE, e.getMessage());
			}finally {
				
				
			}
			
			
		}
		
		if(i!=0) {
			 status ="success";
		}
		else {
			status="Something Is Not Right!!!";
		}
		return status;
	}
	
	

}
