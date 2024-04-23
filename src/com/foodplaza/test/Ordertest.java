package com.foodplaza.test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.foodplaza.dao.OrderDaoImpl;
import com.foodplaza.pojo.Customer;
import com.foodplaza.pojo.Order;
public class Ordertest 
{
	public static void main(String args[])
	{
		int  choice,orderId;
	    String  foodName, customer_EmailId, orderDate;
	    Double  totalBill;
	    Order o=new Order();
	    OrderDaoImpl od=new OrderDaoImpl();
	    do
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("1 Place Order\n2 Show Order\n3.Exit");
			System.out.println("Enter your choice[1-3]");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
//				System.out.println("Enter the foodName");
//				foodName=sc.next();
//				System.out.println("Enter the totalBill");
//				totalBill=sc.nextDouble();
				System.out.println("Enter the customer_EmailId");
				customer_EmailId=sc.next();	
//				System.out.println("Enter the orderDate");
//				orderDate=sc.next();
//				o.setFoodName(foodName);
        		//o.setTotalBill(totalBill);
				o.setCustomer_EmailId(customer_EmailId);
//				o.setOrderDate(orderDate);
				boolean flag=od.placeOrder(customer_EmailId);
				if(flag==true)
				{
					System.out.println("Order added");
				}
				else
				{
					System.out.println("Order adding Failed");
				}
				break;
			case 2:
				List<Order> o1 = new ArrayList<Order>();
				o1 = od.showOrder();
				for(Order order : o1)
				{
					System.out.println(order.getOrderId()+" "+order.getFoodName()+" "+order.getTotalBill()+" "+order.getCustomer_EmailId()+" "+order.getOrderDate());
				}
				break;
			case 3:
				System.out.println("Exit");
				break;
			default:
				System.out.println("Enter the invalid choice[1-3]");
				break;
			}
	  }while(choice<3);
	}
}