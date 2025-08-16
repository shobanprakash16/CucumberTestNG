package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class tests {
    public static void main(String[] args) {
        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Replace with actual path
        WebDriver driver = new ChromeDriver();

        // Navigate to the URL
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Locate the Courses table using XPath
        WebElement coursesTable = driver.findElement(By.xpath("//table[@name='courses']"));

        // Get all rows of the table
        List<WebElement> rows = coursesTable.findElements(By.tagName("tr"));

        // Loop through rows and print each cell value
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + " | ");
            }
            System.out.println();
        }

        // Clean up
        driver.quit();
    }
}