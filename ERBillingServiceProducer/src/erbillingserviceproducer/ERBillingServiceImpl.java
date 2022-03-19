package erbillingserviceproducer;

import java.util.ArrayList;

public class ERBillingServiceImpl implements ERBillingService{


ArrayList<String> items = new ArrayList<String>();
ArrayList<Float> price = new ArrayList<Float>();

public void defaultList() {

items.add("Lens meter");
price.add((float) 20000.00);

items.add("Edger");
price.add((float) 34000.00);

items.add("Traser");
price.add((float) 23000.00);

items.add("Water pump ");
price.add((float) 5800.00);

}


@Override
public void printItemList() {

System.out.println("------------Item List-------------");
for (int i = 0; i < price.size(); i++)
{
System.out.println(i+1 + " " +items.get(i) +" Rs:"+price.get(i));
}
System.out.println("----------------------------------");
}


@Override
public String LoginVerification(String username, String password) {
if((username.equals("admin")) && (password.equals("123"))){
return "admin";
}
else if((username.equals("optician")) && (password.equals("123"))) {
return "optician";
}else {
return "invalid";
}
}


@Override
public void addItem(String itemName, float itemPrice) {
items.add(itemName);
price.add((float) itemPrice);
}


@Override
public void removeItem(int itemId) {
items.remove(itemId-1);
price.remove(itemId-1);
}


@Override
public float calculateBill(int itemId, int Qty, int count) {
float itemPrice = price.get(itemId-1);
float total = (itemPrice*Qty);
System.out.println((count+1) +") "+ items.get(itemId-1) +" X "+ Qty + " = " + total);
return total;
}


@Override
public float calcSubTotal(float total, float discount) {
float subtotal = (total-((total/100)*discount));
return subtotal;
}


@Override
public int getListSize() {
return items.size();
}


@Override
public float calcBalance(float subTotal, float cash) {
return (cash - subTotal);
}
}