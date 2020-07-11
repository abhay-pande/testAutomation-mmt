package calculate;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class TestCal {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\ChromeDriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		//Launch a new browser
		driver.get("http://13.90.226.192/lsirsi/");
		
		//Click on clear button 
		driver.findElement(By.xpath("//button[text()='Clear']")).click();
		
		//  Enter pH value
	driver.findElement(By.cssSelector("input[placeholder='Enter Ph..']")).sendKeys("125.5");
	
	// Enter TDS, ppm  value
	driver.findElement(By.cssSelector("input[placeholder='Enter TDS..']")).sendKeys("185.65");
	
	//Enter temp value
	driver.findElement(By.cssSelector("input[formcontrolname=\'temp\']")).sendKeys("36");
	
	//Enter Ca Hardness
	driver.findElement(By.cssSelector("input[formcontrolname=\'ca\']")).sendKeys("45");
	
	//Enter Alkalinity, ppm CaCO3 value
	driver.findElement(By.cssSelector("input[formcontrolname=\'ppm\']")).sendKeys("54");
	
	//due to dropdown issue, select this at end
	Select temp= new Select(driver.findElement(By.name("sellist1")));
	temp.selectByValue("C");
	temp.selectByValue("F");
	
	//wait
Thread.sleep(4000);

//verifying LSI
	String lsi= driver.findElement(By.xpath("(//input[@id=''])[5]")).getAttribute("value");
		Assert.assertEquals("116.52", lsi);
		System.out.println("LSI Value verified, LSI ="+ lsi);
		
		//verifying RSI
		String rsi= driver.findElement(By.xpath("(//input[@id=''])[6]")).getAttribute("value");
		Assert.assertEquals("-107.53", rsi);
		System.out.println("RSI Value verified, RSI ="+ rsi);
		
		//verifying text
		String text= driver.findElement(By.xpath("(//input[@id=''])[7]")).getAttribute("value");
		Assert.assertEquals("Water is Extremely Scaling!", text);
		System.out.println("text is verified. Text=" + text);
		
		//closing driver
		driver.close();
		
		
		
}
}