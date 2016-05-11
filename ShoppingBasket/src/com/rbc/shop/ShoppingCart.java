package com.rbc.shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {
	
	private CartVisitor visitor = null;
	private List<LineItem> itemList = new ArrayList<LineItem>();
	
	
	ShoppingCart( CartVisitor visitor1) {
		visitor =  visitor1;
		
	}
	
	
	
	public void add(Fruit fruit,double quantity) throws IllegalArgumentException {
		if(quantity > 0.0)
			itemList.add(new LineItem(fruit, quantity));
		else throw new IllegalArgumentException("Quantity has to be greater than zero");
	}
	
	public int getCartSize() {
		return itemList.size();
	}
	
	public BigDecimal getItemQuantity(Fruit fruit) {
		for(LineItem item:itemList) {
			if(item.getFruit().equals(fruit));
			return item.getQuantity();
		}
		return BigDecimal.valueOf(0);
	}
	
	public List<LineItem> getItemList() {
		return Collections.unmodifiableList(itemList);
	}
	
	public BigDecimal checkOut() {
		
		BigDecimal totalCost = BigDecimal.valueOf(0.0).setScale(2);
		
		for(LineItem lineItem:itemList) {
			BigDecimal c = visitor.visit(lineItem);
			totalCost = totalCost.add(c);
		}
		
		return totalCost;
	}

}
