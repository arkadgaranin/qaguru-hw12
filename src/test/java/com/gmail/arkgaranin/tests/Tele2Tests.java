package com.gmail.arkgaranin.tests;

import com.gmail.arkgaranin.pages.MainPage;
import com.gmail.arkgaranin.pages.MyOnlinePage;
import com.gmail.arkgaranin.pages.TariffsPage;
import com.gmail.arkgaranin.pages.TrashPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Owner("Arkadiy Garanin")
public class Tele2Tests extends TestBase {

  MainPage mainPage = new MainPage();
  TariffsPage tariffsPage = new TariffsPage();
  MyOnlinePage myOnlinePage = new MyOnlinePage();
  TrashPage trashPage = new TrashPage();

  @Link(name = "Cтр-ца сайта tele2", url = "https://msk.tele2.ru")
  @DisplayName("Покупка сим карты")
  @Severity(SeverityLevel.NORMAL)
  @Test
  void purchaseSimCardTest() {
    mainPage
        .openPage()
        .gotoTariffsPage();

    tariffsPage.choiceTariff();

    myOnlinePage
        .checkPageTitleForTariff()
        .choiceOneSimCard()
        .clickOnSubmitBtn()
        .submitPurchase();

    trashPage.сheckTariffIsOnTrashPage();
  }

  @Link(name = "Cтр-ца сайта tele2", url = "https://msk.tele2.ru")
  @DisplayName("Удаление купленной сим карты из корзины")
  @Severity(SeverityLevel.NORMAL)
  @Test
  void deleteSimFromTrashTest() {
    mainPage
        .openPage()
        .gotoTrash();

    trashPage.atPage()
        .deleteSimCard()
        .сheckThatTrashIsEmpty();
  }

//  @Link(name = "Cтр-ца сайта tele2", url = "https://msk.tele2.ru")
//  @DisplayName("Поиск свободного номера телефона")
//  @Severity(SeverityLevel.NORMAL)
//  @Test
//  void searchForFreeNumberTest() {
//    mainPage
//        .openPage()
//        .gotoNumbersPage();
//
//    $("h1.catalog-header").shouldHave(text("Выберите номер телефона"));
//    $("#searchNumber").setValue("9772601157");
//    $("div.empty-list").shouldHave(text("По вашему запросу ничего не нашлось"));
//
//    $("a.reset-filters").click();
//    $("div > a.short-info").shouldHave(text("Показать еще"));
//    $("#searchNumber").setValue("9772516671");
//    $("div.catalog-numbers").shouldHave(text("977 251-66-71"));
//  }
//
//  @Link(name = "Cтр-ца сайта tele2", url = "https://msk.tele2.ru")
//  @DisplayName("Поиск смартфона, используя фильтры")
//  @Severity(SeverityLevel.NORMAL)
//  @Test
//  void searchSmartphonesByFiltersTest() {
//    mainPage
//        .openPage()
//        .gotoSmartphonesPage();
//
//    $("div.products-header").shouldHave(text("Смартфоны"));
//    $("#radio_e43fd26858c53d4ef093f0f8d77648d6_listbox > li:nth-child(1) > label > span").click();
//    $(".products-filter > div:nth-of-type(6) .filter-title").click();
//    $("[for='checkBoxField_Samsung']").click();
//    $(".products-filter > div:nth-of-type(7) .filter-title").click();
//    $("[for='checkBoxField_синий']").click();
//    $(".products-filter > div:nth-of-type(8) .filter-title").click();
//    $("[for='checkBoxField_32 Гб']").click();
//    $$(".products-list .col-xs-12").shouldHave(size(5));
//  }
}
