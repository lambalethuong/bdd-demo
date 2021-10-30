import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.amazon.com.au/')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Page_Amazon.com.au Shop online/a_Todays Deals'))

WebUI.scrollToElement(findTestObject('Page_Amazon.com.au - Todays Deals/span_Sort byFeatured'), 0)

WebUI.click(findTestObject('Object Repository/Page_Amazon.com.au - Todays Deals/span_Sort byFeatured'))

WebUI.click(findTestObject('Object Repository/Page_Amazon.com.au - Todays Deals/a_Discount - high to low'))

WebUI.click(findTestObject('Page_Amazon.com.au - Todays Deals/div_second item'))

WebUI.selectOptionByValue(findTestObject('Page_second item detail/select_quantity'), '2', true)

WebUI.click(findTestObject('Page_second item detail/input_Add to cart'))

first_unit_price = WebUI.getText(findTestObject('Page_Amazon.com.au Shopping Cart/first_unit_price'))

first_quantity = WebUI.getText(findTestObject('Page_Amazon.com.au Shopping Cart/first_quantity'))

WebUI.verifyElementText(findTestObject('Page_Amazon.com.au Shopping Cart/total_price'), '$123.76', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Page_Amazon.com.au Shopping Cart/HOME logo'))

WebUI.setText(findTestObject('Object Repository/Page_Amazon.com.au Shop online/input_All_field-keywords'), 'AAA bateries')

WebUI.click(findTestObject('Object Repository/Page_Amazon.com.au  AAA bateries/input_All_nav-search-submit-button'))

WebUI.click(findTestObject('Object Repository/Page_Amazon.com.au  AAA bateries/span_Sort byFeatured'))

WebUI.click(findTestObject('Object Repository/Page_Amazon.com.au  AAA bateries/a_Newest Arrivals'))

WebUI.click(findTestObject('Page_Amazon.com.au aaa batteries/span_first_item'))

WebUI.selectOptionByValue(findTestObject('Page_first_item_detail/select_quantity'), '5', true)

WebUI.click(findTestObject('Page_first_item_detail/input_Add_to_cart'))

WebUI.verifyElementText(findTestObject('Page_Amazon.com.au Shopping Cart/second_item_unit_price'), '$20.92', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Page_Amazon.com.au Shopping Cart/second_item_quantity'), '5', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Page_Amazon.com.au Shopping Cart/first_item_unit_price'), '$9.58', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Page_Amazon.com.au Shopping Cart/first_item_quantity'), '2', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Page_Amazon.com.au Shopping Cart/total_price'), '$123.76', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Amazon.com.au Shopping Cart/span_Cart'))

WebUI.click(findTestObject('Page_Amazon.com.au Shopping Cart/span_first_item_quantity'))

WebUI.click(findTestObject('Page_Amazon.com.au Shopping Cart/select_value_1'))

WebUI.verifyElementText(findTestObject('Page_Amazon.com.au Shopping Cart/first_unit_price'), '$20.92', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Page_Amazon.com.au Shopping Cart/second_unit_price'), '$9.58', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Page_Amazon.com.au Shopping Cart/span_total_items'), 'Subtotal (3 items):', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Page_Amazon.com.au Shopping Cart/span_total_price'), '$40.08', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Page_Amazon.com.au Shopping Cart/span_second_item_quantity'))

WebUI.click(findTestObject('Page_Amazon.com.au Shopping Cart/select_value_3'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Amazon.com.au Shopping Cart/span_total_items'), 'Subtotal (4 items):', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Amazon.com.au Shopping Cart/span_total_price'), '$49.66', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Page_Amazon.com.au Shopping Cart/first_item_delete_link'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Amazon.com.au Shopping Cart/span_total_items'), 'Subtotal (1 item):', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Amazon.com.au Shopping Cart/span_total_price'), '$20.92', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Page_Amazon.com.au Shopping Cart/input_proceedToRetailCheckout'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Amazon Sign In/h1_Sign-In'), 'Sign-In', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()

