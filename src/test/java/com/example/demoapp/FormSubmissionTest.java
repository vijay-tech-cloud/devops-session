package com.example.demoapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FormSubmissionTest {

    @Test
    public void testFormSubmission() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/");

        WebElement nameField = driver.findElement(By.id("name"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement messageField = driver.findElement(By.id("message"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        nameField.sendKeys("John Doe");
        emailField.sendKeys("john.doe@example.com");
        messageField.sendKeys("Hello, this is a test message.");
        submitButton.click();

        // Verify that the form submission was successful
        WebElement result = driver.findElement(By.tagName("body"));
        assert(result.getText().contains("Form Submitted"));

        driver.quit();
    }
}
