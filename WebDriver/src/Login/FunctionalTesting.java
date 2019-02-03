package Login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FunctionalTesting {

	public static void main(String[] args) {
	System.setProperty("webdriver.chromedriver","E://eclipse//chromedriver_win32.zip.//chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
		WebElement un = driver.findElement(By.name("userName"));
		un.sendKeys("gunjan07");     //for typing
		
		WebElement pw = driver.findElement(By.name("password"));
		pw.sendKeys("dgunjan90");
		
		driver.findElement(By.name("login")).click(); 
	
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fromPort")));
	
		String exp ="Find a Flight: Mercury Tours:";    //expected result
		String act =driver.getTitle();     //actual result
		
		if(exp.equals(act))
		{
			System.out.println("Login is successful");
			boolean actVal= driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[1]")).isSelected();
			boolean expVal=true;
			if(expVal==actVal) {
				System.out.println("def val is selected");
				driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]")).click();
			}
			else {
				
				System.out.println("def val is not selected");
			}
			WebElement p=driver.findElement(By.name("passCount"));
			Select passengers =new Select(p);
			passengers.selectByVisibleText("4");
			
			WebElement df=driver.findElement(By.name("fromPort"));
			Select departing =new Select(df);
			departing.selectByVisibleText("London");
			departing.selectByIndex(6);
			departing.selectByValue("Sydney");
			driver.findElement(By.name("findFlights")) .click();
			
			List<WebElement> inputElements = driver.findElements(By.xpath("//*[@type='radio']")); //Relative xpath
			System.out.println(inputElements.size());
			for(int i=0;i<inputElements.size();i++)
			{
				boolean edi=inputElements.get(i).isEnabled();
				System.out.println(edi);
				
				
			}
			Actions ac=new Actions(driver);
			ac.keyUp(Keys.SHIFT).click(driver.findElement(By.linkText("Home"))).build().perform();
			
			/*File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destFile=new File("D:\\GD\\WebdriverTesting\\myscreenshot.png");
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			
			
		}else
		{
			
			System.out.println("Login is unsuccessful");
		}
		//driver.close();
		System.out.println("the test has ended...");
		driver.quit();
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
