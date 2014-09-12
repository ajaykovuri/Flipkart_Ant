package test.java.resources;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestScript extends TestHelper{
  @Test
  public void Register() {
	  callBrowser();
	  openApp();
	 // waitToLoadForElement(1, By.className("logo-img retina-img"));
	  driver.findElement(By.className("signup-link")).click();
	 // driver.findElement(By.id("fk-top-search-box")).sendKeys("hi");
  }
}