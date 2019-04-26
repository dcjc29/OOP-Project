package service;

public interface ServiceFactory {
	 public enum ServiceType {
	        ADMIN, CUSTOMER, EMPLOYEE, ITEM, ORDER, ORDERDETAIL
	    }

	    public SuperService getService(ServiceType serviceType)throws Exception;
}
