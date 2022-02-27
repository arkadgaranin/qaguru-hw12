package com.gmail.arkgaranin.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MyOnlinePage {

  private SelenideElement
      pageTitle = $("div.tariff-card-new-2__heading span"),
      oneSimCard = $("ul.sim-number-selector__list li:nth-child(1)"),
      submitBtn = $(".tariff-card-new__fee-and-buttons .btn"),
      purchaseBtn = $(".btn.submit");

  @Step("Проверка соответствия заголовка стр-цы выбранному тарифу")
  public MyOnlinePage checkPageTitleForTariff() {
    pageTitle.shouldHave(text("Мой онлайн"));
    return this;
  }

  @Step("Выбор одной симки")
  public MyOnlinePage choiceOneSimCard() {
    oneSimCard.click();
    return this;
  }

  @Step("Клик на кнопку покупки сим карты")
  public MyOnlinePage clickOnSubmitBtn() {
    submitBtn.click();
    return this;
  }

  @Step("Подтверждение покупки и переход на стр-цу оплаты")
  public void submitPurchase() {
    purchaseBtn.click();
  }
}
