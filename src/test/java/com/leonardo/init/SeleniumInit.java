package com.leonardo.init;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.*;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.leonardo.pages.IndexPage;
import com.leonardo.pages.Leonardo_mainpage;

import com.leonardo.pages.abstractpage.AbstractPage;

/**
 * Selenium class Initialization
 * 
 */

// @Listeners({ atu.testng.reports.listeners.ATUReportsListener.class,
// ConfigurationListener.class, MethodListener.class })
public class SeleniumInit implements ILoggerStatus {
	static ExtentTest test;
	static ExtentReports report;

	// public static final String PROCUREURL =
	// "https://inv-pre.qa.procurenetworks.com/auth/login"; // Dynamic Procure
	// URL
	/* Minimum requirement for test configuration */
	protected String testUrl; // Test url
	protected String frontsignupUrl; // Front Signup URL
	protected String seleniumHub; // Selenium hub IP
	protected String seleniumHubPort; // Selenium hub port
	protected String targetBrowser; // Target browser
	protected static String test_data_folder_path = null;
	// screen-shot folder
	protected static String screenshot_folder_path = null;
	public static String currentTest; // current running test

	protected static Logger logger = Logger.getLogger("testing");
	protected ChromeDriver driver;

	private Common common = new Common(driver);

	{
		// System.setProperty("atu.reporter.config", "atu.properties");
	}
	
	/* Page's declaration */

	// protected AbstractPage abstractPage;
	// protected Main_Page mainpage;
	// protected Procure_Inventory procureinventory;
	// protected ProcureNetworks procurenetwork;
	// protected Inventory inventory;
	// protected IndexPage indexpage;
	// protected Procure_Contacts contact;
	// protected Procure_Report report;
	// protected Procure_Admin admin;

	// And many more ...

	/**
	 * Fetches suite-configuration from XML suite file.
	 * 
	 * @param testContext
	 */
	@BeforeTest(alwaysRun = true)
	public void fetchSuiteConfiguration(ITestContext testContext) {

		seleniumHub = testContext.getCurrentXmlTest().getParameter("selenium.host");
		seleniumHubPort = testContext.getCurrentXmlTest().getParameter("selenium.port");
		targetBrowser = testContext.getCurrentXmlTest().getParameter("selenium.browser");
		testUrl = testContext.getCurrentXmlTest().getParameter("selenium.url");

	}
	

	/**
	 * WebDriver initialization
	 * 
	 * @return WebDriver object
	 * @throws Exception
	 * @throws InterruptedException
	 */
	@BeforeMethod(alwaysRun = true)
	// @Parameters("browser")
	public void setUp(Method method) throws Exception {

		// ATU Reports
		// ATUReports.setWebDriver(driver);
		// ATUReports.indexPageDescription = "Auction Software Automation";

		currentTest = method.getName(); // get Name of current test.

		URL remote_grid = new URL("http://" + seleniumHub + ":" + seleniumHubPort + "/wd/hub");

		String SCREENSHOT_FOLDER_NAME = "screenshots";
		String TESTDATA_FOLDER_NAME = "test_data";

		test_data_folder_path = new File(TESTDATA_FOLDER_NAME).getAbsolutePath();
		screenshot_folder_path = new File(SCREENSHOT_FOLDER_NAME).getAbsolutePath();

		DesiredCapabilities capability = null;
		// Check if parameter passed from TestNG is 'firefox'
		if (targetBrowser.equalsIgnoreCase("firefox")) {
			FirefoxProfile profile = new FirefoxProfile();
			// ATUReports.setWebDriver(driver);
			// ATUReports.indexPageDescription = "Test Project";
			profile.setPreference("dom.max_chrome_script_run_time", "999");
			profile.setPreference("dom.max_script_run_time", "999");
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.useDownloadDir", true);
			profile.setPreference("browser.download.manager.showWhenStarting", false);
			profile.setEnableNativeEvents(true);
			profile.setPreference("network.http.use-cache", false);
			capability = DesiredCapabilities.firefox();
			capability.setJavascriptEnabled(true);
			capability.setCapability(FirefoxDriver.PROFILE, profile);
			driver = (ChromeDriver) new RemoteWebDriver(remote_grid, capability);
		}
		// Check if parameter passed as 'chrome private browser'
		else if (targetBrowser.equalsIgnoreCase("chrome")) {
			// set path to chromedriver.exe

			/**
			 * System Property For CircleCI
			 * 
			 */

		//	 System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

			/**
			 * Enable when run on local Machine
			 *  
			 */
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new ChromeDriver(capabilities); // private browser
		}

		else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}

