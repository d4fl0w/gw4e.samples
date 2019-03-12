package org.graphwalker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.ChromeDriverManager;

/**
 * This is a dedicated GW4E version of the GraphWalker Amazon sample.
 * This class contains all the UI actions on the browser. It is the parent class of the ShoppingCartImpl test. 
 * Moved to ChromeDriver
 */
 
public class ShoppingCartContext extends ExecutionContext implements ShoppingCart {

    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartContext.class);
    WebDriver driver = null;
    WebDriverWait waiter = null;
    Integer numberOfAddedBooksByProgam = 0;

    @BeforeExecution
    public void setup() {
        ChromeDriverManager.getInstance().setup();
    }

    @AfterExecution
    public void cleanup() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void e_ClickBook() {
        waiter.until(ExpectedConditions.elementToBeClickable(By.linkText("Practical Model-Based Testing: A Tools Approach"))).click();
    }

    public void e_AddBookToCart() {
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.id("mediaTab_heading_1")));
        waiter.until(ExpectedConditions.elementToBeClickable(By.id("mediaTab_heading_1"))).click();
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.id("newOfferAccordionRow")));
        waiter.until(ExpectedConditions.elementToBeClickable(By.id("newOfferAccordionRow"))).click();
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-button")));
        waiter.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button"))).click();
        logger.debug("Number of added books by test: " + ++numberOfAddedBooksByProgam);
    }

    public void v_BookInformation() {
        waiter.until(ExpectedConditions.textMatches(By.tagName("h1"), Pattern.compile("Practical Model-Based Testing: A Tools Approach .*")));
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("mediaTabsGroup")));
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.className("navFooterVerticalColumn")));
    }

    public void v_OtherBoughtBooks() {
        if (driver.findElements(By.tagName("h2")).size() > 0){
            waiter.until(ExpectedConditions.or(
                ExpectedConditions.textMatches(By.tagName("h2"), Pattern.compile("Sponsored products related to.*")),
                ExpectedConditions.textMatches(By.tagName("h2"), Pattern.compile("Bestsellers in.*")),
                ExpectedConditions.textMatches(By.tagName("h2"), Pattern.compile("New Releases in.*"))
                )
            );
        }        
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.className("navFooterVerticalColumn")));
    }

    public void e_StartBrowser() {
        driver = new ChromeDriver();
        Assert.assertNotNull(driver);
        waiter = new WebDriverWait(driver, 10);
    }

   public void v_SearchResult() {
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Practical Model-Based Testing: A Tools Approach")));
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.className("navFooterVerticalColumn")));
    }


    public void v_ShoppingCart() {
        waiter.until(ExpectedConditions.titleContains("Amazon.com"));
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.className("navFooterVerticalColumn")));
        Integer expected_num_of_books_by_graphwalker = ((Double) getAttribute("num_of_books")).intValue();

        // The number of books should be equal both in the model, and in this program
        Assert.assertEquals(expected_num_of_books_by_graphwalker, numberOfAddedBooksByProgam);


        if (expected_num_of_books_by_graphwalker == 0) {
            waiter.until(ExpectedConditions.textToBe(By.tagName("h1"), "Your Shopping Cart is empty."));
            return;
        }

        waiter.until(ExpectedConditions.presenceOfElementLocated(By.id("gutterCartViewForm")));
        String itemsInCart = driver.findElement(By.id("gutterCartViewForm")).getText();

        Pattern pattern = Pattern.compile("Subtotal \\(([0-9]+) items*\\):", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(itemsInCart);
        Integer actual_num_of_books_by_selenium = null;
        if (matcher.find()) {
            actual_num_of_books_by_selenium = Integer.valueOf(matcher.group(1));
        }

        // The number of books should be equal both in the model, and found by selenium in the system under test
        Assert.assertEquals(expected_num_of_books_by_graphwalker, actual_num_of_books_by_selenium);
    }

    public void e_EnterBaseURL() {
        driver.get("http://www.amazon.com");
    }

    public void v_BaseURL() {
        waiter.until(ExpectedConditions.titleContains("Amazon.com: Online Shopping "));
    }

    public void v_BrowserStarted() {
        Assert.assertNotNull(driver);
    }

    public void e_SearchBook() {
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))).clear();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))).sendKeys("Model-based testing" + Keys.ENTER);
    }

    public void e_ShoppingCart() {
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav-cart\"]"))).click();
    }
}
