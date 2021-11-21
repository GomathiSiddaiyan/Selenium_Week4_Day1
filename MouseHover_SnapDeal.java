package week4.day1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class MouseHover_SnapDeal {

	public static void main(String[] args) throws InterruptedException {
		// MouseHover_SnapDeal
//		1. Load https://www.snapdeal.com/
//			2. Mouse hover on Men's Fashion and Click Shirts
//			3. Mouse hover on the first product and Click on Quick View
//			4. Close all the browsers
		//Launch Chrome Driver
		WebDriverManager.chromedriver().setup();
		
		//To avoid alerts in page
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--disable-notification");
		ChromeDriver driver= new ChromeDriver(option);
		
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
//		2. Mouse hover on Men's Fashion and Click Shirts	
		WebElement mouseHoverMen = driver.findElement(By.xpath("//li[@class='navlink lnHeight']//span[1]"));
		Actions builder= new Actions(driver);
		builder.moveToElement(mouseHoverMen).perform();
		//Thread.sleep(500);
//		3. Mouse hover on the first product and Click on Quick View
		driver.findElement(By.xpath("//span[text()='Clothing']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='clearfix row-disc'])[1]")).click();
//		4. Close all the browsers
	}}
