package test.java.resources;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

public class TestHelper extends TestBase {
	
	public void callBrowser(){
		if(config.getProperty("browserType").equalsIgnoreCase("firefox"))
			  driver = new FirefoxDriver();
		  else if(config.getProperty("browserType").equalsIgnoreCase("chrome")){
			  System.setProperty("webdriver.chrome.driver", Basedir + "\\src\\exe files\\chromedriver.exe");
			  driver = new ChromeDriver();
		  }	  
		  else if(config.getProperty("browserType").equalsIgnoreCase("explorer")){
			  System.setProperty("webdriver.ie.driver", Basedir + "\\src\\exe files\\IEDriverServer.exe");
			  driver = new InternetExplorerDriver();
		  }
		  else if(config.getProperty("browserType").equalsIgnoreCase("safari"))
			   driver = new SafariDriver();
	     // else driver = new FirefoxDriver();
		
	}
	public void openApp(){
		driver.get(config.getProperty("appUrl"));
	}
  
	public void sleep(int seconds){
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public boolean waitToLoadForElement(int timeout, By by){
			int k=timeout;
			while (timeout>0){
				sleep(1);
			List<WebElement> list = driver.findElements(by);
			  if(list.size()!=0){
				return true;
			  }
			timeout--;
			}
		Reporter.log("Waited for"+k+"minutes but "+by+" not found");	
		  return false;
		}
	 public void  takeScreenshot(String filename){
		  File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  try {
			FileUtils.copyFile(scrfile, new File(Basedir+"\\src\\screenshots\\"+filename+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
}
