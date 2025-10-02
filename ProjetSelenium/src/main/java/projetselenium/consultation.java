package projetselenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.nio.file.*;
import java.time.Duration;
import java.util.List;

public class consultation {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--disable-dev-shm-usage", "--no-sandbox", "--start-maximized");

        WebDriver driver = new ChromeDriver(options);

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
            String codeRecherche = "100250250";

            WebElement champRecherche = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("input[ng-enter='search_filter()']")));
            champRecherche.clear();
            champRecherche.sendKeys(codeRecherche);
            champRecherche.sendKeys(Keys.ENTER); // déclenche ng-enter=search_filter()

            Thread.sleep(1000); // attendre que la page charge (AJAX ou rafraîchissement)

            // Cliquer sur la loupe
            WebElement loupe = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("i.fa-search")));
            loupe.click();

            // ===== Attente du tableau de résultats =====
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a.display_detail_link")));

            // On relocalise les éléments à chaque tour de boucle pour éviter StaleElementReferenceException
            List<WebElement> resultats = driver.findElements(By.cssSelector("a.display_detail_link"));
            System.out.println("Nombre d’articles trouvés : " + resultats.size());

            WebElement articleDiff = null;

            for (int i = 0; i < resultats.size(); i++) {
                try {
                    // Relocalisation à chaque tour
                    WebElement lien = driver.findElements(By.cssSelector("a.display_detail_link")).get(i);
                    String texte = lien.getText();
                    if (!texte.contains(codeRecherche)) {
                        articleDiff = lien;
                        break;
                    }
                } catch (StaleElementReferenceException e) {
                    System.out.println("Élément devenu stale, on continue...");
                }
            }

            if (articleDiff != null) {
                System.out.println("Article différent trouvé : " + articleDiff.getText());
                articleDiff.click();
            } else {
                System.out.println("Aucun article différent trouvé dans la liste.");
            }

            // ===== Vérification / Capture =====
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path target = Paths.get("consultation_" + System.currentTimeMillis() + ".png");
            Files.copy(scrFile.toPath(), target);
            System.out.println("Screenshot saved to: " + target.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // driver.quit(); // Active si tu veux fermer automatiquement
        }
    }
}
