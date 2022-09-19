package banna;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class increment_item {
	public WebDriver driver; 
  @Test
  public void f() {
	  
	  
	  driver.findElement(By.xpath("//*[@id=\"minicart_price_field\"]")).click();

      //fetching the old quantity value before the change
      String old_quantrity=driver.findElement(By.xpath("//*[@id=\"quantity0\"]")).getAttribute("value");
      
      //pressing the "+"" button to increment the item quantity
      driver.findElement(By.xpath("//*[@id=\"updateCartForm0\"]/input[6]")).click();

      //fetching the new quantity value after the change
      String new_quantrity=driver.findElement(By.xpath("//*[@id=\"quantity0\"]")).getAttribute("value");
      
      //the if condition checks if the alert message has ben displayed 
      if(driver.findElement(By.xpath("//*[@id=\"page\"]/div[5]/div[2]/div")).isDisplayed()==true){

          //insures that the old quantity do not equal the new quantity
          if(!(new_quantrity.equals(old_quantrity))){

              System.out.println("the quantity of the item got increased");
              System.out.println("new quantity "+new_quantrity);
              System.out.println("old quantity "+old_quantrity);
              }

              //fetching the confirmation message 
          String confirm=driver.findElement(By.xpath("//*[@id=\"page\"]/div[5]/div[2]/div/span[2]")).getText();
              
          if(confirm.equals("Product quantity has been updated.")){
              
              System.out.println("update confirmation message got displayed");
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
