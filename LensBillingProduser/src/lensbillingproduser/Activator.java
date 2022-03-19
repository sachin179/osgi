package lensbillingproduser;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext Context) throws Exception {
		System.out.println("Lens billing Service Start");
		LensBillingService lensBillingService = new LensBillingServiceImpl();
		publishServiceRegistration = Context.registerService(
				LensBillingService.class.getName(), lensBillingService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Lens Billing Service Stop");
		publishServiceRegistration.unregister();
	}
}