		// String URL = "https://inv-pre.qa.procurenetworks.com/auth/login";

		driver.get(testUrl);

		// indexpage = new IndexPage(driver);

	}

	// ATU Reports Method
	@Test
	public void testNewLogs() throws AWTException, IOException {

		// ATUReports.add("INfo Step", LogAs.INFO, new
		// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		// ATUReports.add("Pass Step", LogAs.PASSED, new
		// CaptureScreen(ScreenshotOf.DESKTOP));
		// WebElement element =
		// driver.findElement(By.xpath("/html/body/div/h1/a"));
		// ATUReports.add("Warning Step", LogAs.WARNING, new
		// CaptureScreen(element));
		// ATUReports.add("Fail step", LogAs.FAILED, new
		// CaptureScreen(ScreenshotOf.DESKTOP));

	}

	/**
	 * After Method {TearDown}
	 * 
	 * @param testResult
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) {

		try {

			String testName = testResult.getName();

			if (!testResult.isSuccess()) {

				/* Print test result to Jenkins Console */
				System.out.println();
				System.out.println("TEST FAILED - " + testName);
				System.out.println();
				// System.out.println("ERROR MESSAGE: "
				// + testResult.getThrowable());
				System.out.println("\n");
				Reporter.setCurrentTestResult(testResult);

				/* Make a screenshot for test that failed */
