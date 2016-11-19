package com.eastway.htmlunit;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class Automatic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
					try {
				HtmlUnitDriver myDriver = null;
				WebElement accountlink, loginemail, password, submitbutton, postingTitle, street, location, price, postingBody, city, zip, contact, emailAddress, emailAddressConfirm;

				
				myDriver = new HtmlUnitDriver();
				myDriver.get("http://www.eastbay.com/");
				
				//Create new Account URL : https://www.eastbay.com/account/default.cfm?action=accountCreate
			//	myDriver.manage().window().maximize();
				/*myDriver.manage().timeouts()
						.implicitlyWait(5, TimeUnit.SECONDS);*/

				//Thread.sleep(10000);
				/*myDriver.findElement(By.("header_account_link"))
						.click();*/
				List<WebElement> linkList=myDriver.findElements(By.tagName("a"));

				//now traverse over the list and check
				 System.out.println("Page title is: " + myDriver.getTitle());	
				linkList.get(8).click();
			
								
				loginemail = myDriver.findElement(By.id("login_email"));
				loginemail.sendKeys("amitkumarsharma4210@gmail.com");
				
				password = myDriver.findElement(By.id("login_password"));
				password.sendKeys("sharma123");
				/*myDriver.findElement(By.cssSelector("input[value='fso']"))
						.click();*/ 						
				submitbutton = myDriver.findElement(By.id("login_submit"));		
				submitbutton.click();
				
				Thread.sleep(3000);
				for (String handle : myDriver.getWindowHandles()) {
					myDriver.switchTo().window(handle);

				}

				myDriver.navigate().to("http://www.eastbay.com/product/model:260700/sku:31508002/nike-free-rn-mens/black/grey/");
				
				 System.out.println("Page title is: " + myDriver.getTitle());	
				/*myDriver.manage().timeouts()
						.implicitlyWait(1, TimeUnit.SECONDS);*/

				myDriver.findElement(By.id("current_size_display")).click();
			    myDriver.manage().timeouts()
				.implicitlyWait(1, TimeUnit.SECONDS);
				
				//myDriver.findElement(ByLinkText.linkText("13.0")).click();
				myDriver.findElement(By.id("pdp_addtocart_button")).click();	
				myDriver.findElement(By.id("header_cart_link")).click();
				Thread.sleep(2000);
				 try{
				WebElement element =  myDriver.findElement(By.id("attention_continue"));
				element.click();
				 }catch(Exception e){
					 e.printStackTrace();
				 }
				
				myDriver.findElement(By.id("cart_checkout_button")).click();
				for (String handle : myDriver.getWindowHandles()) {
					myDriver.switchTo().window(handle);

				}
				try{
				myDriver.findElement(By.id("billPaneContinue")).click();
				}catch(Exception e){
					e.printStackTrace();
				}
				try{
				myDriver.findElement(By.id("billAddress1")).sendKeys("350 5th Ave");
				myDriver.findElement(By.id("billPostalCode")).sendKeys("10118");
				myDriver.findElement(By.id("billCity")).sendKeys("New York");
				Select dropdown = new Select(myDriver.findElement(By.id("billState")));
				dropdown.selectByIndex(40);
				myDriver.findElement(By.id("billHomePhone")).sendKeys("212-736-3100");
				myDriver.findElement(By.id("shipPaneContinue")).click();	
				myDriver.findElement(By.id("shipMethodPaneContinue")).click();
				}catch(Exception e){
					e.printStackTrace();
				}
				Select creditcard = new Select(myDriver.findElement(By.id("payMethodPanestoredCCCardNumber")));
				creditcard.selectByIndex(0);
				myDriver.findElement(By.id("CardNumber")).sendKeys("4672123456789907");
				myDriver.findElement(By.id("CardExpireDateMM")).sendKeys("06");
				myDriver.findElement(By.id("CardExpireDateYY")).sendKeys("12");
				myDriver.findElement(By.id("CardExpireDateYY")).sendKeys("12");
				myDriver.findElement(By.id("CardCCV")).sendKeys("456");
				
				myDriver.findElement(By.id("payMethodPaneContinue")).click();
				
				/*JavascriptExecutor jse = (JavascriptExecutor) myDriver;
				try {
					jse.executeScript("document.getElementsByName('id')[24].setAttribute('checked', 'true');");
				} catch (Exception e) {
					Utility.logException(e.getMessage(), e);
				}

				myDriver.findElement(By.className("pickbutton")).click();

				for (String handle : myDriver.getWindowHandles()) {
					myDriver.switchTo().window(handle);
				}
				Thread.sleep(2000);
				myDriver.findElement(By.cssSelector("input[value='1']"))
						.click();

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					Utility.logException(e.getMessage(), e);
				}

				try {
					jse.executeScript("document.getElementsByName('n')[24].setAttribute('checked', 'true');");
				} catch (Exception e) {
					Utility.logException(e.getMessage(), e);
				}

				Thread.sleep(3000);
				myDriver.findElement(By.className("pickbutton")).click();

				emailAddress = myDriver.findElement(By.id("FromEMail"));
				emailAddress.sendKeys(userData.getEmail());

				emailAddressConfirm = myDriver.findElement(By
						.id("ConfirmEMail"));
				emailAddressConfirm.sendKeys(userData.getEmail());
				myDriver.findElement(By.id("A")).click();
				myDriver.findElement(By.id("contact_phone_ok")).click();

				contact = myDriver.findElement(By.id("contact_phone"));
				contact.sendKeys(userData.getContact());

				postingTitle = myDriver.findElement(By.id("PostingTitle"));
				postingTitle.sendKeys(userData.getPostingTitle());

				price = myDriver.findElement(By.id("Ask"));
				price.sendKeys(userData.getPrice());

				location = myDriver.findElement(By.id("GeographicArea"));
				location.sendKeys(userData.getLocation());

				zip = myDriver.findElement(By.id("postal_code"));
				zip.sendKeys(userData.getZip());

				postingBody = myDriver.findElement(By.id("PostingBody"));
				postingBody.sendKeys(userData.getPostingDesc());

				for (String handle : myDriver.getWindowHandles()) {
					myDriver.switchTo().window(handle);
					// driver.switchTo().alert().accept();
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					Utility.logException(e.getMessage(), e);
				}
				Select conditionDropdown = new Select(myDriver.findElement(By
						.id("condition")));
				conditionDropdown.selectByIndex(1);
				myDriver.findElement(By.id("see_my_other")).click();

				try {
					jse.executeScript("document.getElementsById('mapinfo')[0].setAttribute('class', 'row fields js-only');");
				} catch (Exception e) {
					Utility.logException(e.getMessage(), e);
				}
				Thread.sleep(2000);
				List<WebElement> list = myDriver.findElements(By
						.className("nreq"));

				list.get(0).sendKeys(userData.getAddress());
				;

				street = myDriver.findElement(By.id("xstreet0"));

				street.sendKeys(userData.getAddress());

				city = myDriver.findElement(By.id("city"));
				city.sendKeys(userData.getCity());
				myDriver.findElement(By.id("oc")).click();

				Thread.sleep(5000);
				myDriver.findElement(By.className("bigbutton")).click();
				for (String handle : myDriver.getWindowHandles()) {
					myDriver.switchTo().window(handle);

				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					Utility.logException(e.getMessage(), e);
				}

				Thread.sleep(5000);

				myDriver.findElement(By.className("bigbutton")).click();
				for (String handle : myDriver.getWindowHandles()) {
					myDriver.switchTo().window(handle);
					// driver.switchTo().alert().accept();
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					Utility.logException(e.getMessage(), e);
				}

				// image uploading by skikuli
				// UploadImage uploadThreadImg = new
				// UploadImage(args[1]+File.separator+userData.getAttachemntFileName());
				// uploadThreadImg.start();

				AutoitScript autoitUpload = new AutoitScript(myDriver, args[1]
						+ File.separator + userData.getAttachemntFileName());
				autoitUpload.start();
				synchronized (autoitUpload) {
					try {
						logger.info("waiting for image upload");
						autoitUpload.wait();

					} catch (Exception e) {

						Utility.logException(e.getMessage(), e);
					}
				}

				myDriver.findElement(By.className("bigbutton")).click();
				Thread.sleep(Long.parseLong(Utility.getProperty("finalSubmitDelay")));
				myDriver.findElement(By.className("button")).click();
				logger.info("Ads posted successfully : "+id);
				System.out.println("Ads posted successfully : "+id);
				data.put("" + id, new Object[] { id,
						userData.getPostingTitle(), userData.getPrice(),
						Utility.getProperty("SUCCESS") });

			}

			
			 * catch (NoSuchElementException e) {
			 * 
			 * // if wrong capcha is filled ! data.put("" + id, new Object[] {
			 * id, userData.getPostingTitle(), userData.getPrice(),
			 * Constant.FAIL }); Utility.logException(e.getMessage(), e); }
			 catch (Exception e) {

				data.put("" + id, new Object[] { id,
						userData.getPostingTitle(), userData.getPrice(),
						Utility.getProperty("FAIL") });
				Utility.logException(e.getMessage(), e);
				logger.info("Ads posted failed : "+id);
				System.out.println("Ads posted failed : "+id);
			} finally {
				if (myDriver != null) {
					myDriver.close();

				}
			}
			id++;

			// myDriver.quit();

		}
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}
		try {
			SheetConditionalFormatting sheetCF = sheet
					.getSheetConditionalFormatting();
			ConditionalFormattingRule rule = sheetCF
					.createConditionalFormattingRule(ComparisonOperator.EQUAL,
							"\"FAIL\"");
			PatternFormatting fill = rule.createPatternFormatting();
			fill.setFillBackgroundColor(IndexedColors.RED.index);
			fill.setFillPattern(PatternFormatting.SOLID_FOREGROUND);

			CellRangeAddress[] regions = { CellRangeAddress.valueOf("A1:Z100") };

			sheetCF.addConditionalFormatting(regions, rule);
			FileOutputStream out = new FileOutputStream("."
					+ File.separator
					+ Utility.getProperty("OUTPUT_FILENAME")
					+ new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(
							new Date()).toString() + Utility.getProperty("OUTPUT_FILEEXT"));
			workbook.write(out);
			out.close();
			logger.info("xlsx written successfully on disk.");
			JOptionPane.showMessageDialog(null, " Cheers! Process Competed.");*/
		} catch (Exception e) {
			//Utility.logException(e.getMessage(), e);
			e.printStackTrace();
		}

	}
		
		
		


}

