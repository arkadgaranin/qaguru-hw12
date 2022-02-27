package com.gmail.arkgaranin.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

  @BeforeAll
  static void setup() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-notifications");
    Configuration.browserCapabilities = options;
    Configuration.baseUrl = "https://msk.tele2.ru";
    Configuration.browserSize = "1920x1080";
  }
}
