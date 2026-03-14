// Copyright 2025 Alex Chandarana

public class Order implements Comparable<Order> {

	private String customer;
	private String foodOrder;
	private int cookingTime;
	private int arrivalTime;
	private int remainingTime;

	public Order(String customer, String foodOrder, int cookingTime, int arrivalTime) {
		
		// Checks if the variables are valid, if not they are set to their default value
		if (customer != null) {
			this.customer = customer;
		} else {
			this.customer = "none";
		}

		if (foodOrder != null) {
			this.foodOrder = foodOrder;
		} else {
			this.foodOrder = "none";
		}

		if (cookingTime > 0) {
			this.cookingTime = cookingTime;
		} else {
			this.cookingTime = 1;
		}

		if (arrivalTime >= 0) {
			this.arrivalTime = arrivalTime;
		} else {
			this.arrivalTime = 0;
		}

		this.remainingTime = this.cookingTime;
	}

	public Order() {
		this.customer = "none";
		this.foodOrder = "none";
		this.cookingTime = 1;
		this.arrivalTime = 0;
		this.remainingTime = this.cookingTime;
	}

	public String getCustomer() {
		return this.customer;
	}

	public String getFoodOrder() {
		return this.foodOrder;
	}

	public int getCookingTime() {
		return this.cookingTime;
	}

	public int getArrivalTime() {
		return this.arrivalTime;
	}

	public int getRemainingTime() {
		return this.remainingTime;
	}

	public void setCustomer(String d) {
		if (d == null) return;
		this.customer = d;
	}

	public void setFoodOrder(String d) {
		if (d == null) return;
		this.foodOrder = d;
	}

	public void setCookingTime(int d) {
		if (d < 0) return;
		this.cookingTime = d;
	}

	public void setArrivalTime(int d) {
		if (d < 0) return;
		this.arrivalTime = d;
	}

	public void setRemainingTime(int d) {
		if (d < 0) return;
		this.remainingTime = d;
	}

	public String toString() {
		return "Customer: " + this.customer + ", Order: " + this.foodOrder + ", Cooking Time Left: " + this.remainingTime;
	}

	public int compareTo(Order other) {
		
		// Sort by shortest cooking time
		return Integer.compare(this.cookingTime, other.cookingTime);
	}
	
	public void cookForOneMinute() {
		this.remainingTime--;
	}
	
	public boolean isDone() {
		return (this.remainingTime <= 0);
	}
	
}
