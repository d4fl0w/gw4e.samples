package com.company.model;

import java.util.Random;

public class User {
	
	int amountDelivered;
	
	public int getCoin () {
		Random rand = new Random(); 
		int value = rand.nextInt(10);
		amountDelivered+=value;
		return value;
	}
	
	public void reset () {
		this.amountDelivered=0;
	}

	public int getAmountDelivered() {
		return amountDelivered;
	}
}
