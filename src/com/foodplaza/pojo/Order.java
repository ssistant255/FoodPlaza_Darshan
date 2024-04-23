package com.foodplaza.pojo;

public class Order
{
	private int  orderId;
	private String  foodName, customer_EmailId, orderDate;
	private Double  totalBill;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getCustomer_EmailId() {
		return customer_EmailId;
	}
	public void setCustomer_EmailId(String customer_EmailId) {
		this.customer_EmailId = customer_EmailId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(Double totalBill) {
		this.totalBill = totalBill;
      }
}