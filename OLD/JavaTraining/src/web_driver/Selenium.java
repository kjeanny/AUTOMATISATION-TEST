package web_driver;
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.chrome.ChromeDriver;  

public class Selenium {
    public static void main(String[] args) {
        // Chemin vers ChromeDriver (à adapter selon ton système)
        System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromedriver");

        // Ouvrir Chrome
        WebDriver driver = new ChromeDriver();

        // Naviguer sur Google
        driver.get("https://www.google.com");

        // Afficher le titre de la page
        System.out.println("Titre de la page : " + driver.getTitle());

        // Fermer le navigateur
        driver.quit();
    }
}