package test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TesteConta {

	private WebDriver driver;

	private String driverPath = "/home/pabloelt/Workspaces/env/driver/chromedriver";
	private String browserPath = "/usr/bin/vivaldi-stable";
	private String baseUrl = "http://localhost:8080/";

	@Before
	public void setUp() throws Exception {
		System.out.println("Iniciando o browser Chrome");
		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions options = new ChromeOptions();
		options.setBinary(browserPath);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Login
		driver.get(baseUrl+"#/login");
		WebElement inputEmail = driver.findElement(
				By.xpath("/html/body/div[1]/div/div/div/div[1]/main/div/div/div[2]/div/div/form/div/label[1]/div[2]/div/div/input"));
		WebElement inputPass = driver.findElement(
				By.xpath("/html/body/div[1]/div/div/div/div[1]/main/div/div/div[2]/div/div/form/div/label[2]/div[2]/div/div/input"));
		WebElement buttonLogin = driver.findElement(
				By.xpath("/html/body/div[1]/div/div/div/div[1]/main/div/div/div[2]/div/div/form/div/div/button[3]"));
		inputEmail.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		inputEmail.sendKeys("foo@foo.com");
		inputPass.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		inputPass.sendKeys("foofoo");
		buttonLogin.click();
	}

	@Test
	public void testChangeEmailEmptyPassword() throws Exception {
		driver.get(baseUrl+"#/settings");
		WebElement inputEmail = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[1]/label[1]/div[2]/div[1]/div/input"));
		WebElement inputPass = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[1]/label[2]/div[2]/div[1]/div/input"));
		WebElement buttonConfirm = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[1]/div[2]/button"));
		inputEmail.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		inputEmail.sendKeys("foo3@foo.com");
		inputPass.sendKeys(" ");
		buttonConfirm.click();
		driver.findElement(
			By.xpath("/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[1]/label[2]/div[2]/div[2]/div/div"));
	}
	@Test
	public void testChangeEmailWrongPassword() throws Exception {
		driver.get(baseUrl+"#/settings");
		WebElement inputEmail = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[1]/label[1]/div[2]/div[1]/div/input"));
		WebElement inputPass = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[1]/label[2]/div[2]/div[1]/div/input"));
		WebElement buttonConfirm = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[1]/div[2]/button"));
		inputEmail.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		inputEmail.sendKeys("foo3@foo.com");
		inputPass.sendKeys("wrong pass");
		buttonConfirm.click();
		driver.findElement(
			By.xpath("/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[1]/label[2]/div[2]/div[2]/div/div"));

	}
	@Test
	public void testChangeEmailBigText() throws Exception {
		driver.get(baseUrl+"#/settings");
		WebElement inputEmail = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[1]/label[1]/div[2]/div[1]/div/input"));
		WebElement inputPass = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[1]/label[2]/div[2]/div[1]/div/input"));
		WebElement buttonConfirm = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[1]/div[2]/button"));
		inputEmail.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		inputEmail.sendKeys("abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
				"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
				"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
				"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
				"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
				"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
				"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
				"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
				"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
				"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijab@foo.com");
		inputPass.sendKeys("foofoo");
		buttonConfirm.click();
		driver.findElement(
			By.xpath("/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[1]/label[1]/div[2]/div[2]/div/div"));
	}
	@Test
	public void testChangePasswordEmptyNewPassword() throws Exception {
		driver.get(baseUrl+"#/settings");
		WebElement inputNewPass = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[2]/label[1]/div[2]/div[1]/div/input"));
		WebElement inputOldPass = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[2]/label[2]/div[2]/div[1]/div/input"));
		WebElement buttonConfirm = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[2]/div/button"));
		inputNewPass.sendKeys(" ");
		inputOldPass.sendKeys("foofoo");
		buttonConfirm.click();
		driver.findElement(
			By.xpath("/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[2]/label[1]/div[2]/div[2]/div/div"));
	}
	@Test
	public void testChangePasswordEmptyOldPassword() throws Exception {
		driver.get(baseUrl+"#/settings");
		WebElement inputNewPass = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[2]/label[1]/div[2]/div[1]/div/input"));
		WebElement inputOldPass = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[2]/label[2]/div[2]/div[1]/div/input"));
		WebElement buttonConfirm = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[2]/div/button"));
		inputNewPass.sendKeys("foo2foo");
		inputOldPass.sendKeys(" ");
		buttonConfirm.click();
		driver.findElement(
			By.xpath("/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[2]/label[2]/div[2]/div[2]/div/div"));
	}
	@Test
	public void testChangePasswordWrongOldPassword() throws Exception {
		driver.get(baseUrl+"#/settings");
		WebElement inputNewPass = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[2]/label[1]/div[2]/div[1]/div/input"));
		WebElement inputOldPass = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[2]/label[2]/div[2]/div[1]/div/input"));
		WebElement buttonConfirm = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[2]/div/button"));
		inputNewPass.sendKeys("foo2foo");
		inputOldPass.sendKeys("wrongpass");
		buttonConfirm.click();
		driver.findElement(
			By.xpath("/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[2]/label[2]/div[2]/div[2]/div/div"));
	}
	@Test
	public void testChangePasswordNewPasswordBigText() throws Exception {
		driver.get(baseUrl+"#/settings");
		WebElement inputNewPass = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[2]/label[1]/div[2]/div[1]/div/input"));
		WebElement inputOldPass = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[2]/label[2]/div[2]/div[1]/div/input"));
		WebElement buttonConfirm = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[2]/div/button"));
		inputNewPass.sendKeys("abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
				"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
				"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
				"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
				"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
				"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
				"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
				"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
				"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
				"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijab@foo.com");
		inputOldPass.sendKeys("foofoo");
		buttonConfirm.click();
		try {
			driver.findElement(
				By.xpath("/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[2]/label[1]/div[2]/div[2]/div/div"));
		} catch (Exception e) {
			inputNewPass.sendKeys("foofoo");
			inputOldPass.sendKeys("abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
					"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
					"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
					"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
					"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
					"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
					"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
					"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
					"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
					"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijab@foo.com");
			buttonConfirm.click();
			throw e;
		}
	}
	@Test
	public void testChangePasswordHappyPath() throws Exception {
		driver.get(baseUrl+"#/settings");
		WebElement inputNewPass = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[2]/label[1]/div[2]/div[1]/div/input"));
		WebElement inputOldPass = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[2]/label[2]/div[2]/div[1]/div/input"));
		WebElement buttonConfirm = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/main/div/div/div[3]/div[2]/div[2]/div/button"));
		inputNewPass.sendKeys("foo2foo");
		inputOldPass.sendKeys("foofoo");
		buttonConfirm.click();
		driver.findElement(
			By.cssSelector(".q-notification__message"));
		// Change back password
		inputNewPass.sendKeys("foofoo");
		inputOldPass.sendKeys("foo2foo");
		buttonConfirm.click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
