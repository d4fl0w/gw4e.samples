package org.graphwalker;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.Generated;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Test;

@Generated(value = "src/main/resources/org/graphwalker/ShoppingCart.json")
@GraphWalker(value = "random(edge_coverage(100))", start = "e_StartBrowser", groups = { "default" })
public class ShoppingCartOffLineImpl extends ExecutionContext implements ShoppingCart {

	public final static Path MODEL_PATH = Paths.get("org/graphwalker/ShoppingCart.json");

	@Override
	public void e_AddBookToCart() {
		System.out.println("Executing:e_AddBookToCart");
	}

	@Override
	public void e_ClickBook() {
		System.out.println("Executing:e_ClickBook");
	}

	@Override
	public void v_BookInformation() {
		System.out.println("Executing:v_BookInformation");
	}

	@Override
	public void v_OtherBoughtBooks() {
		System.out.println("Executing:v_OtherBoughtBooks");
	}

	@Override
	public void e_StartBrowser() {
		System.out.println("Executing:e_StartBrowser");
	}

	@Override
	public void v_SearchResult() {
		System.out.println("Executing:v_SearchResult");
	}

	@Override
	public void v_ShoppingCart() {
		System.out.println("Executing:v_ShoppingCart");
	}

	@Override
	public void e_EnterBaseURL() {
		System.out.println("Executing:e_EnterBaseURL");
	}

	@Override
	public void v_BaseURL() {
		System.out.println("Executing:v_BaseURL");
	}

	@Override
	public void v_BrowserStarted() {
		System.out.println("Executing:v_BrowserStarted");
	}

	@Override
	public void e_SearchBook() {
		System.out.println("Executing:e_SearchBook");
	}

	@Override
	public void e_ShoppingCart() {
		System.out.println("Executing:e_ShoppingCart");
	}

	@Test
	public void test_1508742056350() {
		System.out.println("Generated with : RandomPath(EdgeCoverage(100))");
		e_StartBrowser();
		v_BrowserStarted();
		e_EnterBaseURL();
		v_BaseURL();
		e_SearchBook();
		v_SearchResult();
		e_ClickBook();
		v_BookInformation();
		e_AddBookToCart();
		v_OtherBoughtBooks();
		e_SearchBook();
		v_SearchResult();
		e_ClickBook();
		v_BookInformation();
		e_ShoppingCart();
		v_ShoppingCart();
		e_SearchBook();
		v_SearchResult();
		e_ClickBook();
		v_BookInformation();
		e_AddBookToCart();
		v_OtherBoughtBooks();
		e_SearchBook();
		v_SearchResult();
		e_ShoppingCart();
		v_ShoppingCart();
		e_SearchBook();
		v_SearchResult();
		e_ShoppingCart();
		v_ShoppingCart();
		e_SearchBook();
		v_SearchResult();
		e_ClickBook();
		v_BookInformation();
		e_ShoppingCart();
		v_ShoppingCart();
		e_SearchBook();
		v_SearchResult();
		e_ShoppingCart();
		v_ShoppingCart();
		e_SearchBook();
		v_SearchResult();
		e_ClickBook();
		v_BookInformation();
		e_SearchBook();
		v_SearchResult();
		e_ClickBook();
		v_BookInformation();
		e_AddBookToCart();
		v_OtherBoughtBooks();
		e_ShoppingCart();
		v_ShoppingCart();
	}

}
