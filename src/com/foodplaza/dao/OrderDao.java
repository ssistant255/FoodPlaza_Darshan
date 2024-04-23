package com.foodplaza.dao;
import java.util.List;
import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Order;
public interface OrderDao 
{
	boolean placeOrder(String customer_EmailId);
	List<Order>showOrder();
}
