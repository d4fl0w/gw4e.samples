package com.company;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.Generated;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

@Generated(value = "src/test/resources/com/company/DrinkDispenser.json")
@GraphWalker(value = "random(edge_coverage(100))", start = "Start", groups = { "default" })
public class DrinkDispenserImpl extends ExecutionContext implements DrinkDispenser {

	public final static Path MODEL_PATH = Paths.get("com/company/DrinkDispenser.json");

	@Override
	public void v_wait() {
		System.out.println("Executing:v_wait");
	}
	@Override
	public void e_select_item() {
		System.out.println("Executing:e_select_item");
	}
	@Override
	public void e_insert_coins() {
		System.out.println("Executing:e_insert_coins");
	}
	@Override
	public void v_test_choice() {
		System.out.println("Executing:v_test_choice");
	}
	
	@Override
	public void e_deliver() {
		System.out.println("Executing:e_deliver");
	}

	@Override
	public void e_reset() {
		System.out.println("Executing:e_reset");
	}

	@Override
	public void v_collect_money() {
		System.out.println("Executing:v_collect_money");
	}

	@Override
	public void v_giveback_money() {
		System.out.println("Executing:v_giveback_money");
	}

	@Override
	public void e_giveback_money() {
		System.out.println("Executing:e_giveback_money");
	}

	

	@Override
	public void v_deliver() {
		System.out.println("Executing:v_deliver");
	}

	@Override
	public void e_unselect_item() {
		System.out.println("Executing:e_unselect_item");
	}



}
