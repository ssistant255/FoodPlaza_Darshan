package com.foodplaza.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.foodplaza.pojo.Customer;
import com.foodplaza.utility.DBUtility;
public class CustomerDaoImpl implements CustomerDao 
{
	String query;
	Customer c=new Customer();
	@Override
	public boolean addCustomer(Customer c)
	{
		query="insert into customer1(customerName, customerContact, customerAddress, customerEmailId, customerPassword) values(?,?,?,?,?)";
		 try
		    {
		    	Connection conn=DBUtility. establishConnection();
		    	PreparedStatement ps=conn.prepareStatement(query);
		    	ps.setString(1, c.getCustomerName());
		    	ps.setLong(2, c.getCustomerContact());
		    	ps.setString(3, c.getCustomerAddress());
		    	ps.setString(4, c.getCustomerEmailId());
		    	ps.setString(5, c.getCustomerPassword());
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
	public boolean updateCustomer(Customer c)
	{
		query="update customer1 set customerName=?, customerContact=?, customerAddress=?, customerEmailId=?, customerPassword=? where  customerId=?";
		try
	    {
	    	Connection conn=DBUtility. establishConnection();
	    	PreparedStatement ps=conn.prepareStatement(query);
	    	ps.setString(1, c.getCustomerName());
	    	ps.setLong(2, c.getCustomerContact());
	    	ps.setString(3, c.getCustomerAddress());
	    	ps.setString(4, c.getCustomerEmailId());
	    	ps.setString(5, c.getCustomerPassword());
	    	ps.setInt(6, c.getCustomerId());
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
	public boolean deleteCustomer(int CustomerId)
	{
		query="delete from customer1 where customerId=?";
		try
	    {
	    	Connection conn=DBUtility. establishConnection();
	    	PreparedStatement ps=conn.prepareStatement(query);
	    	ps.setInt(1, c.getCustomerId());
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
	public Customer displaycustomerById(int CustomerId)
	{
		query="select * from customer1 where customerId=?";
		try
	    {
	    	Connection conn=DBUtility. establishConnection();
	    	PreparedStatement ps=conn.prepareStatement(query);
	    	ps.setInt(1, CustomerId);
	    	ResultSet  rs = ps.executeQuery();
			while(rs.next())
			{
				c.setCustomerId(rs.getInt(1));
				c.setCustomerName(rs.getString(2));
				c.setCustomerContact(rs.getLong(3));
				c.setCustomerAddress(rs.getString(4));
				c.setCustomerEmailId(rs.getString(5));
				c.setCustomerPassword(rs.getString(6));
			}
	    }
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return c;
	}
	

	@Override
	public List<Customer> displayAllCustomer()
	{
		 query="select * from customer";
		 Connection conn;
			List<Customer> CustomerList = new ArrayList<Customer>();
			try 
			{
				conn = DBUtility. establishConnection();
				Statement st =  conn.createStatement();
				ResultSet  rs = st.executeQuery(query);

				while(rs.next())
				{
					Customer c = new Customer();
					c.setCustomerId(rs.getInt(1));
					c.setCustomerName(rs.getString(2));
					c.setCustomerContact(rs.getLong(3));
					c.setCustomerAddress(rs.getString(4));
					c.setCustomerEmailId(rs.getString(5));
					c.setCustomerPassword(rs.getString(6));
					CustomerList.add(c);
				}
			}
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
					
		return CustomerList;
  }
	 public void BalanceEnquiry() throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm1_darshan", "root", "darshan3009");
		Statement st = conn.createStatement();
		System.out.println("Enter the pin");
		int pin=sc.nextInt();
		String queryBalanceEnquiry = "select balance from   accountholder1 where pin=?";
		PreparedStatement pr1=conn.prepareStatement(queryBalanceEnquiry);
			pr1.setInt(1, pin);
			ResultSet resultSet1 = pr1.executeQuery();
			while(resultSet1.next()) 
			{
				System.out.println("Balance Enquiry is:" +resultSet1.getLong(1));
		    }
	}
}