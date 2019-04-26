package service;

public class ServiceFactoryImpl implements ServiceFactory {

    private static ServiceFactory serviceFactory;

    public ServiceFactoryImpl() {
    }

    public static ServiceFactory getInstance(){
        if (serviceFactory == null)
            serviceFactory = new ServiceFactoryImpl();
        return serviceFactory;
    }

    @Override
    public SuperService getService(ServiceType serviceType) throws Exception {
        switch (serviceType){
        
            case ITEM: return new ItemServiceImpl();
            default: return null;
        }
    }




}
