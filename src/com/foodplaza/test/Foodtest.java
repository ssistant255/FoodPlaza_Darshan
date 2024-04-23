package com.foodplaza.test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.foodplaza.dao.FoodDaoImpl;
import com.foodplaza.pojo.Food;
public class Foodtest 
{
	public static void main(String[] args)
	{
		int choice;
		int foodId = 0;
		String foodName,foodCategory,foodType;
		double foodPrice;
		Food f=new Food();
		FoodDaoImpl fd = new FoodDaoImpl();
		do
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("1.Add Food\n2.Update Food\n3.Delete Food\n4.DisplayFoodById\n5.DisplayAllFood\n6.Exit");
			System.out.println("Enter your choice[1-6]");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the food name");
				foodName=sc.next();
				System.out.println("Enter the food category");
				foodCategory=sc.next();
				System.out.println("Enter the food type");
				foodType=sc.next();
				System.out.println("Enter the food price");
				foodPrice=sc.nextDouble();
				Food f1=new Food();
				f.setFoodName(foodName);
				f.setFoodCategory(foodCategory);
				f.setFoodType(foodType);
				f.setFoodPrice(foodPrice);
				
				boolean flag=fd.addFood(f);
				if(flag==true)
				{
					System.out.println("Food added");
				}
				else
				{
					System.out.println("Food adding Failed");
				}
				break;
			case 2:
				System.out.println("Enter the food id");
				foodId=sc.nextInt();
				System.out.println("Enter the food name");
				foodName=sc.next();
				Food f2=new Food();
				f.setFoodName(foodName);
				f.setFoodId(foodId);
				
				boolean flag1=fd.updateFood(f);
				if(flag1==true)
				{
					System.out.println("Food Update successfully");
				}
				else
				{
					System.out.println("Food Not update successfully");
				}
				break;
			case 3:
					System.out.println("Enter the food id");
					foodId=sc.nextInt();
					//Food f3=new Food();
					f.setFoodId(foodId);
					boolean flag2=fd.deleteFood(foodId);
					if(flag2==true)
					{
						System.out.println("Food Delete successfully");
					}
					else
					{
						System.out.println("Food Not Delete successfully");
					}
				break;
			case 4:
				System.out.println("Enter FoodID To Display Food:");
				foodId = sc.nextInt();
				f.setFoodId(foodId);
				
				f = fd.displayFoodById(foodId);
				System.out.println(f.getFoodId()+" "+f.getFoodName()+" "+f.getFoodPrice()+" "+f.getFoodCategory()+" "+f.getFoodType());
				break;
			case 5:
				List<Food> fl = new ArrayList<Food>();
				fl = fd.displayAllFood();
				for(Food food : fl)
				{
					System.out.println(food.getFoodId() + " " + food.getFoodName() + " " + food.getFoodCategory() + " " + food.getFoodPrice() + " " + food.getFoodType());
				}
				break;
			case 6:
				System.out.println("Exit");
				break;
			default:
				System.out.println("Enter the invalid choice[1-6]");
				break;
			}
		}while(choice<6);
	}
}