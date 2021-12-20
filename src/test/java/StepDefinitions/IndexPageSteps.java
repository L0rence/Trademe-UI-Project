package StepDefinitions;

import java.util.List;

import org.junit.Assert;


import com.trademe.factory.DriverFactory;
import com.trademe.Pages.IndexPage;
import com.trademe.Pages.JobDetailPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import com.trademe.factory.DriverFactory;
public class IndexPageSteps
{
	private IndexPage indexPage = new IndexPage(DriverFactory.getDriver());
	private static String title;
	private JobDetailPage jobDetailpageObj = new JobDetailPage(DriverFactory.getDriver());

	
	
	@Given("user is on TMSandbox page")
	public void user_is_on_tm_sandbox_page() throws InterruptedException
	{
		System.out.println("Step1: User is on Login Page");
		DriverFactory.getDriver().get("https://www.tmsandbox.co.nz/"); 
		
	}

	@Given("user click on the existing job list")
	public void user_click_on_the_existing_job_list() 
	{
		System.out.println("Step2: User is on the existing job list page");	
		indexPage.ClickOnJobLink();
	}
	@When("user get the title of the page")
	public void user_get_the_title_of_the_page()
	{
		title = indexPage.getIndexPageTitle();
		System.out.println("Title is " + title);
	}
	@Then("user verify the page of the title should be {string}")
	public void user_verify_the_page_of_the_title_should_be(String expectedTitleName)
	{
  		System.out.println("Step 3: Verify the page of the title ");
		System.out.println("Title of the page is " + expectedTitleName);
		Assert.assertEquals(expectedTitleName, "Plumber | Trade Me Jobs");
	}
	@Then("user get on jobs detailed page and verify the information details")
	public void user_get_on_jobs_detailed_page_and_verify_the_information_details()
	{
	    System.out.println("Step 4: User verify the job information details ");
	    String Exp_JobTitle = jobDetailpageObj.getJobDetailsPageTite();
	    Assert.assertEquals(Exp_JobTitle, "TRADEME SANDBOX - Buy online and sell with NZ's #1 auction & classifieds site | Trade Me SANDBOX");
	    System.out.println("Job title is " + Exp_JobTitle);
	     
	    String JobtitleTxtIsDisplayed = jobDetailpageObj.getJobTitleTxt();
	    System.out.println("Job Title text is Displayed " + JobtitleTxtIsDisplayed);
	    Assert.assertEquals(JobtitleTxtIsDisplayed,"Plumber");
	     
	     String companyName = jobDetailpageObj.companyNameIsDisplayed();
	     System.out.println("Company name is " + companyName);
	     Assert.assertEquals(companyName,"Halo Industries");
	     
	     String Joblocation = jobDetailpageObj.jobLocation();
	     System.out.println("Job location is " + Joblocation);
	     Assert.assertEquals(Joblocation,"Tauranga, Bay Of Plenty");
	     
	}


	

	

}
