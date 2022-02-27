package com.gmail.arkgaranin.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class TariffsPage {

  private SelenideElement tariffMyOnline = $(".tariffs-detailed-list > .container > div:nth-of-type(3)");

  @Step("Выбор тарифа")
  public void choiceTariff() {
    tariffMyOnline.click();
  }
}
