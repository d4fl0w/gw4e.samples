package com.company.model;

import java.util.Arrays;
import java.util.List;

public class Catalog {
	static List<Item> items = Arrays.asList(new Item("itemA",10),  new Item("itemB",5));
	
	public static Item  get(int index) {
		return items.get(index);
	}
}
