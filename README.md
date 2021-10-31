Welcome to the BDD automation test script sample web application
==================================================

This sample code helps get you started with a simple Amazon web application
used by Katalon Studio (free version) automation test tool.

My technical decisions
-----------

1. Code language: BDD (feature), Groovy (step definition)

2. Code respository: Github

3. Database: None

4. Server: None (local host)

5. Deployment: None

6. Log: auto generate by tool

7. Development tool: Katalon Studio

8. API: None

Run on local
---------------

To work on the sample code, you'll need to clone your project's repository to your
local computer. If you haven't, do that first. 

1. Github

   * Clone repository into local
   
        $ cd <your_local_folder>

        $ git clone https://github.com/lambalethuong/bdd-demo.git

   * Provide OAuth (user name, access key) 

   * If clone error happen
   
    	https://stackoverflow.com/questions/68775869/support-for-password-authentication-was-removed-please-use-a-personal-access-to

   * Switch to master branch (branch main is not used)

        $ git checkout master

2. Install Katalon Studio

	https://www.katalon.com/

	Attention: 
		
		If you create account with public email (ex: @gmail.com) get free version of Katalon

		If you create account with company email (ex: @vitalify.com) get trial version of Katalon, full functional for 30 days -> can upgrade to paid version (Katalon Studio Enterprise)
		
		This sample use free version so you should create account with @gmail.com

		Katalon can install in MacOS, Window, Linux (cross-platform)

		After installation is done, if a popup about analytics shows, just close. This function is in the paid version.

		Upgrade Katalon: choose Help -> Check for Updates... 

		Note: if you want to try beta or alpha version, please visit this link

		https://github.com/katalon-studio/katalon-studio/releases/


3. Run web on PC (Mac/Window/Linux)

   * Update all browsers (Chrome, Safari, Edge Chromium, Firefox) to the latest version. Internet Explorer degraded so don't care.

   * Update drivers for browsers

		In Katalon menu choose Tools -> Update WebDrivers -> <browser name>

		Normally auto update is successful.
		
		If error happen, please follow these steps below:
		
			1/ Visit website to get newest drivers
		
				Chrome: https://chromedriver.chromium.org/
		
				Firefox: https://github.com/mozilla/geckodriver/releases
				
				Edge Chromium: https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/
		
				Internet Explorer: https://www.selenium.dev/downloads/
				
				Safari: no need, Safari driver will install with MacOS and Safari browser

			2/ Replace drivers in Katalon location
				
				MacOS: /Applications/Katalon Studio.app/Contents/Eclipse/configuration/resources/drivers/<browser name>

				Window: <Katalon_Studio_folder>\configuration\resources\drivers\<browser name>

	* Setting for Safari

		Safari -> Preferences -> Advanced -> check "show Develop menu in menu bar" 

		Safari -> Develop -> Allow Remote Automation

		Reference: https://stackoverflow.com/questions/41629592/macos-sierra-how-to-enable-allow-remote-automation-using-command-line

	* Setting for Edge

		Microsoft Edge Legacy is trial version, just ignore
	
		Please choose Edge Chromium to run testcase

		If problem occur, enter below link

			https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/

			column Microsoft Edge choose accordingly version of Microsoft Edge on PC

			Download and unzip, copy file msedgedriver.exe into folder

				Katalon_Studio_folder\configuration\resources\drivers\edgechromium_win64

4. Run web on Android - Chrome

	Open Terminal and run command: 

		$ npm install -g appium

	If permission denied error happen run command instead:

		$ sudo npm install -g appium --unsafe-perm=true --allow-root

		download file chromedriver same version with chrome on android

			https://sites.google.com/a/chromium.org/chromedriver/downloads

			Mac: copy & replace file chromedriver into this folder

				/usr/local/lib/node_modules/appium/node_modules/appium-chromedriver/chromedriver/mac
   
5. Run web on iPhone - Safari

	make sure Web Inspector is turned on for Safari on iPhone (Settings → Safari → Advanced → Web Inspector)

