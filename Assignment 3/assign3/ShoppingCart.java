// Alex Chandarana Copyright 2024

import java.util.ArrayList;

class ShoppingCart {
	static ArrayList<Product> productList = new ArrayList<Product>();
	static ArrayList<Integer> countList = new ArrayList<Integer>();
	static double shippingValue, federalTaxValue, stateTaxValue;
	public static void reset(double shipping, double federalTax, double stateTax) {
		
		if (shipping < 0) {
			shippingValue = 0;
		} else {
			shippingValue = shipping;
		}
		if (federalTax < 0) {
			federalTaxValue = 0;
		} else {
			federalTaxValue = federalTax;
		}
		if (stateTax < 0) {
			stateTaxValue = 0;
		} else {
			stateTaxValue = stateTax;
		}
		
		// saw the .clear syntax pop up, tried it, and it worked.
		productList.clear();
		countList.clear();
		
	}

	public static void addProduct(Product product) {
		boolean found = false;
		for (int i = 0; i < productList.size(); ++i) {
			if (product == productList.get(i)) {
				countList.set(i, countList.get(i) + 1);
				found = true;
			}
		}
		if (!found) {
			productList.add(product);
			countList.add(1);
		}
}

	public static Order buildOrder() {
		Order order = new Order();
			
		for (int i = 0; i < productList.size(); ++i) {
			Product product = productList.get(i);
			int count = countList.get(i);
			order.addProduct(product, count);
			order.setShipping(shippingValue);
			order.setFederalTax(federalTaxValue);
			order.setStateTax(stateTaxValue);
		}
		return order;
	}

	public static String getContents() {
		String contents = "";
	    
		for (int i = 0; i < productList.size(); ++i) {
			String productId = String.format("%010d", productList.get(i).id());
			int count = countList.get(i);
			contents += productId + " : " + String.format("%4d", count) + "\n";
		}
	    
		return contents.trim(); // .trim fixed an issue, but I'm not sure why
	}

	public static void removeProduct(Product product) {
		for (int i = 0; i < productList.size(); ++i) {
			if (product.equals(productList.get(i))) {
				int isZero = countList.get(i) - 1;
				if (isZero > 0) {
					countList.set(i, isZero);
				} else {
					productList.remove(i);
					countList.remove(i);
				}
			}
		}
	}

	public static void deleteProduct(Product product) {
		for (int i = 0; i < productList.size(); ++i) {
			if (product == productList.get(i)) {
				productList.remove(i);
				countList.remove(i);
			}
		}
	}
}