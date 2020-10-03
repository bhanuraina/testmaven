package Demo;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class firstest {

	WebDriver dri;
	@Test(dataProvider = "dp")
	public void testcase1(String n , String s) throws InterruptedException
	{
		dri.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys(n);
		dri.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(s);
		dri.findElement(By.xpath("//*[@id='btnLogin']")).click();
		Thread.sleep(3000);
		dri.findElement(By.xpath("//*[@id='welcome']")).click();
		Thread.sleep(200);
		dri.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
		Thread.sleep(200);
	}
	
	@DataProvider
	public Object[][] dp()	{
		return new 	Object[][] {
			new Object[][] { "Admin", "admin123" },
			new Object[][] { "lina.anderson", "linda.anderson" },
		};
	}
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Acer\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver dri = new ChromeDriver();
		dri.manage().window().maximize();
		dri.get("https://opensource-demo.orangehrmlive.com/");
		dri.manage().window().maximize();
	}
	@AfterTest
	public void afterTest()throws InterruptedException
	{
		Thread.sleep(5000);
		dri.close();
	}
}
