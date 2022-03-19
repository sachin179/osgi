package erbillingserviceconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import org.osgi.framework.ServiceReference;
import erbillingserviceproducer.ERBillingService;
import erbillingserviceproducer.ERBillingServiceImpl;



public class Activator implements BundleActivator {


ServiceReference serviceReference;

public void start(BundleContext Context) throws Exception {
System.out.println("Otical Consumer Service");
//serviceReference = Context.getServiceReference(ERBillingService.class.getName());
//ERBillingService ERBillingService = (ERBillingService) Context.getService(serviceReference);

try
{
String username, password,choice,itemName ;
float itemPrice, discount,cash, balance;
int itemId;
ERBillingService erBillingService2 = new ERBillingServiceImpl();
erBillingService2.defaultList();
Scanner scanner = new Scanner(System.in);

while(true) {
System.out.println("<< if you want to exit enter 'end' for username >>");
System.out.println("================== Login =========================");
System.out.print("Enter UserName : ");
username = scanner.next();
if( username.equals("end")) {
System.out.println("Ending Equipment billing billing");
break;
}
System.out.print("Enter Password : ");
password = scanner.next();
System.out.println("======================================\n");
choice = erBillingService2.LoginVerification(username, password);
if(choice=="admin") {
System.out.println("~~~~~~~~~~~ **Welcome Admin** ~~~~~~~~~~~");
erBillingService2.printItemList();
while(true) {
System.out.print("Do you want to Add item or Remove item or logout (add / remove / logout) :");
choice = scanner.next();
if(choice.equals("add")) {
System.out.print("Enter Item Name : ");
itemName = scanner.next();

System.out.print("Enter Item Price : ");
itemPrice = scanner.nextFloat();

erBillingService2.addItem(itemName, itemPrice);
erBillingService2.printItemList();

}else if(choice.equals("remove")) {
System.out.print("Enter Equipment  Id : ");
itemId = scanner.nextInt();

erBillingService2.removeItem(itemId);
erBillingService2.printItemList();
}else if(choice.equals("logout")) {
break;
}else {
System.out.println("Error: Invalide input");
}
}
}
else if (choice == "optician") {
System.out.println("~~~~~~~~~~~ **Welcome Optician** ~~~~~~~~~~~");
while(true) {
float total =0;
System.out.print("You wont logout? (y / n) : ");
choice = scanner.next();
System.out.print("\n");
if(choice.equals("y")) {
break;
}else {
erBillingService2.printItemList();
System.out.println("<< If need get total enter 0 >>");
System.out.println("_______________Bill_________________");
int count = 0;
while(true) {
System.out.print("Enter Item Id : ");
itemId = scanner.nextInt();
if(itemId == 0) {
break;
}else if((itemId<=erBillingService2.getListSize()) && itemId>0) {
System.out.print("Enter Qty : ");
int Qty = (int) scanner.nextFloat();
total = total + erBillingService2.calculateBill(itemId, Qty, count);
System.out.println("---------------------------");
count++;
}else {
System.out.println("Error : invalide input");
}
}
System.out.println("---------------------------");
System.out.println("Tatal Amount = " + total);
System.out.print("Enter Discount % : " );
discount = scanner.nextFloat();
float subTotal = erBillingService2.calcSubTotal(total, discount);
System.out.println("===========================");
System.out.println("Sub Tatal = " + subTotal);
System.out.println("===========================");
System.out.print("Enter Cash : " );
cash = scanner.nextFloat();
balance = erBillingService2.calcBalance(subTotal, cash);
System.out.println("Balance = " + balance);
System.out.println("Number of Items = " + count);
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
}


public void stop(BundleContext Context) throws Exception {
System.out.println("Stop Lens Billing Consumer Service");
Context.ungetService(serviceReference);
}


}