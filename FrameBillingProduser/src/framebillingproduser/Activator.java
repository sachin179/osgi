package framebillingproduser;

import javax.naming.Context;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	ServiceRegistration publishServiceRegistration;

	

	public void start(BundleContext Context) throws Exception {
		System.out.println("Frame billing Service Start");
		FrameBillingService frameBillingService = new FrameBillingServiceImpl();
		publishServiceRegistration = Context.registerService(
		FrameBillingService.class.getName(), frameBillingService, null);
	}

	public void stop(BundleContext Context) throws Exception {
		
		System.out.println("Frame Billing Service Stop");
		publishServiceRegistration.unregister();
	}

}
