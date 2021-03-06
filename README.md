
# Deliveroo Automation Project

Automated tests for the Deliveroo's cart 

### The main Frameworks included in the project:
* Selenium WebDriver
* TestNG
* Maven
* WebDriver Manager 
* json-simple
* Allure Report

### Project Design:
* Page Object Model (POM) design pattern (method chaining)
* Singleton design pattern (webDriver)
* A PageBase class in *src/main/java/frameworkBase/PageBases.java* file path, that includes creation of the  webDriver and many wrapper methods which services as a core engine for the project 
* Data Driven framework (JSON)
* A screenShot for failure 
* A Allure / emailable-report report After executing 


### How to run the project test cases :
* Can find the test cases in the *src/test/java* folder mainly in the *pagesTest* package
* Can find the testData  in the *src/test/java* folder mainly in the *data* package
* Can find the TestBase in the *src/test/java* folder mainly in the *base* package
* Can find the test suite for all the test cases in the *deliveroo* folder in the *testng.xml* file
* To start the execution, please make sure that Maven and allure Report are setuped on the environment 
* Can run through TestNG xml: by right-click on the test suite xml file and click Run As >> TestNG Suit 
* Can run through maven : by opening a command-line terminal on the project root path and type `mvn clean` then `mvn Test`
* After executing, you can easily generate the ***Allure Report*** by opening a command-line terminal on the project root path and type `allure. bat serve`



