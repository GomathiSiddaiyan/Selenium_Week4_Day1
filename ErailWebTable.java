package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ErailWebTable {
	public static void main(String[] args) throws InterruptedException {
		
		//Erail website	
		WebDriverManager. chromedriver( ).setup( ) ; 
		ChromeDriver driver = new ChromeDriver(); 
		driver. manage( ) . window( ) . maximize( ) ; 
//		Set the system property and Launch the URL
		driver.get(" https://erail.in/" ) ; 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
//		clear the existing text from station text field
		driver.findElement(By.id("txtStationFrom")).clear();
		Thread.sleep(1000);
//		type "ms"in the from station text field
		driver.findElement(By.id("txtStationFrom")).sendKeys("MS");
		Thread.sleep(1000);
//		tab in the from station text field
		driver.findElement(By.id("txtStationFrom")).sendKeys(Keys.ENTER);
		

//		clear the existing text in the to station text field
		driver.findElement(By.id("txtStationTo")).clear();
		
//		type "mdu" in the to station text field
		driver.findElement(By.id("txtStationTo")).sendKeys("MDU");
		
//		tab in the to station text field
		driver.findElement(By.id("txtStationTo")).sendKeys(Keys.ENTER);

//		Add a java sleep for 2 seconds
		Thread.sleep(2000);
//		Click the 'sort on date' checkbox
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
//		Get the size of list
		List<WebElement> row = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		int listSize= row.size();
		System.out.println("Row Size: "+listSize);
		
//		Store all the train names in a list
		//driver.findElement(By.className("DataTable TrainList TrainListHeader")).click();
	
		List<String> trainNames= new ArrayList<String>();
		System.out.println("Printing Train Names: ");
		for (int i = 1; i < listSize; i++) 
		{
		String text=driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]")).getText();
		trainNames.add(text);
		System.out.print(i+". "+text);
			System.out.println();
		}
		
//		Add the list into a new Set
		Set<String> setTrain= new LinkedHashSet<String>(trainNames);
		
//		Get the size of set
		int setSize= setTrain.size();
//		Compare the Size of list and Set to verify the names are unique
		System.out.println("By comparing list size and set size we can say duplicate values present or not:");
		if(listSize == setSize)
		{
			System.out.println("No duplicate train names");
		}
		else
		{
			System.out.println("Duplicate Train names present");
		}

	}}
