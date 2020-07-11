package flightSearch;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\ChromeDriver\\chromedriver.exe");
		
		//Launch a new browser.
		WebDriver driver= new ChromeDriver();
		
		//Open URL "https://www.makemytrip.com/"
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//closing login popup
	driver.findElement(By.cssSelector("div[data-cy='outsideModal']")).click();
		
		
		//Check "Round Trip" radio button
		driver.findElement(By.xpath("//li[contains(text(),'Round Trip')]")).click();
		
		//Select "Pune"  from the dropdown list
		
		driver.findElement(By.xpath("//span[contains(text(),'From')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'PNQ')]")).click();
		
		//Select "Kolkata" from the dropdown
		driver.findElement(By.xpath("//span[contains(text(),'To')]")).click();
		driver.findElement(By.xpath("//p[contains(text(),'Kolkata, India')]")).click();
		
		//Select Departure date " 16 Aug 2020"
		driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]")).click();
		driver.findElement(By.cssSelector("div[aria-label='Sun Aug 16 2020']")).click();
		
		//Select return date "19 Aug 2020"
		driver.findElement(By.cssSelector("div[aria-label='Wed Aug 19 2020']")).click();
		
		// Select in traveler and class is an adult is "2" and children is "1" and infant "0" and "Premium Economy" and click apply
		driver.findElement(By.xpath("//span[contains(text(),'Travellers & CLASS')]")).click();
		driver.findElement(By.cssSelector("li[data-cy=\'adults-2\']")).click();
		driver.findElement(By.cssSelector("li[data-cy=\'children-1\']")).click();
		driver.findElement(By.cssSelector("li[data-cy=\'infants-0\']")).click();
		driver.findElement(By.cssSelector("li[data-cy=\'travelClass-1\']")).click();
		driver.findElement(By.cssSelector("button[data-cy=\'travellerApplyBtn\']")).click();
		
		//Click on the Search button
		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
		Thread.sleep(5000);
		//To verify text is " Flights from Pune to Kolkata, and back"
		String headerText= driver.findElement(By.xpath("//p[contains(string(), 'Flights from ')]")).getText();
	
		Assert.assertEquals("Flights from Pune to Kolkata, and back",headerText);
		System.out.println("Header Text verified, text is:"+ headerText);
		
		//closing driver
		driver.close();
		
		
	}

}
