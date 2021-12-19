package com.trademe.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage 
{

	private WebDriver driver;

	//1. By Locator

	private By JobLink = By.xpath("//div[contains(@class,'small job-card-inner card5')]//div[contains(@class,'title')]");

	//2. Constructor of the page class

	public IndexPage(WebDriver driver)
	{
		this.driver =driver;
	}
	//3. Page Actions: Feature (Behavior) of the Page

	public String getIndexPageTitle()
	{
		return driver.getTitle(); 
	}
	public JobDetailPage ClickOnJobLink()
	{
		((JavascriptExecutor)driver).executeScript("scroll(0,900)");
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(JobLink));
		driver.findElement(JobLink).click();
		return new JobDetailPage(driver);
	}

}
