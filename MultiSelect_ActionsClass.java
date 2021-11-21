package week4.day1;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelect_ActionsClass {

	public static void main(String[] args) throws InterruptedException {
		// MultiSelect_ActionsClass
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();

		Thread.sleep(2000);
		
		/*
		 * //Multi select -by click Method driver.findElement(By.
		 * xpath("//option[text()='Select your programs']/following-sibling::option[@value='1']"
		 * )) .click(); driver.findElement(By.
		 * xpath("//option[text()='Select your programs']/following-sibling::option[@value='4']"
		 * )) .click();
		 */
		
		//Multi select -by Actions Class
		WebElement select1 = driver
				.findElement(By.xpath("//option[text()='Select your programs']/following-sibling::option[@value='1']"));
		WebElement select2 = driver
				.findElement(By.xpath("//option[text()='Select your programs']/following-sibling::option[@value='4']"));

		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(select1).click(select2).keyUp(Keys.CONTROL).perform();

	}

}
