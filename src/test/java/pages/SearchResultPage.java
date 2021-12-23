package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class SearchResultPage extends TestBase {

	@FindBy(linkText = "Search")
	WebElement searchHeading;
	
	@FindBy(xpath="//span[contains(text(), 'Add')]")
	WebElement addToCart;
	
	@FindBy(css="span#cart-total")
	WebElement cartTotal;
	
	@FindBy(css="div.product-thumb")
	List<WebElement> items;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public void addItemToCart() {
	if(items.size() > 0 ) 
		addToCart.click();
	}
	
	
//	public void isItemsListed() {
//		if(items.size() > 0)
//			
//		System.out.println("Number of items : " + items.size());
//	}
	public boolean isItemAdded()  {
//		WebDriverWait wait = new WebDriverWait(10,  TimeUnit.SECONDS);
//		wait.until(ExpectedConditions.textToBe(null, null))
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String total = cartTotal.getText();
		System.out.println("Cart Total : "+total);
		String itemCount = total.split(" ")[0];
		int intCount = Integer.parseInt(itemCount);
		System.out.println("Num of Items : "+ itemCount);
		if(intCount > 0)
			return true;
		else
			return false;
	}
	
}
