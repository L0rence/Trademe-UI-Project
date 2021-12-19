package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.trademe.factory.DriverFactory;
import com.trademe.utils.ConfiReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks
{
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfiReader configReader;
	Properties prop;
	
	@Before(order = 0)
	public void getProperty()
	{
		configReader = new ConfiReader();
		prop = configReader.init_prop();
	}
	
	@Before(order=1)
	public void launchBrowser()
	{
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		
		
	}
	
	@After(order=0)
	public void quitBrowser()
	{
		driver.quit();
	}
	@After(order=1)
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			// Take Screenshot
			String ScreenshotName = scenario.getName().replaceAll("", "_");
			byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", ScreenshotName);
		}
	}

}
