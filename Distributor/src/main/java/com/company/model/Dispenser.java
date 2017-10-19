package com.company.model;

public class Dispenser {
	Item item;
	int insertedAmount;
	boolean delivered = true;
	int giveBackAmount;

	public void select (int index) {
		this.item=Catalog.get(index);
	}
	
	public void unselect () {
		this.item=null;
	}
	
	public void insertCoin (int amount) {
		this.insertedAmount+=amount;
	}
	
	public int giveBack () {
		if (item==null) return -1;
		this.setGiveBackAmount(insertedAmount - item.getAmount());
		return this.getGiveBackAmount();
	}

	public boolean needGiveBack () {
		return giveBack()>0;
	}

	public boolean exactAmount () {
		return giveBack()==0;
	}
	
	public boolean sufficientAmount () {
		return giveBack()>=0;
	}
	
	public int getCurrentPriceItem () {
		return  this.item.getAmount();
	}
	
	
	public void deliver () {
		setDelivered(true);
	}
	
	public boolean isIdle () {
		return this.item==null && this.insertedAmount == 0 && this.giveBackAmount == 0;
	}
	
	public boolean hasItemSelected () {
		return this.item!=null;
	}
	
	public void reset () {
		this.item=null;
		this.insertedAmount=0;
		setDelivered(true);
		setGiveBackAmount(0);
	}
	
	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	public int getGiveBackAmount() {
		return giveBackAmount;
	}

	public void setGiveBackAmount(int giveBackAmount) {
		this.giveBackAmount = giveBackAmount;
	}

	public int getInsertedAmount() {
		return insertedAmount;
	}
}
