package stepDefs;

import org.junit.Assert;

import base.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.HomePage;
import pages.SearchResultPage;

public class OrderStepDef extends TestBase{

	HomePage homePage;
	SearchResultPage resultPage;
	@Before
	public void setup() {
		initialize();
		homePage = new HomePage();
//		resultPage = new SearchResultPage();
	}
	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		String pageTitle = homePage.getHomePageTitle();
		Assert.assertEquals("Your Store", pageTitle);
	}

	@When("User search {string}")
	public void user_search(String strItem) {
		resultPage = homePage.searchItem(strItem);
		System.out.println("Modified by Tester2");
		
	}

	@When("User add Item to cart")
	public void user_add_item_to_cart() {
		resultPage.addItemToCart();
		System.out.println("Item Added to Cart");

	}

	@Then("Item must be added to cart")
	public void item_must_be_added_to_cart() {
		boolean isItemCount = false;
		try {
			isItemCount = resultPage.isItemAdded();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(isItemCount);
	}

}
