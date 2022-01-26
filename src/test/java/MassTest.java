import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MassTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void choosingStarvationCategoryTest() {
        // Open mass calculator page
        driver.get("https://healthunify.com/bmicalculator/");
        // Set Weight
        driver.findElement(By.name("wg")).sendKeys("40");
        // Set Height
        driver.findElement(By.name("ht")).sendKeys("170");
        // Click on 'Calculate'
        driver.findElement(By.name("cc")).click();
        // Check that Starvation Category is shown
        String message = driver.findElement(By.className("content")).getAttribute("value");
        Assert.assertEquals(message, "Your category is Starvation");
    }

    @Test
    public void choosingUnderweightCategoryTest() {
        // Open mass calculator page
        driver.get("https://healthunify.com/bmicalculator/");
        // Set Weight
        driver.findElement(By.name("wg")).sendKeys("50");
        // Set Height
        driver.findElement(By.name("ht")).sendKeys("180");
        // Click on 'Calculate'
        driver.findElement(By.name("cc")).click();
        // Check that Starvation Category is shown
        String message = driver.findElement(By.className("content")).getAttribute("value");
        Assert.assertEquals(message, "Your category is Underweight");
    }

    @Test
    public void choosingNormalCategoryTest() {
        // Open mass calculator page
        driver.get("https://healthunify.com/bmicalculator/");
        // Set Weight
        driver.findElement(By.name("wg")).sendKeys("61");
        // Set Height
        driver.findElement(By.name("ht")).sendKeys("180");
        // Click on 'Calculate'
        driver.findElement(By.name("cc")).click();
        // Check that Starvation Category is shown
        String message = driver.findElement(By.className("content")).getAttribute("value");
        Assert.assertEquals(message, "Your category is Normal");
    }

    @Test
    public void choosingOverweightCategoryTest() {
        // Open mass calculator page
        driver.get("https://healthunify.com/bmicalculator/");
        // Set Weight
        driver.findElement(By.name("wg")).sendKeys("91.5");
        // Set Height
        driver.findElement(By.name("ht")).sendKeys("181");
        // Click on 'Calculate'
        driver.findElement(By.name("cc")).click();
        // Check that Starvation Category is shown
        String message = driver.findElement(By.className("content")).getAttribute("value");
        Assert.assertEquals(message, "Your category is Overweight");
    }

    @Test
    public void choosingObeseCategoryTest() {
        // Open mass calculator page
        driver.get("https://healthunify.com/bmicalculator/");
        // Set Weight
        driver.findElement(By.name("wg")).sendKeys("101.55");
        // Set Height
        driver.findElement(By.name("ht")).sendKeys("181.5");
        // Click on 'Calculate'
        driver.findElement(By.name("cc")).click();
        // Check that Starvation Category is shown
        String message = driver.findElement(By.className("content")).getAttribute("value");
        Assert.assertEquals(message, "Your category is Obese");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

