package com.leonardo.pages.abstractpage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.leonardo.init.Common;
import com.leonardo.init.SeleniumInit;

public abstract class AbstractPage extends SeleniumInit {

	Common common = new Common(driver);

	String customFiled1 = common.generateRandomChars(5);

	public int DRIVER_WAIT = 5;

	
	public String LEGACY_LOGIN_TXT_USERNAME_VALUE = "ADMIN";
	public String LEGACY_LOGIN_TXT_PASSWORD_VALUE = "admin";
	public String LEGACY_LOGIN_TXT_USERNAME = "username";
	public String LEGACY_LOGIN_TXT_PASSWORD = "password";
	public String LEGACY_LOGIN_BTN_SUBMIT = "submit";


	/**
	 * Initialize UserAbstractPage.
	 * 
	 * @param Driver
	 */
	public AbstractPage(WebDriver driver) {

		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = (ChromeDriver) driver;
	}

}
