package projetselenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class exerciceauto {
public static void main(String[] args) throws IOException {    
	// TODO Auto-generated method stub  
	//Chemin driver
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.youtube.com/");
	//Saisir  Qualite logicielle dans la barre de recherche
	driver.findElement(By.name("search_query")).sendKeys("Qualite logicielle");
	
	//Cliquer sur le bouton Rechercher pour faire la recherche des données saisies
	driver.findElement(By.name("search_query")).submit();
	
	//Fermer la fenetre 
	//driver.quit();
}
}
