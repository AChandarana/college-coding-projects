// Alex Chandarana Copyright 2024

import java.util.ArrayList;

public class Order {
	
	ArrayList<Product> productList = new ArrayList<Product>();
	ArrayList<Integer> countList = new ArrayList<Integer>();
	private double stateTax;
	private double federalTax;
	private double shipping;
	
	public Order() {
		this.productList = new ArrayList<>();
		this.countList = new ArrayList<>();
	}

	public void addProduct(Product product, int count) {

		productList.add(product);
		countList.add(count);
		
	}

	public void setStateTax(double stateTax) {
		if (stateTax > 0) {
			this.stateTax = stateTax;
		}
	}

	public void setFederalTax(double federalTax) {
		if (federalTax > 0) {
			this.federalTax = federalTax;
		}
	}

	public void setShipping(double shipping) {
		if (shipping > 0) {
			this.shipping = shipping;
		}
	}
	
	String completeOrder() {
		String order = "Product List\n";
		for (int i=0; i < productList.size(); ++i) {
			String isSpace = productList.get(i).name();
			if (productList.get(i).name().contains(" ")) {
				isSpace = "\"" + productList.get(i).name() + "\"";
			}
			order = order + "\t" + String.format("%010d",productList.get(i).id()) + ", " + isSpace + 
			", $" + String.format("%.2f", productList.get(i).price()) + "\t" + countList.get(i) + "\n";
			
			
		}
		
		
		double productTotal = 0;
		for (int i=0; i < productList.size(); ++i) {
			productTotal = productTotal + (countList.get(i) * productList.get(i).price());
		}
		
		double grandTotal = (productTotal + (stateTax * productTotal) + (federalTax * productTotal) + shipping); // had to use a lot of rounding to avoid floating point errors (removed because of new TestBase code)
		
		String orderSummary =
				"Order Summary\n\tProduct Total:\t$" + String.format("%.2f", productTotal);
		
		if (stateTax > 0) {
			orderSummary += "\n\tState Tax:\t$" + String.format("%.2f", stateTax*productTotal);
		}
		
		if (federalTax > 0) {
			orderSummary += "\n\tFederal Tax:\t$" + String.format("%.2f", federalTax*productTotal);
		}
		
		orderSummary += "\n\tShipping:\t$" + String.format("%.2f", shipping);
		
		orderSummary += "\n\tOrder Total:\t$" + String.format("%.2f", grandTotal);
		
		return order + orderSummary;
	}
}
