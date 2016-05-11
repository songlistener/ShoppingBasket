package com.rbc.shop;

import java.math.BigDecimal;

public interface Item {
	public BigDecimal accept(CartVisitor visitor,LineItem lineItem);

}
