package bookingObjectsPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.print.Book;
import java.time.Duration;

public class BookingObjectsPage {
    WebDriver driver;
    WebDriverWait wait;

    public void openWebpage(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Selectors.webPage);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void makeAppointment(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Selectors.makeAppBtn)));
        driver.findElement(By.cssSelector(Selectors.makeAppBtn)).click();
    }

    public void bookAppointment(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Selectors.usernameField)));
        driver.findElement(By.cssSelector(Selectors.usernameField)).sendKeys(Selectors.usernametxt);
        driver.findElement(By.cssSelector(Selectors.passwordField)).sendKeys(Selectors.passwordtxt);
        driver.findElement(By.cssSelector(Selectors.loginBtn)).click();
    }

    public void makeAppointmentFinal(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Selectors.comboFacility)));
        Select select = new Select(driver.findElement(By.cssSelector(Selectors.comboFacility)));
        select.selectByValue(Selectors.comboFacilityOptions);
        driver.findElement(By.cssSelector(Selectors.healthProgram)).click();
        driver.findElement(By.cssSelector(Selectors.visitDate)).click();
        driver.findElement(By.cssSelector(Selectors.visitDate)).sendKeys(Selectors.chooseDate);
        driver.findElement(By.cssSelector(Selectors.textBox)).sendKeys(Selectors.textInputs);
        driver.findElement(By.cssSelector(Selectors.bookApt)).click();
    }

    public void logOutBtn(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Selectors.menuToggle)));
        driver.findElement(By.cssSelector(Selectors.menuToggle)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Selectors.sideBarWrap)));
        driver.findElement(By.cssSelector(Selectors.logoutBtn)).click();
    }

    public void teardown(){
        driver.quit();
    }

}
