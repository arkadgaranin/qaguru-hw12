package com.gmail.arkgaranin.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

  private SelenideElement
      linkTariffs = $("[href='/tariffs']"),
      linkNumbers = $("[href='/shop/number']"),
      linkSmartphones = $("[href='/shop/devices/smartphones']"),
      linkTrash = $("[data-cartridge-type='GoToCartAction2']");

  @Step("Открытие главной стр-цы Теле2")
  public MainPage openPage() {
    open("/");
    return this;
  }

  @Step("Переход на стр-цу Тарифы")
  public void gotoTariffsPage() {
    linkTariffs.click();
  }

  @Step("Переход на стр-цу Номера")
  public void gotoNumbersPage() {
    linkNumbers.click();
  }

  @Step("Переход на стр-цу Смартфоны")
  public void gotoSmartphonesPage() {
    linkSmartphones.click();
  }

  @Step("Переход в корзину")
  public void gotoTrash() {
    linkTrash.click();
  }
}
