package Utilities;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class Utility {
    private static final String SCREENSHOTS_PATH = "test-outputs/Screenshots/";

    public static void clickingOnElement(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public static void clickingOnElementJS(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", findWebElement(driver, locator));
    }

    public static void clickingOnElementFromList(WebDriver driver, By locator, int index) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElements(locator).get(index).click();
    }

    public static void enterData(WebDriver driver, By locator, String data) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(data);
    }

    public static String getText(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();

    }

    public static String getTextFromList(WebDriver driver, By locator, int index) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElements(locator).get(index).getText();
    }

    public static WebDriverWait generalWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void scrolling(WebDriver driver, By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findWebElement(driver, locator)).perform();
    }

    public static void scrollingJS(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", findWebElement(driver, locator));
    }

    public static void scrollingToElementFromList(WebDriver driver, By locator, int index) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElements(locator).get(index)).perform();
    }

    public static WebElement findWebElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }

    public static void selectingFromDropDown(WebDriver driver, By locator, String option) {
        new Select(findWebElement(driver, locator)).selectByVisibleText(option);
    }

    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd-hh-mm-ssa").format(new Date());
    }

    public static void takeScreenShot(WebDriver driver, String screenshotName) {
        try {
            // Capture screenshot using TakesScreenshot
            File screenshotSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Save screenshot to a file if needed
            File screenshotFile = new File(SCREENSHOTS_PATH + screenshotName + "-" + getTimeStamp() + ".png");
            FileUtils.copyFile(screenshotSrc, screenshotFile);

            // Attach the screenshot to Allure
            Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenshotFile.getPath())));
        } catch (Exception e) {
            LogsUtils.error(e.getMessage());
        }
    }

    public static void uploadFileRobot(WebDriver driver, By locator, String filePath) {
        try {
            // Create a Robot instance
            Robot robot = new Robot();

            // Click on the element to open the file dialog
            clickingOnElement(driver, locator);

            // Wait for the file dialog to open
            Thread.sleep(1000);

            // Type the file path into the file dialog
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Press Enter to confirm the file selection
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            LogsUtils.error(e.getMessage());
        }
    }

    public static int generateRandomNumber(int upperBound) { //0 >> upper-1  > 5
        return new Random().nextInt(upperBound) + 1;
    }

    //Set >> unique >> 1,2,3,4,3 > condition
    public static Set<Integer> generateUniqueNumber(int numberOfProductsNeeded, int totalNumberOfProducts) //5 >> 50
    {
        Set<Integer> generatedNumbers = new HashSet<>();
        while (generatedNumbers.size() < numberOfProductsNeeded) { //11111 > 1 2 10 5 7
            int randomNumber = generateRandomNumber(totalNumberOfProducts);
            generatedNumbers.add(randomNumber);
        }
        return generatedNumbers;
    }

    public static boolean VerifyURL(WebDriver driver, String expectedURL) {
        try {
            generalWait(driver).until(ExpectedConditions.urlToBe(expectedURL));
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public static Set<Cookie> getAllCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    public static void restoreSession(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies)
            driver.manage().addCookie(cookie);
    }

    public static File getLatestFile(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        assert files != null;
        if (files.length == 0)
            return null;
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());

        return files[0];
    }

    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }
    
}