6. Run test case with Katalon Studio

	* Launch Katalon Studio
	
	* Login with registered account (in Toolbar, account icon at the top right)

	* File -> Open Project -> choose clone repository on local computer
	
	* Run Feature file
	
		In the left show project structure, go to Include -> features -> double click OrderFlow.feature
		
		File will open as new tab
		
		The first scenario same as technical test file
		
		The second scenario replace search key, quantity of each items (for dynamic reason)
		
		In Toolbar, we have Play icon. Click on drop-down to choose corresponding browser to run
		
			Computer headful mode: Chrome, Safari, Edge Chromium, Firefox
			
			Computer headless mode: Chrome, Firefox (for faster)
			
			Android: Just connect Android device via USB cable (refer 4. Run web on Android - Chrome). Run test case on Chrome browser of Android device.  
			
			iOS: Just connect iPhone, iPad device via USB cable (refer 5. Run web on iPhone - Safari). Run test case on Safari browser of iOS device.
			
	* Run test suite collection
	
		In the left show project structure, go to Test Suites
		
		Open Headful file by double click, show as new tab.
		
			Just click Execute button to run automatically on all browsers: Chrome, Safari, Edge Chromium, Firefox

		Open Headless file by double click, show as new tab.
		
			Just click Execute button to run automatically on all browsers: Chrome, Firefox (faster run, just show log)
		
7. Report

    When run test case or test suite, report each step show on Log Viewer tab at the bottom, for more detail see Console tab.

	After run test suite, report auto generate at Reports -> YYYYMMDD_HHmmss folder (in my example 20211031_185942)
	
		In Headful folder (name of Test suite collection) we have report file but cannot see (need upgrade to paid version)
		
		But we can go to this path to see HTML file
		
			/Users/thuonglbl/Katalon Studio/AmazonBDDDemo/Reports/20211031_185942/MainSuite/20211031_185944/20211031_185944.html
			
			MainSuite is name of test suite run in test suite collection
			
			Each HTML file is generated for each browser, each time run

Run on cloud
---------------

	Not yet support

Deploy
---------------

	Not yet support
	
Future improvements
---------------

	1. Support out of stock item (cannot change quantity)

	2. Support item with multiple branches

	3. Support login session

	4. Support calculate for more items

	5. Run on Cloud & Deploy
	
Structure
-----------

This sample includes:

* Profiles/ - this directory contains the configuration files that allows
  run all multiple environments (such as dev, staging, production)
  in this sample only production environment so not use
* Test Cases/OrderFlow - record test cases used to identify objects under test (save time for Inspect)
* Test Cases/Main - call Feature file
* Object Repository - each folder is one web page, items in folder are all objects under test
  very important to identify object (such as xpath, id, class, text, tag, ...)
* Test Suites/MainSuite - this file is test suite, contains all the test cases in sequence
* Test Suites/Headful - this file is test suite collection, used to run test suite in multiple browsers/profiles
* Test Suites/Headless - this file is test suite collection, used to run test suite in multiple browsers/profiles
* Data Files/ - this directory contains self-defined input/output files used by project
  in this sample not use
* Checkpoints/ - the snapshot of test data taken at a specific time. A checkpoint is used to verify whether the current state of the data source is different from its previous taken state. An example where Checkpoints proves to be helpful are database validation cases where value usually changes constantly.
  in this sample no DB so not use
* Keywords/ - self-defined keywords. Usually use when not supported by Katalon Studio
  in this sample not use
* Test Listeners/ - Automation testers usually want to specify prerequisite and clean-up configurations for their test cases. With the prerequisite configuration, the test engine must take specific actions before starting test execution. For clean-up configuration, the test engine must carry out some actions after the test execution finishes.
  in this sample not use
* Reports/ - this directory contains auto generate results by Katalon Studio
* TestOps/ - this directory contains configuration files for CI/CD into cloud
  in this sample not use
* Include/ - this directory contains BDD feature files, step definition files
* Plugins/ - this directory contains some plugins from Katalon Plugin Store
  in this sample not use
* .gitignore - list files not commit to git
* build.gradle - compile options
* console.properties - configurations to link with other services 
* README.md - this file, describe the project