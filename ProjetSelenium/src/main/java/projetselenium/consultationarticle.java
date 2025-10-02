package projetselenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.nio.file.*;
import java.time.Duration;

public class consultationarticle {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--disable-dev-shm-usage", "--no-sandbox", "--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        try {
            driver.get("https://pos1-demo-prosuma.retail.groupe-asten.fr/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // ===== Connexion =====
            driver.findElement(By.id("username")).sendKeys("Administrateur");
            driver.findElement(By.id("password")).sendKeys("123456789www");
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            wait.until(ExpectedConditions.urlContains("/"));

            // ===== Menu Articles =====
            WebElement menuArticles = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("li[data-iden='products'] > a")));
            menuArticles.click();

            WebElement sousMenuArticles = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("li[data-path='/product/'] > a")));
            sousMenuArticles.click();

            // ===== Recherche d’un article =====
            WebElement champRecherche = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("input[ng-enter='search_filter()']")));
            champRecherche.sendKeys("100250250");

            /*// Cliquer sur le bouton loupe (plutôt que Enter)
            WebElement boutonRecherche = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button.btn.btn-info.btn-block")));
            boutonRecherche.click();*/
            
            
         // Cliquer sur la loupe (icône)
            /*WebElement loupe = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("i.fa-search")));
            loupe.click();*/

            // ===== Attente des résultats =====
            WebElement lienArticle = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("a.display_detail_link")));
            System.out.println("Article trouvé : " + lienArticle.getText());

            // Cliquer pour consulter
            lienArticle.click();

            // ===== Vérification / Capture =====
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path target = Paths.get("consultation_" + System.currentTimeMillis() + ".png");
            Files.copy(scrFile.toPath(), target);
            System.out.println("Screenshot saved to: " + target.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermer le navigateur
            // driver.quit();
        }
    }
}
