package tests;

import manager.AppManager;
import manager.TestNgListener;
import org.testng.annotations.*;

@Listeners(TestNgListener.class)
public class TestBase implements AppManager {
    @BeforeSuite(alwaysRun = true)
    public void start(){
        init();
    }
    @AfterSuite(alwaysRun = true)
    public void stop(){
        //tearDown();
    }
}
