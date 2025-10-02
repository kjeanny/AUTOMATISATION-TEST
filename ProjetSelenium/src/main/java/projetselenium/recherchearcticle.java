package projetselenium;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
public class recherchearcticle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 WebDriverManager.chromedriver().setup();
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 
		 	ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-gpu");
	        options.addArguments("--disable-dev-shm-usage");
	        options.addArguments("--no-sandbox");
	        options.addArguments("--start-maximized");

	        WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	        try {
	            // 1. Accéder à l'application
	            driver.get("https://pos1-demo-prosuma.retail.groupe-asten.fr/"); // Mets ici ton URL réelle
	            
	           		        
	
	            
	            WebElement login= driver.findElement(By.id("username"));
	    		WebElement pwd= driver.findElement(By.id("password"));
	    		login.sendKeys("Administrateur");
	    		pwd.sendKeys("123456789www");
	    		driver.findElement(By.cssSelector("button[type='submit']")).click();
	    		System.out.println("Page title: " + driver.getTitle());
	    		
	    		new WebDriverWait(driver, Duration.ofSeconds(10)).until(
	    			    ExpectedConditions.urlContains("https://pos1-demo-prosuma.retail.groupe-asten.fr/"));
	    		
	    		
	    		  		
	    				
	    		
	    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    		// Clic sur le menu "Articles"
	    		WebElement menuArticles = wait.until(ExpectedConditions.elementToBeClickable(
	    		    By.cssSelector("li[data-iden='products'] > a")
	    		));
	    		menuArticles.click();

	    		// Clic sur le sous-menu "Articles"
	    		WebElement sousMenuArticles = wait.until(ExpectedConditions.elementToBeClickable(
	    		    By.cssSelector("li[data-path='/product/'] > a")
	    		));
	    		sousMenuArticles.click();

	    		// Champ de recherche
	    		WebElement champRecherche = wait.until(ExpectedConditions.visibilityOfElementLocated(
	    		   By.cssSelector("input[ng-enter='search_filter()']")
	    		));
	    		/*champRecherche.sendKeys("100250250");
	    		champRecherche.sendKeys(Keys.ENTER);
	    		champRecherche.click();*/
	    		champRecherche.click();
	    		champRecherche.clear();
	    		champRecherche.sendKeys("100250250");
	    		
	    		System.out.println("Champ trouvé ? " + champRecherche.isDisplayed() + ", enabled ? " + champRecherche.isEnabled());
	    		
	    		
	    		// simulate true Enter key event to trigger ng-enter
	    		JavascriptExecutor js = (JavascriptExecutor) driver;
 
	    		String script = """
	    		    var e = new KeyboardEvent('keydown', {
	    		        bubbles: true,
	    		        cancelable: true,
	    		        key: 'Enter',
	    		        code: 'Enter',
	    		        keyCode: 13,
	    		        which: 13
	    		    });
	    		    arguments[0].dispatchEvent(e);
	    		""";
	    		js.executeScript(script, champRecherche);
	    		
	    		
	    		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    		Path target = Paths.get("failure_" + System.currentTimeMillis() + ".png");
	    		Files.copy(scrFile.toPath(), target);
	    		System.out.println("Screenshot saved to: " + target.toString());
	    	
	    		
	    		/*// 2. Cliquer sur le bouton Rechercher
	    		WebElement boutonRecherche = wait.until(ExpectedConditions.elementToBeClickable(
	    		    By.xpath("//button[contains(text(), 'Rechercher')]")
	    		));
	    		boutonRecherche.click();*/

	    		// 💡 Optionnel : appeler la fonction Angular si le clic ne déclenche rien
	    		//JavascriptExecutor js = (JavascriptExecutor) driver;
	    		//js.executeScript("angular.element(arguments[0]).scope().search_filter();", champRecherche);
	    		
	    		/*// Champ de consultation
	    		WebElement champConsultation = wait.until(ExpectedConditions.elementToBeClickable(
	    		  By.cssSelector("input[ng-click='display_detail($event, item']")
	    		));
	    		champConsultation.click();*/
	    		
	    	
	    		// 1. Trouver le champ
	    		/*WebElement champRecherche = wait.until(ExpectedConditions.elementToBeClickable(
	    		    By.cssSelector("input[ng-enter='search_filter()']")
	    		));

	    		champRecherche.click();
	    		champRecherche.clear();
	    		champRecherche.sendKeys("100250250");

	    		// 2. Forcer l'appel de la fonction AngularJS
	    		JavascriptExecutor js = (JavascriptExecutor) driver;
	    		js.executeScript("angular.element(arguments[0]).scope().search_filter();", champRecherche);

	    		System.out.println("Recherche déclenchée avec search_filter()");*/
	    		
	    		

	            // 2. Cliquer sur le sous-menu Articles
	           // WebElement sousMenuArticles = driver.findElement(By.xpath("//li[@data-path='/product/']/a"));
	           // WebElement sousMenuArticles = driver.findElement(By.xpath("data-iden=products"));
	           // sousMenuArticles.click();
	    		
	    	
	            // 3. Attendre que la page charge (selon ton système, ajouter un petit sleep ou wait explicite)
	            //Thread.sleep(4000); // Remplace par WebDriverWait si nécessaire

	            // 4. Trouver le champ de recherche du code article
	           // WebElement champRecherche = driver.findElement(By.id("Articles")); // adapte l'id exact

	            // 5. Entrer le code article
	           // champRecherche.sendKeys("100250250");

	            // 6. Cliquer sur le bouton Rechercher
	           // WebElement boutonRecherche = driver.findElement(By.xpath("//button[contains(text(), 'Rechercher')]"));
	          //  boutonRecherche.click();

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // driver.quit(); // Tu peux fermer le navigateur ici
	        }	
		

	}

}
