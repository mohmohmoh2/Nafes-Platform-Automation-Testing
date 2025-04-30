package DriverSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver createDriver(String driverType) throws IOException {
        return switch (driverType.toLowerCase()) {
            case "chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                Path chromeTempDir = Files.createTempDirectory("chrome-user-data");
                chromeOptions.addArguments("--user-data-dir=" + chromeTempDir.toAbsolutePath());
                yield new ChromeDriver(chromeOptions);
            }
            case "firefox" -> new FirefoxDriver(); // Firefox does not require user-data-dir handling by default
            case "edge" -> {
                EdgeOptions edgeOptions = new EdgeOptions();
                Path edgeTempDir = Files.createTempDirectory("edge-user-data");
                edgeOptions.addArguments("--user-data-dir=" + edgeTempDir.toAbsolutePath());
                yield new EdgeDriver(edgeOptions);
            }
            default -> throw new IllegalArgumentException("Invalid driver type: " + driverType);
        };
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        getDriver().quit();
        driverThreadLocal.remove();
    }
}