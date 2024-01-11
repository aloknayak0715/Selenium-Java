package testngextenttutorial.ExtentTutorial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

	ExtentReports extent;

	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter esr = new ExtentSparkReporter(path);
		esr.config().setReportName("Web Automation Test");
		esr.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(esr);
		extent.setSystemInfo("Tester", "Automation");
	}

	@Test
	public void initalizeDemo() {
		extent.createTest("initialize demo");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		extent.flush();
	}

}
