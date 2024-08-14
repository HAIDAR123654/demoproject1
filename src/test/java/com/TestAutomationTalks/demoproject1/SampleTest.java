package com.TestAutomationTalks.demoproject1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SampleTest {

    @BeforeMethod
    public void setUp() {
        WebDriver driver = MyWebDriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
    }

    @Test
	public void test1() throws InterruptedException {
    	WebDriver driver = MyWebDriverManager.getDriver();
    	System.out.println("Executing testMethod1 on thread: " + Thread.currentThread().threadId());
		driver.findElement(By.name("q")).sendKeys("selenium", Keys.ENTER);
		driver.findElement(By.xpath("//div[@jsmodel='b5W85 vNzKHd']")).click();
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test
	public void test2() throws InterruptedException {
		WebDriver driver = MyWebDriverManager.getDriver();
		System.out.println("Executing testMethod2 on thread: " + Thread.currentThread().threadId());
		driver.findElement(By.xpath("//a[text()='About']")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Products')]")).click();
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test
	public void test3() throws InterruptedException {
		WebDriver driver = MyWebDriverManager.getDriver();
		System.out.println("Executing testMethod2 on thread: " + Thread.currentThread().threadId());
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("error_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		String title = driver.getTitle();
		System.out.println(title);
	}

    @AfterMethod
    public void tearDown() {
        MyWebDriverManager.closeDriver();
    }
}

