package com.leonardo.pages;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.thread.IFutureResult;
import org.openqa.selenium.support.ui.Select;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import com.leonardo.init.Common;
import com.leonardo.pages.abstractpage.AbstractPage;
import com.relevantcodes.extentreports.LogStatus;

public class Leonardo_mainpage extends AbstractPage {

	Common common = new Common(driver);
	private JavascriptExecutor jse;

	public Leonardo_mainpage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	// Login with valid details
	public void Login_with_valid_Details() {
		test = extent.startTest("passTest");

		System.out.println("Step :: Enter the Valid Email");
		common.log("Step :: Enter the Valid Email");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sagar@testscenario.com");

		System.out.println("Step :: Enter the Valid Password");
		common.log("Step :: Enter the Valid Password");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345678a");

		System.out.println("Step :: Click on I agree terms and conditions check-box");
		common.log("Steps:: Click on I agree terms and conditions check-box");
		common.log("Step :: Enter the Valid Password");
		driver.findElement(By.xpath("//div[@class='wrapper-inline inline']//div[2]//span[1]//div[1]//icon")).click();

		System.out.println("Step :: Click on Sign in button");
		common.log("Step :: Click on Sign in button");
		driver.findElement(By.xpath("//button[@class='btn ng-binding ng-isolate-scope']")).click();
		common.pause(70);
		WebElement logo = driver.findElement(By.xpath("//a[@class='logo ng-binding ng-isolate-scope']"));

		if (logo.isDisplayed()) {

			System.out.println("Step :: Login succesfully , Leonardo logo is displaying");
			common.log("Step :: Login succesfully , Leonardo logo is displaying");
		} else {

			System.out.println("Step :: Login failed , Leonardo logo is not displaying");
			common.log("Step :: Login failed , Leonardo logo is not  displaying");
		}
	}

	// Login with invalid Data
	public void Login_with_invalid_data() {
		System.out.println("Step :: Enter the invalid Email");
		common.log("Step :: Enter the invalid Email");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ttt");

		System.out.println("Step :: Enter the invalid Password");
		common.log("Step :: Enter the invalid Password");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123");

		System.out.println("Step :: Click on Sign in button");
		common.log("Step :: Click on Sign in button");
		driver.findElement(By.xpath("//button[@class='btn ng-binding ng-isolate-scope']")).click();
		common.pause(20);
		String emailval = driver.findElement(By.xpath("//p[@class='error ng-scope ng-binding']")).getText();
		System.out.println("Step :: Email Validation >> " + emailval);
		common.log("Step :: Email Validaiton >>" + emailval);

		common.pause(10);

		System.out.println("Step :: Clear Email field");
		common.log("Step :: Clear Email field");
		driver.findElement(By.xpath("//input[@type='email']")).clear();

		System.out.println("Step :: Enter the Valid Email");
		common.log("Step :: Enter the Valid Email");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sagar@testscenario.com");

		System.out.println("Step :: Clear the Password field");
		common.log("Step :: Clear the Password field");
		driver.findElement(By.xpath("//input[@type='password']")).clear();

		System.out.println("Step :: Enter the invalid Password");
		common.log("Step :: Enter the invalid Password");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123");

		System.out.println("Step :: Click on Sign in button");
		common.log("Step :: Click on Sign in button");
		driver.findElement(By.xpath("//button[@class='btn ng-binding ng-isolate-scope']")).click();

		System.out.println("Step :: Clear the Password field");
		common.log("Step :: Clear the Password field");
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		common.pause(10);
		System.out.println("Step :: Click on Sign in button");
		common.log("Step :: Click on Sign in button");
		driver.findElement(By.xpath("//button[@class='btn ng-binding ng-isolate-scope']")).click();
		common.pause(10);

	}

	// Request corporate account

