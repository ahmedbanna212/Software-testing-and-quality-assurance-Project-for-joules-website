


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class B_PROMO_CODE {
	public static void main(String[] args) throws InterruptedException {
		//You must download chromedriver.exe for ChromeDriver to work properly
		
		    // System Property for Chrome Driver   
	        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ahmed salah\\Documents\\NetBeansProjects\\JOULS_TESTING\\chromedriver.exe");  
	        
	        // Instantiate a ChromeDriver class to establish a connection       
	        WebDriver driver=new ChromeDriver();  
			
			
		
			//Puts an implicit wait, will wait for 10 seconds before throwing exception
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			//Launch Website
			driver.navigate().to("https://www.joules.com");
			
			//Maximize the Browser
			driver.manage().window().maximize();
            //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	    //note !!!!!!!!!!!!!!!!!!!!!!!!! this test case must be excuted after add to cart test cases beacuse one of its preconditions is to have at least one item in tha shop cart
            //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            
            //this click accepts cookies 
            driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
                

            //this click triggers the sign in at top left 
            driver.findElement(By.xpath("//*[@id=\"page\"]/header/div/div/nav/div[1]/ul/li[2]/a")).click();
            driver.findElement(By.xpath("//*[@id=\"page\"]/header/div/div/nav/div[1]/ul/li[2]/a")).click();

            //filling  sign in data
            driver.findElement(By.xpath("//*[@id=\"j_username\"]")).sendKeys("ahmed192277@bue.edu.eg");
            driver.findElement(By.xpath("//*[@id=\"j_password\"]")).sendKeys("test-Cart123");
            driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).click();

            Thread.sleep(2000);

            //clicking the home breadcrumb to return to the homepage
            driver.findElement(By.xpath("//*[@id=\"breadcrumb\"]/div/ul/li[1]/a")).click();

            Thread.sleep(2000);

            //clicking the shopcart icon at top left 
            driver.findElement(By.xpath("//*[@id=\"minicart_price_field\"]")).click();
            
            //filling the promo code input field with "hhbh8136749816"
            driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[3]/div[2]/div[1]/div[1]/div/div/form/div[1]/div/div/input")).sendKeys("hhbh8136749816");

            // submiting the inserted promo code
            driver.findElement(By.xpath("//*[@id=\"voucher.apply\"]/div[1]/span/button")).submit();

            //the if condition checks if the alert message has ben displayed 
            if(driver.findElement(By.xpath("//*[@id=\"page\"]/div[5]/div[1]/div")).isDisplayed()==true){

                System.out.println("error message detected");
                //fetching the alert message content
                String confirm=driver.findElement(By.xpath("//*[@id=\"page\"]/div[5]/div[1]/div/span[2]")).getText();

                //the if condition checks if informs the user that the inserted code is invalid 
                if(confirm.equals("The offer code which you have entered has not been recognised, please check that you have entered it correctly")){

                    System.out.println("incorrect Code confirmed");
                    }
                }
    driver.close();
    driver.quit();
    }
}



       