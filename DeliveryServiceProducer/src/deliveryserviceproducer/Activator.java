package deliveryserviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;


	public void start(BundleContext Context) throws Exception {
		
		System.out.println("Delivery Service Start");
		DeliveryService deliveryService = new DeliveryServiceimpl();
		publishServiceRegistration = Context.registerService(DeliveryService.class.getName(), deliveryService, null);
	}

	public void stop(BundleContext Context) throws Exception {
		System.out.println("Delivery Service Stop");
		publishServiceRegistration.unregister();
	}

}
