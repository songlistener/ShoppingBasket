package com.rbc.shop;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {

	@Before
	public void setUp() throws Exception {
	}

	/*
	 * The cart contains zero items  for  an empty basket 
	 */
	
	@Test
	public void testEmptyBasketSize() {
		CartVisitor visitor = new ConcreteCartVisitor();
		
		ShoppingCart cart = new ShoppingCart(visitor);
	
		
		assertEquals(0, cart.getCartSize());
		
	}
	/*
	 * Quantity has to be greater that zero
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testZeroQuantityBasketSize() {
		CartVisitor visitor = new ConcreteCartVisitor();
		
		ShoppingCart cart = new ShoppingCart(visitor);
		
		cart.add(Fruit.Bananas, 0);
		
		assertEquals(0, cart.getCartSize());
		
	}
	
	/*
	 * The cost of a cart for an empty basket should be zero.
	 */
	
	
	@Test
	public void testEmptyBasketCost() {
		BigDecimal totalCost = BigDecimal.valueOf(0.00).setScale(2);
		BigDecimal expectedCost = BigDecimal.valueOf(0.00).setScale(2);
		
		CartVisitor visitor = new ConcreteCartVisitor();
		ShoppingCart cart = new ShoppingCart(visitor);
		
		expectedCost = cart.checkOut();
		
		assertEquals(expectedCost, totalCost);
	}
	
	@Test
	public void testOneItemOneQuantitySize() {
		
		BigDecimal totalCost = BigDecimal.valueOf(0.00).setScale(2);
		BigDecimal expectedCost = BigDecimal.valueOf(0.00).setScale(2);
		
		CartVisitor visitor = new ConcreteCartVisitor();
		
		ShoppingCart cart = new ShoppingCart(visitor);
		cart.add(Fruit.Bananas, 1);
		expectedCost = cart.checkOut();
		
		
		
		assertEquals(1, cart.getCartSize());
		
	}
	
	@Test
	public void testOneItemMultipleQuantitySize() {
		CartVisitor visitor = new ConcreteCartVisitor();
		
		ShoppingCart cart = new ShoppingCart(visitor);
		
		cart.add(Fruit.Bananas, 5);
		
		assertEquals(BigDecimal.valueOf(5.0), cart.getItemQuantity(Fruit.Bananas));
		
	}
	
	@Test
	public void testMultipleItemMultipleQuantitySize() {
		
		CartVisitor visitor = new ConcreteCartVisitor();
		ShoppingCart cart = new ShoppingCart(visitor);
		
		cart.add(Fruit.Bananas, 5);
		cart.add(Fruit.Peach, 2);
		
		assertEquals(2, cart.getCartSize());
		
	}
	
	@Test
	public void testOneItemMultipleQuantityCost() {
		BigDecimal totalCost = BigDecimal.valueOf(0.00);
		BigDecimal expetedCost =  BigDecimal.valueOf(5.00).setScale(2);
		
		CartVisitor visitor = new ConcreteCartVisitor();
		ShoppingCart cart = new ShoppingCart(visitor);
		
		cart.add(Fruit.Bananas, 5);
		
		totalCost = cart.checkOut();
		
		
		assertEquals(expetedCost, totalCost);
		
		
	}
	
	
	@Test
	public void testMultipleItemMultipleQuantityCost() {
		BigDecimal totalCost = BigDecimal.valueOf(0.00).setScale(2);
		BigDecimal expectedCost = BigDecimal.valueOf(11.0).setScale(2);
		CartVisitor visitor = new ConcreteCartVisitor();
		ShoppingCart cart = new ShoppingCart(visitor);
		
		cart.add(Fruit.Bananas, 5);
		cart.add(Fruit.Peach, 3);
		
		totalCost = cart.checkOut();
		
		
		assertEquals(expectedCost, totalCost.setScale(2));
		
		
	}

}
