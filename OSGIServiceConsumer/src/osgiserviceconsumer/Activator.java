package osgiserviceconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import erbillingserviceproducer.ERBillingService;


public class Activator implements BundleActivator {
	
	ServiceReference serviceRefernce1;
	ServiceReference serviceRefernce2;
	ServiceReference serviceRefernce3;
	ServiceReference serviceRefernce4;

	
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Subscriber Service");
		
		System.out.println("*********Welcome*********");
		System.out.println("1 - Deliverry service");
		System.out.println("2 - Equpment Rental Service "); 
		System.out.println("3 - Frame Billing");
		System.out.println("4 - Lens Billing");
		System.out.println("Enter the facility number you wanto go :");
		
		
	
		serviceRefernce2 = context.getServiceReference(ERBillingService.class.getName());
		ERBillingService servicePublish2 = (ERBillingService) context.getService(serviceRefernce2);
//		
//		serviceRefernce3 = context.getServiceReference(FrameBillingService.class.getName());
//		FrameBillingService servicePublish3 = (FrameBillingService) context.getService(serviceRefernce3);
//		
//		serviceRefernce4 = context.getServiceReference(LensBillingService.class.getName());
//		LensBillingService servicePublish4 = (LensBillingService) context.getService(serviceRefernce4);  
//try {
	
	
	
//		serviceRefernce1 = context.getServiceReference(DeliveryService.class.getName());
//		ERBillingService servicePublish1 = (ERBillingService) context.getService(serviceRefernce1);
		

	
	

	//	}
		//	catch (Exception e)
		//	{
		//		System.out.println(e.getMessage());
		//	}	

	}
	
	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye");
		context.ungetService(serviceRefernce1);
		context.ungetService(serviceRefernce2);
		context.ungetService(serviceRefernce3);
		context.ungetService(serviceRefernce4);
	}


 
}

