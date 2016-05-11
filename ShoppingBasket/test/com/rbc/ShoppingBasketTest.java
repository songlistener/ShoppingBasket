package com.rbc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShoppingBasketTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ShoppingBasket basket = new ShoppingBasket();
		Fruit apples = new Apples();
		basket.add(apples);
	}

}
