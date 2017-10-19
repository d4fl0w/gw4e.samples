package com.company.model;

public class Item {
	int amount;
	String label;
	public Item(String label,int amount) {
		super();
		this.amount = amount;
		this.label = label;
	}
	public int getAmount() {
		return amount;
	}
	public String getLabel() {
		return label;
	}
}
