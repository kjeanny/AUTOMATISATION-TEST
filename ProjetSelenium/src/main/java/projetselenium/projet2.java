package projetselenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;

public class projet2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			
			WebDriverManager.chromedriver().setup();
			
			WebDriver driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			
			driver.get("https://www.udemy.com/");
			
			driver.navigate().to("https://www.amazon.com/");
			
			System.out.println(driver.getTitle());
			
			//Maximiser l'affichage
			driver.manage().window().maximize();
			
			driver.manage().window().minimize();
			
			driver.manage().window().fullscreen();
			
			/*driver.manage().window().getSize().getWidth();
			driver.manage().window().getSize().getHeight();
			Dimension size = driver.manage().window().getSize();
			
			System.out.println(size.getWidth());
			System.out.println(size.getHeight());*/
			
			
			//driver.manage().window().setSize(new Dimension(400,450));
			
			//driver.close();
			//driver.get("https://www.opera.com/download");
			//driver.findElement(By.cssSelector(null));
		}


}
