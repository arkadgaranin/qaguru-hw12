package com.gmail.arkgaranin.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TrashPage {

  private SelenideElement
      pageTitle = $("[aria-expanded='true'] .checkout-step-header__title"),
      tariffTitle = $(".order-item-2__tariff-info span"),
      deleteBtn = $("button.icon-close"),
      emptyPageTitle = $(".main-info span.text");

  @Step("Проверка, что выбранный тариф есть на стр-це Корзины")
  public void сheckTariffIsOnTrashPage() {
    pageTitle.shouldHave(text("Корзина"));
    tariffTitle.shouldHave(text("Мой онлайн"));
  }

  @Step("Проверка, что находимся на стр-це Корзины")
  public TrashPage atPage() {
    pageTitle.shouldHave(text("Корзина"));
    return this;
  }

  @Step("Удаление сим карты из корзины")
  public TrashPage deleteSimCard() {
    deleteBtn.click();
    return this;
  }

  @Step("Проверка, что Корзина пустая")
  public void сheckThatTrashIsEmpty() {
    emptyPageTitle.shouldHave(text("Ваша корзина пока пуста"));
  }
}
