package test.java.resources;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import org.testng.Reporter;

public class Helper extends flipkart_HomePage {

	public WebDriver driver;
	public boolean login(String uname, String pwd){
		if(driver.findElements(By.cssSelector("a.no-border")).size()>0){
			return true;
		}
		
		//List<WebElement> logins = driver.findElements(By.cssSelector("a.no-border.js-login.login-required"));
		driver.findElement(By.cssSelector("a.no-border.js-login.login-required")).click();
		driver.findElement(By.id("login_email_id")).sendKeys(uname);
		driver.findElement(By.id("login_password")).sendKeys(pwd);
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
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
