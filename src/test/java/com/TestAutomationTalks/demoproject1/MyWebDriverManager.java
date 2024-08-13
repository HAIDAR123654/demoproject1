package com.TestAutomationTalks.demoproject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyWebDriverManager {
    // ThreadLocal to hold WebDriver instances for each thread
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    // Private constructor to prevent instantiation
    private MyWebDriverManager() {}

    // Method to get the WebDriver instance for the current thread
    public static WebDriver getDriver() {
        // Initialize the WebDriver if it's not already initialized for the current thread
        if (driverThreadLocal.get() == null) {
            driverThreadLocal.set(createDriver());
        }
        return driverThreadLocal.get();
    }

    // Method to create a new WebDriver instance
    private static WebDriver createDriver() {
        // Set up the WebDriver for the desired browser
        return new ChromeDriver();
    }

    // Method to close the WebDriver instance for the current thread
    public static void closeDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}