	public void Request_corporate_account_with_valid_details() {
		System.out.println("Step :: Click on Request for corporate account >> ");
		common.log("Step :: Click on Request for corporate account");
		driver.findElement(By.xpath("//a[@class='white ng-binding']")).click();

		String page = driver.findElement(By.xpath("//h2[@class='ng-binding']")).getText();
		System.out.println("Step ::Title of the page >> " + page);
		common.log("Step :: Title of the page" + page);

		String con = driver.findElement(By.xpath("//p[@class='description ng-binding']")).getText();
		System.out.println("Step ::content of the page >> " + con);
		common.log("Step :: content of the page" + con);

		WebElement form = driver.findElement(By.xpath("//div[@class='container']//form[@name='Form']"));
		if (form.isDisplayed()) {

			common.pause(15);

			String firstname = common.generateRandomChars(5);
			System.out.println("Step :: Enter the first name >> " + firstname);
			common.log("Step :: Ennter the first name >>" + firstname);
			driver.findElement(By.xpath(
					"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']//input[@name='value']"))
					.sendKeys(firstname);

			String lastname = common.generateRandomChars(5);
			System.out.println("Step :: Enter the last name >> " + lastname);
			common.log("Step :: Ennter the last name >>" + lastname);
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/input[1]"))
					.sendKeys(lastname);

			System.out.println("Step :: Enter password");
			common.log("Step :: Ennter password");
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]"))
					.sendKeys("12345");

			System.out.println("Step :: Enter confirm password");
			common.log("Step :: Ennter confirm password");
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/input[1]"))
					.sendKeys("12345");
			System.out.println("Step :: Enter Email");
			common.log("Step :: Enter Email");
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/input[1]"))
					.sendKeys("testingqa1818@gmail.com");

			System.out.println("Step :: Click on Submit button");
			common.log("Step :: Click on Submit button");
			driver.findElement(By.xpath("//button[@class='btn ng-binding']")).click();
			common.pause(25);
			String page1 = driver.findElement(By.xpath("//h2[@id='ngdialog1-aria-labelledby']")).getText();
			System.out.println("Step ::Title of the page >> " + page1);
			common.log("Step :: Title of the page" + page1);

			String thxtext = driver.findElement(By.xpath("//span[@class='ng-binding']")).getText();
			System.out.println("Step ::Title of the page >> " + thxtext);
			common.log("Step :: Title of the page" + thxtext);

			System.out.println("Step :: Click on ok button");
			common.log("Step :: Click on ok button");
			driver.findElement(By.xpath("//span[@class='btn ng-binding']")).click();

			String url = driver.getCurrentUrl();
			System.out.println("Step :: User is redirecting to Prod website Current URL>>" + url);
			common.log("User is redirecting to Prod website" + url);

		} else {
			System.out.println("Step :: Request corporate Form missing");
			common.log("Step :: Request corporate Form missin");

		}

	}

	public void Request_corporate_account_with_blank_spaces() {
		System.out.println("Step :: Click on Request for corporate account >> ");
		common.log("Step :: Click on Request for corporate account");
		driver.findElement(By.xpath("//a[@class='white ng-binding']")).click();

		String page = driver.findElement(By.xpath("//h2[@class='ng-binding']")).getText();
		System.out.println("Step ::Title of the page >> " + page);
		common.log("Step :: Title of the page" + page);

		String con = driver.findElement(By.xpath("//p[@class='description ng-binding']")).getText();
		System.out.println("Step ::content of the page >> " + con);
		common.log("Step :: content of the page" + con);

		System.out.println("Step :: Click on Submit button");
		common.log("Step :: Click on Submit button");
		driver.findElement(By.xpath("//button[@class='btn ng-binding']")).click();
		common.pause(5);

		Actions actions = new Actions(driver);

		// Retrieve WebElement
		WebElement element = driver.findElement(By.xpath("//div[@name='first_name']"));

		// Use action class to mouse hover
		actions.moveToElement(element).perform();

		WebElement toolTip = driver.findElement(By.cssSelector(".tooltiptext"));

		// To get the tool tip text and assert
		String toolTipText = toolTip.getText();
		System.out.println("toolTipText-->" + toolTipText);

		// Verification if tooltip text is matching expected value
		if (toolTipText.equalsIgnoreCase("We ask for your age only for statistical purposes.")) {
			System.out.println("Pass* : Tooltip matching expected value");
		} else {
			System.out.println("Fail : Tooltip NOT matching expected value");
		}

	}

	// Property Task
	public void Property_task() {

		common.pause(60);

		System.out.println("Step :: Click on Property tab");
		common.log("Step :: Click on Property tab");
		driver.findElement(By.xpath("//a[@class='label-property ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(40);

		System.out.println("Step ::Click on Property Selector");
		common.log("Step :: Click on Property Selector");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope disabled']//div[@class='arrow']"))
				.click();

		common.pause(30);

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[2]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(70);

		System.out.println("Step :: Click on check box for complete tasks");
		common.log("Step :: Click on checkbox for complete tasks");
		driver.findElement(By.xpath(
				"//body[@class='ng-scope block-ui block-ui-anim-fade']/div[@class='ng-scope']/ui-view[@class='ng-scope']/div[@class='snap-content ng-scope']/div[@class='layout-main']/div[@class='wrapper-columns']/div[@class='wrapper-columns-column region-main ng-isolate-scope']/div[@class='content-column']/div[@class='content-main table']/div[@class='zone-content']/div[@class='region-content ng-scope']/div[@class='ng-scope']/div[@class='ng-scope']/div[@class='wrapper-tasks wrapper-tasks-workspace ng-scope ng-isolate-scope']/div[@class='ng-scope']/div[@class='content']/div[@class='col-left']/ul/li[1]/div[1]/div[2]/span[1]"))
				.click();

		common.pause(20);
		// String tasktext =
		// driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/h2[1]/span[1]"))
		// .getText();
		// System.out.println("Step :: Verify tasks title message >>" + tasktext);
		// common.log("Step :: Verify tasks title message >>" + tasktext);

		// common.Scrollpage();
		common.pause(30);

		System.out.println("Step :: Click on Mark this task as completed");
		common.log("Step :: Click on Mark this as completed");
		driver.findElement(By.xpath("//span[contains(text(),'Mark this task as completed')]")).click();

		common.pause(40);

		System.out.println("Step :: Click on Add task button");
		common.log("Step :: Click on Add task button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-scope ng-isolate-scope']"))
				.click();

		common.pause(70);

		// common.Scrollpage();

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		String tasknameval = driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']"))
				.getText();
		System.out.println("Step :: Click on Save changes button" + tasknameval);
		common.log("Step :: Click on Save changes button" + tasknameval);

		String prorityval = driver.findElement(By.xpath("//div[@class='widget-priority inline']//p")).getText();

		System.out.println("Step :: Verfiy Priority validaiton message >>" + prorityval);
		common.log("Step :: Verify Priority validaiton message>>" + prorityval);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");

		String categoryval = driver.findElement(By.xpath("//div[@name='category']//p")).getText();
		System.out.println("Step :: Verify Category validation message >>" + categoryval);
		common.log("Step :: Verify Category validation message" + categoryval);

		common.pause(40);

		String taskname = common.generateRandomChars(5);
		System.out.println("Step :: Enter the Task name >> " + taskname);
		common.log("Step :: Ennter the Task name >>" + taskname);
		driver.findElement(By.xpath("//label[@class='widget-label required ng-binding ng-isolate-scope']//..//input"))
				.sendKeys(taskname);

		System.out.println("Step :: Click on Priority Normal Radio button");
		common.log("Step :: Click Priority Normal Radio button");
		driver.findElement(By.xpath(
				"//div[@class='section-boxed box wrapper-tab-main ng-scope ng-isolate-scope']//div[@class='wrapper-fields-group']//li[2]"))
				.click();

		JavascriptExecutor jse4 = (JavascriptExecutor) driver;
		jse4.executeScript("window.scrollBy(0,500)", "");

		System.out.println("Step :: Select categry as Accounting");
		common.log("Step :: Select category as Accounting");
		driver.findElement(By.xpath("//div[@name='category']//li[1]")).click();

		System.out.println("Step :: Click on Sub category dropdown");
		common.log("Step :: Click on Sub category dropdown");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope has-error']//div[@class='arrow']"))
				.click();
		common.pause(10);
		System.out.println("Step :: Select Sub category as accounting");
		common.log("Step :: Select Sub category as accounting");
		driver.findElement(By.xpath("//div[@placeholder='Select Subcategory']//ul//li[1]")).click();

		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		jse5.executeScript("window.scrollBy(0,500)", "");

		System.out.println("Step :: Click on Property Info Type");
		common.log("Step :: Click on Property Info Type");
		driver.findElement(By.xpath(
				"//div[@name='type']//div[@class='field-list flex']//div[1]//div[1]//ng-include[1]//div[1]//div[1]"))
				.click();

		// common.Scrollpage();

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		common.pause(60);

		System.out.println("Step :: Click on Create Task Report button");
		common.log("Step :: Click on Create Task Report button");
		driver.findElement(By.xpath("//span[@class='btn btn-small ng-binding ng-isolate-scope']")).click();

		System.out.println("Step :: Select Date from date picker");
		common.log("Step :: Select Date from date picker");
		driver.findElement(By.xpath("//div[@name='from']//tr[2]//td[1]")).click();

		String fromdate = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[1]/div[1]/div[1]"))
				.getText();
		System.out.println("Step :: Selected Date >>" + fromdate);
		common.log("Step :: Selected Date >>" + fromdate);

		System.out.println("Step :: Select To Date from date picker");
		common.log("Step :: Select To Date from date picker");
		driver.findElement(By.xpath("//div[@name='to']//tr[2]//td[1]")).click();

		String todate = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/div[1]/div[2]/div[1]"))
				.getText();
		System.out.println("Step :: Selected Date >>" + todate);
		common.log("Step :: Selected Date >>" + todate);

		// common.Scrollpage();

		System.out.println("Step :: Click on Create button");
		common.log("Step :: Click on Create button");
		driver.findElement(By.xpath("//span[@class='btn btn-print ng-binding ng-isolate-scope']")).click();

		common.pause(40);

		System.out.println("Step :: Click on Export button");
		common.log("Step :: Click on Export button");
		driver.findElement(By.xpath("//span[contains(text(),'Export')]")).click();

		System.out.println("Step :: Enter the Report name");
		common.log("Step :: Enter the Report name");
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Property Report");

		// common.Scrollpage();

		System.out.println("Step :: Click on Export button");
		common.log("Step :: Click on Export button");
		driver.findElement(By.xpath("//span[@class='right btn ng-binding ng-isolate-scope']")).click();

		common.pause(10);

		String reportsucccessmsg = driver.findElement(By.xpath("//div[@id='toast-container']")).getText();
		System.out.println("Step :: Verfiy the Successmessage" + reportsucccessmsg);
		common.log("Step :: Verfiy the Successmessage" + reportsucccessmsg);

		common.pause(40);

		System.out.println("Step :: Click on Export button");
		common.log("Step :: Click on  Export button");
		driver.findElement(By.xpath("//span[contains(text(),'Export')]")).click();
		common.pause(20);

		System.out.println("Step :: Click on report warehouse tab");
		common.log("Step :: Click on report warehouse tab");
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("test");
		common.pause(30);
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/ul[1]/span[1]")).click();
		System.out.println("Step :: Click on Report");
		common.log("Step :: Click on Report");

	}

	public void Remember_Username() {
		System.out.println("Step :: Enter the Valid Email");
		common.log("Step :: Enter the Valid Email");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sagar@testscenario.com");

		System.out.println("Step :: Enter the Valid Password");
		common.log("Step :: Enter the Valid Password");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345678a");

		System.out.println("Step :: Click on Remember My username Checkbox");
		common.log("Step :: Click on Remember My username Checkbox");
		driver.findElement(
				By.xpath("//span[@class='form-checkbox ng-pristine ng-untouched ng-valid ng-isolate-scope']//icon"))
				.click();
		System.out.println("Step :: Click on I agree terms and conditions check-box");
		common.log("Steps:: Click on I agree terms and conditions check-box");
		common.log("Step :: Enter the Valid Password");
		driver.findElement(By.xpath("//div[@class='wrapper-inline inline']//div[2]//span[1]//div[1]//icon")).click();

		System.out.println("Step :: Click on Sign in button");
		common.log("Step :: Click on Sign in button");
		driver.findElement(By.xpath("//button[@class='btn ng-binding ng-isolate-scope']")).click();
		common.pause(70);
		WebElement logo = driver.findElement(By.xpath("//a[@class='logo ng-binding ng-isolate-scope']"));

		if (logo.isDisplayed()) {
			System.out.println("Step :: Login succesfully , Leonardo logo is displaying");
			common.log("Step :: Login succesfully , Leonardo logo is displaying");
		} else {
			System.out.println("Step :: Login failed , Leonardo logo is not displaying");
			common.log("Step :: Login failed , Leonardo logo is not  displaying");
		}
		common.pause(30);
		System.out.println("Step :: Click on User name");
		common.log("Step :: Click on User name");
		driver.findElement(By.xpath("//div[@class='wrapper-user-menu-data']")).click();
		common.pause(30);
		System.out.println("Step :: Click on Logout");
		common.log("Step :: Click on Logout");
		driver.findElement(By.xpath("//div[@class='zone-user ng-isolate-scope']//div[3]")).click();

		common.pause(20);

		String email = driver.findElement(By.xpath("//input[@type='email']")).getAttribute("value");

		System.out.println("Step :: Verfiy the Username >>" + email);
		common.log("Step :: Verfiy the Username >>" + email);
	}

	public void Update_Created_PropertyTask() {

		common.pause(60);

		System.out.println("Step :: Click on Property tab");
		common.log("Step :: Click on Property tab");
		driver.findElement(By.xpath("//a[@class='label-property ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(40);

		System.out.println("Step ::Click on Property Selector");
		common.log("Step :: Click on Property Selector");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope disabled']//div[@class='arrow']"))
				.click();

		common.pause(30);

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[2]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(70);

		System.out.println("Step :: Click on check box for complete tasks");
		common.log("Step :: Click on checkbox for complete tasks");
		driver.findElement(By.xpath(
				"//body[@class='ng-scope block-ui block-ui-anim-fade']/div[@class='ng-scope']/ui-view[@class='ng-scope']/div[@class='snap-content ng-scope']/div[@class='layout-main']/div[@class='wrapper-columns']/div[@class='wrapper-columns-column region-main ng-isolate-scope']/div[@class='content-column']/div[@class='content-main table']/div[@class='zone-content']/div[@class='region-content ng-scope']/div[@class='ng-scope']/div[@class='ng-scope']/div[@class='wrapper-tasks wrapper-tasks-workspace ng-scope ng-isolate-scope']/div[@class='ng-scope']/div[@class='content']/div[@class='col-left']/ul/li[1]/div[1]/div[2]/span[1]"))
				.click();

		common.pause(20);
		// String tasktext =
		// driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/h2[1]/span[1]"))
		// .getText();
		// System.out.println("Step :: Verify tasks title message >>" + tasktext);
		// common.log("Step :: Verify tasks title message >>" + tasktext);

		// common.Scrollpage();
		common.pause(30);

		System.out.println("Step :: Click on Mark this task as completed");
		common.log("Step :: Click on Mark this as completed");
		driver.findElement(By.xpath("//span[contains(text(),'Mark this task as completed')]")).click();

		common.pause(40);

		System.out.println("Step :: Click on Add task button");
		common.log("Step :: Click on Add task button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-scope ng-isolate-scope']"))
				.click();

		common.pause(70);

		// common.Scrollpage();

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		String tasknameval = driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']"))
				.getText();
		System.out.println("Step :: Click on Save changes button" + tasknameval);
		common.log("Step :: Click on Save changes button" + tasknameval);

		String prorityval = driver.findElement(By.xpath("//div[@class='widget-priority inline']//p")).getText();

		System.out.println("Step :: Verfiy Priority validaiton message >>" + prorityval);
		common.log("Step :: Verify Priority validaiton message>>" + prorityval);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");

		String categoryval = driver.findElement(By.xpath("//div[@name='category']//p")).getText();
		System.out.println("Step :: Verify Category validation message >>" + categoryval);
		common.log("Step :: Verify Category validation message" + categoryval);

		common.pause(40);

		String taskname = common.generateRandomChars(5);
		System.out.println("Step :: Enter the Task name >> " + taskname);
		common.log("Step :: Ennter the Task name >>" + taskname);
		driver.findElement(By.xpath("//label[@class='widget-label required ng-binding ng-isolate-scope']//..//input"))
				.sendKeys(taskname);

		System.out.println("Step :: Click on Priority Normal Radio button");
		common.log("Step :: Click Priority Normal Radio button");
		driver.findElement(By.xpath(
				"//div[@class='section-boxed box wrapper-tab-main ng-scope ng-isolate-scope']//div[@class='wrapper-fields-group']//li[2]"))
				.click();

		JavascriptExecutor jse4 = (JavascriptExecutor) driver;
		jse4.executeScript("window.scrollBy(0,500)", "");

		System.out.println("Step :: Select categry as Accounting");
		common.log("Step :: Select category as Accounting");
		driver.findElement(By.xpath("//div[@name='category']//li[1]")).click();

		System.out.println("Step :: Click on Sub category dropdown");
		common.log("Step :: Click on Sub category dropdown");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope has-error']//div[@class='arrow']"))
				.click();
		common.pause(10);
		System.out.println("Step :: Select Sub category as accounting");
		common.log("Step :: Select Sub category as accounting");
		driver.findElement(By.xpath("//div[@placeholder='Select Subcategory']//ul//li[1]")).click();

		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		jse5.executeScript("window.scrollBy(0,500)", "");

		System.out.println("Step :: Click on Property Info Type");
		common.log("Step :: Click on Property Info Type");
		driver.findElement(By.xpath(
				"//div[@name='type']//div[@class='field-list flex']//div[1]//div[1]//ng-include[1]//div[1]//div[1]"))
				.click();

		// common.Scrollpage();

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		common.pause(25);

		System.out.println("Step :: Click on Templates");
		common.log("Step :: Click on Templates");
		driver.findElement(By.xpath("//a[@class='ng-binding ng-isolate-scope'][contains(text(),'Templates')]")).click();

		System.out.println("Step :: Enter the Taskname >>" + taskname);
		common.log("Step :: Enter the Taskname >>" + taskname);
		driver.findElement(By.xpath("//input[@placeholder='Template Name']")).sendKeys(taskname);

		System.out.println("Step ::Click on Search icon ");
		common.log("Step :: Click o Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();

		common.pause(50);

		System.out.println("Step :: Click on Edit icon");
		common.log("Step :: Click on Edit icon");
		driver.findElement(By.xpath("//div[contains(@class,'td actions')][1]//icon")).click();

		common.pause(25);

		System.out.println("Step :: Update the Task name");
		common.log("Step ::  Update the Task name");
		driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-valid ng-valid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']//input[@name='value']"))
				.sendKeys("aaa");

		System.out.println("Step :: Click on Save changes");
		common.log("Step :: Click on Save changes");
		driver.findElement(By.xpath("//span[@class='btn btn-black right ng-binding ng-isolate-scope']")).click();
		common.pause(25);

		System.out.println("Step :: Clear the templatename field");
		common.log("Step :: Clear the templatename field");
		driver.findElement(By.xpath("//input[@placeholder='Template Name']")).clear();

		System.out.println("Step :: Enter the Taskname with updated value >>" + taskname + "aaa");
		common.log("Step :: Enter the Taskname with updated value>>" + taskname + "aaa");
		driver.findElement(By.xpath("//input[@placeholder='Template Name']")).sendKeys(taskname + "aaa");

		System.out.println("Step ::Click on Search icon ");
		common.log("Step :: Click o Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();

		String updatedtaskname = driver.findElement(By.xpath("//div[@class='td field-name ng-binding active']"))
				.getText();
		System.out.println("Step :: Verify the updated taskname in list " + updatedtaskname);
		common.log("Step :: Verify the updated the taskname in list" + updatedtaskname);
	}

	// TC-12 Edit the Createad task with blank spaces
	public void Edit_Created_task_with_blank_spaces() {
		common.pause(60);

		System.out.println("Step :: Click on Property tab");
		common.log("Step :: Click on Property tab");
		driver.findElement(By.xpath("//a[@class='label-property ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(40);

		System.out.println("Step ::Click on Property Selector");
		common.log("Step :: Click on Property Selector");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope disabled']//div[@class='arrow']"))
				.click();

		common.pause(30);

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[2]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(70);

		System.out.println("Step :: Click on check box for complete tasks");
		common.log("Step :: Click on checkbox for complete tasks");
		driver.findElement(By.xpath(
				"//body[@class='ng-scope block-ui block-ui-anim-fade']/div[@class='ng-scope']/ui-view[@class='ng-scope']/div[@class='snap-content ng-scope']/div[@class='layout-main']/div[@class='wrapper-columns']/div[@class='wrapper-columns-column region-main ng-isolate-scope']/div[@class='content-column']/div[@class='content-main table']/div[@class='zone-content']/div[@class='region-content ng-scope']/div[@class='ng-scope']/div[@class='ng-scope']/div[@class='wrapper-tasks wrapper-tasks-workspace ng-scope ng-isolate-scope']/div[@class='ng-scope']/div[@class='content']/div[@class='col-left']/ul/li[1]/div[1]/div[2]/span[1]"))
				.click();

		common.pause(30);

		System.out.println("Step :: Click on Mark this task as completed");
		common.log("Step :: Click on Mark this as completed");
		driver.findElement(By.xpath("//span[contains(text(),'Mark this task as completed')]")).click();

		common.pause(40);

		System.out.println("Step :: Click on Add task button");
		common.log("Step :: Click on Add task button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-scope ng-isolate-scope']"))
				.click();

		common.pause(70);

		// common.Scrollpage();

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		String tasknameval = driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']"))
				.getText();
		System.out.println("Step :: Click on Save changes button" + tasknameval);
		common.log("Step :: Click on Save changes button" + tasknameval);

		String prorityval = driver.findElement(By.xpath("//div[@class='widget-priority inline']//p")).getText();

		System.out.println("Step :: Verfiy Priority validaiton message >>" + prorityval);
		common.log("Step :: Verify Priority validaiton message>>" + prorityval);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");

		String categoryval = driver.findElement(By.xpath("//div[@name='category']//p")).getText();
		System.out.println("Step :: Verify Category validation message >>" + categoryval);
		common.log("Step :: Verify Category validation message" + categoryval);

		common.pause(40);

		String taskname = common.generateRandomChars(5);
		System.out.println("Step :: Enter the Task name >> " + taskname);
		common.log("Step :: Ennter the Task name >>" + taskname);
		driver.findElement(By.xpath("//label[@class='widget-label required ng-binding ng-isolate-scope']//..//input"))
				.sendKeys(taskname);

		System.out.println("Step :: Click on Priority Normal Radio button");
		common.log("Step :: Click Priority Normal Radio button");
		driver.findElement(By.xpath(
				"//div[@class='section-boxed box wrapper-tab-main ng-scope ng-isolate-scope']//div[@class='wrapper-fields-group']//li[2]"))
				.click();

		JavascriptExecutor jse4 = (JavascriptExecutor) driver;
		jse4.executeScript("window.scrollBy(0,500)", "");

		System.out.println("Step :: Select categry as Accounting");
		common.log("Step :: Select category as Accounting");
		driver.findElement(By.xpath("//div[@name='category']//li[1]")).click();

		System.out.println("Step :: Click on Sub category dropdown");
		common.log("Step :: Click on Sub category dropdown");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope has-error']//div[@class='arrow']"))
				.click();
		common.pause(10);
		System.out.println("Step :: Select Sub category as accounting");
		common.log("Step :: Select Sub category as accounting");
		driver.findElement(By.xpath("//div[@placeholder='Select Subcategory']//ul//li[1]")).click();

		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		jse5.executeScript("window.scrollBy(0,500)", "");

		System.out.println("Step :: Click on Property Info Type");
		common.log("Step :: Click on Property Info Type");
		driver.findElement(By.xpath(
				"//div[@name='type']//div[@class='field-list flex']//div[1]//div[1]//ng-include[1]//div[1]//div[1]"))
				.click();

		// common.Scrollpage();

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		common.pause(25);

		System.out.println("Step :: Click on Templates");
		common.log("Step :: Click on Templates");
		driver.findElement(By.xpath("//a[@class='ng-binding ng-isolate-scope'][contains(text(),'Templates')]")).click();

		System.out.println("Step :: Enter the Taskname >>" + taskname);
		common.log("Step :: Enter the Taskname >>" + taskname);
		driver.findElement(By.xpath("//input[@placeholder='Template Name']")).sendKeys(taskname);

		System.out.println("Step ::Click on Search icon ");
		common.log("Step :: Click o Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();

		common.pause(50);

		System.out.println("Step :: Click on Edit icon");
		common.log("Step :: Click on Edit icon");
		driver.findElement(By.xpath("//div[contains(@class,'td actions')][1]//icon")).click();

		System.out.println("Step :: Clear the Task name");
		common.log("Step ::  Clear the Task name");
		driver.findElement(By.xpath("//input[@placeholder='Template Name']")).clear();
		common.pause(15);
		System.out.println("Step :: Click on Save changes");
		common.log("Step :: Click on Save changes");
		driver.findElement(By.xpath("//span[@class='btn btn-black right ng-binding ng-isolate-scope']")).click();
		common.pause(25);

	}

	public void clone_created_task_functionality_with_all_validations_in_templates() {

		common.pause(60);

		System.out.println("Step :: Click on Property tab");
		common.log("Step :: Click on Property tab");
		driver.findElement(By.xpath("//a[@class='label-property ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(40);

		System.out.println("Step ::Click on Property Selector");
		common.log("Step :: Click on Property Selector");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope disabled']//div[@class='arrow']"))
				.click();

		common.pause(30);

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[2]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(70);

		System.out.println("Step :: Click on check box for complete tasks");
		common.log("Step :: Click on checkbox for complete tasks");
		driver.findElement(By.xpath(
				"//body[@class='ng-scope block-ui block-ui-anim-fade']/div[@class='ng-scope']/ui-view[@class='ng-scope']/div[@class='snap-content ng-scope']/div[@class='layout-main']/div[@class='wrapper-columns']/div[@class='wrapper-columns-column region-main ng-isolate-scope']/div[@class='content-column']/div[@class='content-main table']/div[@class='zone-content']/div[@class='region-content ng-scope']/div[@class='ng-scope']/div[@class='ng-scope']/div[@class='wrapper-tasks wrapper-tasks-workspace ng-scope ng-isolate-scope']/div[@class='ng-scope']/div[@class='content']/div[@class='col-left']/ul/li[1]/div[1]/div[2]/span[1]"))
				.click();

		common.pause(30);

		System.out.println("Step :: Click on Mark this task as completed");
		common.log("Step :: Click on Mark this as completed");
		driver.findElement(By.xpath("//span[contains(text(),'Mark this task as completed')]")).click();

		common.pause(40);

		System.out.println("Step :: Click on Add task button");
		common.log("Step :: Click on Add task button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-scope ng-isolate-scope']"))
				.click();

		common.pause(70);

		// common.Scrollpage();

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		String tasknameval = driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']"))
				.getText();
		System.out.println("Step :: Click on Save changes button" + tasknameval);
		common.log("Step :: Click on Save changes button" + tasknameval);

		String prorityval = driver.findElement(By.xpath("//div[@class='widget-priority inline']//p")).getText();

		System.out.println("Step :: Verfiy Priority validaiton message >>" + prorityval);
		common.log("Step :: Verify Priority validaiton message>>" + prorityval);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");

		String categoryval = driver.findElement(By.xpath("//div[@name='category']//p")).getText();
		System.out.println("Step :: Verify Category validation message >>" + categoryval);
		common.log("Step :: Verify Category validation message" + categoryval);

		common.pause(40);

		String taskname = common.generateRandomChars(5);
		System.out.println("Step :: Enter the Task name >> " + taskname);
		common.log("Step :: Ennter the Task name >>" + taskname);
		driver.findElement(By.xpath("//label[@class='widget-label required ng-binding ng-isolate-scope']//..//input"))
				.sendKeys(taskname);

		System.out.println("Step :: Click on Priority Normal Radio button");
		common.log("Step :: Click Priority Normal Radio button");
		driver.findElement(By.xpath(
				"//div[@class='section-boxed box wrapper-tab-main ng-scope ng-isolate-scope']//div[@class='wrapper-fields-group']//li[2]"))
				.click();

		JavascriptExecutor jse4 = (JavascriptExecutor) driver;
		jse4.executeScript("window.scrollBy(0,500)", "");

		System.out.println("Step :: Select categry as Accounting");
		common.log("Step :: Select category as Accounting");
		driver.findElement(By.xpath("//div[@name='category']//li[1]")).click();

		System.out.println("Step :: Click on Sub category dropdown");
		common.log("Step :: Click on Sub category dropdown");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope has-error']//div[@class='arrow']"))
				.click();
		common.pause(10);
		System.out.println("Step :: Select Sub category as accounting");
		common.log("Step :: Select Sub category as accounting");
		driver.findElement(By.xpath("//div[@placeholder='Select Subcategory']//ul//li[1]")).click();

		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		jse5.executeScript("window.scrollBy(0,500)", "");

		System.out.println("Step :: Click on Property Info Type");
		common.log("Step :: Click on Property Info Type");
		driver.findElement(By.xpath(
				"//div[@name='type']//div[@class='field-list flex']//div[1]//div[1]//ng-include[1]//div[1]//div[1]"))
				.click();

		// common.Scrollpage();

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		common.pause(25);

		System.out.println("Step :: Click on Templates");
		common.log("Step :: Click on Templates");
		driver.findElement(By.xpath("//a[@class='ng-binding ng-isolate-scope'][contains(text(),'Templates')]")).click();
		common.pause(25);
		System.out.println("Step :: Enter the Taskname >>" + taskname);
		common.log("Step :: Enter the Taskname >>" + taskname);
		driver.findElement(By.xpath("//input[@placeholder='Template Name']")).sendKeys(taskname);

		System.out.println("Step ::Click on Search icon ");
		common.log("Step :: Click o Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();

		common.pause(50);

		System.out.println("Step ::Click on Clone");
		common.log("Step :: Click on Clone");
		driver.findElement(By.xpath("//div[contains(@class,'td actions')][2]//icon")).click();

		common.pause(15);

		System.out.println("Step ::Click on Select button");
		common.log("Step :: Click on Select button");
		driver.findElement(By.xpath(
				"//ul[@class='actions']//span[@class='btn ng-binding ng-isolate-scope'][contains(text(),'Select')]"))
				.click();

		common.pause(15);

		System.out.println("Step ::Click on Account template(All templates)");
		common.log("Step :: Click on Select button(All templates)");
		driver.findElement(By.xpath("//div[@class='form-item form-item-properties-selector']//li[1]//icon[1]")).click();

		System.out.println("Step ::Click on Select button");
		common.log("Step :: Click on Select button");
		driver.findElement(By.xpath(
				"//ul[@class='actions']//span[@class='btn ng-binding ng-isolate-scope'][contains(text(),'Select')]"))
				.click();

		String clonedcpy = driver.findElement(By.xpath("//div[@class='table-row']//div[6]")).getText();
		System.out.println("Step ::Get the cloned copy name>>" + clonedcpy);
		common.log("Step :: Get the cloned copy name>>" + clonedcpy);

	}

	public void Delete_Template_with_all_child_and_without_all_child_templates() {
		common.pause(60);

		System.out.println("Step :: Click on Property tab");
		common.log("Step :: Click on Property tab");
		driver.findElement(By.xpath("//a[@class='label-property ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(40);

		System.out.println("Step ::Click on Property Selector");
		common.log("Step :: Click on Property Selector");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope disabled']//div[@class='arrow']"))
				.click();

		common.pause(30);

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[2]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(70);

		System.out.println("Step :: Click on check box for complete tasks");
		common.log("Step :: Click on checkbox for complete tasks");
		driver.findElement(By.xpath(
				"//body[@class='ng-scope block-ui block-ui-anim-fade']/div[@class='ng-scope']/ui-view[@class='ng-scope']/div[@class='snap-content ng-scope']/div[@class='layout-main']/div[@class='wrapper-columns']/div[@class='wrapper-columns-column region-main ng-isolate-scope']/div[@class='content-column']/div[@class='content-main table']/div[@class='zone-content']/div[@class='region-content ng-scope']/div[@class='ng-scope']/div[@class='ng-scope']/div[@class='wrapper-tasks wrapper-tasks-workspace ng-scope ng-isolate-scope']/div[@class='ng-scope']/div[@class='content']/div[@class='col-left']/ul/li[1]/div[1]/div[2]/span[1]"))
				.click();

		common.pause(30);

		System.out.println("Step :: Click on Mark this task as completed");
		common.log("Step :: Click on Mark this as completed");
		driver.findElement(By.xpath("//span[contains(text(),'Mark this task as completed')]")).click();

		common.pause(40);

		System.out.println("Step :: Click on Add task button");
		common.log("Step :: Click on Add task button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-scope ng-isolate-scope']"))
				.click();

		common.pause(70);

		// common.Scrollpage();

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		String tasknameval = driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']"))
				.getText();
		System.out.println("Step :: Click on Save changes button" + tasknameval);
		common.log("Step :: Click on Save changes button" + tasknameval);

		String prorityval = driver.findElement(By.xpath("//div[@class='widget-priority inline']//p")).getText();

		System.out.println("Step :: Verfiy Priority validaiton message >>" + prorityval);
		common.log("Step :: Verify Priority validaiton message>>" + prorityval);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");

		String categoryval = driver.findElement(By.xpath("//div[@name='category']//p")).getText();
		System.out.println("Step :: Verify Category validation message >>" + categoryval);
		common.log("Step :: Verify Category validation message" + categoryval);

		common.pause(40);

		String taskname = common.generateRandomChars(5);
		System.out.println("Step :: Enter the Task name >> " + taskname);
		common.log("Step :: Ennter the Task name >>" + taskname);
		driver.findElement(By.xpath("//label[@class='widget-label required ng-binding ng-isolate-scope']//..//input"))
				.sendKeys(taskname);

		System.out.println("Step :: Click on Priority Normal Radio button");
		common.log("Step :: Click Priority Normal Radio button");
		driver.findElement(By.xpath(
				"//div[@class='section-boxed box wrapper-tab-main ng-scope ng-isolate-scope']//div[@class='wrapper-fields-group']//li[2]"))
				.click();

		JavascriptExecutor jse4 = (JavascriptExecutor) driver;
		jse4.executeScript("window.scrollBy(0,500)", "");

		System.out.println("Step :: Select categry as Accounting");
		common.log("Step :: Select category as Accounting");
		driver.findElement(By.xpath("//div[@name='category']//li[1]")).click();

		System.out.println("Step :: Click on Sub category dropdown");
		common.log("Step :: Click on Sub category dropdown");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope has-error']//div[@class='arrow']"))
				.click();
		common.pause(10);
		System.out.println("Step :: Select Sub category as accounting");
		common.log("Step :: Select Sub category as accounting");
		driver.findElement(By.xpath("//div[@placeholder='Select Subcategory']//ul//li[1]")).click();

		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		jse5.executeScript("window.scrollBy(0,500)", "");

		System.out.println("Step :: Click on Property Info Type");
		common.log("Step :: Click on Property Info Type");
		driver.findElement(By.xpath(
				"//div[@name='type']//div[@class='field-list flex']//div[1]//div[1]//ng-include[1]//div[1]//div[1]"))
				.click();

		// common.Scrollpage();

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		common.pause(25);

		System.out.println("Step :: Click on Templates");
		common.log("Step :: Click on Templates");
		driver.findElement(By.xpath("//a[@class='ng-binding ng-isolate-scope'][contains(text(),'Templates')]")).click();

		System.out.println("Step :: Enter the Taskname >>" + taskname);
		common.log("Step :: Enter the Taskname >>" + taskname);
		driver.findElement(By.xpath("//input[@placeholder='Template Name']")).sendKeys(taskname);

		System.out.println("Step ::Click on Search icon ");
		common.log("Step :: Click o Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();

		common.pause(50);

		System.out.println("Step ::Click on Delete icon ");
		common.log("Step :: Click on Delete icon");
		driver.findElement(By.xpath("//div[contains(@class,'td actions')][3]//icon")).click();

		String delmsg = driver.findElement(By.xpath("//p[@id='ngdialog3-aria-describedby']")).getText();
		System.out.println("Step ::Verfiy the Delete confirmaiton message >>" + delmsg);
		common.log("Step :: Verfiy the Deletew confirmaiton message >>" + delmsg);

		System.out.println("Step ::Click on Yes Delete button ");
		common.log("Step :: Click on Yes Delete button");
		driver.findElement(By.xpath("//span[@class='btn btn-delete ng-binding ng-isolate-scope']")).click();

		common.pause(35);

		System.out.println("Step :: Enter the Taskname >>" + taskname);
		common.log("Step :: Enter the Taskname >>" + taskname);
		driver.findElement(By.xpath("//input[@placeholder='Template Name']")).sendKeys(taskname);

		System.out.println("Step ::Click on Search icon ");
		common.log("Step :: Click o Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();

		common.pause(25);

		String strmsg = driver
				.findElement(By.xpath("//span[contains(text(),'Choose a filter option above in order to see match')]"))
				.getText();
		System.out.println("Step :: Verify the Blank screen with message >>" + strmsg);
		common.log("Step :: Verify the Blank screen with message >>" + strmsg);

	}

	public void Edit_Property_task() {
		common.pause(60);

		System.out.println("Step :: Click on Property tab");
		common.log("Step :: Click on Property tab");
		driver.findElement(By.xpath("//a[@class='label-property ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(40);

		System.out.println("Step ::Click on Property Selector");
		common.log("Step :: Click on Property Selector");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope disabled']//div[@class='arrow']"))
				.click();

		common.pause(30);

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[2]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(70);

		System.out.println("Step :: Click on check box for complete tasks");
		common.log("Step :: Click on checkbox for complete tasks");
		driver.findElement(By.xpath(
				"//body[@class='ng-scope block-ui block-ui-anim-fade']/div[@class='ng-scope']/ui-view[@class='ng-scope']/div[@class='snap-content ng-scope']/div[@class='layout-main']/div[@class='wrapper-columns']/div[@class='wrapper-columns-column region-main ng-isolate-scope']/div[@class='content-column']/div[@class='content-main table']/div[@class='zone-content']/div[@class='region-content ng-scope']/div[@class='ng-scope']/div[@class='ng-scope']/div[@class='wrapper-tasks wrapper-tasks-workspace ng-scope ng-isolate-scope']/div[@class='ng-scope']/div[@class='content']/div[@class='col-left']/ul/li[1]/div[1]/div[2]/span[1]"))
				.click();

		common.pause(30);

		System.out.println("Step :: Click on Mark this task as completed");
		common.log("Step :: Click on Mark this as completed");
		driver.findElement(By.xpath("//span[contains(text(),'Mark this task as completed')]")).click();

		common.pause(40);

		System.out.println("Step :: Click on Add task button");
		common.log("Step :: Click on Add task button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-scope ng-isolate-scope']"))
				.click();

		common.pause(70);

		// common.Scrollpage();

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		String tasknameval = driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']"))
				.getText();
		System.out.println("Step :: Click on Save changes button" + tasknameval);
		common.log("Step :: Click on Save changes button" + tasknameval);

		String prorityval = driver.findElement(By.xpath("//div[@class='widget-priority inline']//p")).getText();

		System.out.println("Step :: Verfiy Priority validaiton message >>" + prorityval);
		common.log("Step :: Verify Priority validaiton message>>" + prorityval);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");

		String categoryval = driver.findElement(By.xpath("//div[@name='category']//p")).getText();
		System.out.println("Step :: Verify Category validation message >>" + categoryval);
		common.log("Step :: Verify Category validation message" + categoryval);

		common.pause(40);

		String taskname = common.generateRandomChars(5);
		System.out.println("Step :: Enter the Task name >> " + taskname);
		common.log("Step :: Ennter the Task name >>" + taskname);
		driver.findElement(By.xpath("//label[@class='widget-label required ng-binding ng-isolate-scope']//..//input"))
				.sendKeys(taskname);

		System.out.println("Step :: Click on Priority Normal Radio button");
		common.log("Step :: Click Priority Normal Radio button");
		driver.findElement(By.xpath(
				"//div[@class='section-boxed box wrapper-tab-main ng-scope ng-isolate-scope']//div[@class='wrapper-fields-group']//li[2]"))
				.click();

		JavascriptExecutor jse4 = (JavascriptExecutor) driver;
		jse4.executeScript("window.scrollBy(0,500)", "");

		System.out.println("Step :: Select categry as Accounting");
		common.log("Step :: Select category as Accounting");
		driver.findElement(By.xpath("//div[@name='category']//li[1]")).click();

		System.out.println("Step :: Click on Sub category dropdown");
		common.log("Step :: Click on Sub category dropdown");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope has-error']//div[@class='arrow']"))
				.click();
		common.pause(10);
		System.out.println("Step :: Select Sub category as accounting");
		common.log("Step :: Select Sub category as accounting");
		driver.findElement(By.xpath("//div[@placeholder='Select Subcategory']//ul//li[1]")).click();

		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		jse5.executeScript("window.scrollBy(0,500)", "");

		System.out.println("Step :: Click on Property Info Type");
		common.log("Step :: Click on Property Info Type");
		driver.findElement(By.xpath(
				"//div[@name='type']//div[@class='field-list flex']//div[1]//div[1]//ng-include[1]//div[1]//div[1]"))
				.click();

		// common.Scrollpage();

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		common.pause(25);

		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter BY");
		driver.findElement(By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope']//div[@class='arrow']"))
				.click();

		System.out.println("Step :: Click on three dot for the created task from Today workspace");
		common.log("Step :: Click on three dot for the created task from Today workspace");
		driver.findElement(By.xpath("//div[@class='col-left']/ul/li[1]/div[1]//icon[2]")).click();
		System.out.println("Step :: Click on Edit");
		common.log("Step :: Click on Edit");
		driver.findElement(By.xpath("//div[@class='col-left']/ul/li[1]/div[1]//li[2]")).click();
		common.pause(25);

		if (driver.findElement(By.xpath("//div[@class='col-left']/ul/li[1]/div[1]//div[@class='title']"))
				.isDisplayed()) {
			System.out.println("Step :: Task name field present- Property task Edit form displaying");
			common.log("Step :: Task name field present- Property task Edit form displaying.");
		} else {

			System.out.println("Step :: Edit form not displaying");
			common.log("Step :: Edit form not displayingt");
		}
	}

	public void Edit_Property_task_with_blankspaces() {
		System.out.println("Step :: Clear taskname field");
		common.log("Step :: Clear taskname field");
		driver.findElement(By.xpath("//div[@name='name']//input[@name='value']")).clear();

		System.out.println("Step ::click on  Recurrence ");
		common.log("Step ::Click on  Recurrence ");
		driver.findElement(By.xpath("//select[@ng-model='recurrence.type']")).click();
		common.pause(25);
		System.out.println("Step :: NO Recurrence  ");
		common.log("Step :: No Recurrence ");
		driver.findElement(By.xpath("//select[@ng-model='recurrence.type']//option[1]")).click();
		common.pause(35);

		System.out.println("Step :: Click on Save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		common.pause(35);

		String dr = driver.findElement(By.xpath("//p[@class='error ng-scope ng-binding'][1]")).getText();
		System.out.println("Step :: Task name field validaiton with blank spaces>>" + dr);
		common.log("Step :: Task name field validaiton with blank spaces>>" + dr);

		String dr1 = driver.findElement(By.xpath("//p[@class='error ng-scope ng-binding'][2]")).getText();
		System.out.println("Step :: Task name field validaiton with blank spaces>>" + dr1);
		common.log("Step :: Task name field validaiton with blank spaces>>" + dr1);

		common.pause(35);

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		common.pause(35);

	}

	public void Proprty_task_Template_option() {

		common.pause(60);

		System.out.println("Step :: Click on Property tab");
		common.log("Step :: Click on Property tab");
		driver.findElement(By.xpath("//a[@class='label-property ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(40);

		System.out.println("Step ::Click on Property Selector");
		common.log("Step :: Click on Property Selector");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope disabled']//div[@class='arrow']"))
				.click();

		common.pause(30);

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[2]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(70);

		System.out.println("Step :: Click on check box for complete tasks");
		common.log("Step :: Click on checkbox for complete tasks");
		driver.findElement(By.xpath(
				"//body[@class='ng-scope block-ui block-ui-anim-fade']/div[@class='ng-scope']/ui-view[@class='ng-scope']/div[@class='snap-content ng-scope']/div[@class='layout-main']/div[@class='wrapper-columns']/div[@class='wrapper-columns-column region-main ng-isolate-scope']/div[@class='content-column']/div[@class='content-main table']/div[@class='zone-content']/div[@class='region-content ng-scope']/div[@class='ng-scope']/div[@class='ng-scope']/div[@class='wrapper-tasks wrapper-tasks-workspace ng-scope ng-isolate-scope']/div[@class='ng-scope']/div[@class='content']/div[@class='col-left']/ul/li[1]/div[1]/div[2]/span[1]"))
				.click();

		common.pause(20);
		// String tasktext =
		// driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/h2[1]/span[1]"))
		// .getText();
		// System.out.println("Step :: Verify tasks title message >>" + tasktext);
		// common.log("Step :: Verify tasks title message >>" + tasktext);

		// common.Scrollpage();
		common.pause(30);

		System.out.println("Step :: Click on Mark this task as completed");
		common.log("Step :: Click on Mark this as completed");
		driver.findElement(By.xpath("//span[contains(text(),'Mark this task as completed')]")).click();

		common.pause(40);

		System.out.println("Step :: Click on Add task button");
		common.log("Step :: Click on Add task button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-scope ng-isolate-scope']"))
				.click();

		common.pause(70);

		// common.Scrollpage();

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		String tasknameval = driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']"))
				.getText();
		System.out.println("Step :: Click on Save changes button" + tasknameval);
		common.log("Step :: Click on Save changes button" + tasknameval);

		String prorityval = driver.findElement(By.xpath("//div[@class='widget-priority inline']//p")).getText();

		System.out.println("Step :: Verfiy Priority validaiton message >>" + prorityval);
		common.log("Step :: Verify Priority validaiton message>>" + prorityval);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");

		String categoryval = driver.findElement(By.xpath("//div[@name='category']//p")).getText();
		System.out.println("Step :: Verify Category validation message >>" + categoryval);
		common.log("Step :: Verify Category validation message" + categoryval);

		common.pause(40);

		String taskname = common.generateRandomChars(5);
		System.out.println("Step :: Enter the Task name >> " + taskname);
		common.log("Step :: Ennter the Task name >>" + taskname);
		driver.findElement(By.xpath("//label[@class='widget-label required ng-binding ng-isolate-scope']//..//input"))
				.sendKeys(taskname);

		System.out.println("Step :: Click on Priority Normal Radio button");
		common.log("Step :: Click Priority Normal Radio button");
		driver.findElement(By.xpath(
				"//div[@class='section-boxed box wrapper-tab-main ng-scope ng-isolate-scope']//div[@class='wrapper-fields-group']//li[2]"))
				.click();

		JavascriptExecutor jse4 = (JavascriptExecutor) driver;
		jse4.executeScript("window.scrollBy(0,500)", "");

		System.out.println("Step :: Select categry as Accounting");
		common.log("Step :: Select category as Accounting");
		driver.findElement(By.xpath("//div[@name='category']//li[1]")).click();

		System.out.println("Step :: Click on Sub category dropdown");
		common.log("Step :: Click on Sub category dropdown");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope has-error']//div[@class='arrow']"))
				.click();
		common.pause(10);
		System.out.println("Step :: Select Sub category as accounting");
		common.log("Step :: Select Sub category as accounting");
		driver.findElement(By.xpath("//div[@placeholder='Select Subcategory']//ul//li[1]")).click();

		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		jse5.executeScript("window.scrollBy(0,500)", "");

		System.out.println("Step :: Click on Property Info Type");
		common.log("Step :: Click on Property Info Type");
		driver.findElement(By.xpath(
				"//div[@name='type']//div[@class='field-list flex']//div[1]//div[1]//ng-include[1]//div[1]//div[1]"))
				.click();

		// common.Scrollpage();

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		common.pause(25);

		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter BY");
		driver.findElement(By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope']//div[@class='arrow']"))
				.click();

		System.out.println("Step :: Click on three dot for the created task from Today workspace");
		common.log("Step :: Click on three dot for the created task from Today workspace");
		driver.findElement(By.xpath("//div[@class='col-left']/ul/li[1]/div[1]//icon[2]")).click();

		if (driver.findElement(By.xpath("//div[@class='col-left']//li[1]//div[1]//div[2]//ul[1]//li[5]"))
				.isDisplayed()) {
			System.out.println("Step :: Click on assign user");
			common.log("Step :: Click on assign user");
			driver.findElement(By.xpath("//div[@class='col-left']//li[1]//div[1]//div[2]//ul[1]//li[5]")).click();
		} else {
			System.out.println("Step ::  assign user feature missing");
			common.log("Step :: assign user feature missing");

		}

		common.pause(20);

		driver.findElement(By.xpath("//span[@class='btn btn-cancel ng-binding ng-isolate-scope']")).click();
		common.pause(35);

		System.out.println("Step :: Click on three dot for the created task from Today workspace");
		common.log("Step :: Click on three dot for the created task from Today workspace");
		driver.findElement(By.xpath("//div[@class='col-left']/ul/li[1]/div[1]//icon[2]")).click();

		System.out.println("Step :: Click on Deactivate");
		common.log("Step :: Click on Deactivate");
		driver.findElement(By.xpath("//div[@class='col-left']//li[1]//div[1]//div[2]//ul[1]//li[6]")).click();
		common.pause(25);

		String str = driver.findElement(By.xpath("//div[@class='wrapper-content center']")).getAttribute("value");
		System.out.println("Step :: Confirmation Message >>" + str);
		common.log("Step :: Confirmation Message" + str);

		System.out.println("Step :: Click on Yes-Deactivate");
		common.log("Step :: Click on Yes-Deactivate");
		driver.findElement(By.xpath("//span[@class='btn btn-delete ng-binding ng-isolate-scope']")).click();

	}

	public void Property_task_option() {

		common.pause(60);

		System.out.println("Step :: Click on Property tab");
		common.log("Step :: Click on Property tab");
		driver.findElement(By.xpath("//a[@class='label-property ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(40);

		System.out.println("Step ::Click on Property Selector");
		common.log("Step :: Click on Property Selector");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope disabled']//div[@class='arrow']"))
				.click();

		common.pause(30);

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[2]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(70);

		System.out.println("Step :: Click on check box for complete tasks");
		common.log("Step :: Click on checkbox for complete tasks");
		driver.findElement(By.xpath(
				"//body[@class='ng-scope block-ui block-ui-anim-fade']/div[@class='ng-scope']/ui-view[@class='ng-scope']/div[@class='snap-content ng-scope']/div[@class='layout-main']/div[@class='wrapper-columns']/div[@class='wrapper-columns-column region-main ng-isolate-scope']/div[@class='content-column']/div[@class='content-main table']/div[@class='zone-content']/div[@class='region-content ng-scope']/div[@class='ng-scope']/div[@class='ng-scope']/div[@class='wrapper-tasks wrapper-tasks-workspace ng-scope ng-isolate-scope']/div[@class='ng-scope']/div[@class='content']/div[@class='col-left']/ul/li[1]/div[1]/div[2]/span[1]"))
				.click();

		common.pause(20);
		// String tasktext =
		// driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/form[1]/h2[1]/span[1]"))
		// .getText();
		// System.out.println("Step :: Verify tasks title message >>" + tasktext);
		// common.log("Step :: Verify tasks title message >>" + tasktext);

		// common.Scrollpage();
		common.pause(30);

		System.out.println("Step :: Click on Mark this task as completed");
		common.log("Step :: Click on Mark this as completed");
		driver.findElement(By.xpath("//span[contains(text(),'Mark this task as completed')]")).click();

		common.pause(40);

		System.out.println("Step :: Click on Add task button");
		common.log("Step :: Click on Add task button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-scope ng-isolate-scope']"))
				.click();

		common.pause(70);

		// common.Scrollpage();

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		String tasknameval = driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']"))
				.getText();
		System.out.println("Step :: Click on Save changes button" + tasknameval);
		common.log("Step :: Click on Save changes button" + tasknameval);

		String prorityval = driver.findElement(By.xpath("//div[@class='widget-priority inline']//p")).getText();

		System.out.println("Step :: Verfiy Priority validaiton message >>" + prorityval);
		common.log("Step :: Verify Priority validaiton message>>" + prorityval);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");

		String categoryval = driver.findElement(By.xpath("//div[@name='category']//p")).getText();
		System.out.println("Step :: Verify Category validation message >>" + categoryval);
		common.log("Step :: Verify Category validation message" + categoryval);

		common.pause(40);

		String taskname = common.generateRandomChars(5);
		System.out.println("Step :: Enter the Task name >> " + taskname);
		common.log("Step :: Ennter the Task name >>" + taskname);
		driver.findElement(By.xpath("//label[@class='widget-label required ng-binding ng-isolate-scope']//..//input"))
				.sendKeys(taskname);

		System.out.println("Step :: Click on Priority Normal Radio button");
		common.log("Step :: Click Priority Normal Radio button");
		driver.findElement(By.xpath(
				"//div[@class='section-boxed box wrapper-tab-main ng-scope ng-isolate-scope']//div[@class='wrapper-fields-group']//li[2]"))
				.click();

		JavascriptExecutor jse4 = (JavascriptExecutor) driver;
		jse4.executeScript("window.scrollBy(0,500)", "");

		System.out.println("Step :: Select categry as Accounting");
		common.log("Step :: Select category as Accounting");
		driver.findElement(By.xpath("//div[@name='category']//li[1]")).click();

		System.out.println("Step :: Click on Sub category dropdown");
		common.log("Step :: Click on Sub category dropdown");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope has-error']//div[@class='arrow']"))
				.click();
		common.pause(10);
		System.out.println("Step :: Select Sub category as accounting");
		common.log("Step :: Select Sub category as accounting");
		driver.findElement(By.xpath("//div[@placeholder='Select Subcategory']//ul//li[1]")).click();

		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		jse5.executeScript("window.scrollBy(0,500)", "");

		System.out.println("Step :: Click on Property Info Type");
		common.log("Step :: Click on Property Info Type");
		driver.findElement(By.xpath(
				"//div[@name='type']//div[@class='field-list flex']//div[1]//div[1]//ng-include[1]//div[1]//div[1]"))
				.click();

		// common.Scrollpage();

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		common.pause(25);

		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter BY");
		driver.findElement(By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope']//div[@class='arrow']"))
				.click();

		System.out.println("Step :: Click on three dot for the created task from Today workspace");
		common.log("Step :: Click on three dot for the created task from Today workspace");
		driver.findElement(By.xpath("//div[@class='col-left']/ul/li[1]/div[1]//icon[2]")).click();

		// Leave note
		common.pause(25);

		System.out.println("Step :: Click on leave note");
		common.log("Step :: Click on leave note");
		driver.findElement(By.xpath("//div[@class='col-left']/ul/li[1]/div[1]//li[8]")).click();

		common.pause(30);
		WebElement notefield = driver.findElement(By.xpath("//textarea[@placeholder='Note']"));
		notefield.sendKeys("testnote");
		notefield.getAttribute("value");
		System.out.println("Step :: Enter the note >> " + notefield);
		common.log("Step :: Enter the note >>" + notefield);

		System.out.println("Step :: Click on leave note button");
		common.log("Step :: Click on leave note button");
		driver.findElement(By.xpath("//span[@class='btn btn-print ng-binding ng-isolate-scope']")).click();
		common.pause(45);

	}

	public void Pastdue_Current_tasks() {

		common.pause(60);

		System.out.println("Step :: Click on Property tab");
		common.log("Step :: Click on Property tab");
		driver.findElement(By.xpath("//a[@class='label-property ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(50);

		WebElement btn = driver
				.findElement(By.xpath("//span[@class='btn btn-small right ng-binding ng-isolate-scope']"));
		if (btn.isDisplayed()) {
			System.out.println("Step :: Click on Past due button");
			common.log("Step :: Click on Past button");
			btn.click();

		}

		common.pause(40);
		WebElement titletxt = driver.findElement(By.xpath("//h1[@class='ng-binding ng-scope']"));
		String title = titletxt.getText();
		System.out.println("Step :: Title for Page >>" + title);
		common.log("Step :: Title for page>>" + title);

		WebElement protxt = driver.findElement(By.xpath("//h1[@class='left ng-binding']"));
		String txt = protxt.getText();
		System.out.println("Step :: Title for property Page >>" + txt);
		common.log("Step :: Title for property page>>" + txt);
		common.pause(25);
		WebElement yesterdaytxt = driver
				.findElement(By.xpath("(//span[contains(@ng-show,'initialDueDate == dueDate')])[1]"));
		String tes = yesterdaytxt.getText();
		System.out.println("Step :: Yesterday Task title present" + tes);
		common.log("Step :: Yesterday Task title present" + tes);
		common.pause(15);
		// driver.findElement(By.xpath("(//span[@class='prev
		// ng-binding'])[1]")).click();

		WebElement dailytxt = driver.findElement(By.xpath("(//span[@class='ng-binding'])[6]"));
		String ea = dailytxt.getText();
		System.out.println("Step :: Daily Task title present" + ea);
		common.log("Step :: Daily Task title present" + ea);
		common.pause(35);

		WebElement week = driver.findElement(By.xpath("(//span[@class='ng-binding'])[17]"));
		String weekly = yesterdaytxt.getText();
		System.out.println("Step :: Weekly Task title present" + weekly);
		common.log("Step :: Yesterday Task title present" + weekly);
		common.pause(15);
		// driver.findElement(By.xpath("(//span[@class='prev
		// ng-binding'][contains(.,'Previous')])[2]")).click();

	}

	public void Completetask_functionality_in_property_tasks() {

		common.pause(60);

		System.out.println("Step :: Click on Property tab");
		common.log("Step :: Click on Property tab");
		driver.findElement(By.xpath("//a[@class='label-property ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(40);

		System.out.println("Step ::Click on Property Selector");
		common.log("Step :: Click on Property Selector");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope disabled']//div[@class='arrow']"))
				.click();

		common.pause(30);

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[2]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(70);

		System.out.println("Step :: Click on check box for complete tasks");
		common.log("Step :: Click on checkbox for complete tasks");
		driver.findElement(By.xpath(
				"//body[@class='ng-scope block-ui block-ui-anim-fade']/div[@class='ng-scope']/ui-view[@class='ng-scope']/div[@class='snap-content ng-scope']/div[@class='layout-main']/div[@class='wrapper-columns']/div[@class='wrapper-columns-column region-main ng-isolate-scope']/div[@class='content-column']/div[@class='content-main table']/div[@class='zone-content']/div[@class='region-content ng-scope']/div[@class='ng-scope']/div[@class='ng-scope']/div[@class='wrapper-tasks wrapper-tasks-workspace ng-scope ng-isolate-scope']/div[@class='ng-scope']/div[@class='content']/div[@class='col-left']/ul/li[1]/div[1]/div[2]/span[1]"))
				.click();

		common.pause(30);

		System.out.println("Step :: Click on Mark this task as completed");
		common.log("Step :: Click on Mark this as completed");
		driver.findElement(By.xpath("//span[contains(text(),'Mark this task as completed')]")).click();

		common.pause(40);

		System.out.println("Step :: Click on Add task button");
		common.log("Step :: Click on Add task button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-scope ng-isolate-scope']"))
				.click();

		common.pause(70);

		// common.Scrollpage();

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		String tasknameval = driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']"))
				.getText();
		System.out.println("Step :: Click on Save changes button" + tasknameval);
		common.log("Step :: Click on Save changes button" + tasknameval);

		String prorityval = driver.findElement(By.xpath("//div[@class='widget-priority inline']//p")).getText();

		System.out.println("Step :: Verfiy Priority validaiton message >>" + prorityval);
		common.log("Step :: Verify Priority validaiton message>>" + prorityval);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");

		String categoryval = driver.findElement(By.xpath("//div[@name='category']//p")).getText();
		System.out.println("Step :: Verify Category validation message >>" + categoryval);
		common.log("Step :: Verify Category validation message" + categoryval);

		common.pause(40);

		String taskname = common.generateRandomChars(5);
		System.out.println("Step :: Enter the Task name >> " + taskname);
		common.log("Step :: Ennter the Task name >>" + taskname);
		driver.findElement(By.xpath("//label[@class='widget-label required ng-binding ng-isolate-scope']//..//input"))
				.sendKeys(taskname);

		System.out.println("Step :: Click on Priority Normal Radio button");
		common.log("Step :: Click Priority Normal Radio button");
		driver.findElement(By.xpath(
				"//div[@class='section-boxed box wrapper-tab-main ng-scope ng-isolate-scope']//div[@class='wrapper-fields-group']//li[2]"))
				.click();

		JavascriptExecutor jse4 = (JavascriptExecutor) driver;
		jse4.executeScript("window.scrollBy(0,500)", "");

		System.out.println("Step :: Select categry as Accounting");
		common.log("Step :: Select category as Accounting");
		driver.findElement(By.xpath("//div[@name='category']//li[1]")).click();

		System.out.println("Step :: Click on Sub category dropdown");
		common.log("Step :: Click on Sub category dropdown");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope has-error']//div[@class='arrow']"))
				.click();
		common.pause(10);
		System.out.println("Step :: Select Sub category as accounting");
		common.log("Step :: Select Sub category as accounting");
		driver.findElement(By.xpath("//div[@placeholder='Select Subcategory']//ul//li[1]")).click();

		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		jse5.executeScript("window.scrollBy(0,500)", "");

		System.out.println("Step :: Click on Property Info Type");
		common.log("Step :: Click on Property Info Type");
		driver.findElement(By.xpath(
				"//div[@name='type']//div[@class='field-list flex']//div[1]//div[1]//ng-include[1]//div[1]//div[1]"))
				.click();

		// common.Scrollpage();

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();
		common.pause(30);

		System.out.println("Step :: Click on check box for complete tasks");
		common.log("Step :: Click on checkbox for complete tasks");
		driver.findElement(By.xpath(
				"//body[@class='ng-scope block-ui block-ui-anim-fade']/div[@class='ng-scope']/ui-view[@class='ng-scope']/div[@class='snap-content ng-scope']/div[@class='layout-main']/div[@class='wrapper-columns']/div[@class='wrapper-columns-column region-main ng-isolate-scope']/div[@class='content-column']/div[@class='content-main table']/div[@class='zone-content']/div[@class='region-content ng-scope']/div[@class='ng-scope']/div[@class='ng-scope']/div[@class='wrapper-tasks wrapper-tasks-workspace ng-scope ng-isolate-scope']/div[@class='ng-scope']/div[@class='content']/div[@class='col-left']/ul/li[1]/div[1]/div[2]/span[1]"))
				.click();

		common.pause(30);

		System.out.println("Step :: Click on Mark this task as completed");
		common.log("Step :: Click on Mark this as completed");
		driver.findElement(By.xpath("//span[contains(text(),'Mark this task as completed')]")).click();

	}

	// Add new Unit Workflow

	public void Add_new_unit_workflow_functionality() {
		common.pause(40);
		System.out.println("Step :: Click Unit section from left menus");
		common.log("Step :: Click unit section from left menus");
		driver.findElement(By.xpath("//a[@href='#/unit-turn']")).click();
		common.pause(25);
		System.out.println("Step :: Click on Definew workflow tasks");
		common.log("Step :: Click on Deifne workflow tasks");
		driver.findElement(By.xpath("//a[@ui-sref='unit-turn.workflows'][contains(.,'Define Unit Workflow')]")).click();
		common.pause(35);

		System.out.println("Step :: Click on Add new unitworkflow button");
		common.log("Step ::Click on Add new unitworkflow button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-isolate-scope']")).click();
		common.pause(25);
		System.out.println("Step :: Enter the name in unit work flow field");
		common.log("Step ::Enter the Name in unit work flow field");
		String name = common.generateRandomChars(5);
		driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']//input[@name='value']"))
				.sendKeys(name);

		System.out.println("Step :: Click on Save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		common.pause(30);

		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step :: Click on unitflow");
		common.log("Step ::  Click on unitflow");
		driver.findElement(By.xpath("//li[contains(text(),'By Others')]//icon")).click();

		common.pause(5);
		System.out.println("Step :: Enter the unitwork flow name" + name);
		common.log("Step :: Enter the unitwork flow name" + name);
		driver.findElement(By.xpath("//input[@placeholder='Unit workflow name']")).sendKeys(name);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();
		// div[@class='wrappers-actions table-cell
		// align-right']//icon[@class='ng-isolate-scope
		// inline']//ng-include[@class='ng-scope']//*[local-name()='svg']
		common.pause(25);

		System.out.println("Step :: Click on Add new item button");
		common.log("Step :: Click on Add new item button");
		driver.findElement(By.xpath("//span[contains(.,'Add new item')]")).click();

		common.pause(15);
		String taskname = common.generateRandomChars(3);
		driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']//input[@name='value']"))
				.sendKeys(taskname);
		System.out.println("Step :: Enter the taskname" + taskname);
		common.log("Step :: Enter the taskname" + taskname);

		System.out.println("Step :: Select Normal");
		common.log("Step :: Select Normal");
		driver.findElement(By.xpath("//div[@class='section-boxed box wrapper-tab-main ng-isolate-scope']//li[2]"))
				.click();

		System.out.println("Step :: Select Category");
		common.log("Step :: Select Category");
		driver.findElement(By.xpath("//div[@name='category']//li[2]")).click();

		System.out.println("Step :: Click on Save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();

		common.pause(20);

		System.out.println("Step :: Click On My portfolio");
		common.log("Step :: Click On My portfolio");
		driver.findElement(By.xpath("//a[contains(text(),'My portfolios')]")).click();
		common.pause(60);
		System.out.println("Step :: Click on Unit types");
		common.log("Step :: Click On Unit types");
		driver.findElement(By.xpath("//a[contains(text(),'Unit Types')]")).click();
		common.pause(25);
		System.out.println("Step :: Click on Add new unit type");
		common.log("Step :: Click On Add new unit type");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-isolate-scope']")).click();
		common.pause(25);
		String unittype = common.generateRandomChars(3);
		driver.findElement(By.xpath("//input[@placeholder='Unit Type']")).sendKeys(unittype);
		System.out.println("Step :: Enter Unit type" + unittype);
		common.log("Step :: Enter Unit type" + unittype);

		driver.findElement(By.xpath("//span[@class='btn btn-print ng-binding ng-isolate-scope']")).click();
		common.pause(25);
		System.out.println("Step :: Click Unit section from left menus");
		common.log("Step :: Click unit section from left menus");
		driver.findElement(By.xpath("//a[@href='#/unit-turn']")).click();
		common.pause(35);
		System.out.println("Step :: Click Launch Unit workflow task");
		common.log("Step :: Click Launch Unit workflow task");
		driver.findElement(By.xpath("//a[contains(text(),'Launch Unit Workflow')]")).click();

		common.pause(35);
		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step :: Click on unitflork flow as category");
		common.log("Step :: Click on unitflork flow as category");
		driver.findElement(By.xpath("//li[contains(text(),'By Others')]//icon")).click();

		common.pause(5);
		System.out.println("Step :: Enter the unitwork flow name" + name);
		common.log("Step :: Enter the unitwork flow name" + name);
		driver.findElement(By.xpath("//input[@placeholder='Unit workflow name']")).sendKeys(name);

		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();

		common.pause(15);

		System.out.println("Step :: Click on Launch Unitwork flow");
		common.log("Step :: Click on Launch Unitwork flow");
		driver.findElement(
				By.xpath("//span[@class='inline btn btn-small btn-black ng-binding ng-scope ng-isolate-scope']"))
				.click();
		common.pause(15);
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope disabled']//div[@class='arrow']"))
				.click();

		common.pause(50);

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		common.pause(50);
		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		common.pause(50);
		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[4]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		System.out.println("Step :: Click on Launch button");
		common.log("Step :: Click on Launch button");
		driver.findElement(By.xpath("//span[@class='btn ng-binding ng-isolate-scope']")).click();

		common.pause(25);
		driver.findElement(By.xpath("(//div[contains(@class,'form-checkbox')])[1]")).click();

		System.out.println("Step :: Click on Select button");
		common.log("Step :: Click on Select button");
		driver.findElement(By.xpath("//span[@class='btn ng-binding ng-isolate-scope'][contains(text(),'Select')]"))
				.click();

		common.pause(25);

		System.out.println("Step :: Click on Unitwork flow in progress");
		common.log("Step :: Click on Unitwork flow in progress");
		driver.findElement(By.xpath("//a[contains(text(),'Unit Workflow In Progress')]")).click();

	}

	// general method for add unit task workflow and verify in task
	public void Unittaskworkflow_add_verificaiton_inList() {

		common.pause(40);
		System.out.println("Step :: Click Unit section from left menus");
		common.log("Step :: Click unit section from left menus");
		driver.findElement(By.xpath("//a[@href='#/unit-turn']")).click();
		common.pause(25);
		System.out.println("Step :: Click on Definew workflow tasks");
		common.log("Step :: Click on Deifne workflow tasks");
		driver.findElement(By.xpath("//a[@ui-sref='unit-turn.workflows'][contains(.,'Define Unit Workflow')]")).click();
		common.pause(35);

		System.out.println("Step :: Click on Add new unitworkflow button");
		common.log("Step ::Click on Add new unitworkflow button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-isolate-scope']")).click();
		common.pause(25);
		System.out.println("Step :: Enter the name in unit work flow field");
		common.log("Step ::Enter the Name in unit work flow field");
		String name = common.generateRandomChars(5);
		driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']//input[@name='value']"))
				.sendKeys(name);

		System.out.println("Step :: Click on Save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		common.pause(50);

		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step :: Click on unitflow");
		common.log("Step ::  Click on unitflow");
		driver.findElement(By.xpath("//li[contains(text(),'By Others')]//icon")).click();

		common.pause(5);
		System.out.println("Step :: Enter the unitwork flow name" + name);
		common.log("Step :: Enter the unitwork flow name" + name);
		driver.findElement(By.xpath("//input[@placeholder='Unit workflow name']")).sendKeys(name);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();
		// div[@class='wrappers-actions table-cell
		// align-right']//icon[@class='ng-isolate-scope
		// inline']//ng-include[@class='ng-scope']//*[local-name()='svg']
		common.pause(25);
		WebElement ele = driver.findElement(By.xpath("//div[@class='header']"));

		String taskname = common.generateRandomChars(3);
		if (ele.isDisplayed()) {

			common.pause(25);
			System.out.println("Step :: Click on Add new item button");
			common.log("Step :: Click on Add new item button");
			driver.findElement(By.xpath("//span[contains(.,'Add new item')]")).click();

			driver.findElement(By.xpath(
					"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']//input[@name='value']"))
					.sendKeys(taskname);
			System.out.println("Step :: Enter the taskname" + taskname);
			common.log("Step :: Enter the taskname" + taskname);

			common.pause(25);
			System.out.println("Step :: Select Normal");
			common.log("Step :: Select Normal");
			driver.findElement(By.xpath("//div[@class='section-boxed box wrapper-tab-main ng-isolate-scope']//li[2]"))
					.click();

			System.out.println("Step :: Select Category");
			common.log("Step :: Select Category");
			driver.findElement(By.xpath("//div[@name='category']//li[2]")).click();

			System.out.println("Step :: Click on Save button");
			common.log("Step :: Click on Save button");
			driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();

			common.pause(20);

		}

		else {
			System.out.println("Step :: Button missing");
			common.log("Step :: Button missing");
		}
		common.pause(35);
		System.out.println("Step :: Click on My portfolio section");
		common.log("Step :: Click on My portfolio section");
		driver.findElement(By.xpath("//a[contains(text(),'My portfolios')]")).click();
		common.pause(35);

		// Add new unit

		System.out.println("Step :: Click on Unit section");
		common.log("Step :: Click on Unit section");
		driver.findElement(By.xpath("//a[@ui-sref='portfolios.units'][contains(.,'Unit')]")).click();
		common.pause(25);
		System.out.println("Step :: Click on Add new unit button");
		common.log("Step :: Click on Add new unit button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-isolate-scope']")).click();

		System.out.println("Step :: Click on select unit type dropdown");
		common.log("Step :: Click on select unit type dropdown");
		driver.findElement(By.xpath(
				"//div[@class='form-select-multiple filter-']//div[@class='wrapper-select capitalize ng-isolate-scope']//div[@class='arrow']"))
				.click();
		common.pause(35);

		System.out.println("Step :: select unit type");
		common.log("Step :: select unit type");
		driver.findElement(By.xpath("//div[@placeholder='Select Type']//li[2]")).click();

		System.out.println("Step :: Click on select property");
		common.log("Step :: Click on select property");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope disabled']//div[@class='arrow']"))
				.click();
common.pause(15);
		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		common.pause(50);
		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		common.pause(50);
		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[3]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();
		String unitnumber = common.generateRandomChars(3);
		driver.findElement(By.xpath("//input[@placeholder='Number']")).sendKeys(unitnumber);
		System.out.println("Step :: Enter the unitnumber" + unitnumber);
		common.log("Step :: Enter the unitnumber" + unitnumber);
		common.pause(25);
		driver.findElement(By.xpath("//span[@class='btn btn-print ng-binding ng-isolate-scope']")).click();

		common.pause(40);
		System.out.println("Step :: Navigate Unit workflow section");
		common.log("Step :: Navigate Unit workflow section");
		driver.findElement(By.xpath("//a[@ui-sref='unit-turn'][contains(.,'Unit Workflow')]")).click();

		common.pause(25);
		System.out.println("Step :: Click on launch unit workflow");
		common.log("Step :: Click on launch unit workflow");
		driver.findElement(By.xpath("//a[contains(.,'Launch Unit Workflow')]")).click();

		//
		common.pause(40);
		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step :: Click on unitflork flow as Name");
		common.log("Step :: Click on unitflork flow as Name");
		driver.findElement(By.xpath("//li[contains(text(),'By Others')]//icon")).click();

		common.pause(5);
		System.out.println("Step :: Enter the unitwork flow name>>" + name);
		common.log("Step :: Enter the unitwork flow name>>" + name);
		driver.findElement(By.xpath("//input[@placeholder='Unit workflow name']")).sendKeys(name);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();
		common.pause(25);
		System.out.println("Step :: Click on launch unitworkflow button");
		common.log("Step :: Click on launch unitworkflow button");
		driver.findElement(By.xpath("//div[@class='header']//span[1]")).click();

		common.pause(20);

		System.out.println("Step :: Click on select property");
		common.log("Step :: Click on select property");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope disabled']//div[@class='arrow']"))
				.click();
		common.pause(15);
		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		common.pause(50);
		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		common.pause(50);
		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[3]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(25);

		System.out.println("Step :: Click on launch button");
		common.log("Step :: Click on launch button");
		driver.findElement(By.xpath("//span[@class='btn ng-binding ng-isolate-scope']")).click();

		System.out.println("Step :: Enter the Unit number");
		common.log("Step :: Enter the Unit number");
		driver.findElement(By.xpath("//input[@placeholder='Unit Number']")).sendKeys(unitnumber);
		common.pause(15);
		System.out.println("Step :: Click on Filter button");
		common.log("Step :: Click on filter button");
		driver.findElement(By.xpath("//span[@class='btn left ng-binding ng-isolate-scope']")).click();

		common.pause(40);
		System.out.println("Step :: Select Unit>>" + unitnumber);
		common.log("Step ::Select Unit>>" + unitnumber);
		driver.findElement(
				By.xpath("(//div[@class='td field-number ng-binding'][contains(.,'" + unitnumber + "')])//..//div[1]"))
				.click();

		System.out.println("Step :: Click on Select");
		common.log("Step :: Click on Select");
		driver.findElement(By.xpath("//span[contains(text(),'Select')]")).click();

		common.pause(30);

		// step:17
		System.out.println("Step :: Click on Unit task workflow section");
		common.log("Step ::Click on Unit task workflow section");
		driver.findElement(By.xpath("//a[@ui-sref='unit-turn'][contains(.,'Unit Workflow')]")).click();

		common.pause(55);

		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step :: Click on unitflork flow as Name");
		common.log("Step :: Click on unitflork flow as Name");
		driver.findElement(By.xpath("//li[contains(text(),'By Others')]//li[2]")).click();

		common.pause(5);

		System.out.println("Step :: Enter the unitwork flow name>>" + name);
		common.log("Step :: Enter the unitwork flow name>>" + name);
		driver.findElement(By.xpath("//input[@placeholder='Unit workflow name']")).sendKeys(name);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();
		common.pause(25);
		// driver.findElement(By.xpath("//div[@class='arrow arrow-up']")).click();
		common.pause(15);

		// WebElement tname = driver.findElement(By.xpath("//td[@class='field-name
		// ng-binding']"));
		String sd = driver.findElement(By.xpath("//td[@class='field-name ng-binding']")).getText();
		System.out.println("Step :: Verify the unittask is present>>" + sd);
		common.log("Step :: Verfiy the unittask is present>> " + sd);

		common.pause(10);

		System.out.println("Step :: Click on expand icon from listed unit worlflows ");
		common.log("Step :: Click on expand icon from listed unit worlflows");
		driver.findElement(
				By.xpath("//td[@class='field-actions']/div[@class='field-options']/div[@class='options']/icon[1]"))
				.click();

		WebElement tr = driver.findElement(By.xpath("//td[@class='field-name']"));
		String templatename = tr.getText();
		System.out.println("Step :: template name>>" + templatename);
		common.log("Step :: template name>>" + templatename);
		common.pause(25);

		System.out.println("Step :: Click Unit section from left menus");
		common.log("Step :: Click unit section from left menus");
		driver.findElement(By.xpath("//a[@href='#/unit-turn']")).click();
		common.pause(25);

		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		common.pause(50);
		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		common.pause(50);
		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[3]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(40);
		// System.out.println("Step :: Click on filter by");
		// common.log("Step :: Click on filter by");
		// driver.findElement(By.xpath("//div[@class='wrapper-select capitalize
		// ng-isolate-scope']//div[@class='arrow']"))
		// .click();
		//
		// System.out.println("Step :: Click on unit number");
		// common.log("Step :: Click on unit number");
		// driver.findElement(By.xpath("//div[@class='zone-header
		// ng-scope']//li[3]")).click();
		//
		// System.out.println("Step :: Enter the unitnumber>>" + unitnumber);
		// common.log("Step :: Enter the unitnumber>>" + unitnumber);
		// driver.findElement(By.xpath("//input[@placeholder='Unit
		// number']")).sendKeys(unitnumber);
		// common.pause(55);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();

	}

	public void AssginUser_in_Unittask() {
		common.pause(40);
		System.out.println("Step :: Click on three dot icon");
		common.log("Step :: Click on three dot icon");
		driver.findElement(
				By.xpath("//div[@class='section-boxed box ng-isolate-scope']//div[@class='content']//icon[2]")).click();

		System.out.println("Step :: Click on assign user from task template");
		common.log("Step :: Click on assign user from task template");
		driver.findElement(By.xpath("//div[@class='content-main table']//li[2]")).click();

		common.pause(30);
		System.out.println("Step :: Click on select user dropdown");
		common.log("Step :: Click on select user drop down");
		driver.findElement(By.xpath("//div[@class='form-select-multiple filter-']//div[@class='arrow']")).click();

		System.out.println("Step :: Click on select user");
		common.log("Step :: Click on select user");
		driver.findElement(By.xpath("//ul[@class='widget-combo-list']//li[1]")).click();

		System.out.println("Step :: Click on assign");
		common.log("Step :: Click on assign");
		driver.findElement(By.xpath("//span[@class='btn ng-binding ng-isolate-scope']")).click();

		common.pause(35);

		String assignuser = driver.findElement(By.xpath("//span[contains(text(),'SM')]")).getAttribute("value");
		System.out.println("Step :: Verify the assigen user name ");
		common.log("Step ::Verify the assigen user name ");

	}

	public void Leave_note_functionality_in_unit_workflow_tasks_with_all_validations() {

		common.pause(40);
		System.out.println("Step :: Click on thee dot for listed task");
		common.log("Step :: Click on thee dot for listed task");
		driver.findElement(
				By.xpath("//div[@class='section-boxed box ng-isolate-scope']//div[@class='content']//icon[2]")).click();

		System.out.println("Step :: Click on Leave note link");
		common.log("Step :: Click on Leave note link");
		driver.findElement(By.xpath("//ul[@class='actions ng-scope']//li[4]")).click();

		System.out.println("Step :: Click on Leave note button");
		common.log("Step :: Click on Leave note button");
		driver.findElement(By.xpath("//span[@class='btn btn-print ng-binding ng-isolate-scope']")).click();
		common.pause(25);
		WebElement val = driver.findElement(By.xpath("//p[@class='error ng-scope ng-binding']"));
		val.getText();
		System.out.println("Step :: Validation message>>" + val);
		common.log("Step :: Validation message>>" + val);

		common.pause(30);
		String note = common.generateRandomChars(5);
		System.out.println("Step :: Enter the note>>" + note);
		common.log("Step :: Enter the note>>" + note);
		driver.findElement(By.xpath("//textarea[@placeholder='Note']")).sendKeys(note);

		System.out.println("Step :: Click on Leave note button");
		common.log("Step :: Click on Leave note button");
		driver.findElement(By.xpath("//span[@class='btn btn-print ng-binding ng-isolate-scope']")).click();

		common.pause(20);
		System.out.println("Step :: Click on note icon ");
		common.log("Step :: Click on  note icon");
		driver.findElement(By.xpath("//div[@class='wrapper-actions right ng-scope']//icon[1]")).click();

		common.pause(25);
		WebElement rea = driver.findElement(By.xpath("//div[contains(text(),'" + note + "')]"));
		System.out.println("Step :: Verfiy the note text >> " + rea);
		common.log("Step :: Verfiy the note text>>" + rea);

	}

	public void Assign_User_functionality_in_unit_workflow_tasks_with_all_validations() {

		common.pause(45);
		System.out.println("Step :: Click on three dot icon");
		common.log("Step :: Click on three dot icon");
		driver.findElement(
				By.xpath("//div[@class='section-boxed box ng-isolate-scope']//div[@class='content']//icon[2]")).click();

		System.out.println("Step :: Click on assign user from task template");
		common.log("Step :: Click on assign user from task template");
		driver.findElement(By.xpath("//div[@class='content-main table']//li[2]")).click();

		common.pause(30);
		System.out.println("Step :: Click on select user dropdown");
		common.log("Step :: Click on select user drop down");
		driver.findElement(By.xpath("//div[@class='form-select-multiple filter-']//div[@class='arrow']")).click();

		System.out.println("Step :: Click on select user");
		common.log("Step :: Click on select user");
		driver.findElement(By.xpath("//ul[@class='widget-combo-list']//li[1]")).click();

		System.out.println("Step :: Click on assign");
		common.log("Step :: Click on assign");
		driver.findElement(By.xpath("//span[@class='btn ng-binding ng-isolate-scope']")).click();

		common.pause(35);

		String assignuser = driver.findElement(By.xpath("//span[contains(text(),'SM')]")).getAttribute("value");
		System.out.println("Step :: Verify the assigen user name ");
		common.log("Step ::Verify the assigen user name ");

	}

	public void Cannot_do_functionality_in_unit_workflow_tasks_with_all_validations() {
		common.pause(30);

		System.out.println("Step :: Click on three dot icon");
		common.log("Step :: Click on three dot icon");
		driver.findElement(
				By.xpath("//div[@class='section-boxed box ng-isolate-scope']//div[@class='content']//icon[2]")).click();

		System.out.println("Step :: Click on can't do ");
		common.log("Step :: Click on can't do");
		driver.findElement(By.xpath("//div[@class='content-main table']//li[6]")).click();

		System.out.println("Step :: Click on Can't do button");
		common.log("Step :: Click on can't do button");
		driver.findElement(By.xpath("//span[@class='btn btn-delete ng-binding ng-isolate-scope']")).click();

		System.out.println("Step ::  Validation message>>");
		common.log("Step :: Validaiton message>>");

		String srt = common.generateRandomChars(3);
		driver.findElement(By.xpath("//textarea[@placeholder='Note']")).sendKeys(srt);
		System.out.println("Step :: Enter the text in note field>>" + srt);
		common.log("Step :: Enter the text in note field>>" + srt);

		System.out.println("Step :: Click on Can't do button");
		common.log("Step :: Click on can't do button");
		driver.findElement(By.xpath("//span[@class='btn btn-delete ng-binding ng-isolate-scope']")).click();

		common.pause(35);

		if (driver.findElement(By.xpath("//div[@class='inline title-inline']")).isDisplayed()) {
			driver.findElement(By.xpath("//div[@class='inline title-inline']")).click();
		} else {
			System.out.println("Step :: Task not found in can't do section");
			common.log("Step :: Task not found in can't do section");
		}

		String cantdotext = driver.findElement(By.xpath("//h4[@class='center task-name ng-binding ng-isolate-scope']"))
				.getAttribute("value");
		System.out.println("Step :: Verify  text in can't do section>>" + cantdotext);
		common.log("Step :: Verify  text in can't do section>>" + cantdotext);

	}

	public void remove_task() {

		System.out.println("Step :: Click Unit section from left menus");
		common.log("Step :: Click unit section from left menus");
		driver.findElement(By.xpath("//a[@href='#/unit-turn']")).click();
		common.pause(20);
		// common.waitForConditionIsElementPresent("//a[@ui-sref='unit-turn.workflows'][contains(.,'Define
		// Unit Workflow')]");
		System.out.println("Step :: Click on Define workflow tasks");
		common.log("Step :: Click on Deifne workflow tasks");
		driver.findElement(By.xpath("//a[@ui-sref='unit-turn.workflows'][contains(.,'Define Unit Workflow')]")).click();
		common.pause(100);

		// common.waitForConditionIsElementPresent("//div[@class='workflow-list
		// ng-scope']/div[2]/div[1]/div[1]/div[2]/div[1]");

		for (int i = 1; i < 30; i++)

		{

			if (driver
					.findElement(By.xpath("//div[@class='workflow-list ng-scope']/div[2]/div[1]/div[1]/div[2]/div[1]"))
					.isDisplayed()) {
				System.out.println("Step :: Click on delete icon");
				common.log("Step :: Click on delete icon");
				driver.findElement(
						By.xpath("//div[@class='workflow-list ng-scope']/div[2]/div[1]/div[1]/div[2]/div[1]")).click();
				common.pause(10);
				System.out.println("Step :: Click on yes ");
				common.log("Step :: Click on yes");
				driver.findElement(By.xpath("//span[@class='btn btn-delete ng-binding ng-isolate-scope']")).click();

				common.pause(35);
			} else {
				break;
			}
		}

	}

	public void Complate_task_functionality_in_unit_workflow_tasks() {
		common.pause(25);
		System.out.println("Step :: Click on check box for complete tasks");
		common.log("Step :: Click on checkbox for complete tasks");
		driver.findElement(
				By.xpath("//div[@class='wrapper-actions right ng-scope']//span[@class='resolve ng-binding ng-scope']"))
				.click();

		common.pause(25);
		System.out.println("Step :: Click on Mark this as completed");
		common.log("Step :: Click on Mark this as completed");
		driver.findElement(By.xpath("//span[@class='btn ng-binding ng-isolate-scope']")).click();

	}

	public void dynamic_form_functionality_in_Unit_workflow_tasks() {
		common.pause(40);
		System.out.println("Step :: Click Unit section from left menus");
		common.log("Step :: Click unit section from left menus");
		driver.findElement(By.xpath("//a[@href='#/unit-turn']")).click();
		common.pause(25);
		System.out.println("Step :: Click on Definew workflow tasks");
		common.log("Step :: Click on Deifne workflow tasks");
		driver.findElement(By.xpath("//a[@ui-sref='unit-turn.workflows'][contains(.,'Define Unit Workflow')]")).click();
		common.pause(35);

		System.out.println("Step :: Click on Add new unitworkflow button");
		common.log("Step ::Click on Add new unitworkflow button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-isolate-scope']")).click();
		common.pause(25);
		System.out.println("Step :: Enter the name in unit work flow field");
		common.log("Step ::Enter the Name in unit work flow field");
		String name = common.generateRandomChars(5);
		driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']//input[@name='value']"))
				.sendKeys(name);

		System.out.println("Step :: Click on Save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		common.pause(30);

		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step :: Click on unitflow");
		common.log("Step ::  Click on unitflow");
		driver.findElement(By.xpath("//li[contains(text(),'By Others')]//icon")).click();

		common.pause(5);
		System.out.println("Step :: Enter the unitwork flow name" + name);
		common.log("Step :: Enter the unitwork flow name" + name);
		driver.findElement(By.xpath("//input[@placeholder='Unit workflow name']")).sendKeys(name);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();
		// div[@class='wrappers-actions table-cell
		// align-right']//icon[@class='ng-isolate-scope
		// inline']//ng-include[@class='ng-scope']//*[local-name()='svg']
		common.pause(25);
		WebElement ele = driver.findElement(By.xpath("//div[@class='header']"));

		String taskname = common.generateRandomChars(3);
		if (ele.isDisplayed()) {

			common.pause(25);
			System.out.println("Step :: Click on Add new item button");
			common.log("Step :: Click on Add new item button");
			driver.findElement(By.xpath("//span[contains(.,'Add new item')]")).click();

			driver.findElement(By.xpath(
					"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']//input[@name='value']"))
					.sendKeys(taskname);
			System.out.println("Step :: Enter the taskname" + taskname);
			common.log("Step :: Enter the taskname" + taskname);

			common.pause(25);
			System.out.println("Step :: Select Normal");
			common.log("Step :: Select Normal");
			driver.findElement(By.xpath("//div[@class='section-boxed box wrapper-tab-main ng-isolate-scope']//li[2]"))
					.click();

			System.out.println("Step :: Click on select from doc manager");
			common.log("Step :: Click on select from doc manager");
			driver.findElement(By.xpath("//span[contains(text(),'Select from Doc Manager')]")).click();
			common.pause(30);

			System.out.println("Step :: Select Df from list");
			common.log("Step :: Select Df from list");
			driver.findElement(By.xpath("//div[@class='box ng-isolate-scope']//li[2]")).click();

			System.out.println("Step :: Click on Select button");
			common.log("Step :: Click on Select button");
			driver.findElement(By.xpath(
					"//ul[@class='actions']//span[@class='btn ng-binding ng-isolate-scope'][contains(text(),'Select')]"))
					.click();
			System.out.println("Step :: Select Category");
			common.log("Step :: Select Category");
			driver.findElement(By.xpath("//div[@name='category']//li[2]")).click();

			System.out.println("Step :: Click on Save button");
			common.log("Step :: Click on Save button");
			driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();

			common.pause(20);

		}

		else {
			System.out.println("Step :: Button missing");
			common.log("Step :: Button missing");
		}
		common.pause(35);
		System.out.println("Step :: Click on My portfolio section");
		common.log("Step :: Click on My portfolio section");
		driver.findElement(By.xpath("//a[contains(text(),'My portfolios')]")).click();
		common.pause(25);

		// Add new unit

		System.out.println("Step :: Click on Unit section");
		common.log("Step :: Click on Unit section");
		driver.findElement(By.xpath("//a[@ui-sref='portfolios.units'][contains(.,'Unit')]")).click();
		common.pause(25);
		System.out.println("Step :: Click on Add new unit button");
		common.log("Step :: Click on Add new unit button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-isolate-scope']")).click();
		common.pause(35);
		System.out.println("Step :: Click on select unit type dropdown");
		common.log("Step :: Click on select unit type dropdown");
		driver.findElement(By.xpath(
				"//div[@class='form-select-multiple filter-']//div[@class='wrapper-select capitalize ng-isolate-scope']//div[@class='arrow']"))
				.click();
		common.pause(35);

		System.out.println("Step :: select unit type");
		common.log("Step :: select unit type");
		driver.findElement(By.xpath("//div[@placeholder='Select Type']//li[2]")).click();

		System.out.println("Step :: Click on select property");
		common.log("Step :: Click on select property");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope disabled']//div[@class='arrow']"))
				.click();

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		common.pause(50);
		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		common.pause(50);
		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[3]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();
		String unitnumber = common.generateRandomChars(3);
		driver.findElement(By.xpath("//input[@placeholder='Number']")).sendKeys(unitnumber);
		System.out.println("Step :: Enter the unitnumber" + unitnumber);
		common.log("Step :: Enter the unitnumber" + unitnumber);

		driver.findElement(By.xpath("//span[@class='btn btn-print ng-binding ng-isolate-scope']")).click();

		common.pause(40);
		System.out.println("Step :: Navigate Unit workflow section");
		common.log("Step :: Navigate Unit workflow section");
		driver.findElement(By.xpath("//a[@ui-sref='unit-turn'][contains(.,'Unit Workflow')]")).click();

		common.pause(25);
		System.out.println("Step :: Click on launch unit workflow");
		common.log("Step :: Click on launch unit workflow");
		driver.findElement(By.xpath("//a[contains(.,'Launch Unit Workflow')]")).click();

		//
		common.pause(40);
		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step :: Click on unitflork flow as Name");
		common.log("Step :: Click on unitflork flow as Name");
		driver.findElement(By.xpath("//li[contains(text(),'By Others')]//icon")).click();

		common.pause(5);
		System.out.println("Step :: Enter the unitwork flow name>>" + name);
		common.log("Step :: Enter the unitwork flow name>>" + name);
		driver.findElement(By.xpath("//input[@placeholder='Unit workflow name']")).sendKeys(name);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();
		common.pause(25);
		System.out.println("Step :: Click on launch unitworkflow button");
		common.log("Step :: Click on launch unitworkflow button");
		driver.findElement(By.xpath("//div[@class='header']//span[1]")).click();

		common.pause(20);

		System.out.println("Step :: Click on select property");
		common.log("Step :: Click on select property");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope disabled']//div[@class='arrow']"))
				.click();
		common.pause(15);
		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		common.pause(50);
		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		common.pause(50);
		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[3]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(25);

		System.out.println("Step :: Click on launch button");
		common.log("Step :: Click on launch button");
		driver.findElement(By.xpath("//span[@class='btn ng-binding ng-isolate-scope']")).click();

		System.out.println("Step :: Enter the Unit number");
		common.log("Step :: Enter the Unit number");
		driver.findElement(By.xpath("//input[@placeholder='Unit Number']")).sendKeys(unitnumber);

		System.out.println("Step :: Click on Filter button");
		common.log("Step :: Click on filter button");
		driver.findElement(By.xpath("//span[@class='btn left ng-binding ng-isolate-scope']")).click();

		common.pause(40);
		System.out.println("Step :: Select Unit>>" + unitnumber);
		common.log("Step ::Select Unit>>" + unitnumber);
		driver.findElement(
				By.xpath("(//div[@class='td field-number ng-binding'][contains(.,'" + unitnumber + "')])//..//div[1]"))
				.click();

		System.out.println("Step :: Click on Select");
		common.log("Step :: Click on Select");
		driver.findElement(By.xpath("//span[contains(text(),'Select')]")).click();

		common.pause(30);

		// step:17
		System.out.println("Step :: Click on Unit task workflow section");
		common.log("Step ::Click on Unit task workflow section");
		driver.findElement(By.xpath("//a[@ui-sref='unit-turn'][contains(.,'Unit Workflow')]")).click();

		common.pause(55);

		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step :: Click on unitflork flow as Name");
		common.log("Step :: Click on unitflork flow as Name");
		driver.findElement(By.xpath("//li[contains(text(),'By Others')]//li[2]")).click();

		common.pause(5);

		System.out.println("Step :: Enter the unitwork flow name>>" + name);
		common.log("Step :: Enter the unitwork flow name>>" + name);
		driver.findElement(By.xpath("//input[@placeholder='Unit workflow name']")).sendKeys(name);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();
		common.pause(25);
		// driver.findElement(By.xpath("//div[@class='arrow arrow-up']")).click();
		common.pause(15);

		// WebElement tname = driver.findElement(By.xpath("//td[@class='field-name
		// ng-binding']"));
		String sd = driver.findElement(By.xpath("//td[@class='field-name ng-binding']")).getText();
		System.out.println("Step :: Verify the unittask is present>>" + sd);
		common.log("Step :: Verfiy the unittask is present>> " + sd);

		common.pause(10);

		System.out.println("Step :: Click on expand icon from listed unit worlflows ");
		common.log("Step :: Click on expand icon from listed unit worlflows");
		driver.findElement(
				By.xpath("//td[@class='field-actions']/div[@class='field-options']/div[@class='options']/icon[1]"))
				.click();

		WebElement tr = driver.findElement(By.xpath("//td[@class='field-name']"));
		String templatename = tr.getText();
		System.out.println("Step :: template name>>" + templatename);
		common.log("Step :: template name>>" + templatename);
		common.pause(25);

		System.out.println("Step :: Click Unit section from left menus");
		common.log("Step :: Click unit section from left menus");
		driver.findElement(By.xpath("//a[@href='#/unit-turn']")).click();
		common.pause(25);

		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		common.pause(50);
		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		common.pause(50);
		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[3]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(40);
		System.out.println("Step :: Click on filter by");
		common.log("Step :: Click on filter by");
		driver.findElement(By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope']//div[@class='arrow']"))
				.click();

		System.out.println("Step :: Click on unit number");
		common.log("Step :: Click on unit number");
		driver.findElement(By.xpath("//div[@class='zone-header ng-scope']//li[3]")).click();

		System.out.println("Step :: Enter the unitnumber>>" + unitnumber);
		common.log("Step :: Enter the unitnumber>>" + unitnumber);
		driver.findElement(By.xpath("//input[@placeholder='Unit number']")).sendKeys(unitnumber);
		common.pause(55);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();
		common.pause(35);

		System.out.println("Step :: Click on dynamic form icon");
		common.log("Step :: Click on dynamic icon");
		driver.findElement(
				By.xpath("//div[@class='section-boxed box ng-isolate-scope']//div[@class='content']//icon[1]")).click();
		common.pause(35);

		if (driver.findElement(By.xpath("//span[@class='Widget_Label_Description'][contains(text(),'Sagar M')]"))
				.isDisplayed()) {
			System.out.println("Step :: Leonardo user >> Sagar M");
			common.log("Step :: Property name >> Sagar M");
		} else {
			System.out.println("Step :: User  Name mismatching");
			common.log("Step :: User name mismatching");
		}

		common.pause(20);

		System.out.println("Step :: Click on Finsh button");
		common.log("Step :: Click on Finish button");
		driver.findElement(By.xpath("//button[contains(text(),'Finish')]")).click();

		common.pause(25);

	}

	public void Clear_dynamic_form_fields_functionality_in_Unit_workflow_tasks() {

		common.pause(40);
		System.out.println("Step :: Click Unit section from left menus");
		common.log("Step :: Click unit section from left menus");
		driver.findElement(By.xpath("//a[@href='#/unit-turn']")).click();
		common.pause(25);
		System.out.println("Step :: Click on Definew workflow tasks");
		common.log("Step :: Click on Deifne workflow tasks");
		driver.findElement(By.xpath("//a[@ui-sref='unit-turn.workflows'][contains(.,'Define Unit Workflow')]")).click();
		common.pause(35);

		System.out.println("Step :: Click on Add new unitworkflow button");
		common.log("Step ::Click on Add new unitworkflow button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-isolate-scope']")).click();
		common.pause(25);
		System.out.println("Step :: Enter the name in unit work flow field");
		common.log("Step ::Enter the Name in unit work flow field");
		String name = common.generateRandomChars(5);
		driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']//input[@name='value']"))
				.sendKeys(name);

		System.out.println("Step :: Click on Save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		common.pause(30);

		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step :: Click on unitflow");
		common.log("Step ::  Click on unitflow");
		driver.findElement(By.xpath("//li[contains(text(),'By Others')]//icon")).click();

		common.pause(5);
		System.out.println("Step :: Enter the unitwork flow name" + name);
		common.log("Step :: Enter the unitwork flow name" + name);
		driver.findElement(By.xpath("//input[@placeholder='Unit workflow name']")).sendKeys(name);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();
		// div[@class='wrappers-actions table-cell
		// align-right']//icon[@class='ng-isolate-scope
		// inline']//ng-include[@class='ng-scope']//*[local-name()='svg']
		common.pause(25);
		WebElement ele = driver.findElement(By.xpath("//div[@class='header']"));

		String taskname = common.generateRandomChars(3);
		if (ele.isDisplayed()) {

			common.pause(25);
			System.out.println("Step :: Click on Add new item button");
			common.log("Step :: Click on Add new item button");
			driver.findElement(By.xpath("//span[contains(.,'Add new item')]")).click();

			driver.findElement(By.xpath(
					"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']//input[@name='value']"))
					.sendKeys(taskname);
			System.out.println("Step :: Enter the taskname" + taskname);
			common.log("Step :: Enter the taskname" + taskname);

			common.pause(25);
			System.out.println("Step :: Select Normal");
			common.log("Step :: Select Normal");
			driver.findElement(By.xpath("//div[@class='section-boxed box wrapper-tab-main ng-isolate-scope']//li[2]"))
					.click();

			System.out.println("Step :: Click on select from doc manager");
			common.log("Step :: Click on select from doc manager");
			driver.findElement(By.xpath("//span[contains(text(),'Select from Doc Manager')]")).click();
			common.pause(30);

			System.out.println("Step :: Select Df from list");
			common.log("Step :: Select Df from list");
			driver.findElement(By.xpath("//div[@class='box ng-isolate-scope']//li[2]")).click();

			System.out.println("Step :: Click on Select button");
			common.log("Step :: Click on Select button");
			driver.findElement(By.xpath(
					"//ul[@class='actions']//span[@class='btn ng-binding ng-isolate-scope'][contains(text(),'Select')]"))
					.click();
			System.out.println("Step :: Select Category");
			common.log("Step :: Select Category");
			driver.findElement(By.xpath("//div[@name='category']//li[2]")).click();

			System.out.println("Step :: Click on Save button");
			common.log("Step :: Click on Save button");
			driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();

			common.pause(20);

		}

		else {
			System.out.println("Step :: Button missing");
			common.log("Step :: Button missing");
		}
		common.pause(35);
		System.out.println("Step :: Click on My portfolio section");
		common.log("Step :: Click on My portfolio section");
		driver.findElement(By.xpath("//a[contains(text(),'My portfolios')]")).click();
		common.pause(25);

		// Add new unit

		System.out.println("Step :: Click on Unit section");
		common.log("Step :: Click on Unit section");
		driver.findElement(By.xpath("//a[@ui-sref='portfolios.units'][contains(.,'Unit')]")).click();
		common.pause(25);
		System.out.println("Step :: Click on Add new unit button");
		common.log("Step :: Click on Add new unit button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-isolate-scope']")).click();

		System.out.println("Step :: Click on select unit type dropdown");
		common.log("Step :: Click on select unit type dropdown");
		driver.findElement(By.xpath(
				"//div[@class='form-select-multiple filter-']//div[@class='wrapper-select capitalize ng-isolate-scope']//div[@class='arrow']"))
				.click();
		common.pause(35);

		System.out.println("Step :: select unit type");
		common.log("Step :: select unit type");
		driver.findElement(By.xpath("//div[@placeholder='Select Type']//li[2]")).click();

		System.out.println("Step :: Click on select property");
		common.log("Step :: Click on select property");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope disabled']//div[@class='arrow']"))
				.click();

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		common.pause(50);
		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		common.pause(50);
		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[3]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();
		String unitnumber = common.generateRandomChars(3);
		driver.findElement(By.xpath("//input[@placeholder='Number']")).sendKeys(unitnumber);
		System.out.println("Step :: Enter the unitnumber" + unitnumber);
		common.log("Step :: Enter the unitnumber" + unitnumber);

		driver.findElement(By.xpath("//span[@class='btn btn-print ng-binding ng-isolate-scope']")).click();

		common.pause(40);
		System.out.println("Step :: Navigate Unit workflow section");
		common.log("Step :: Navigate Unit workflow section");
		driver.findElement(By.xpath("//a[@ui-sref='unit-turn'][contains(.,'Unit Workflow')]")).click();

		common.pause(25);
		System.out.println("Step :: Click on launch unit workflow");
		common.log("Step :: Click on launch unit workflow");
		driver.findElement(By.xpath("//a[contains(.,'Launch Unit Workflow')]")).click();

		//
		common.pause(40);
		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step :: Click on unitflork flow as Name");
		common.log("Step :: Click on unitflork flow as Name");
		driver.findElement(By.xpath("//li[contains(text(),'By Others')]//icon")).click();

		common.pause(5);
		System.out.println("Step :: Enter the unitwork flow name>>" + name);
		common.log("Step :: Enter the unitwork flow name>>" + name);
		driver.findElement(By.xpath("//input[@placeholder='Unit workflow name']")).sendKeys(name);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();
		common.pause(25);
		System.out.println("Step :: Click on launch unitworkflow button");
		common.log("Step :: Click on launch unitworkflow button");
		driver.findElement(By.xpath("//div[@class='header']//span[1]")).click();

		common.pause(20);

		System.out.println("Step :: Click on select property");
		common.log("Step :: Click on select property");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope disabled']//div[@class='arrow']"))
				.click();
		common.pause(15);
		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		common.pause(50);
		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		common.pause(50);
		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[3]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(25);

		System.out.println("Step :: Click on launch button");
		common.log("Step :: Click on launch button");
		driver.findElement(By.xpath("//span[@class='btn ng-binding ng-isolate-scope']")).click();

		System.out.println("Step :: Enter the Unit number");
		common.log("Step :: Enter the Unit number");
		driver.findElement(By.xpath("//input[@placeholder='Unit Number']")).sendKeys(unitnumber);
		common.pause(5);
		System.out.println("Step :: Click on Filter button");
		common.log("Step :: Click on filter button");
		driver.findElement(By.xpath("//span[@class='btn left ng-binding ng-isolate-scope']")).click();

		common.pause(40);
		System.out.println("Step :: Select Unit>>" + unitnumber);
		common.log("Step ::Select Unit>>" + unitnumber);
		driver.findElement(
				By.xpath("(//div[@class='td field-number ng-binding'][contains(.,'" + unitnumber + "')])//..//div[1]"))
				.click();

		System.out.println("Step :: Click on Select");
		common.log("Step :: Click on Select");
		driver.findElement(By.xpath("//span[contains(text(),'Select')]")).click();

		common.pause(30);

		// step:17
		System.out.println("Step :: Click on Unit task workflow section");
		common.log("Step ::Click on Unit task workflow section");
		driver.findElement(By.xpath("//a[@ui-sref='unit-turn'][contains(.,'Unit Workflow')]")).click();

		common.pause(55);

		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step :: Click on unitflork flow as Name");
		common.log("Step :: Click on unitflork flow as Name");
		driver.findElement(By.xpath("//li[contains(text(),'By Others')]//li[2]")).click();

		common.pause(5);

		System.out.println("Step :: Enter the unitwork flow name>>" + name);
		common.log("Step :: Enter the unitwork flow name>>" + name);
		driver.findElement(By.xpath("//input[@placeholder='Unit workflow name']")).sendKeys(name);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();
		common.pause(25);
		// driver.findElement(By.xpath("//div[@class='arrow arrow-up']")).click();
		common.pause(15);

		// WebElement tname = driver.findElement(By.xpath("//td[@class='field-name
		// ng-binding']"));
		String sd = driver.findElement(By.xpath("//td[@class='field-name ng-binding']")).getText();
		System.out.println("Step :: Verify the unittask is present>>" + sd);
		common.log("Step :: Verfiy the unittask is present>> " + sd);

		common.pause(10);

		System.out.println("Step :: Click on expand icon from listed unit worlflows ");
		common.log("Step :: Click on expand icon from listed unit worlflows");
		driver.findElement(
				By.xpath("//td[@class='field-actions']/div[@class='field-options']/div[@class='options']/icon[1]"))
				.click();

		WebElement tr = driver.findElement(By.xpath("//td[@class='field-name']"));
		String templatename = tr.getText();
		System.out.println("Step :: template name>>" + templatename);
		common.log("Step :: template name>>" + templatename);
		common.pause(25);

		System.out.println("Step :: Click Unit section from left menus");
		common.log("Step :: Click unit section from left menus");
		driver.findElement(By.xpath("//a[@href='#/unit-turn']")).click();
		common.pause(25);

		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		common.pause(50);
		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		common.pause(50);
		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[3]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(40);
		System.out.println("Step :: Click on filter by");
		common.log("Step :: Click on filter by");
		driver.findElement(By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope']//div[@class='arrow']"))
				.click();

		System.out.println("Step :: Click on unit number");
		common.log("Step :: Click on unit number");
		driver.findElement(By.xpath("//div[@class='zone-header ng-scope']//li[3]")).click();

		System.out.println("Step :: Enter the unitnumber>>" + unitnumber);
		common.log("Step :: Enter the unitnumber>>" + unitnumber);
		driver.findElement(By.xpath("//input[@placeholder='Unit number']")).sendKeys(unitnumber);
		common.pause(55);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();
		common.pause(35);

		System.out.println("Step :: Click on dynamic form icon");
		common.log("Step :: Click on dynamic icon");
		driver.findElement(
				By.xpath("//div[@class='section-boxed box ng-isolate-scope']//div[@class='content']//icon[1]")).click();

		// String titletxt = driver.findElement(By.xpath("//h2")).getText();
		// System.out.println("Step :: Form title text" + titletxt);
		// common.log("Step :: Form title text" + titletxt);
		common.pause(20);

		if (driver.findElement(By.xpath(
				"//body[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"))
				.isDisplayed()) {
			System.out.println("Step :: Property name ");
			common.log("Step :: Property name ");
		} else {
			System.out.println("Step :: Property  Name mismatching");
			common.log("Step :: Property name mismatching");
		}
		if (driver.findElement(By.xpath("//span[@class='Widget_Label_Description'][contains(text(),'Sagar M')]"))
				.isDisplayed()) {
			System.out.println("Step :: Leonardo user >> Sagar M");
			common.log("Step :: Property name >> Sagar M");
		} else {
			System.out.println("Step :: User  Name mismatching");
			common.log("Step :: User name mismatching");
		}

		common.pause(20);

		System.out.println("Step :: Click on Clear button");
		common.log("Step :: Click on Clear button");
		driver.findElement(By.xpath("//button[@class='Button Button_Small Button_Delete Inline']")).click();
		common.pause(7);

		System.out.println("Step :: Click on yes clear button");
		common.log("Step :: Click on Yes Clear button");
		driver.findElement(By.xpath("//button[@class='Button Button_Delete Inline']")).click();
		common.pause(7);

	}

	public void Finish_Dynamic_Form() {
		common.pause(40);
		System.out.println("Step :: Click Unit section from left menus");
		common.log("Step :: Click unit section from left menus");
		driver.findElement(By.xpath("//a[@href='#/unit-turn']")).click();
		common.pause(25);
		System.out.println("Step :: Click on Definew workflow tasks");
		common.log("Step :: Click on Deifne workflow tasks");
		driver.findElement(By.xpath("//a[@ui-sref='unit-turn.workflows'][contains(.,'Define Unit Workflow')]")).click();
		common.pause(35);

		System.out.println("Step :: Click on Add new unitworkflow button");
		common.log("Step ::Click on Add new unitworkflow button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-isolate-scope']")).click();
		common.pause(25);
		System.out.println("Step :: Enter the name in unit work flow field");
		common.log("Step ::Enter the Name in unit work flow field");
		String name = common.generateRandomChars(5);
		driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']//input[@name='value']"))
				.sendKeys(name);

		System.out.println("Step :: Click on Save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		common.pause(30);

		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step :: Click on unitflow");
		common.log("Step ::  Click on unitflow");
		driver.findElement(By.xpath("//li[contains(text(),'By Others')]//icon")).click();

		common.pause(5);
		System.out.println("Step :: Enter the unitwork flow name" + name);
		common.log("Step :: Enter the unitwork flow name" + name);
		driver.findElement(By.xpath("//input[@placeholder='Unit workflow name']")).sendKeys(name);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();
		// div[@class='wrappers-actions table-cell
		// align-right']//icon[@class='ng-isolate-scope
		// inline']//ng-include[@class='ng-scope']//*[local-name()='svg']
		common.pause(25);
		WebElement ele = driver.findElement(By.xpath("//div[@class='header']"));

		String taskname = common.generateRandomChars(3);
		if (ele.isDisplayed()) {

			common.pause(25);
			System.out.println("Step :: Click on Add new item button");
			common.log("Step :: Click on Add new item button");
			driver.findElement(By.xpath("//span[contains(.,'Add new item')]")).click();

			driver.findElement(By.xpath(
					"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']//input[@name='value']"))
					.sendKeys(taskname);
			System.out.println("Step :: Enter the taskname" + taskname);
			common.log("Step :: Enter the taskname" + taskname);

			common.pause(25);
			System.out.println("Step :: Select Normal");
			common.log("Step :: Select Normal");
			driver.findElement(By.xpath("//div[@class='section-boxed box wrapper-tab-main ng-isolate-scope']//li[2]"))
					.click();

			System.out.println("Step :: Click on select from doc manager");
			common.log("Step :: Click on select from doc manager");
			driver.findElement(By.xpath("//span[contains(text(),'Select from Doc Manager')]")).click();
			common.pause(30);

			System.out.println("Step :: Select Df from list");
			common.log("Step :: Select Df from list");
			driver.findElement(By.xpath("//div[@class='box ng-isolate-scope']//li[2]")).click();

			System.out.println("Step :: Click on Select button");
			common.log("Step :: Click on Select button");
			driver.findElement(By.xpath(
					"//ul[@class='actions']//span[@class='btn ng-binding ng-isolate-scope'][contains(text(),'Select')]"))
					.click();
			System.out.println("Step :: Select Category");
			common.log("Step :: Select Category");
			driver.findElement(By.xpath("//div[@name='category']//li[2]")).click();

			System.out.println("Step :: Click on Save button");
			common.log("Step :: Click on Save button");
			driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();

			common.pause(20);

		}

		else {
			System.out.println("Step :: Button missing");
			common.log("Step :: Button missing");
		}
		common.pause(35);
		System.out.println("Step :: Click on My portfolio section");
		common.log("Step :: Click on My portfolio section");
		driver.findElement(By.xpath("//a[contains(text(),'My portfolios')]")).click();
		common.pause(25);

		// Add new unit

		System.out.println("Step :: Click on Unit section");
		common.log("Step :: Click on Unit section");
		driver.findElement(By.xpath("//a[@ui-sref='portfolios.units'][contains(.,'Unit')]")).click();
		common.pause(25);
		System.out.println("Step :: Click on Add new unit button");
		common.log("Step :: Click on Add new unit button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-isolate-scope']")).click();

		System.out.println("Step :: Click on select unit type dropdown");
		common.log("Step :: Click on select unit type dropdown");
		driver.findElement(By.xpath(
				"//div[@class='form-select-multiple filter-']//div[@class='wrapper-select capitalize ng-isolate-scope']//div[@class='arrow']"))
				.click();
		common.pause(35);

		System.out.println("Step :: select unit type");
		common.log("Step :: select unit type");
		driver.findElement(By.xpath("//div[@placeholder='Select Type']//li[2]")).click();

		System.out.println("Step :: Click on select property");
		common.log("Step :: Click on select property");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope disabled']//div[@class='arrow']"))
				.click();

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		common.pause(50);
		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		common.pause(50);
		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[3]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();
		String unitnumber = common.generateRandomChars(3);
		driver.findElement(By.xpath("//input[@placeholder='Number']")).sendKeys(unitnumber);
		System.out.println("Step :: Enter the unitnumber" + unitnumber);
		common.log("Step :: Enter the unitnumber" + unitnumber);

		driver.findElement(By.xpath("//span[@class='btn btn-print ng-binding ng-isolate-scope']")).click();

		common.pause(40);
		System.out.println("Step :: Navigate Unit workflow section");
		common.log("Step :: Navigate Unit workflow section");
		driver.findElement(By.xpath("//a[@ui-sref='unit-turn'][contains(.,'Unit Workflow')]")).click();

		common.pause(25);
		System.out.println("Step :: Click on launch unit workflow");
		common.log("Step :: Click on launch unit workflow");
		driver.findElement(By.xpath("//a[contains(.,'Launch Unit Workflow')]")).click();

		//
		common.pause(40);
		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step :: Click on unitflork flow as Name");
		common.log("Step :: Click on unitflork flow as Name");
		driver.findElement(By.xpath("//li[contains(text(),'By Others')]//icon")).click();

		common.pause(5);
		System.out.println("Step :: Enter the unitwork flow name>>" + name);
		common.log("Step :: Enter the unitwork flow name>>" + name);
		driver.findElement(By.xpath("//input[@placeholder='Unit workflow name']")).sendKeys(name);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();
		common.pause(25);
		System.out.println("Step :: Click on launch unitworkflow button");
		common.log("Step :: Click on launch unitworkflow button");
		driver.findElement(By.xpath("//div[@class='header']//span[1]")).click();

		common.pause(20);

		System.out.println("Step :: Click on select property");
		common.log("Step :: Click on select property");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope disabled']//div[@class='arrow']"))
				.click();
		common.pause(15);
		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		common.pause(50);
		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		common.pause(50);
		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[3]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(25);

		System.out.println("Step :: Click on launch button");
		common.log("Step :: Click on launch button");
		driver.findElement(By.xpath("//span[@class='btn ng-binding ng-isolate-scope']")).click();

		System.out.println("Step :: Enter the Unit number");
		common.log("Step :: Enter the Unit number");
		driver.findElement(By.xpath("//input[@placeholder='Unit Number']")).sendKeys(unitnumber);

		System.out.println("Step :: Click on Filter button");
		common.log("Step :: Click on filter button");
		driver.findElement(By.xpath("//span[@class='btn left ng-binding ng-isolate-scope']")).click();

		common.pause(40);
		System.out.println("Step :: Select Unit>>" + unitnumber);
		common.log("Step ::Select Unit>>" + unitnumber);
		driver.findElement(
				By.xpath("(//div[@class='td field-number ng-binding'][contains(.,'" + unitnumber + "')])//..//div[1]"))
				.click();

		System.out.println("Step :: Click on Select");
		common.log("Step :: Click on Select");
		driver.findElement(By.xpath("//span[contains(text(),'Select')]")).click();

		common.pause(30);

		// step:17
		System.out.println("Step :: Click on Unit task workflow section");
		common.log("Step ::Click on Unit task workflow section");
		driver.findElement(By.xpath("//a[@ui-sref='unit-turn'][contains(.,'Unit Workflow')]")).click();

		common.pause(55);

		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step :: Click on unitflork flow as Name");
		common.log("Step :: Click on unitflork flow as Name");
		driver.findElement(By.xpath("//li[contains(text(),'By Others')]//li[2]")).click();

		common.pause(5);

		System.out.println("Step :: Enter the unitwork flow name>>" + name);
		common.log("Step :: Enter the unitwork flow name>>" + name);
		driver.findElement(By.xpath("//input[@placeholder='Unit workflow name']")).sendKeys(name);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();
		common.pause(25);
		// driver.findElement(By.xpath("//div[@class='arrow arrow-up']")).click();
		common.pause(15);

		// WebElement tname = driver.findElement(By.xpath("//td[@class='field-name
		// ng-binding']"));
		String sd = driver.findElement(By.xpath("//td[@class='field-name ng-binding']")).getText();
		System.out.println("Step :: Verify the unittask is present>>" + sd);
		common.log("Step :: Verfiy the unittask is present>> " + sd);

		common.pause(10);

		System.out.println("Step :: Click on expand icon from listed unit worlflows ");
		common.log("Step :: Click on expand icon from listed unit worlflows");
		driver.findElement(
				By.xpath("//td[@class='field-actions']/div[@class='field-options']/div[@class='options']/icon[1]"))
				.click();

		WebElement tr = driver.findElement(By.xpath("//td[@class='field-name']"));
		String templatename = tr.getText();
		System.out.println("Step :: template name>>" + templatename);
		common.log("Step :: template name>>" + templatename);
		common.pause(25);

		System.out.println("Step :: Click Unit section from left menus");
		common.log("Step :: Click unit section from left menus");
		driver.findElement(By.xpath("//a[@href='#/unit-turn']")).click();
		common.pause(25);

		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		common.pause(50);
		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		common.pause(50);
		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[3]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(40);
		System.out.println("Step :: Click on filter by");
		common.log("Step :: Click on filter by");
		driver.findElement(By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope']//div[@class='arrow']"))
				.click();

		System.out.println("Step :: Click on unit number");
		common.log("Step :: Click on unit number");
		driver.findElement(By.xpath("//div[@class='zone-header ng-scope']//li[3]")).click();

		System.out.println("Step :: Enter the unitnumber>>" + unitnumber);
		common.log("Step :: Enter the unitnumber>>" + unitnumber);
		driver.findElement(By.xpath("//input[@placeholder='Unit number']")).sendKeys(unitnumber);
		common.pause(55);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();
		common.pause(35);

		System.out.println("Step :: Click on dynamic form icon");
		common.log("Step :: Click on dynamic icon");
		driver.findElement(
				By.xpath("//div[@class='section-boxed box ng-isolate-scope']//div[@class='content']//icon[1]")).click();

		common.pause(35);

		if (driver.findElement(By.xpath("//span[@class='Widget_Label_Description'][contains(text(),'Sagar M')]"))
				.isDisplayed()) {
			System.out.println("Step :: Leonardo user >> Sagar M");
			common.log("Step :: Property name >> Sagar M");
		} else {
			System.out.println("Step :: User  Name mismatching");
			common.log("Step :: User name mismatching");
		}

		common.pause(20);

		System.out.println("Step :: Click on Finsh button");
		common.log("Step :: Click on Finish button");
		driver.findElement(By.xpath("//button[contains(text(),'Finish')]")).click();

	}

	public void print_Dynamicform() {

		System.out.println("Step :: Click on print icon");
		common.log("Step :: Click on printl icon");
		driver.findElement(By.xpath("//i[@class='icon-print pointer']")).click();

		System.out.println("Step :: Verfiy Print page opened");
		common.log("Step :: Verfiy Pritn page opened");
	}

	public void Undo_task_from_completed_sectoin_in_unitworkflow() {
		System.out.println("Step :: Click on Undo button");
		common.log("Step :: Click on Undo button");
		driver.findElement(By.xpath(
				"//body[@class='ng-scope block-ui block-ui-anim-fade']/div[@class='ng-scope']/ui-view[@class='ng-scope']/div[@class='snap-content ng-scope']/div[@class='layout-main']/div[@class='wrapper-columns']/div[@class='wrapper-columns-column region-main']/div[@class='content-column']/div[@class='content-main table']/div[@class='zone-content']/div[@class='region-content ng-scope']/div[@class='ng-scope']/div[@class='task-layout-two-cols']/div[@class='right']/div[@class='ng-scope']/div[@class='wrapper-tasks ng-scope']/div[@class='content']/div[13]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[2]/span[1]"))
				.click();
	}

	public void Define_Workflow() {
		common.pause(25);
		System.out.println("Step :: Click on Workflow Module");
		common.log("Step :: Click on Workflow Module");
		driver.findElement(By.xpath("//a[@ui-sref='workflows']")).click();

		common.pause(30);

		System.out.println("Step :: Click on Define workflows");
		common.log("Step :: Click on Define Workflows");
		driver.findElement(By.xpath("//a[contains(.,'Define Workflows')]")).click();
		common.pause(25);
		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();
		common.pause(10);
		System.out.println("Step :: Click on property");
		common.log("Step :: Click property");
		driver.findElement(By.xpath("//li[contains(text(),'By Hierarchy')]//li[2]")).click();
		common.pause(10);
		System.out.println("Step :: Click on all property");
		common.log("Step :: Click on all property");
		driver.findElement(By.xpath("//input[@class='capitalize ng-isolate-scope']")).click();

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[4]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(70);

		System.out.println("Step :: Click on Select button");
		common.log("Step :: Click on Select button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-scope ng-isolate-scope']"))
				.click();

		common.pause(35);

		System.out.println("Step :: Click on Add new unit workflow button");
		common.log("Step :: Click on Add new unit workflow button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-isolate-scope']")).click();

		System.out.println("Step :: Click on save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		String str = driver.findElement(By.xpath("//p[@class='error ng-scope ng-binding'][1]")).getText();
		System.out.println("Step :: Verfiy the validaiton message>>" + str);
		common.log("Step ::  Verfiy the validaiton message>>" + str);

		String str1 = driver.findElement(By.xpath("//p[@class='error ng-scope ng-binding'][2]")).getText();
		System.out.println("Step :: Verfiy the validaiton message>>" + str1);
		common.log("Step ::  Verfiy the validaiton message>>" + str1);

		common.pause(20);
		String name = common.generateRandomChars(5);
		driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']//input[@name='value']"))
				.sendKeys(name);
		System.out.println("Step :: Enter the Name of Workflow>>" + name);
		common.log("Step :: Step :: Enter the Name of Workflow>>" + name);

		System.out.println("Step :: Click on save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();
		common.pause(30);

		driver.findElement(By.xpath("//div[@class='arrow']")).click();
		driver.findElement(By.xpath("//li[contains(text(),'By Others')]//li")).click();
		driver.findElement(By.xpath("//input[@placeholder='Workflow name']")).sendKeys(name);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();

		common.pause(25);

		System.out.println("Step :: Verfiy the created workflow is displyed in list>>" + name);
		common.log("Step :: Verfiy the created workflow is displyed in list>>" + name);
		driver.findElement(By.xpath("//div[contains(text(),'" + name + "')]")).isDisplayed();

		System.out.println("Step :: Click on Add new item button");
		common.log("Step :: Click on Add new item button");
		driver.findElement(
				By.xpath("//span[@class='inline btn btn-small btn-black ng-binding ng-scope ng-isolate-scope']"))
				.click();

		common.pause(25);
		System.out.println("Step :: Click on save button");
		common.log("Step :: Click on save button");
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();

		String tasknameval = driver
				.findElement(By.xpath(
						"//div[@class='table-cell wrapper-name']/div[1]//p[@class='error ng-scope ng-binding'][1]"))
				.getText();
		System.out.println("Step :: Task name validaiton" + tasknameval);
		common.log("Step :: Task name validaiton" + tasknameval);

		String prorityval = driver
				.findElement(By.xpath("//div[@name='priority']//p[@class='error ng-scope ng-binding'][1]")).getText();

		System.out.println("Step :: Verfiy Priority validaiton message >>" + prorityval);
		common.log("Step :: Verify Priority validaiton message>>" + prorityval);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");

		String categoryval = driver
				.findElement(By.xpath("//div[@name='category']//p[@class='error ng-scope ng-binding']")).getText();
		System.out.println("Step :: Verify Category validation message >>" + categoryval);
		common.log("Step :: Verify Category validation message" + categoryval);
		common.pause(25);

		String taskname = common.generateRandomChars(3);
		driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']//input[@name='value']"))
				.sendKeys(taskname);
		System.out.println("Step :: Enter the taskname" + taskname);
		common.log("Step :: Enter the taskname" + taskname);

		System.out.println("Step :: Select Normal");
		common.log("Step :: Select Normal");
		driver.findElement(By.xpath("//div[@name='priority']//li[2]")).click();

		System.out.println("Step :: Select Category");
		common.log("Step :: Select Category");
		driver.findElement(By.xpath("//ul[@class='widget-category-selector inline']//li[2]")).click();

		System.out.println("Step :: Click on Save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();

	}

	public void Launch_workflow() {

		common.pause(25);
		System.out.println("Step :: Click on Workflow Module");
		common.log("Step :: Click on Workflow Module");
		driver.findElement(By.xpath("//a[@ui-sref='workflows']")).click();

		common.pause(10);

		System.out.println("Step :: Click on Define workflows");
		common.log("Step :: Click on Define Workflows");
		driver.findElement(By.xpath("//a[contains(.,'Define Workflows')]")).click();
		common.pause(25);
		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();
		common.pause(10);
		System.out.println("Step :: Click on property");
		common.log("Step :: Click property");
		driver.findElement(By.xpath("//li[contains(text(),'By Hierarchy')]//li[2]")).click();
		common.pause(10);
		System.out.println("Step :: Click on all property");
		common.log("Step :: Click on all property");
		driver.findElement(By.xpath("//input[@class='capitalize ng-isolate-scope']")).click();

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[4]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(70);

		System.out.println("Step :: Click on Select button");
		common.log("Step :: Click on Select button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-scope ng-isolate-scope']"))
				.click();

		common.pause(35);

		System.out.println("Step :: Click on Add new unit workflow button");
		common.log("Step :: Click on Add new unit workflow button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-isolate-scope']")).click();

		System.out.println("Step :: Click on save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		String str = driver.findElement(By.xpath("//p[@class='error ng-scope ng-binding'][1]")).getText();
		System.out.println("Step :: Verfiy the validaiton message>>" + str);
		common.log("Step ::  Verfiy the validaiton message>>" + str);

		String str1 = driver.findElement(By.xpath("//p[@class='error ng-scope ng-binding'][2]")).getText();
		System.out.println("Step :: Verfiy the validaiton message>>" + str1);
		common.log("Step ::  Verfiy the validaiton message>>" + str1);

		common.pause(20);
		String name = common.generateRandomChars(5);
		driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']//input[@name='value']"))
				.sendKeys(name);
		System.out.println("Step :: Enter the Name of Workflow>>" + name);
		common.log("Step :: Step :: Enter the Name of Workflow>>" + name);

		System.out.println("Step :: Click on save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();
		common.pause(30);

		driver.findElement(By.xpath("//div[@class='arrow']")).click();
		driver.findElement(By.xpath("//li[contains(text(),'By Others')]//li")).click();
		driver.findElement(By.xpath("//input[@placeholder='Workflow name']")).sendKeys(name);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();

		common.pause(25);

		System.out.println("Step :: Verfiy the created workflow is displyed in list>>" + name);
		common.log("Step :: Verfiy the created workflow is displyed in list>>" + name);
		driver.findElement(By.xpath("//div[contains(text(),'" + name + "')]")).isDisplayed();

		System.out.println("Step :: Click on Add new item button");
		common.log("Step :: Click on Add new item button");
		driver.findElement(
				By.xpath("//span[@class='inline btn btn-small btn-black ng-binding ng-scope ng-isolate-scope']"))
				.click();

		common.pause(25);
		System.out.println("Step :: Click on save button");
		common.log("Step :: Click on save button");
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();

		String tasknameval = driver
				.findElement(By.xpath(
						"//div[@class='table-cell wrapper-name']/div[1]//p[@class='error ng-scope ng-binding'][1]"))
				.getText();
		System.out.println("Step :: Task name validaiton" + tasknameval);
		common.log("Step :: Task name validaiton" + tasknameval);

		String prorityval = driver
				.findElement(By.xpath("//div[@name='priority']//p[@class='error ng-scope ng-binding'][1]")).getText();

		System.out.println("Step :: Verfiy Priority validaiton message >>" + prorityval);
		common.log("Step :: Verify Priority validaiton message>>" + prorityval);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");

		String categoryval = driver
				.findElement(By.xpath("//div[@name='category']//p[@class='error ng-scope ng-binding']")).getText();
		System.out.println("Step :: Verify Category validation message >>" + categoryval);
		common.log("Step :: Verify Category validation message" + categoryval);
		common.pause(25);

		String taskname = common.generateRandomChars(3);
		driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']//input[@name='value']"))
				.sendKeys(taskname);
		System.out.println("Step :: Enter the taskname" + taskname);
		common.log("Step :: Enter the taskname" + taskname);

		System.out.println("Step :: Select Normal");
		common.log("Step :: Select Normal");
		driver.findElement(By.xpath("//div[@name='priority']//li[2]")).click();

		System.out.println("Step :: Select Category");
		common.log("Step :: Select Category");
		driver.findElement(By.xpath("//ul[@class='widget-category-selector inline']//li[2]")).click();

		System.out.println("Step :: Click on Save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
		common.pause(20);
		System.out.println("Step :: Click on Launch workflow section");
		common.log("Step :: Click on Launch workflow section");
		driver.findElement(By.xpath("//a[contains(.,'Launch Workflow')]")).click();

		common.pause(35);
		driver.findElement(By.xpath("//div[@class='arrow']")).click();
		driver.findElement(By.xpath("//li[contains(text(),'By Others')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Workflow name']")).sendKeys(name);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();

		common.pause(35);
		System.out.println("Step :: Click on Launch workflow button");
		common.log("Step :: Click on Launch workflow button");
		driver.findElement(
				By.xpath("//span[@class='inline btn btn-small btn-black ng-binding ng-scope ng-isolate-scope']"))
				.click();
		common.pause(35);
		System.out.println("Step :: Click on select property");
		common.log("Step :: Click on select property");
		driver.findElement(
				By.xpath("//div[@class='wrapper-select capitalize ng-isolate-scope disabled']//div[@class='arrow']"))
				.click();

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='filters']//li[4]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		String date = driver.findElement(By.xpath("//div[@class='wrapper-input relative']//input[@name='value']"))
				.getText();
		System.out.println("Step :: Selected date to begin is >>" + date);
		common.log("Step :: Selected date to begin is >>" + date);

		System.out.println("Step :: Click on launch button");
		common.log("Step :: Click on launch button");
		driver.findElement(By.xpath("//span[@class='btn ng-binding ng-isolate-scope']")).click();

		driver.getCurrentUrl();
		common.pause(30);

	}

	public void Defineworkflow_with_Dynamic_form() {

		common.pause(25);
		System.out.println("Step :: Click on Workflow Module");
		common.log("Step :: Click on Workflow Module");
		driver.findElement(By.xpath("//a[@ui-sref='workflows']")).click();

		common.pause(10);

		System.out.println("Step :: Click on Define workflows");
		common.log("Step :: Click on Define Workflows");
		driver.findElement(By.xpath("//a[contains(.,'Define Workflows')]")).click();
		common.pause(25);
		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();
		common.pause(10);
		System.out.println("Step :: Click on property");
		common.log("Step :: Click property");
		driver.findElement(By.xpath("//li[contains(text(),'By Hierarchy')]//li[2]")).click();
		common.pause(10);
		System.out.println("Step :: Click on all property");
		common.log("Step :: Click on all property");
		driver.findElement(By.xpath("//input[@class='capitalize ng-isolate-scope']")).click();

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(
				By.xpath("//div[@class='form-select-multiple filter-portfolio_dialog']//div[@class='arrow']")).click();

		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//div[@class='table-cell']//li[4]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope ng-isolate-scope']")).click();

		common.pause(70);

		System.out.println("Step :: Click on Select button");
		common.log("Step :: Click on Select button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-scope ng-isolate-scope']"))
				.click();

		common.pause(35);

		System.out.println("Step :: Click on Add new unit workflow button");
		common.log("Step :: Click on Add new unit workflow button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-isolate-scope']")).click();

		System.out.println("Step :: Click on save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		String str = driver.findElement(By.xpath("//p[@class='error ng-scope ng-binding'][1]")).getText();
		System.out.println("Step :: Verfiy the validaiton message>>" + str);
		common.log("Step ::  Verfiy the validaiton message>>" + str);

		String str1 = driver.findElement(By.xpath("//p[@class='error ng-scope ng-binding'][2]")).getText();
		System.out.println("Step :: Verfiy the validaiton message>>" + str1);
		common.log("Step ::  Verfiy the validaiton message>>" + str1);

		common.pause(20);
		String name = common.generateRandomChars(5);
		driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']//input[@name='value']"))
				.sendKeys(name);
		System.out.println("Step :: Enter the Name of Workflow>>" + name);
		common.log("Step :: Step :: Enter the Name of Workflow>>" + name);

		System.out.println("Step :: Click on save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();
		common.pause(30);

		driver.findElement(By.xpath("//div[@class='arrow']")).click();
		driver.findElement(By.xpath("//li[contains(text(),'By Others')]//li")).click();
		driver.findElement(By.xpath("//input[@placeholder='Workflow name']")).sendKeys(name);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();

		common.pause(25);

		System.out.println("Step :: Verfiy the created workflow is displyed in list>>" + name);
		common.log("Step :: Verfiy the created workflow is displyed in list>>" + name);
		driver.findElement(By.xpath("//div[contains(text(),'" + name + "')]")).isDisplayed();

		System.out.println("Step :: Click on Add new item button");
		common.log("Step :: Click on Add new item button");
		driver.findElement(
				By.xpath("//span[@class='inline btn btn-small btn-black ng-binding ng-scope ng-isolate-scope']"))
				.click();

		common.pause(25);
		System.out.println("Step :: Click on save button");
		common.log("Step :: Click on save button");
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();

		String tasknameval = driver
				.findElement(By.xpath(
						"//div[@class='table-cell wrapper-name']/div[1]//p[@class='error ng-scope ng-binding'][1]"))
				.getText();
		System.out.println("Step :: Task name validaiton" + tasknameval);
		common.log("Step :: Task name validaiton" + tasknameval);

		String prorityval = driver
				.findElement(By.xpath("//div[@name='priority']//p[@class='error ng-scope ng-binding'][1]")).getText();

		System.out.println("Step :: Verfiy Priority validaiton message >>" + prorityval);
		common.log("Step :: Verify Priority validaiton message>>" + prorityval);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");

		String categoryval = driver
				.findElement(By.xpath("//div[@name='category']//p[@class='error ng-scope ng-binding']")).getText();
		System.out.println("Step :: Verify Category validation message >>" + categoryval);
		common.log("Step :: Verify Category validation message" + categoryval);
		common.pause(25);

		String taskname = common.generateRandomChars(3);
		driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']//input[@name='value']"))
				.sendKeys(taskname);
		System.out.println("Step :: Enter the taskname" + taskname);
		common.log("Step :: Enter the taskname" + taskname);

		System.out.println("Step :: Select Normal");
		common.log("Step :: Select Normal");
		driver.findElement(By.xpath("//div[@name='priority']//li[2]")).click();

		System.out.println("Step :: Select Category");
		common.log("Step :: Select Category");
		driver.findElement(By.xpath("//ul[@class='widget-category-selector inline']//li[2]")).click();

		System.out.println("Step :: Click on Select from doc manager");
		common.log("Step :: Click on Select from doc manager");
		driver.findElement(By.xpath("//span[contains(text(),'Select from Doc Manager')]")).click();
		common.pause(20);

		System.out.println("Step :: Select the dynamic form from the list");
		common.log("Step :: Select the dynamic form from the list");
		driver.findElement(By.xpath("//div[@class='box ng-isolate-scope']//ul//li[3]")).click();

		driver.findElement(By.xpath(
				"//ul[@class='actions']//span[@class='btn ng-binding ng-isolate-scope'][contains(text(),'Select')]"))
				.click();

		common.pause(25);
		System.out.println("Step :: Click on Save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//span[@class='btn ng-binding ng-isolate-scope']")).click();
	}

	// To_verfify_the_Edit_Delete_fucitonalities_for_Defined_workflow
	public void Edit_Delete_Funcitonality_Workflowtask() {
		common.pause(25);

		System.out.println("Step :: Click on Workflow Module");
		common.log("Step :: Click on Workflow Module");
		driver.findElement(By.xpath("//a[@ui-sref='workflows']")).click();
		common.pause(10);
		System.out.println("Step :: Click on Define workflows");
		common.log("Step :: Click on Define Workflows");
		driver.findElement(By.xpath("//a[contains(.,'Define Workflows')]")).click();
		common.pause(15);
		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step :: Click on property");
		common.log("Step :: Click property");
		driver.findElement(By.xpath("//li[contains(text(),'Property')]")).click();

		System.out.println("Step :: Click on all property");
		common.log("Step :: Click on all property");
		driver.findElement(By.xpath("//input[contains(@value,'All Properties')]")).click();

		System.out.println("Step ::Click on By Portfolio");
		common.log("Step :: Click on By Portfolio");
		driver.findElement(By.xpath("//span[contains(text(),'By Portfolio')]")).click();

		System.out.println("Step ::Click on Select portfolio dropdown");
		common.log("Step :: Click on Select portfolio dropdown");
		driver.findElement(By.xpath(
				"//div[@class='form-select-multiple filter-portfolio_dialog']//input[@class='capitalize ng-scope']"))
				.click();

		System.out.println("Step :: Select Portfolio from list");
		common.log("Step :: Select Portfolio from list");
		driver.findElement(By.xpath("//li[contains(text(),'Portfolio 132321321')]")).click();

		common.pause(40);
		System.out.println("Step :: Click on Property Results");
		common.log("Step :: Click on Property Results");
		driver.findElement(By.xpath(
				"//ul[@class='results']//li[@class='capitalize ng-binding ng-scope'][contains(text(),'property 111')]"))
				.click();

		System.out.println("Step :: Click on Select button");
		common.log("Step :: Click on Select button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-scope']")).click();

		common.pause(35);

		System.out.println("Step :: Click on Add new unit workflow button");
		common.log("Step :: Click on Add new unit workflow button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding']")).click();

		System.out.println("Step :: Click on save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding'][contains(.,'Save')]")).click();

		String str = driver.findElement(By.xpath("//p[@class='error ng-binding']")).getText();
		System.out.println("Step :: Verfiy the validaiton message>>" + str);
		common.log("Step ::  Verfiy the validaiton message>>" + str);

		common.pause(20);
		String name = common.generateRandomChars(5);
		driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength has-error']//input[@name='value']"))
				.sendKeys(name);
		System.out.println("Step :: Enter the Name of Workflow>>" + name);
		common.log("Step :: Step :: Enter the Name of Workflow>>" + name);

		System.out.println("Step :: Click on save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding'][contains(.,'Save')]")).click();

		common.pause(30);

		System.out.println("Step :: Verfiy the created workflow is displyed in list>>" + name);
		common.log("Step :: Verfiy the created workflow is displyed in list>>" + name);
		common.pause(25);

		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		driver.findElement(By.xpath("//li[contains(text(),'Workflow name')]")).click();

		driver.findElement(By.xpath("//input[@placeholder='Workflow name']")).sendKeys(name);

		driver.findElement(By.xpath("//span[@class='icon-filter ng-binding']")).click();
		common.pause(20);

		System.out.println("Step :: Click on Edit icon for listed workflow");
		common.log("Step :: Click on Edit icon for listed workflow");
		driver.findElement(By.xpath("//i[@class='icon-template-edit']")).click();
		common.pause(20);

		String name1 = common.generateRandomChars(2);
		driver.findElement(By.xpath(
				"//div[@class='ng-pristine ng-untouched ng-valid ng-scope ng-isolate-scope ng-valid-required']//input[@name='value']"))
				.sendKeys(name1);
		System.out.println("Step :: Enter the Name of Workflow>>" + name1);
		common.log("Step :: Step :: Enter the Name of Workflow>>" + name1);

		System.out.println("Step :: Click on save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding'][contains(.,'Save')]")).click();

		common.pause(25);
		System.out.println("Step :: Click on Filter By");
		common.log("Step :: Click on Filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		driver.findElement(By.xpath("//li[contains(text(),'Workflow name')]")).click();

		driver.findElement(By.xpath("//input[@placeholder='Workflow name']")).sendKeys(name1);

		common.pause(10);
		System.out.println("Step :: Click on Delete icon");
		common.log("Step :: Click on Delete icon");
		driver.findElement(By.xpath("//i[@class='icon-delete']")).click();

		System.out.println("Step :: Click on Yes button");
		common.log("Step :: Click on Yes button");
		driver.findElement(By.xpath("//span[@class='btn btn-delete ng-binding']")).click();

		System.out.println("Step :: Verfiy the workdlow has been removed from list");
		common.log("Step :: Verfiy the workflow has been removed from list");
	}

	public void Add_task_with_fixed_date_recurrance() throws ParseException {
		common.pause(15);
		System.out.println("Step :: Click on Add action Templates");
		common.log("Step :: Click on Add actionTemplates");
		driver.findElement(By.xpath("//a[@ui-sref='templates'][contains(.,'Templates')]")).click();

		System.out.println("Step :: Click on Add action Templates button");
		common.log("Step :: Click on Add actionTemplates button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-isolate-scope']")).click();
		common.pause(25);
		System.out.println("Step :: Select all property checkbox");
		common.log("Step :: Select all property checkbox");
		driver.findElement(By.xpath("//li[contains(text(),'Account template (All properties)')]")).click();

		System.out.println("Step :: Click on Select button");
		common.log("Step :: Click on Select button");
		driver.findElement(By.xpath("//span[@class='btn ng-binding']")).click();

		common.pause(25);

		String taskname = common.generateRandomChars(4);

		driver.findElement(By.xpath(
				"//div[@class='form-item form-group ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-valid-minlength ng-valid-maxlength']//input[@name='value']"))
				.sendKeys(taskname);
		System.out.println("Step :: Enter the task name" + taskname);
		common.log("Step :: Enter the taskname" + taskname);

		System.out.println("Step :: Select prority as normal");
		common.log("Step :: Select prority as normal");
		driver.findElement(By.xpath("//li[contains(text(),'Normal')]")).click();

		System.out.println("Step :: Select category as accounting");
		common.log("Step :: Select category as accounting");
		driver.findElement(By.xpath("//li[contains(text(),'Accounting')]")).click();

		JavascriptExecutor jse4 = (JavascriptExecutor) driver;
		jse4.executeScript("window.scrollBy(0,1500)", "");
		common.pause(25);
		common.pause(10);
		System.out.println("Step :: Click on Sub category dropdown");
		common.log("Step :: Click on Sub category dropdown");
		driver.findElement(By.xpath("(//div[contains(@class,'arrow')])[7]")).click();
		common.pause(20);
		System.out.println("Step :: Select Sub category as accounting");
		common.log("Step :: Select Sub category as accounting");
		driver.findElement(By.xpath("//div[@placeholder='Select Subcategory']//ul//li[1]")).click();

		System.out.println("Step :: Click on Recurrance dropdown");
		common.log("Step :: Click on Recurrance dropdown");
		driver.findElement(By.xpath("//div[@class='wrapper-select field-recurrence-type left']")).click();

		common.pause(5);

		System.out.println("Step :: Select recurrance as fixed date");
		common.log("Step :: Select recurrance as fixed date");
		driver.findElement(By.xpath("//div[@class='wrapper-select field-recurrence-type left']//select//option[3]"))
				.click();

		common.pause(5);
		System.out.println("Step :: Click on date radio button");
		common.log("Step :: Click on Date radio button");
		driver.findElement(By.xpath("//li[contains(text(),'Date')]")).click();

		System.out.println("Step :: Click on Date picker");
		common.log("Step :: Click on Date picker");
		driver.findElement(By.xpath(
				"//div[@class='form-item form-group form-item-date ng-valid ng-dirty ng-valid-parse ng-valid-required']//input[@name='value']"))
				.click();
		common.pause(25);
		String today = common.tomorrowDate();
		System.out.println("Step ::Future's date " + today + "\n");

		// Click and open the datepickers
		driver.findElement(By.xpath(
				"//div[@class='form-item form-group form-item-date ng-valid ng-dirty ng-valid-parse ng-valid-required']//input[@name='value']"))
				.sendKeys(today);

		// This is from date picker table
		// driver.findElement(By.xpath("//div[@class='datepicker-days']")).sendKeys(today);

		// This are the rows of the from date picker table
		// List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));

		// This are the columns of the from date picker table
		// List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));

		// DatePicker is a table. Thus we can navigate to each cell
		// and if a cell matches with the current date then we will click it.

		System.out.println("Step :: Select the property infor type as residential");
		common.log("Step :: Select the property infor type as residential");
		driver.findElement(By.xpath("//div[contains(text(),'Residential')]")).click();

		System.out.println("Step :: Click on Save changes button");
		common.log("Step :: Click on Save changes button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding']")).click();

		common.pause(20);

		System.out.println("Step :: Enter the taskname in template searchbox");
		common.log("Step :: Enter the taskname in template searchbox");
		driver.findElement(By.xpath("//input[@placeholder='Template Name']")).sendKeys(taskname);

		System.out.println("Step :: Click on Search icon ");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//span[@class='icon-filter ng-binding']")).click();
		common.pause(25);
		String rec = driver.findElement(By.xpath("//div[@class='overflow-ellipsis ng-binding']")).getText();
		System.out.println("Step :: Verfiy the recurrance date >>" + rec);
		common.log("Step :: Verfiy the recurrance date >>+rec");

		System.out.println("Step :: Click on Property task ");
		common.log("Step :: Click on Property task");
		driver.findElement(By.xpath("//a[@href='#/property']")).click();

		common.pause(85);

		if (driver.findElement(By.xpath(
				"//li[@class='task-teaser task-teaser-workspace ng-scope priority-normal']//span[@class='text task-name-inline ng-binding'][contains(text(),'"
						+ taskname + "')]"))
				.isDisplayed()) {
			System.out.println("Step :: Search and click on created taskname>>" + taskname);
			common.log("Step :: Search and click on created taskname>>" + taskname);
			driver.findElement(By.xpath(
					"//li[@class='task-teaser task-teaser-workspace ng-scope priority-normal']//span[@class='text task-name-inline ng-binding'][contains(text(),'"
							+ taskname + "')]"))
					.click();
		} else {
			System.out.println("Step :: Task not displaying on property workspace ");
			common.log("Step :: Task not displaying on property workspace");
		}

	}

	public void On_Demand_instruction_topics() {
		common.pause(15);
		System.out.println("Step :: Click on On demand instruction");
		common.log("Step :: Click on On demand instruction");
		driver.findElement(By.xpath("//a[contains(text(),'On Demand instructions')]")).click();
		common.pause(5);
		String title = driver.findElement(By.xpath("//p[@class='title ng-binding']")).getText();
		System.out.println("Step :: Library page title text >>" + title);
		common.log("Step :: Step :: Library page title text >>" + title);
		common.pause(5);
		String category = driver.findElement(By.xpath("//h2[@class='ng-binding ng-scope ng-isolate-scope']")).getText();
		System.out.println("Step :: Section displayed >>" + category);
		common.log("Step :: Step :: Section displayed >>" + category);
		common.pause(10);
		String topics = driver.findElement(By.xpath("//h2[@class='ng-binding ng-isolate-scope']")).getText();
		System.out.println("Step :: Section displayed >>" + topics);
		common.log("Step :: Step :: Section displayed >>" + topics);

	}

	public void Add_categories_OnDemand_instruction() {
		common.pause(25);
		System.out.println("Step :: Click on On demand instruction");
		common.log("Step :: Click on On demand instruction");
		driver.findElement(By.xpath("//a[contains(text(),'On Demand instructions')]")).click();
		common.pause(25);

		System.out.println("Step :: Click on On edit categories section");
		common.log("Step :: Click on On edit categories section");
		driver.findElement(By.xpath("//li[@class='ng-scope active']//li[2]")).click();
		common.pause(25);

		System.out.println("Step :: Click on On demand category button");
		common.log("Step :: Click on On demand category button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-isolate-scope']")).click();

		common.pause(5);
		// JavascriptExecutor jse4 = (JavascriptExecutor) driver;
		// jse4.executeScript("window.scrollBy(0,500)", "");
		common.pause(15);
		System.out.println("Step :: Click on Save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		if (driver.findElement(By.xpath("//p[@class='error ng-scope ng-binding'][1]")).isDisplayed()) {
			String str = driver.findElement(By.xpath("//p[@class='error ng-scope ng-binding'][1]")).getText();
			System.out.println("Step :: Category field Validation message >>" + str);
			common.log("Step :: Category field validation message >>" + str);
		} else {
			System.out.println("Step :: Validation message missing");
			common.log("Step :: Validation message missing");
		}

		String catname = common.generateRandomChars(5);
		System.out.println("Step :: Enter the category name>>" + catname);
		common.log("Step :: Enter the category name>>" + catname);
		driver.findElement(By.xpath("//input[@placeholder='Please enter a name']")).sendKeys(catname);

		WebElement subarrow = driver
				.findElement(By.xpath("//div[@placeholder='Select Subcategory']//div[@class='arrow']"));

		if (subarrow.isDisplayed()) {
			System.out.println("Step :: Click on Subcategory dropdown");
			common.log("Step :: Click on Subcategory dropdown");
			subarrow.click();
			common.pause(20);
			if (driver.findElement(By.xpath("//ul[@class='widget-combo-list']//li[1]")).isDisplayed()) {
				System.out.println("Step :: select Subcategory item");
				common.log("Step :: Select subcategory item");
				driver.findElement(By.xpath("//ul[@class='widget-combo-list']//li[1]")).click();
			} else {
				System.out.println("Step :: Subcategory item not displaying in list");
				common.log("Step :: Subcategory item not displaying in list");
			}
		} else {
			System.out.println("Step :: Subcategory dropdown missing");
			common.log("Step :: Subcategory dropdown missing");
		}
		common.pause(15);

		System.out.println("Step :: Click on Save button");
		common.log("Step :: Click on Save button");
		driver.findElement(
				By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope'][contains(.,'Save')]"))
				.click();

		common.pause(15);

		System.out.println("Step :: Verfiy the created category on Demand instruction library page and click on it");
		common.log("Step :: Verfiy the created category on Demand instruction library page and click on it");
		driver.findElement(
				By.xpath("//div[@class='col left ng-scope']//ul//li//div[2]//h3[contains(text(),'" + catname + "')]"))
				.click();
		common.pause(25);
		String ti = driver.findElement(By.xpath("//h1[@class='ng-binding']")).getText();
		System.out.println("Step :: Category title matching with created categoryname value>>" + ti);
		common.log("Step :: Category title matching with created categoryname value>>" + ti);
	}

	public void Edit_Delete_Created_category_OnDemandinsturction() {

		common.pause(25);
		System.out.println("Step :: Click on On demand instruction");
		common.log("Step :: Click on On demand instruction");
		driver.findElement(By.xpath("//a[contains(text(),'On Demand instructions')]")).click();
		common.pause(25);

		System.out.println("Step :: Click on On edit categories section");
		common.log("Step :: Click on On edit categories section");
		driver.findElement(By.xpath("//li[@class='ng-scope active']//li[2]")).click();
		common.pause(25);

		System.out.println("Step :: Click on On demand category button");
		common.log("Step :: Click on On demand category button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-isolate-scope']")).click();

		common.pause(5);
		// JavascriptExecutor jse4 = (JavascriptExecutor) driver;
		// jse4.executeScript("window.scrollBy(0,500)", "");
		common.pause(15);
		System.out.println("Step :: Click on Save button");
		common.log("Step :: Click on Save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		if (driver.findElement(By.xpath("//p[@class='error ng-scope ng-binding'][1]")).isDisplayed()) {
			String str = driver.findElement(By.xpath("//p[@class='error ng-scope ng-binding'][1]")).getText();
			System.out.println("Step :: Category field Validation message >>" + str);
			common.log("Step :: Category field validation message >>" + str);
		} else {
			System.out.println("Step :: Validation message missing");
			common.log("Step :: Validation message missing");
		}

		String catname = common.generateRandomChars(5);
		System.out.println("Step :: Enter the category name>>" + catname);
		common.log("Step :: Enter the category name>>" + catname);
		driver.findElement(By.xpath("//input[@placeholder='Please enter a name']")).sendKeys(catname);

		WebElement subarrow = driver
				.findElement(By.xpath("//div[@placeholder='Select Subcategory']//div[@class='arrow']"));

		if (subarrow.isDisplayed()) {
			System.out.println("Step :: Click on Subcategory dropdown");
			common.log("Step :: Click on Subcategory dropdown");
			subarrow.click();
			common.pause(20);
			if (driver.findElement(By.xpath("//ul[@class='widget-combo-list']//li[1]")).isDisplayed()) {
				System.out.println("Step :: select Subcategory item");
				common.log("Step :: Select subcategory item");
				driver.findElement(By.xpath("//ul[@class='widget-combo-list']//li[1]")).click();
			} else {
				System.out.println("Step :: Subcategory item not displaying in list");
				common.log("Step :: Subcategory item not displaying in list");
			}
		} else {
			System.out.println("Step :: Subcategory dropdown missing");
			common.log("Step :: Subcategory dropdown missing");
		}
		common.pause(25);
		System.out.println("Step :: Click on Save button");
		common.log("Step :: Click on Save button");
		driver.findElement(
				By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope'][contains(.,'Save')]"))
				.click();

		common.pause(30);
		System.out.println("Step:: Click on Edit categories");
		common.log("Steps :: CLick on Edit categories");
		driver.findElement(By.xpath("//a[contains(text(),'Edit Categories')]")).click();

		common.pause(25);

		System.out.println("Step:: Click on dropdown arrow for filter by");
		common.log("Steps :: CLick on drop down arrow for filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step:: Click on term name");
		common.log("Steps :: CLick on term name");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope']")).click();

		System.out.println("Step:: Enter the category name in searchbox>>" + catname);
		common.log("Steps :: Enter the category name in searchbox>>" + catname);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(catname);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();
		common.pause(30);

		System.out.println("Step:: Click on edit icon");
		common.log("Steps :: CLick on edit icon");
		driver.findElement(By.xpath("//div[@class='edit']//icon[1]")).click();

		common.pause(30);

		String newcat = common.generateRandomChars(3);
		System.out.println("Steps:: Update the categortyname>>" + newcat);
		common.log("Steps :: Update the categortyname>>" + newcat);
		driver.findElement(By.xpath("//input[@placeholder='Please enter a name']")).sendKeys(newcat);

		System.out.println("Step:: Click on save button");
		common.log("Steps :: CLick on save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();
		common.pause(30);

		System.out.println("Step:: Click on Edit categories");
		common.log("Steps :: CLick on Edit categories");
		driver.findElement(By.xpath("//a[contains(text(),'Edit Categories')]")).click();

		common.pause(15);
		common.log("Steps :: CLick on drop down arrow for filter By");
		driver.findElement(By.xpath("//div[@class='arrow']")).click();

		System.out.println("Step:: Click on term name");
		common.log("Steps :: CLick on term name");
		driver.findElement(By.xpath("//li[@class='capitalize ng-binding ng-scope']")).click();

		System.out.println("Step:: Enter the category name in searchbox>>" + newcat);
		common.log("Steps :: Enter the category name in searchbox>>" + newcat);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(newcat);

		System.out.println("Step :: Click on Search icon");
		common.log("Step :: Click on Search icon");
		driver.findElement(By.xpath("//div[@class='wrappers-actions table-cell align-right']//icon[1]")).click();
		common.pause(30);

		String newcatname = driver.findElement(By.xpath("//h3[@class='ng-binding']")).getText();
		System.out.println("Steps:: Verfiy the updated category name>>" + newcatname);
		common.log("Steps :: Verfiy the updated category name>>" + newcatname);

		common.pause(10);

		System.out.println("Steps:: Click on delete icon");
		common.log("Steps :: CLick on delete icon");
		driver.findElement(By.xpath("//div[@class='edit']//icon[2]")).click();

		common.pause(5);
		System.out.println("Steps:: Click on Yes button");
		common.log("Steps :: CLick on Yes button");
		driver.findElement(By.xpath("//span[@class='btn btn-delete ng-binding ng-isolate-scope']")).click();
	}

	public void Add_OnDemand_Subcategory() {
		common.pause(25);
		System.out.println("Step :: Click on On demand instruction");
		common.log("Step :: Click on On demand instruction");
		driver.findElement(By.xpath("//a[contains(text(),'On Demand instructions')]")).click();
		common.pause(25);

		System.out.println("Step :: Click on On Edit subcategories");
		common.log("Step :: Click on On Edit subcategories");
		driver.findElement(By.xpath("//a[contains(text(),'Edit Subcategories')]")).click();
		common.pause(25);
		System.out.println("Step :: Click on On Add on Demand subcategory button");
		common.log("Step :: Click on On Add on Demand subcategory button");
		driver.findElement(By.xpath("//span[@class='btn btn-black btn-small ng-binding ng-isolate-scope']")).click();

		System.out.println("Step :: Click on On Save button");
		common.log("Step :: Click on On Save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

		String valmessage = driver.findElement(By.xpath("//p[@class='error ng-scope ng-binding'][1]")).getText();
		System.out.println("Step :: Verify the validation message>>" + valmessage);
		common.log("Step :: Verify the validation message>>" + valmessage);

		String subname = common.generateRandomChars(3);
		System.out.println("Step :: Enter the vaue in subcategoryname field" + subname);
		common.log("Step :: Enter the vaue in subcategoryname field" + subname);
		driver.findElement(By.xpath("//input[@placeholder='Please enter a name']")).sendKeys(subname);

		System.out.println("Step :: Click on On Save button");
		common.log("Step :: Click on On Save button");
		driver.findElement(By.xpath("//div[@class='btn btn-small right ng-binding ng-isolate-scope']")).click();

	}

}
