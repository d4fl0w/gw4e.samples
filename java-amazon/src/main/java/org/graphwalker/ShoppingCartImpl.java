package org.graphwalker;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Generated;

import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.Context;
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

/**
 * Before running this test, you should go the current directory of this sample to issue the following maven command :
 *   mvn clean install
 *
 * This will download the required Selenium dependencies.
 */

@Generated(value = "src/main/resources/org/graphwalker/ShoppingCart.json")
@GraphWalker(value = "random(edge_coverage(100))", start = "e_StartBrowser")
public class ShoppingCartImpl extends ShoppingCartContext   {

	public final static Path MODEL_PATH = Paths.get("org/graphwalker/ShoppingCart.json");

	//@org.graphwalker.java.annotation.AfterExecution
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

	@Test
	public void runSmokeTest() throws IOException {
		Context context = new ShoppingCartImpl();
		TestBuilder builder = new TestBuilder().addContext(context, MODEL_PATH);
		context.setPathGenerator(new AStarPath(new ReachedVertex("v_ShoppingCart")));
		context.setNextElement(context.getModel().findElements("e_StartBrowser").get(0));
		Result result = builder.execute();
		Assert.assertFalse(result.hasErrors());
	}

	@Test
	public void runFunctionalTest() throws IOException {
		Context context = new ShoppingCartImpl();
		TestBuilder builder = new TestBuilder().addContext(context, MODEL_PATH);
		context.setPathGenerator(new RandomPath(new EdgeCoverage(100)));
		context.setNextElement(context.getModel().findElements("e_StartBrowser").get(0));
		Result result = builder.execute();
		Assert.assertFalse(result.hasErrors());
	}

	@Test
	public void runStabilityTest() throws IOException {
		Context context = new ShoppingCartImpl();
		TestBuilder builder = new TestBuilder().addContext(context, MODEL_PATH);
		context.setPathGenerator(new RandomPath(new TimeDuration(30, TimeUnit.SECONDS)));
		context.setNextElement(context.getModel().findElements("e_StartBrowser").get(0));
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
