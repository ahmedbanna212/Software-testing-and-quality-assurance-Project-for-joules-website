package banna;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Remove_item {
	public WebDriver driver; 
  @Test
  public void f() {
	  driver.findElement(By.xpath("//*[@id=\"minicart_price_field\"]")).click();
	  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      //insures that there is an item in the cart "so it can be removed "
	 // if(driver.findElement(By.xpath("//*[@id=\"page\"]/div[5]/div[2]/div")).isDisplayed()==true){
          //System.out.println("item found");
          //clicks on the remove button
          try {
  			Thread.sleep(3000);
  		} catch (InterruptedException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
          driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[3]/div[1]/div[2]/div[3]/div[2]/div/div[2]/a")).click();
          
      //}
      
       //the if condition checks if the alert message has ben displayed
      if(driver.findElement(By.xpath("//*[@id=\"page\"]/div[5]/div[2]/div")).isDisplayed()==true){
          //fetching the alert message content
          String confirm=driver.findElement(By.xpath("//*[@id=\"page\"]/div[5]/div[2]/div/span[2]")).getText();

          //the if condition checks if the message informs the user that the item has been removed 
          if(confirm.equals("Product has been removed from your cart.")){
              System.out.println("item removed");
          }
	  
      }
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","F:\\ChromeDriver\\chromedriver.exe");  
  driver = new ChromeDriver();

	// to not accept cookies 
       //Puts an implicit wait, will wait for 10 seconds before throwing exception
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Launch Website
      driver.navigate().to("https://www.joules.com/");


	//Maximize the Browser
	driver.manage().window().maximize();
	        // to not accept cookies 
	driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
	

   //this click triggers the sign in at top left 
	driver.findElement(By.xpath("//*[@id=\"page\"]/header/div/div/nav/div[1]/ul/li[2]/a")).click();
   driver.findElement(By.xpath("//*[@id=\"page\"]/header/div/div/nav/div[1]/ul/li[2]/a")).click();

   //filling  sign in data
   driver.findElement(By.xpath("//*[@id=\"j_username\"]")).sendKeys("ahmed192277@bue.edu.eg");
   driver.findElement(By.xpath("//*[@id=\"j_password\"]")).sendKeys("test-Cart123");
   driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).click();

   try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

   //clicking the home breadcrumb to return to the homepage
	driver.findElement(By.xpath("//*[@id=\"breadcrumb\"]/div/ul/li[1]/a")).click();
  }

  @AfterMethod
  public void afterMethod() {
	 driver.close();
	 driver.quit();
  }

}
