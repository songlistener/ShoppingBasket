package com.rbc.shop;

import java.math.BigDecimal;


/*
 * This is a concrete implementation of one of the vistor types.
 * Different billing stategies can be implemented for different types of customers
 */
public class ConcreteCartVisitor implements CartVisitor {

	@Override
	public BigDecimal visit(LineItem lineItem) {
		BigDecimal finalCost = BigDecimal.valueOf(0.0);

		Fruit fruit = lineItem.getFruit();
		switch (fruit) {
			case Bananas:
				finalCost = finalCost.add(fruit.getPrice().multiply(lineItem.getQuantity()));
				break;
	
			case Peach:
				finalCost = finalCost.add(fruit.getPrice().multiply(lineItem.getQuantity()));
				break;
		}
		return finalCost.setScale(2);
	}

}
