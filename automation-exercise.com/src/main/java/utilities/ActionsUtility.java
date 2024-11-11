package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtility extends Utility {

    private static Actions act() {
        return new Actions(driver);
    }

    public static void sendKeys(WebElement source, CharSequence keys) {
        act().sendKeys(source, keys).perform();
    }

    public static void sendKeys(CharSequence keys) {
        act().sendKeys(keys).perform();

    }

    public static void moveTo(WebElement source) {
        act().moveToElement(source).perform();


    }

}
