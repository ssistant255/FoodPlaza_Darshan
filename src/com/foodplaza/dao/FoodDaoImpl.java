package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodplaza.pojo.Food;
import com.foodplaza.test.Foodtest;
import com.foodplaza.utility.DBUtility;

public class FoodDaoImpl implements FoodDao 
{
	String query;
	Food f =  new Food();
	Food f1=new Food();
	Food f4=new Food();

	@Override
	public boolean addFood(Food f) {
		query="insert into Food(foodName,foodPrice,foodCategory,foodType) values(?,?,?,?)";
	    try
	    {
	    	Connection conn=DBUtility. establishConnection();
	    	PreparedStatement ps=conn.prepareStatement(query);
	    	ps.setString(1, f.getFoodName());
	    	ps.setDouble(2,f.getFoodPrice());
	    	ps.setString(3, f.getFoodCategory());
	    	ps.setString(4, f.getFoodType());
	    	int row =ps.executeUpdate();
	    	if(row>0)
	    	{
	    	     return true;
	    	}
	    	else
	    	{
	    		return false;
	    	}
	    }
	    catch(ClassNotFoundException e)
	    {
	    	e.printStackTrace(); 
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
		return false;
	}

	@Override
	public boolean updateFood(Food f1) 
	{
		query="update Food set foodName=? where foodId=?";
		try
		{
			Connection conn=DBUtility. establishConnection();
	    	PreparedStatement ps=conn.prepareStatement(query);
	    	ps.setString(1,f1.getFoodName());
	    	ps.setInt(2,f1.getFoodId());
	    	int row =ps.executeUpdate();
	    	if(row>0)
	    	{
	    	     return true;
	    	}
	    	else
	    	{
	    		return false;
	    	}
	    }
		catch(ClassNotFoundException e)
	    {
	    	e.printStackTrace(); 
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
		return false;
	}

	@Override
	public boolean deleteFood(int FoodId) 
	{
		
		query="delete from Food where foodId=?";
		try
		{
			Connection conn=DBUtility. establishConnection();
	    	PreparedStatement ps=conn.prepareStatement(query);
	    	ps.setInt(1, f.getFoodId());
	    	int row =ps.executeUpdate();
	    	if(row>0)
	    	{
	    	     return true;
	    	}
	    	else
	    	{
	    		return false;
	    	}
		}
		catch(ClassNotFoundException e)
	    {
	    	e.printStackTrace(); 
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
		return false;
	}

	@Override
	public Food displayFoodById(int FoodId) 
	{
		query="select * from Food where foodId=?";
		try
		{
			Connection conn=DBUtility. establishConnection();
	    	PreparedStatement ps=conn.prepareStatement(query);
	    	ps.setInt(1, FoodId);
			ResultSet  rs = ps.executeQuery();
			while(rs.next())
			{
				f4.setFoodId(rs.getInt(1));
				f4.setFoodName(rs.getString(2));
				f4.setFoodPrice(rs.getDouble(3));
				f4.setFoodCategory(rs.getString(4));
				f4.setFoodType(rs.getString(5));
			}
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
				return f4;
	}

	@Override
	public List<Food> displayAllFood() {
        query="select * from Food";
       
		Connection conn;
		List<Food> foodList = new ArrayList<Food>();
		try {
			conn = DBUtility. establishConnection();
			Statement st =  conn.createStatement();
			ResultSet  rs = st.executeQuery(query);
			
			while(rs.next())
			{
				Food f = new Food();
				f.setFoodId(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				f.setFoodPrice(rs.getDouble(3));
				f.setFoodCategory(rs.getString(4));
				f.setFoodType(rs.getString(5));
				
				
				foodList.add(f);
			}
			
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return foodList;
	}
}