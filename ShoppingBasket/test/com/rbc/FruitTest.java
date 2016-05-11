package com.rbc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitTest {


	@Test
	public void testApples() {
		Fruit f = new Apples();;
		String expectedName = "Apples";
		double expectedPrice = 2.0;
		assertEquals(expectedName,f.getName());
		assertEquals(expectedPrice,f.getPrice(),0.0);
	}
	
	@Test
	public void testBananas() {
		Fruit f = new Bananas();;
		String expectedName = "Bananas";
		double expectedPrice = 3.5;
		assertEquals(expectedName,f.getName());
		assertEquals(expectedPrice,f.getPrice(),0.0);
	}

}
