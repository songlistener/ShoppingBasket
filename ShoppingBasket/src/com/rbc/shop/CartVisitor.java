package com.rbc.shop;

import java.math.BigDecimal;


	
	public interface CartVisitor {
		 
	    
	    BigDecimal visit(LineItem lineItem);
	}


