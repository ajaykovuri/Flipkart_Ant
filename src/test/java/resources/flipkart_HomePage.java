package test.java.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class flipkart_HomePage {
  
	public static WebDriver driver;
	public static Properties config = null;
	public static Properties OR = null;
	public String Basedir = System.getProperty("user.dir");
	//public Helper h = new Helper();
  @BeforeSuite
  public void initialize() throws IOException{
	//Testing Git Hub
  System.out.println("entered Beforesuite");
  
  config = new Properties();
  OR = new Properties();
  FileInputStream fp = new FileInputStream(Basedir + "\\src\\ConfigFiles\\config.properties");
  config.load(fp);
  FileInputStream fp1 = new FileInputStream(Basedir + "\\src\\ConfigFiles\\OR.properties");
  OR.load(fp1);
  System.out.println("choosing the browser "+ config.getProperty("browserType"));
  //driver.get(config.getProperty("testUrl"));
  }
  
  @Test
  public void browse_flipkart(){
	  System.out.println("entered test method");
	driver.get(config.getProperty("testUrl"));
//	driver.findElement(By.cssSelector(OR.getProperty("cart"))).click();
	  
  }
	
}
