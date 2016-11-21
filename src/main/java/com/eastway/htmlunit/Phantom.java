package com.eastway.htmlunit;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.Select;

public class Phantom {

	public static void main(String[] args) {
		
		File file = new File("D:/others/phantomjs.exe");				
        System.setProperty("phantomjs.binary.path", file.getAbsolutePath());		
        WebDriver driver = new PhantomJSDriver();	
        driver.get("http://www.eastbay.com/");
		System.out.println("Page title is: " + driver.getTitle());	
		driver.findElement(By.id("header_account_link")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		try{
		driver.findElement(By.id("login_email")).sendKeys("XXXXXXXXX");
		driver.findElement(By.id("login_password")).sendKeys("XXXXX");
			
		driver.findElement(By.id("login_submit")).click();
		Thread.sleep(3000);
		System.out.println("user name "+driver.findElement(By.id("nav_account_username")).getText());
		driver.navigate().to("http://www.eastbay.com/product/model:260700/sku:31508002/nike-free-rn-mens/black/grey/");
		
		 System.out.println("Page title is: " + driver.getTitle());	
		 driver.findElement(By.id("current_size_display")).click();
		    driver.manage().timeouts()
			.implicitlyWait(1, TimeUnit.SECONDS);
			
			driver.findElement(By.linkText("13.0")).click();
			driver.findElement(By.id("pdp_addtocart_button")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("header_cart_link")).click();
			Thread.sleep(2000);
			 System.out.println("Page title is: " + driver.getTitle());	
			 System.out.println("item in cart " + driver.findElement(By.id("cart_quantity")).getText());
			Thread.sleep(2000);
			 try{
			WebElement element =  driver.findElement(By.id("attention_continue"));
			element.click();
			 }catch(Exception e){
				// e.printStackTrace();
			 }
			
			driver.findElement(By.id("cart_checkout_button")).click();
			for (String handle : driver.getWindowHandles()) {
				driver.switchTo().window(handle);

			}
			try{
			driver.findElement(By.id("billPaneContinue")).click();
			}catch(Exception e){
				//e.printStackTrace();
			}
			try{
				Thread.sleep(2000);
				driver.findElement(By.id("billPaneEdit")).click();
			}catch(Exception e){
				
			}
			Thread.sleep(2000);
			driver.findElement(By.id("billAddress1")).sendKeys("350 5th Ave");
			driver.findElement(By.id("billPostalCode")).sendKeys("10118");
			driver.findElement(By.id("billCity")).sendKeys("New York");
			Select dropdown = new Select(driver.findElement(By.id("billState")));
			dropdown.selectByIndex(40);
			driver.findElement(By.id("billHomePhone")).sendKeys("212-736-3100");
			try{
				driver.findElement(By.id("shipPaneEdit")).click();
			}catch(Exception e){
				
			}
			Thread.sleep(1000);
			driver.findElement(By.id("shipPaneContinue")).click();	
			driver.findElement(By.id("shipMethodPaneContinue")).click();
			Select creditcard = new Select(driver.findElement(By.id("payMethodPanestoredCCCardNumber")));
			creditcard.selectByIndex(0);
			 System.out.println("Page title is: " + driver.getTitle());	
			driver.findElement(By.id("CardNumber")).sendKeys("4672123456789907");
			driver.findElement(By.id("CardExpireDateMM")).sendKeys("06");
			driver.findElement(By.id("CardExpireDateYY")).sendKeys("12");
			driver.findElement(By.id("CardExpireDateYY")).sendKeys("12");
			driver.findElement(By.id("CardCCV")).sendKeys("456");
			driver.quit();
			driver.findElement(By.id("payMethodPaneContinue")).click();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
