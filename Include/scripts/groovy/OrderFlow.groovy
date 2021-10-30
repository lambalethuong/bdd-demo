import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class OrderFlow {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	
	String first_unit_price
	String first_quantity
	String second_unit_price
	String second_quantity
	
	@Given("I am on Amazon Homepage")
	def I_am_on_Amazon_Homepage() {
		println "I am on Amazon Homepage"
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://www.amazon.com.au/')
	}
	
	@When("Go to Today’s Deal")
	def Go_to_Today_Deal() {
		println "Go to Today’s Deal"
		// maximize Window to see Today Deals button	
		WebUI.maximizeWindow()		
		WebUI.click(findTestObject('Object Repository/Page_Amazon.com.au Shop online/a_Todays Deals'))
	}
	
	@And("Sort the items by “Discount: High to Low”")
	def Sort_the_items_by_Discount_High_to_Low() {
		println "Sort the items by “Discount: High to Low”"
		// scroll down for easier to see the sort result
		WebUI.scrollToElement(findTestObject('Page_Amazon.com.au - Todays Deals/span_Sort byFeatured'), 0)
		WebUI.click(findTestObject('Object Repository/Page_Amazon.com.au - Todays Deals/span_Sort byFeatured'))
		WebUI.click(findTestObject('Object Repository/Page_Amazon.com.au - Todays Deals/a_Discount - high to low'))
	}

	@And("View Deal for second item")
	def View_Deal_for_second_item() {
		println "View Deal for second item"
		WebUI.click(findTestObject('Page_Amazon.com.au - Todays Deals/div_second item'))
	}

	@And("Add (.*) first items into the cart")
	def Add_firstCount_first_items_into_the_cart(String firstCount) {
		println "Add " + firstCount + " first items into the cart"
		first_unit_price = WebUI.getText(findTestObject('Page_first_item_detail/first_step_unit_price'))		
		WebUI.selectOptionByValue(findTestObject('Page_second item detail/select_quantity'), firstCount, true)		
		WebUI.click(findTestObject('Page_second item detail/input_Add to cart'))
		
	}

	@Then("Check first order: quantities, individual prices, combined prices")
	def Check_first_order_quantities_individual_prices_combined_prices() {
		println "Check first order: quantities, individual prices, combined prices"
		first_quantity = WebUI.getText(findTestObject('Page_Amazon.com.au Shopping Cart/first_step_total_items'))
		println "first unit price: " + first_unit_price + ", first quantity: " + first_quantity
		// remove $ add first
		first_unit_price = first_unit_price.substring(1)
		// format of total items "Cart subtotal (10 items):" -> get number only
		first_quantity = first_quantity.find(/\d+/)
		println "first unit price: " + first_unit_price + ", first quantity: " + first_quantity
		Float total_price = first_unit_price.toFloat() * first_quantity.toFloat()
		
		WebUI.verifyElementText(findTestObject('Page_Amazon.com.au Shopping Cart/first_step_total_price'), '$' + total_price.round(2).toString(), FailureHandling.CONTINUE_ON_FAILURE)		
	}

	@When("Go back to main page")
	def Go_back_to_main_page() {
		println "Go back to main page"
		WebUI.click(findTestObject('Page_Amazon.com.au Shopping Cart/HOME logo'))
	}

	@And("Search for (.*)")
	def Search_for_searchKey(String searchKey) {
		println "Search for " + searchKey
		WebUI.setText(findTestObject('Object Repository/Page_Amazon.com.au Shop online/input_All_field-keywords'), searchKey)
		WebUI.click(findTestObject('Object Repository/Page_Amazon.com.au  AAA bateries/input_All_nav-search-submit-button'))
	}
	
	@And("Sort the items by “Newest Arrivals”")
	def Sort_the_items_by_Newest_Arrivals() {
		println "Sort the items by “Newest Arrivals”"
		WebUI.click(findTestObject('Object Repository/Page_Amazon.com.au  AAA bateries/span_Sort byFeatured'))
		WebUI.click(findTestObject('Object Repository/Page_Amazon.com.au  AAA bateries/a_Newest Arrivals'))
	}

	@And("Add (.*) second items into the cart")
	def Add_secondCount_second_items_into_the_cart(String secondCount) {
		println "Add " + secondCount + " second items into the cart"
		WebUI.click(findTestObject('Page_Amazon.com.au aaa batteries/span_first_item'))
		WebUI.selectOptionByValue(findTestObject('Page_first_item_detail/select_quantity'), secondCount, true)
		WebUI.click(findTestObject('Page_first_item_detail/input_Add_to_cart'))
	}

	@Then("Check second order: quantities, individual prices, combined prices")
	def Check_second_order_quantities_individual_prices_combined_prices() {
		println "Check second order: quantities, individual prices, combined prices"
		first_unit_price = WebUI.getText(findTestObject('Page_Amazon.com.au Shopping Cart/first_item_unit_price'))
		first_quantity = WebUI.getText(findTestObject('Page_Amazon.com.au Shopping Cart/first_item_quantity'))
		println "first unit price: " + first_unit_price + ", first quantity: " + first_quantity
		second_unit_price = WebUI.getText(findTestObject('Page_Amazon.com.au Shopping Cart/second_item_unit_price'))
		second_quantity = WebUI.getText(findTestObject('Page_Amazon.com.au Shopping Cart/second_item_quantity'))
		println "second unit price: " + second_unit_price + ", second quantity: " + second_quantity
		// remove $ add first
		first_unit_price = first_unit_price.substring(1)
		second_unit_price = second_unit_price.substring(1)
		Float total_price = first_unit_price.toFloat() * first_quantity.toFloat() + second_unit_price.toFloat() * second_quantity.toFloat()
		WebUI.verifyElementText(findTestObject('Page_Amazon.com.au Shopping Cart/total_price'), '$' + total_price.round(2).toString(), FailureHandling.CONTINUE_ON_FAILURE)
	}

	@When("Go to your cart")
	def Go_to_your_cart() {
		println "Go to your cart"
		WebUI.click(findTestObject('Object Repository/Page_Amazon.com.au Shopping Cart/span_Cart'))
	}

	@And("Edit the first item quantity - set to (.*)")
	def Edit_the_first_item_quantity_set_to_firstCountAfter(String firstCountAfter) {
		println "Edit the first item quantity - set to " + firstCountAfter
		WebUI.click(findTestObject('Page_Amazon.com.au Shopping Cart/span_first_item_quantity'))
		// click on dynamic object like //a[@id='quantity_1'] replace 1 with firstCountAfter
		String xpath = '//a[@id=\'quantity_' + firstCountAfter + '\']'
		TestObject to = new TestObject("select_first_value")
		to.addProperty("xpath", ConditionType.EQUALS, xpath)
		WebUI.click(to)
	}
	
	@And("Edit the second item quantity – set to (.*)")
	def Edit_the_second_item_quantity_set_to_secondCountAfter(String secondCountAfter) {
		println "Edit the second item quantity - set to " + secondCountAfter
		WebUI.click(findTestObject('Page_Amazon.com.au Shopping Cart/span_second_item_quantity'))
		// click on dynamic object like //a[@id='quantity_1'] replace 1 with secondCountAfter
		String xpath = '(//a[@id=\'quantity_' + secondCountAfter + '\'])[2]'
		TestObject to = new TestObject("select_second_value")
		to.addProperty("xpath", ConditionType.EQUALS, xpath)
		WebUI.click(to)
	}

	@And("Delete the first item")
	def Delete_the_first_item() {
		println "Delete the first item"
		WebUI.click(findTestObject('Page_Amazon.com.au Shopping Cart/first_item_delete_link'))
	}
	
	@Then("Check third order: quantities, individual prices, combined prices")
	def Check_third_order_quantities_individual_prices_combined_prices() {
		println "Check third order: quantities, individual prices, combined prices"
		first_unit_price = WebUI.getText(findTestObject('Page_Amazon.com.au Shopping Cart/third_step_unit_price'))
		first_quantity = WebUI.getText(findTestObject('Page_Amazon.com.au Shopping Cart/third_step_quantity'))
		println "first unit price: " + first_unit_price + ", first quantity: " + first_quantity
		// remove $ add first
		first_unit_price = first_unit_price.substring(1)
		// quantity format: "Qty:3"
		first_quantity = first_quantity.substring(4)
		println "first unit price: " + first_unit_price + ", first quantity: " + first_quantity
		// check total item
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Amazon.com.au Shopping Cart/third_step_total_items'), 'Subtotal ('+ first_quantity +' item):', 
			FailureHandling.CONTINUE_ON_FAILURE)
		Float total_price = first_unit_price.toFloat() * first_quantity.toFloat()
		// check total price
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Amazon.com.au Shopping Cart/third_step_total_price'), '$'+total_price.round(2).toString(), 
			FailureHandling.CONTINUE_ON_FAILURE)
	}

	@When("Click “Proceed to Checkout”")
	def Click_Proceed_to_Checkout() {
		println "Click “Proceed to Checkout”"
		WebUI.click(findTestObject('Page_Amazon.com.au Shopping Cart/input_proceedToRetailCheckout'))
	}
	
	@Then("I am on Login page")
	def I_am_on_Login_page() {
		println "I am on Login page"
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Amazon Sign In/h1_Sign-In'), 'Sign-In', FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.closeBrowser()
	}

}