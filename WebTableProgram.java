package week4.day1;
//import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.bouncycastle.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableProgram {

	public static void main(String[] args) {
		// WebTable -LeafGround web site

//		1)Get the count of number of rows and columns
//		2)Get the Progress value of 'Learn to Interact with elements
//		3)Check the vital task for the least completed progress

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/table.html");

//		1)Get the count of number of rows and columns
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		int rowSize = rows.size();
		System.out.println("The Total Number of Rows in webTable: " + rowSize);
		for (int i = 2; i <= rowSize; i++) {
			List<WebElement> tds = driver.findElements(By.xpath("//table[@id='table_id']//tr[" + i + "]/td"));
			int tdSize = tds.size(); // number of td from 2nd row -> 6
			for (int j = 1; j <= tdSize; j++) {
				// i = 2 ; j = 1
//				String text = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td["+j+"]")).getText();
//				System.out.println(text);
			}
			System.out.println("The Number of columns in row " + i + " of webTable: " + tdSize);
		}

//		2)Get the Progress value of 'Learn to Interact with elements
		String progress = driver.findElement(By.xpath("//table[@id='table_id']//tr[3]//td[2]")).getText();
		System.out.println("The Progress value of 'Learn to Interact with elements: "+progress);
		
//		3)Check the vital task for the least completed progress
		System.out.println("Selected the checkbox which have least Completed progress:");
		driver.findElement(By.xpath("//td[text()='Learn to interact using Keyboard, Actions']/following::input[@type='checkbox']")).click();
	
//		List<String> text= new LinkedList<String>();
//		for (int i = 2; i <=rowSize; i++) {
//			String vitalValue=driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]//td[2]")).getText();
//			text.add(vitalValue);
//			System.out.println(vitalValue);
//		}
//		String replace= text.replace('%',' ');
//		System.out.println(text);
//		
		
	}

}
