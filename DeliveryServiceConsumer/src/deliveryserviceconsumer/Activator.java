
package deliveryserviceconsumer;import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import java.util.Scanner;
import org.osgi.framework.ServiceReference;
import deliveryserviceproducer.DeliveryService;
import deliveryserviceproducer.DeliveryServiceimpl;public class Activator implements BundleActivator { ServiceReference serviceReference;
public void start(BundleContext Context) throws Exception {
System.out.println("Optical Consumer Service");
//serviceReference = Context.getServiceReference(DeliveryService.class.getName());
//DeliveryService DeliveryService = (DeliveryService) Context.getService(serviceReference);
try
{
String username, password,choice,itemName ;
float itemPrice, discount,cash, balance;
int itemId;
DeliveryService deliveryService2 = new DeliveryServiceimpl();
deliveryService2.defaultList();
Scanner scanner = new Scanner(System.in); while(true) {
System.out.println("<< if you want to exit enter 'end' for username >>");
System.out.println("================== Login =========================");
System.out.print("Enter UserName : ");
username = scanner.next();
if( username.equals("end")) {
System.out.println("Ending Delivery service");
break;
}
System.out.print("Enter Password : ");
password = scanner.next();
System.out.println("======================================\n");
choice = deliveryService2.LoginVerification(username, password);
if(choice=="admin") {
System.out.println("~~~~~~~~~~~ **Welcome Admin** ~~~~~~~~~~~");
deliveryService2.printItemList();
while(true) {
System.out.print("Do you want to Add item or Remove item or logout (add / remove / logout) :");
choice = scanner.next();
if(choice.equals("add")) {
System.out.print("Enter Order Name : ");
itemName = scanner.next(); System.out.print("Enter Order charge : ");
itemPrice = scanner.nextFloat(); deliveryService2.addItem(itemName, itemPrice);
deliveryService2.printItemList(); }else if(choice.equals("remove")) {
System.out.print("Enter Order Id : ");
itemId = scanner.nextInt(); deliveryService2.removeItem(itemId);
deliveryService2.printItemList();
}else if(choice.equals("logout")) {
break;
}else {
System.out.println("Error: Invalid input");
}
}
}
else if (choice == "optician") {
System.out.println("~~~~~~~~~~~ **Welcome optician** ~~~~~~~~~~~");
while(true) {
float total =0;
System.out.print("You wont logout? (y / n) : ");
choice = scanner.next();
System.out.print("\n");
if(choice.equals("y")) {
break;
}else {
deliveryService2.printItemList();
System.out.println("<< If need get total enter 0 >>");
System.out.println("_______________Bill_________________");
int count = 0;
while(true) {
System.out.print("Enter Order Id : ");
itemId = scanner.nextInt();
if(itemId == 0) {
break;
}else if((itemId<=deliveryService2.getListSize()) && itemId>0) {
System.out.print("Enter distance(km) : ");
int Qty = (int) scanner.nextFloat();
total = total + deliveryService2.calculateBill(itemId, Qty, count);
System.out.println("---------------------------");
count++;
}else {
System.out.println("Error : invalid input");
}
}
System.out.println("---------------------------");
System.out.println("Total Amount = " + total);
System.out.print("Enter Discount % : " );
discount = scanner.nextFloat();
float subTotal = deliveryService2.calcSubTotal(total, discount);
System.out.println("===========================");
System.out.println("Sub Total = " + subTotal);
System.out.println("===========================");
System.out.print("Enter Cash : " );
cash = scanner.nextFloat();
balance = deliveryService2.calcBalance(subTotal, cash);
System.out.println("Balance = " + balance);
System.out.println("No of Items = " + count);
System.out.println("____________________________________");
}
}
}
else {
System.out.println("Incorrect login");
}
}
}
catch (Exception e)
{
System.out.println(e.getMessage());
}
} public void stop(BundleContext Context) throws Exception {
System.out.println("Stop Delivery Consumer Service");
Context.ungetService(serviceReference);
}}

