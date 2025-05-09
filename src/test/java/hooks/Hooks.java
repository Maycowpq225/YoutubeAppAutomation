package hooks;

import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import utils.DriverConfig;

public class Hooks {

    @BeforeAll
    public static void initiateDriver() {
        DriverConfig.shared().defaultConfig();
    }

    @After
    public static void tearDown() {
        DriverConfig.shared().quitDriver();
    }
}
