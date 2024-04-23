package com.foodplaza.test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.foodplaza.dao.CartDaoImpl;
import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Customer;
public class Carttest 
{
	public static void main(String args[])
	{
		int CartId,choice,foodId;
		String customerEmailId,foodName;
		double foodQty,foodPrice;
		Cart c=new Cart();
		CartDaoImpl cd=new CartDaoImpl();
		do
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("1.Add Cart\n2.Show Cart\n3.delete Cart Deatils\n4.Exit");
			System.out.println("Enter your choice[1-6]");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the customer EmailId :");
				customerEmailId=sc.next();
				System.out.println("Enter the food Name:");
				foodName=sc.next();
				System.out.println("Enter the food QTY:");
				foodQty=sc.nextDouble();
				c.setCustomerEmailId(customerEmailId);
				c.setFoodName(foodName);
				c.setFoodQty(foodQty);
		        boolean flag = cd.addtoCart(c);
		        if(flag==true)
		        {
		        	System.out.println("Cart Added SuccessFully");
		        }
		        else
		        {
		        	System.out.println("Cart Added Failed");
		        }
				break;
			case 2:
				List<Cart> ct = new ArrayList<Cart>();
				System.out.println("Enter your emailId:");
				customerEmailId = sc.next();
				ct = cd.showCart(customerEmailId);
				for(Cart cart : ct)
				{
					System.out.println(" "+cart.getFoodQty()+" "+cart.getFoodName()+" "+cart.getFoodPrice());
				}
				break;
			case 3:
				System.out.println("Enter the CartId");
				CartId=sc.nextInt();
				c.setCartId(CartId);
				boolean flag1=cd.deletetoCart(CartId);
				if(flag1==true)
				{
					System.out.println("Cart Delete successfully");
				}
				else
				{
					System.out.println("Cart Not Delete successfully");
				}
		        break;
			case 4:
				System.out.println("Exit");
				break;
			default:
				System.out.println("Enter the invalid choice[1-4]");
				break;
			}
		}while(choice<4);
	}
}