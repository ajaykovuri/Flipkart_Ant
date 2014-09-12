package test.java.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	public static WebDriver driver;
	public static Properties config,OR;
	public static FileInputStream f1,f2;
	public static String Basedir = System.getProperty("user.dir");
	public static TestHelper h;
  @BeforeSuite
  public void LoadProperties() throws IOException {
	  config = new Properties();
	  OR = new Properties();
	  
	  f1 = new FileInputStream(Basedir +"\\src\\ConfigFiles\\config.properties");
	  f2 = new FileInputStream(Basedir + "\\src\\ConfigFiles\\OR.properties");
	  config.load(f1);
	  OR.load(f2);
//	  h.callBrowser();
	  
  }
  
}