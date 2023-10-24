package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public interface AppManager {

    Logger logger = LoggerFactory.getLogger(AppManager.class);

    WebDriver driver = new ChromeDriver();

    default void init(){
        driver.navigate().to("https://trello.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("URL https://trello.com/ Start testing --> " + LocalDateTime.now());
    }

    default void tearDown(){
        driver.quit();
        logger.info("Stop testing --> " + LocalDateTime.now());
    }

}
