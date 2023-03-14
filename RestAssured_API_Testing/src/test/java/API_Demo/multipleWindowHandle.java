package API_Demo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.Window;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class multipleWindowHandle {

     private WebDriver driver;
     private String baseURL;
     
     
     @BeforeClass
     public void setup() {
    	 
    	 System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver_win32\\chromedriver.exe");
    	 driver= new ChromeDriver();
    	 driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    	 baseURL= "https://chandanachaitanya.github.io/selenium-practice-site/";
    	 	 
     }
     
     @Test
     public void pageTitle() throws Exception {
    	 driver.get(baseURL);
    	 
    	 String parentWindHandle = driver.getWindowHandle();
    	 System.out.println("Parent Window Handle:" +parentWindHandle);
    	 
    	 WebElement newWindowBtn = driver.findElement(By.id("win1"));
    	 newWindowBtn.click();
    	 
    	 Set<String>winHandles = driver.getWindowHandles();
    	 
    	 for(String Handle:winHandles) {
    		 
    		 if(!Handle.equals(parentWindHandle)) {
    			 driver.switchTo().window(Handle);
    			 Thread.sleep(1000);
    			 System.out.println("Title of the new Window:" +driver.getTitle());
    			 System.out.println("Closing the new Window....");
    			 driver.close();
    		 }
    		 
    		 driver.switchTo().window(parentWindHandle);
    		 System.out.println("Parent Window Handle:" + driver.getCurrentUrl());
    	 }
    	 
    	 
    	 
    	 
    	 
    	 
     }
	
}
