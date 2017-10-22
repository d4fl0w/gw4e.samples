package com.company;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.annotation.Generated;

import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.Context;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.model.Edge;
import org.graphwalker.core.model.Element;
import org.graphwalker.core.statistics.Profile;
import org.graphwalker.core.statistics.Profiler;
import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.company.model.Dispenser;
import com.company.model.User;

@Generated (value ="src/test/resources/com/company/DrinkDispenser.json")

@GraphWalker(value = "a_star(reached_vertex(v_deliver))", start = "Start", groups = { "default" })

public class DrinkDispenserImpl extends ExecutionContext implements DrinkDispenser {

	public final static Path MODEL_PATH = Paths.get("com/company/DrinkDispenser.json");

	private int getIndex () {
		Random rand = new Random(); 
		return rand.nextInt(1);
	}
	
	private User getUser () {
		User user = (User)this.getAttribute("user");
		return user;
	}
	
	private Dispenser getDistributor () {
		Dispenser distributor = (Dispenser)this.getAttribute("dispenser");
		return distributor;
	}
	
	@Override
	public void e_unselect_item() {
		System.out.println("Executing:e_unselect_item");
		getDistributor ().unselect();
	}

	@Override
	public void v_deliver() {
		System.out.println("Executing:v_deliver");
	 	org.junit.Assert.assertTrue("Invalid state for delivery" ,getDistributor ().isDelivered());
	}

	@Override
	public void e_deliver() {
		System.out.println("Executing:e_deliver");
		getDistributor ().setDelivered(true);
	}

	@Override
	public void v_collect_money() {
		System.out.println("Executing:v_collect_money(");
		org.junit.Assert.assertTrue("Invalid state for inserted amount" , this.getDistributor().getInsertedAmount() == this.getUser().getAmountDelivered());
	}

	@Override
	public void e_select_item() {
		System.out.println("Executing:e_select_item");
		getDistributor ().select(getIndex());
	}

	@Override
	public void v_wait() {
		System.out.println("Executing:v_wait");
		org.junit.Assert.assertTrue("Not in a delivered state" , this.getDistributor().isDelivered());
		org.junit.Assert.assertTrue("Not in a idle state" , this.getDistributor().isIdle());
	}

	@Override
	public void e_insert_coins() {
		System.out.println("Executing:e_insert_coins");
		getDistributor ().insertCoin(getUser().getCoin()); 
 	}

	@Override
	public void e_giveback_money() {
		System.out.println("Executing:e_giveback_money");
		getDistributor ().giveBack();
	}

	@Override
	public void v_test_choice() {
		System.out.println("Executing:v_test_choice");
		org.junit.Assert.assertTrue("No item selected" , this.getDistributor().hasItemSelected());
	}
	
	@Override
	public void e_reset() {
		getDistributor().reset();
		getUser().reset();
	}

	@Override
	public void v_giveback_money() {
		System.out.println("Executing:v_giveback_money");
		int given = this.getUser().getAmountDelivered();
		int price = this.getDistributor().getCurrentPriceItem();
		int back = this.getDistributor().getGiveBackAmount();
		org.junit.Assert.assertEquals("Invalid anount back" , (given-price) , back);
	}

	@org.graphwalker.java.annotation.BeforeExecution
	public void _beforeExecution() {
		System.out.println("Executing: _beforeExecution");
		this.setAttribute("dispenser", new Dispenser());
		this.setAttribute("user", new User());
	}

