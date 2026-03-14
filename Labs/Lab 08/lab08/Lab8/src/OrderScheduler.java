// Copyright 2025 Alex Chandarana

public class OrderScheduler {

	MinHeap<Order> orders;
	Order currentOrder;
	int currentMinute = 0;
	int totalOrders = 0;
	int summedWaitingTimes = 0;
	
	// New instance of the scheduler
	public OrderScheduler() {
		orders = new MinHeap<>();
		currentOrder = null;
		currentMinute = 0;
		totalOrders = 0;
		summedWaitingTimes = 0;
	}

	public void addOrder(Order order) {
		if (currentOrder == null) {
			currentOrder = order;
		} else {
			orders.add(order);
		}
		totalOrders++;
	}

	public boolean isDone() {
		if (currentOrder == null) return true;
		return false;
	}

	public String getCurrentOrder() {
		return currentOrder.toString();
	}

	public void advanceOneMinute() {
		currentMinute++;
		currentOrder.cookForOneMinute();
		if (currentOrder.isDone()) {
			summedWaitingTimes += currentMinute - currentOrder.getArrivalTime();
			
			// if the order is finished, remove from list and go to the next one
			currentOrder = orders.remove();
		}
	}

	public double getAverageWaitingTime() {
		if (totalOrders == 0) return 0; // Divide by zero error
		
		// Cast to double to allow decimal value
		return (double) summedWaitingTimes / totalOrders;
	}

}
