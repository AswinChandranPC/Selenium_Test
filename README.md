"# Selenium_Test" 

The framework is designed using **Page Object Model**


**TestBase class**
TestBase is the base class ,which will load **config.properties** file and initialize browser based on the property **browser** in **config.properties** file.

**config.properties file**
It contains the properties which are common like base url,username and password, browser type(like chrome ,firefox..etc)

**LoginPage Class**
It contains the page objects and Actions for login page
It inherits TestBase class

**TestUtil Class**
It contains the common utility methods and variables

**LoginPageTest Class**
It contains the testscripts for Login Page


