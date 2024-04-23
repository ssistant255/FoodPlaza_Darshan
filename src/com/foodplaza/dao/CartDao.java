package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Cart;

public interface CartDao 
{
	boolean addtoCart(Cart c);
	List<Cart>showCart(String customerEmailId);
	boolean deletetoCart(int CartId);

}
