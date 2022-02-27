package com.gmail.arkgaranin.tests;

import com.codeborne.selenide.Configuration;
import com.gmail.arkgaranin.helpers.Attachments;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

  @BeforeAll
  static void setup() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-notifications");
    Configuration.browserCapabilities = options;
    Configuration.baseUrl = "https://msk.tele2.ru";
    Configuration.browserSize = "1920x1080";

    String login = System.getProperty("login");
    String password = System.getProperty("password");
    String url = System.getProperty("url");
    Configuration.remote = "https://" + login + ":" + password + "@" + url;

    Configuration.browser = System.getProperty("browser");
    Configuration.browserVersion = System.getProperty("browserVersion");
    Configuration.browserSize = System.getProperty("browserSize");

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("enableVNC", true);
    capabilities.setCapability("enableVideo", true);
    Configuration.browserCapabilities = capabilities;
  }

  @AfterEach
  void addAttachments() {
    Attachments.takeScreenshot();
    Attachments.takePageSource();
    Attachments.addVideo();
    Attachments.browserConsoleLogs();
  }
}
