package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HelperBase {

    protected final ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
    }

    protected void type(By locator, String text) {
        click(locator);
        manager.driver.findElement(locator).clear();
        manager.driver.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        manager.driver.findElement(locator).click();
    }

    protected void dropdownType(String num, String contact) {
        manager.driver.findElement(By.name(num)).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name(num));
            dropdown.findElement(By.xpath("//option[. = '" + contact + "']")).click();
        }
    }
}
