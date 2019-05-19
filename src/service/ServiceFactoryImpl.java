package service;

public class ServiceFactoryImpl implements ServiceFactory {

    private static ServiceFactory serviceFactory;

    private ServiceFactoryImpl() {
    }

    public static ServiceFactory getInstance(){
        if (serviceFactory == null)
            serviceFactory = new ServiceFactoryImpl();
        return serviceFactory;
    }

    @Override
    public SuperService getService(ServiceType serviceType) {
        switch (serviceType){
            case ADMIN: return new AdminServiceImpl();
            case ITEM: return new ItemServiceImpl();
            case USER: return new UserServiceImpl();
            case BID: return new BidServiceImpl();
            default: return null;
        }
    }




}