	@org.graphwalker.java.annotation.AfterExecution
	public void _afterExecution() {
		String newline = System.getProperty("line.separator");
		String quote = "\"";
		Profiler profiler = this.getProfiler();
		List<Profile> profiles = profiler.getProfiles();
		StringBuffer sb = new StringBuffer();
		sb.append("{").append(newline);
		sb.append(quote).append("performance").append(quote).append(" : {").append(newline);
		sb.append(quote).append("items").append(quote).append(" : [").append(newline);
		Iterator<Profile> iter = profiles.iterator();
		while (iter.hasNext()) {
			Profile profile = iter.next();
			Element element = profile.getElement();
			String contextModel = profile.getContext().getModel().getName();
			String contextName = profile.getContext().getClass().getName();
			String pathGenerator = profile.getContext().getPathGenerator().toString();
			sb.append("{").append(newline).append(quote).append("name").append(quote).append(":").append(quote)
					.append(element.getName()).append(quote).append(",").append(newline);
			sb.append(quote).append("contextName").append(quote).append(":").append(quote).append(contextName)
					.append(quote).append(",").append(newline);
			sb.append(quote).append("pathGenerator").append(quote).append(":").append(quote).append(pathGenerator)
					.append(quote).append(",").append(newline);
			if (element instanceof Edge.RuntimeEdge) {
				Edge.RuntimeEdge re = (Edge.RuntimeEdge) element;
				sb.append(quote).append("type").append(quote).append(":").append(quote).append("EDGE").append(quote)
						.append(",").append(newline);
				sb.append(quote).append("source").append(quote).append(":").append(quote)
						.append(re.getSourceVertex() == null ? "" : re.getSourceVertex().getName()).append(quote)
						.append(",").append(newline);
				sb.append(quote).append("target").append(quote).append(":").append(quote)
						.append(re.getTargetVertex() == null ? "" : re.getTargetVertex().getName()).append(quote)
						.append(",").append(newline);
			} else {
				sb.append(quote).append("kind").append(quote).append(":").append(quote).append("VERTEX").append(quote)
						.append(",").append(newline);
			}
			sb.append(quote).append("ExecutionCount").append(quote).append(":").append(quote)
					.append(profile.getExecutionCount()).append(quote).append(",").append(newline);
			sb.append(quote).append("FirstExecutionTime").append(quote).append(":").append(quote)
					.append(profile.getFirstExecutionTime(TimeUnit.MILLISECONDS)).append(quote).append(",")
					.append(newline);
			sb.append(quote).append("LastExecutionTime").append(quote).append(":").append(quote)
					.append(profile.getLastExecutionTime(TimeUnit.MILLISECONDS)).append(quote).append(",")
					.append(newline);
			sb.append(quote).append("MaxExecutionTime").append(quote).append(":").append(quote)
					.append(profile.getMaxExecutionTime(TimeUnit.MILLISECONDS)).append(quote).append(",")
					.append(newline);
			sb.append(quote).append("MinExecutionTime").append(quote).append(":").append(quote)
					.append(profile.getMinExecutionTime(TimeUnit.MILLISECONDS)).append(quote).append(",")
					.append(newline);
			sb.append(quote).append("TotalExecutionTime").append(quote).append(":").append(quote)
					.append(profile.getTotalExecutionTime(TimeUnit.MILLISECONDS)).append(quote).append(",")
					.append(newline);
			sb.append(quote).append("AverageExecutionTime").append(quote).append(":").append(quote)
					.append(profile.getAverageExecutionTime(TimeUnit.MILLISECONDS)).append(quote).append(newline);
			sb.append("}").append(newline);
			if (iter.hasNext())
				sb.append(",");
		}
		sb.append("]").append("}").append("}");
		System.out.println(sb.toString());
	}

	@org.graphwalker.java.annotation.BeforeElement
	public void _beforeElement() {
		System.out.println("Executing: _beforeElement");
	}

	@org.graphwalker.java.annotation.AfterElement
	public void _afterElement() {
		System.out.println("Executing: _afterElement");
	}
 
	@Test
	public void runSmokeTest() throws IOException {
		Context context = new DrinkDispenserImpl();
		TestBuilder builder = new TestBuilder().addContext(context, MODEL_PATH);
		context.setPathGenerator(new AStarPath(new ReachedVertex("v_deliver")));
		context.setNextElement(context.getModel().findElements("Start").get(0));
		Result result = builder.execute();
		Assert.assertFalse(result.hasErrors());
	}

	@Test
	public void runFunctionalTest() throws IOException {
		Context context = new DrinkDispenserImpl();
		TestBuilder builder = new TestBuilder().addContext(context, MODEL_PATH);
		context.setPathGenerator(new RandomPath(new EdgeCoverage(100)));
		context.setNextElement(context.getModel().findElements("Start").get(0));
		Result result = builder.execute();
		Assert.assertFalse(result.hasErrors());
	}

	@Test
	public void runStabilityTest() throws IOException {
		Context context = new DrinkDispenserImpl();
		TestBuilder builder = new TestBuilder().addContext(context, MODEL_PATH);
		context.setPathGenerator(new RandomPath(new TimeDuration(30, TimeUnit.SECONDS)));
		context.setNextElement(context.getModel().findElements("Start").get(0));
		Result result = builder.execute();
		Assert.assertFalse(result.hasErrors());
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	

}
