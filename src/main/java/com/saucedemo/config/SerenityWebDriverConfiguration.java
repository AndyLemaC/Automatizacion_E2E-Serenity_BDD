package com.saucedemo.config;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SerenityWebDriverConfiguration {
    public static void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }
}
