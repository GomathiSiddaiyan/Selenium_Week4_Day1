package week4.day1;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Myntra_ActionsClass {
	public static void main(String[] args) throws InterruptedException {
		//Myntra_ActionsClass
//		1) Open https://www.myntra.com/
//			2) Mouse hover on MeN 
//			3) Click Jackets 
//			4) Find the total count of item 
//			5) Validate the sum of categories count matches
//			6) Check jackets
//			7) Click + More option under BRAND
//			8) Type Duke and click checkbox
//			9) Close the pop-up x
//			10) Confirm all the Coats are of brand Duke
//			    Hint : use List 
//			11) Sort by Better Discount
//			12) Find the price of first displayed item
//			 13) Click on the first product	
//			14) Click on WishList Now
//			14) Close Browser(driver.close())

		
//		1) Open https://www.myntra.com/
WebDriverManager.chromedriver().setup();
		
		//To avoid alerts in page
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--disable-notification");
		ChromeDriver driver= new ChromeDriver(option);
		
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
//		2) Mouse hover on MeN 
		WebElement menMouseHover = driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Men']"));
		Actions builder= new Actions(driver);
		builder.moveToElement(menMouseHover).perform();
		
//		3) Click Jackets 
		driver.findElement(By.xpath("(//ul[@class='desktop-navBlock']//a[text()='Jackets'])[1]")).click();
		
//		4) Find the total count of item 
		String totalItem = driver.findElement(By.className("title-count")).getText();
		System.out.println("Total count of item: "+totalItem);
		
//		5) Validate the sum of categories count matches
		String ValidateSum = driver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::span)[1]")).getText();
		System.out.println("Validate the sum of categories count matches to total count item"+ ValidateSum);
		if(totalItem==(ValidateSum))
		{
			System.out.println("Equal count");
		}
		else
		{
			System.out.println("Not equal count");
		}
		
//		6) Check jackets
		driver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::div)[1]")).click();
		
//		7) Click + More option under BRAND
		driver.findElement(By.className("brand-more")).click();
		
//		8) Type Duke and click checkbox
		driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("Duke");
		driver.findElement(By.xpath("(//span[@class='FilterDirectory-count'])[1]/following-sibling::div")).click();
		Thread.sleep(2000);
//		9) Close the pop-up x
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		
//		10) Confirm all the Coats are of brand Duke
//		    Hint : use List 
		List<WebElement> brand = driver.findElements(By.xpath("//div[@class='product-productMetaInfo']/h3[text()='Duke']"));
		boolean brandChk = brand.contains("Duke");
		if(brandChk==true)
		{
			System.out.println("Same Brand Name"+brandChk);
		}
		else
		{
			System.out.println("Having different brand names");
		}
//		11) Sort by Better Discount
		String sortByText = driver.findElement(By.xpath("//label[@class='sort-label ']/input[@value='discount']")).getText();
		System.out.println("The sort by dropdown: "+sortByText );
		
//		12) Find the price of first displayed item
		String discountPrice = driver.findElement(By.xpath("(//div[@class='product-price']//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println("The Price of the first product: "+ discountPrice);
		
//		 13) Click on the first product	
		driver.findElement(By.xpath("(//div[@class='product-price']//span[@class='product-discountedPrice'])[1]")).click();
		Thread.sleep(2000);
//		14) Click on WishList Now
//		driver.findElement(By.xpath("//div[@id='sizeButtonsContainer']//following::span[text()='WISHLIST']")).click();
		driver.findElement(By.xpath("//a[@class='desktop-wishlist']/span[text()='Wishlist']")).click();
//		WebElement WishListMouseHover = driver.findElement(By.xpath("(//div[@class='product-actions ']//span[text()='wishlist'])[1]"));
//		builder.moveToElement(WishListMouseHover).click().perform();
		
		
//		14) Close Browser(driver.close())
		driver.close();
		
		
		
	}

}
