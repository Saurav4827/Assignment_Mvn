package Assign2;

 
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.IOException;

import java.io.FileReader;

import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.yaml.snakeyaml.Yaml;

public class Stepdefs {
	WebDriver driver;
  
		
	   
	@Given("User is already on the javatpoint home page")
	public void user_is_already_on_the_javatpoint_home_page() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	
		
		FileReader reader=new FileReader("src/test/resources/Assign2/browserinfo.properties");
		Properties p=new Properties();
		p.load(reader);
        System.out.println(reader);
        String browser=p.getProperty("browser");
        String Url=p.getProperty("Url");
        
       
        if(browser.contentEquals("chrome"))
        {
        	 System.setProperty("webdriver.chrome.driver","/home/qainfotech/Downloads/chromedriver");	
  		     driver = new ChromeDriver();
    		
        }
        else 
        {
        	System.setProperty("webdriver.gecko.driver","/home/qainfotech/Downloads/geckodriver");	
   		    driver = new FirefoxDriver();
   		    
        }
        driver.get(Url);
       
	
		
		
	}

	@When("User clicks on the java button")
	public void user_clicks_on_the_java_button() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		String outerkey="java";
		String innerkey="locator";
		String locatorget=method(outerkey,innerkey);
		System.out.println(locatorget);
		driver.findElement(By.xpath(locatorget)).click();
		
	    
	}

	@Then("User is navigate to javatutorial webpage")
	public void user_is_navigate_to_javatutorial_webpage() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("java tutorials webpage");
	    
	}

	@Then("User matches the title of webpage")
	public void user_matches_the_title_of_webpage() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		String outerkey="title";
		String innerkey="locator";
		String locatorget=method(outerkey,innerkey);
		System.out.println(locatorget);
		String Actualtitle= driver.findElement(By.xpath(locatorget)).getText();
        Assert.assertEquals("Java Tutorial",Actualtitle);
	}
	
	public String method(String outerkey,String innerkey) throws IOException {
		
		 Yaml y=new Yaml();
		 FileReader reader1=new FileReader("src/test/resources/Assign2/data.yaml");
			 Map<String,Map<String,String>>    obj=y.load(reader1);
		String locator=obj.get(outerkey).get(innerkey);
		
		
		return locator;
	
	}





}