//				String screenshotName = common.getCurrentTimeStampString() + testName;
//				Reporter.log("<br> <b>Please look to the screenshot - </b>");
//				common.makeScreenshot(driver, screenshotName);
			} else {
				System.out.println("TEST PASSED - " + testName + "\n"); // Print
																		// test
																		// result
																		// to
																		// Jenkins
																		// Console
			}

			driver.manage().deleteAllCookies();
			driver.quit();

		} catch (Throwable throwable) {

		}
	}
	
	

	/**
	 * Log given message to Reporter output.
	 * 
	 * @param msg
	 *            Message/Log to be reported.
	 */
	public static void logMessage(String msg) {
		Reporter.log("<br>" + msg + "</br>");
	}

	/**
	 * Log
	 * 
	 * @param msg
	 * @param logger_status
	 */
	public static void log(String msg, final int logger_status) {

		switch (logger_status) {

		case ILoggerStatus.NORMAL:
			Reporter.log("<br>" + msg + "</br>");
			break;

		case ILoggerStatus.ITALIC:
			log("<i>" + msg + "</i>");
			break;

		case ILoggerStatus.STRONG:
			Reporter.log("<strong>" + msg + "</br>");
			break;
		}
	}

	/**
	 * Log Status
	 * 
	 * @param test_status
	 */
	public static void logStatus(final int test_status) {

		switch (test_status) {

		case ITestStatus.PASSED:
			log("<font color=238E23>--Passed</font>");
			break;

		case ITestStatus.FAILED:
			log("<font color=#FF0000>--Failed</font>");
			break;

		case ITestStatus.SKIPPED:
			log("<font color=#FFFF00>--Skipped</font>");
			break;

		default:
			break;
		}

	}

	/**
	 * Log given message to Reporter output.
	 * 
	 * @param msg
	 *            Message/Log to be reported.
	 */
	protected static void log(String msg) {
		Reporter.log(msg);
	}

	/**
	 * Csv Logic with Two Tokens
	 * 
	 * For Login Feature
	 * 
	 * @return
	 */
	public Object[][] parseCsv() {

		String[][] csvParsingData = null;

		try {

			String strFile = "test_data" + File.separator + "login.csv";

			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int lineNumber = 0, tokenNumber = 0;

			int numberOfLines = 0;
			while ((strLine = br.readLine()) != null)
				lineNumber++;

			numberOfLines = lineNumber;
			System.out.println("numberOfLines: " + numberOfLines);
			csvParsingData = new String[lineNumber][2];

			br.close();
			br = new BufferedReader(new FileReader(strFile));
			lineNumber = 0;

			while ((strLine = br.readLine()) != null) {
				lineNumber++;

				st = new StringTokenizer(strLine, "|");

				while (st.hasMoreTokens()) {

					tokenNumber++;
					String token = st.nextToken();
					System.out.println("Line # " + lineNumber + ", Token # " + tokenNumber + ", Token : " + token);
					csvParsingData[lineNumber - 1][tokenNumber - 1] = token;
				}

				// reset token number
				tokenNumber = 0;

			}

		} catch (Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}

		return csvParsingData;

	}

	/**
	 * Csv Logic with Eight Tokens
	 * 
	 * For Signup Feature
	 * 
	 * @return
	 */
	public Object[][] parseSignUpCsv() {

		String[][] csvParsingData = null;

		try {

			String strFile = "test_data" + File.separator + "signup.csv";

			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int lineNumber = 0, tokenNumber = 0;

			int numberOfLines = 0;
			while ((strLine = br.readLine()) != null)
				lineNumber++;

			numberOfLines = lineNumber;
			System.out.println("numberOfLines: " + numberOfLines);
			csvParsingData = new String[lineNumber][8];

			br.close();
			br = new BufferedReader(new FileReader(strFile));
			lineNumber = 0;

			while ((strLine = br.readLine()) != null) {
				lineNumber++;

				st = new StringTokenizer(strLine, "|");

				while (st.hasMoreTokens()) {

					tokenNumber++;
					String token = st.nextToken();
					System.out.println("Line # " + lineNumber + ", Token # " + tokenNumber + ", Token : " + token);
					csvParsingData[lineNumber - 1][tokenNumber - 1] = token;
				}

				// reset token number
				tokenNumber = 0;

			}

		} catch (Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}

		return csvParsingData;

	}

	/**
	 * Csv Logic with Two Tokens
	 * 
	 * For Login Feature
	 * 
	 * @return
	 */
	public Object[][] parseRegularSignupCsv() {

		String[][] csvParsingData = null;

		try {

			String strFile = "test_data" + File.separator + "regularsignuplogin.csv";

			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int lineNumber = 0, tokenNumber = 0;

			int numberOfLines = 0;
			while ((strLine = br.readLine()) != null)
				lineNumber++;

			numberOfLines = lineNumber;
			System.out.println("numberOfLines: " + numberOfLines);
			csvParsingData = new String[lineNumber][2];

			br.close();
			br = new BufferedReader(new FileReader(strFile));
			lineNumber = 0;

			while ((strLine = br.readLine()) != null) {
				lineNumber++;

				st = new StringTokenizer(strLine, "|");

				while (st.hasMoreTokens()) {

					tokenNumber++;
					String token = st.nextToken();
					System.out.println("Line # " + lineNumber + ", Token # " + tokenNumber + ", Token : " + token);
					csvParsingData[lineNumber - 1][tokenNumber - 1] = token;
				}

				// reset token number
				tokenNumber = 0;

			}

		} catch (Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}

		return csvParsingData;

	}

	/**
	 * Csv Logic with Three Tokens
	 * 
	 * For Login Feature
	 * 
	 * @return
	 */
	public Object[][] parsemissedliveauctionCsv() {

		String[][] csvParsingData = null;

		try {

			String strFile = "test_data" + File.separator + "missedliveaution.csv";

			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int lineNumber = 0, tokenNumber = 0;

			int numberOfLines = 0;
			while ((strLine = br.readLine()) != null)
				lineNumber++;

			numberOfLines = lineNumber;
			System.out.println("numberOfLines: " + numberOfLines);
			csvParsingData = new String[lineNumber][3];

			br.close();
			br = new BufferedReader(new FileReader(strFile));
			lineNumber = 0;

			while ((strLine = br.readLine()) != null) {
				lineNumber++;

				st = new StringTokenizer(strLine, "|");

				while (st.hasMoreTokens()) {

					tokenNumber++;
					String token = st.nextToken();
					System.out.println("Line # " + lineNumber + ", Token # " + tokenNumber + ", Token : " + token);
					csvParsingData[lineNumber - 1][tokenNumber - 1] = token;
				}

				// reset token number
				tokenNumber = 0;

			}

		} catch (Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}

		return csvParsingData;

	}

	/**
	 * Csv Logic with four Tokens
	 * 
	 * For Login Feature
	 * 
	 * @return
	 */
	public Object[][] parsecreateauctionCsv() {

		String[][] csvParsingData = null;

		try {

			String strFile = "test_data" + File.separator + "createauction.csv";

			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int lineNumber = 0, tokenNumber = 0;

			int numberOfLines = 0;
			while ((strLine = br.readLine()) != null)
				lineNumber++;

			numberOfLines = lineNumber;
			System.out.println("numberOfLines: " + numberOfLines);
			csvParsingData = new String[lineNumber][4];

			br.close();
			br = new BufferedReader(new FileReader(strFile));
			lineNumber = 0;

			while ((strLine = br.readLine()) != null) {
				lineNumber++;

				st = new StringTokenizer(strLine, "|");

				while (st.hasMoreTokens()) {

					tokenNumber++;
					String token = st.nextToken();
					System.out.println("Line # " + lineNumber + ", Token # " + tokenNumber + ", Token : " + token);
					csvParsingData[lineNumber - 1][tokenNumber - 1] = token;
				}

				// reset token number
				tokenNumber = 0;

			}

		} catch (Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}

		return csvParsingData;

	}

	/**
	 * Csv Logic with four Tokens
	 * 
	 * For Login Feature
	 * 
	 * @return
	 */
	public Object[][] parseTwoLoginUsersCsv() {

		String[][] csvParsingData = null;

		try {

			String strFile = "test_data" + File.separator + "twouserlogin.csv";

			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int lineNumber = 0, tokenNumber = 0;

			int numberOfLines = 0;
			while ((strLine = br.readLine()) != null)
				lineNumber++;

			numberOfLines = lineNumber;
			System.out.println("numberOfLines: " + numberOfLines);
			csvParsingData = new String[lineNumber][6];

			br.close();
			br = new BufferedReader(new FileReader(strFile));
			lineNumber = 0;

			while ((strLine = br.readLine()) != null) {
				lineNumber++;

				st = new StringTokenizer(strLine, "|");

				while (st.hasMoreTokens()) {

					tokenNumber++;
					String token = st.nextToken();
					System.out.println("Line # " + lineNumber + ", Token # " + tokenNumber + ", Token : " + token);
					csvParsingData[lineNumber - 1][tokenNumber - 1] = token;
				}

				// reset token number
				tokenNumber = 0;

			}

		} catch (Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}

		return csvParsingData;

	}

	/**
	 * Csv Logic with Two Tokens
	 * 
	 * For Login Feature
	 * 
	 * @return
	 */
	public Object[][] parseliveauctionCsv() {

		String[][] csvParsingData = null;

		try {

			String strFile = "test_data" + File.separator + "liveauction.csv";

			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int lineNumber = 0, tokenNumber = 0;

			int numberOfLines = 0;
			while ((strLine = br.readLine()) != null)
				lineNumber++;

			numberOfLines = lineNumber;
			System.out.println("numberOfLines: " + numberOfLines);
			csvParsingData = new String[lineNumber][5];

			br.close();
			br = new BufferedReader(new FileReader(strFile));
			lineNumber = 0;

			while ((strLine = br.readLine()) != null) {
				lineNumber++;

				st = new StringTokenizer(strLine, "|");

				while (st.hasMoreTokens()) {

					tokenNumber++;
					String token = st.nextToken();
					System.out.println("Line # " + lineNumber + ", Token # " + tokenNumber + ", Token : " + token);
					csvParsingData[lineNumber - 1][tokenNumber - 1] = token;
				}

				// reset token number
				tokenNumber = 0;

			}

		} catch (Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}

		return csvParsingData;

	}

	/**
	 * Csv Logic with Four Tokens
	 * 
	 * For Login Feature
	 * 
	 * @return
	 */
	public Object[][] parseAdminUserCsv() {

		String[][] csvParsingData = null;

		try {

			String strFile = "test_data" + File.separator + "adminusers.csv";

			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int lineNumber = 0, tokenNumber = 0;

			int numberOfLines = 0;
			while ((strLine = br.readLine()) != null)
				lineNumber++;

			numberOfLines = lineNumber;
			System.out.println("numberOfLines: " + numberOfLines);
			csvParsingData = new String[lineNumber][5];

			br.close();
			br = new BufferedReader(new FileReader(strFile));
			lineNumber = 0;

			while ((strLine = br.readLine()) != null) {
				lineNumber++;

				st = new StringTokenizer(strLine, "|");

				while (st.hasMoreTokens()) {

					tokenNumber++;
					String token = st.nextToken();
					System.out.println("Line # " + lineNumber + ", Token # " + tokenNumber + ", Token : " + token);
					csvParsingData[lineNumber - 1][tokenNumber - 1] = token;
				}

				// reset token number
				tokenNumber = 0;

			}

		} catch (Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}

		return csvParsingData;

	}

	/**
	 * Generate Random Chars
	 * 
	 * @param length
	 * @return
	 */
	public static String generateRandomChars(int length) {
		String total = "qwertyuioplkjhgfdsazxcvbnm";
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < length; i++) {
			char _char = total.charAt((int) (Math.random() * 100) % total.length());
			buf.append(_char);
		}
		return buf.toString();
	}

	public void setCommon(Common common) {
		this.common = common;
	}
}
