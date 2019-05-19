package service;

public interface ServiceFactory {
    public enum ServiceType {
        ADMIN, ITEM, BID, USER
    }

    public SuperService getService(ServiceType serviceType);
}
