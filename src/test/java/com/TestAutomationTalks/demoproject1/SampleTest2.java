package com.TestAutomationTalks.demoproject1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SampleTest2 {

    @BeforeMethod
    public void setUp() {
        WebDriver driver = MyWebDriverManager.getDriver();
        driver.get("https://google.com");
    }

    @Test
	public void test1() throws InterruptedException {
    	System.out.println("Executing testMetho4 on thread: " + Thread.currentThread().threadId());
    	WebDriver driver = MyWebDriverManager.getDriver();
		driver.findElement(By.name("q")).sendKeys("selenium", Keys.ENTER);
		driver.findElement(By.xpath("//div[@jsmodel='b5W85 vNzKHd']")).click();
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test
	public void test2() throws InterruptedException {
		System.out.println("Executing testMethod5 on thread: " + Thread.currentThread().threadId());
		WebDriver driver = MyWebDriverManager.getDriver();
		driver.findElement(By.xpath("//a[text()='About']")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Learn more')]")).click();
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test
	public void test3() throws InterruptedException {
		System.out.println("Executing testMethod6 on thread: " + Thread.currentThread().threadId());
		WebDriver driver = MyWebDriverManager.getDriver();
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

