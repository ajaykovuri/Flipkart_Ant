package test.java.resources;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

public class OpenPositions extends Helper {
//	Properties prop = new Properties();
//	WebDriver driver = new FirefoxDriver();
	
	@BeforeTest
	public void beforeMethod(){
		Reporter.log("entered BeforeTest firefox");
		
		System.out.println(config.getProperty("browserType"));
		if(config.getProperty("browserType").equalsIgnoreCase("Firefox")){
			
			driver = new FirefoxDriver();
		}
		else if(config.getProperty("browserType").equalsIgnoreCase("Chrome")){
			System.out.println("entered BeforeTest chrome");
			System.setProperty("webdriver.chrome.driver", Basedir + "\\src\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(config.getProperty("browserType").equalsIgnoreCase("internetexplorer")){
			System.out.println("entered beforeTest internetexplorer");
			System.setProperty("webdriver.ie.driver", Basedir + "\\src\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}
	@Test
	public void position(){
		System.out.println("entered position");
		//driver.manage().window().maximize();
		driver.get(config.getProperty("appUrl"));
//		driver.findElement(By.cssSelector(OR.getProperty("cart"))).click();
		//h.login(config.getProperty("uname"),config.getProperty("pwd"));
	}
	 
	
//	@Test
//	public void position() throws Exception, Exception{
//		System.out.println("entered test method");
////		String BaseUrl = System.getProperty("user.dir");
////		prop.load(new FileInputStream(BaseUrl + "//src//ConfigFiles//config.properties"));
//		driver.get(config.getProperty("Flipkart_positions_url"));
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.switchTo().frame(OR.getProperty("frameid"));
//		List<WebElement> hire = driver.findElements(By.className(OR.getProperty("classname")));
//		System.out.println(hire.size());
////		Reporter.log("hello");
//		
//		Reporter.log("the list size is "+hire.size());
//		
//}
}