package com.gmail.arkgaranin.tests;

import com.codeborne.selenide.Configuration;
import com.gmail.arkgaranin.helpers.Attachments;
import org.junit.jupiter.api.AfterEach;
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

  @AfterEach
  void addAttachments() {
    Attachments.takeScreenshot();
    Attachments.takePageSource();
    Attachments.addVideo();
    Attachments.browserConsoleLogs();
  }
}
