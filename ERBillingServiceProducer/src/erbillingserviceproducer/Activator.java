package erbillingserviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {


ServiceRegistration publishServiceRegistration;


public void start(BundleContext Context) throws Exception {
System.out.println("Equpment Rental Service Start");
ERBillingService erBillingService = new ERBillingServiceImpl();
publishServiceRegistration = Context.registerService(
ERBillingService.class.getName(), erBillingService, null);
}


public void stop(BundleContext context) throws Exception {
System.out.println("Equpment Rental Service Stop");
publishServiceRegistration.unregister();
}
}