


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
public class A_add_to_cart{

	public static void main(String[] args) throws InterruptedException {

		//You must download chromedriver.exe for ChromeDriver to work properly
		
		    // System Property for Chrome Driver   
	        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ahmed salah\\Documents\\NetBeansProjects\\JOULS_TESTING\\chromedriver.exe");  
	          
	        // Instantiate a ChromeDriver class to establish a connection       
	        WebDriver driver=new ChromeDriver();  
			
			
		
			//Puts an implicit wait, will wait for 10 seconds before throwing exception
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			//opens jouls
			driver.navigate().to("https://www.joules.com");
			
			
			driver.manage().window().maximize();
			
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
            //clicking the men section from the mega nav-bar
            
            WebElement x= driver.findElement(By.xpath("//*[@id=\"mega-nav\"]/ul/li[3]/a"));
            Actions action = new Actions(driver);
            action.moveToElement(x).perform();
            //clicking  the Polo Shirts  categorie
	    driver.findElement(By.xpath("//*[@id=\"mega-nav\"]/ul/li[3]/ul/div/div[1]/div/div[2]/li/ul/li[7]/a")).click();

            //scrolling down about 20 pixles 
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("window.scrollBy(0,1200)");

            //clicking the desired item which is Woody Slim Fit Polo Shirt 
			driver.findElement(By.xpath("//*[@id=\"new-product-grid\"]/section[1]/article[1]/div[2]/section/a/div/img[1]")).click();
			
            //saving the DOM element as a drop down datatype
			WebElement dropdown= driver.findElement(By.xpath("//*[@id=\"size\"]"));
			Select sizeMenu= new Select(dropdown);
            //selecting T-shirt size "xl"
			sizeMenu.selectByValue("XL");


            //the if condition checks if the desired size is selected and if not it will print " test failed "
            if(driver.findElement(By.xpath("//*[@id=\"size\"]/option[5]")).isSelected()){
                //clicks on add to bag to add it to the cart 
                driver.findElement(By.xpath("//*[@id=\"product-variant-selectors\"]/div[3]/button")).click();
                Thread.sleep(2000);

                //the if condition checks if the adding confirmation message appeared or not
                if(driver.findElement(By.xpath("//*[@id=\"component-product-page\"]/div[2]/div/div/ul/li[2]/a")).isDisplayed()){
                    //clicks on "go to cart"
                    driver.findElement(By.xpath("//*[@id=\"component-product-page\"]/div[2]/div/div/ul/li[2]/a")).click();
                }
                 //the if condition checks if the item is displayed on the cart or not 
                if(driver.findElement(By.xpath("//*[@id=\"page\"]/div[6]/div[3]/div[1]/div[2]/div[3]")).isDisplayed()==true){

                    
                    //fetching the T-shirt size
                    String T_size = driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[3]/div[1]/div[2]/div[3]/div[2]/div/div[1]/div[2]/span[2]")).getText();
                    //fetching the T-shirt color
                    String T_color = driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[3]/div[1]/div[2]/div[3]/div[2]/div/div[1]/div[3]/span[2]")).getText();
                    //fetching the T-shirt quantity 
                    String T_quantity = driver.findElement(By.xpath("//*[@id=\"quantity0\"]")).getAttribute("value");

                     //the if condition checks if the added T-shirt size is correct
                    if(T_size.equals("XL")){
                        System.out.println("Correct size!");
                    }
                    else{
                        System.out.println("not Correct size!");
                    }

                    //the if condition checks if the added T-shirt color is correct
                    if(T_color.equals("DEEP RASPBERRY")){
                        System.out.println("Correct color!");
                    }
                    else{
                        System.out.println("not Correct color!");
                    }
                    //the if condition checks if the added T-shirt quantity is correct
                    if(T_quantity.equals("1")){
                        System.out.println("Correct quantity!");
                    }
                    else{
                        System.out.println("inCorrect quantity!");
                    }
                    
                }
        }else{
            System.out.println("test failed!");
        }
    driver.close();
    driver.quit();
    }
}



       