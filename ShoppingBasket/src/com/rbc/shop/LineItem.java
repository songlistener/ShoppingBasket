package com.rbc.shop;

import java.math.BigDecimal;

public class LineItem {
	private Fruit fruit;
	private BigDecimal quantity;
	
	public LineItem(Fruit fruit, double quantity) {
				this.fruit = fruit;
		this.quantity = BigDecimal.valueOf(quantity);
	}

	public Fruit getFruit() {
		return fruit;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fruit == null) ? 0 : fruit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineItem other = (LineItem) obj;
		if (fruit != other.fruit)
			return false;
		return true;
	}
	
	
	

}
