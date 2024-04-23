package com.foodplaza.dao;
import java.util.List;
import com.foodplaza.pojo.Customer;
import com.foodplaza.pojo.Food;
public interface CustomerDao
{
	boolean addCustomer(Customer c);
	boolean updateCustomer(Customer c);
	boolean deleteCustomer(int CustomerId);
	Customer  displaycustomerById(int CustomerId);
	List<Customer>displayAllCustomer();
	
}
