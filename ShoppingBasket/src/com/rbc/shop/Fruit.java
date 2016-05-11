package com.rbc.shop;

import java.math.BigDecimal;

public enum Fruit implements Item {
	Bananas("Bananas",1.00),Peach("Peach",2.00);
	private String name;
    private BigDecimal price;
    
    Fruit(String name,double price) {
    	this.name=name;
    	this.price=BigDecimal.valueOf(price);
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return name;
    }

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public BigDecimal accept(CartVisitor visitor,LineItem lineItem) {
		// TODO Auto-generated method stub
		return visitor.visit(lineItem).setScale(2);
	}
}
