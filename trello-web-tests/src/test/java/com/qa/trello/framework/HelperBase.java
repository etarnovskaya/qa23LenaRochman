package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
  WebDriver wd;
  WebDriverWait wait; //класс ждать, если нужно подождать подгрузку на странице принудительно

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public void returnToHomePage() {
    click(By.cssSelector("[name='house']"));
    // click(By.cssSelector("[class='_2BQG4yPMt5s_hu _2hgn5meZL7bJdx _1ctYJ9-gOV_hrm _3Xj1tqB73NcWn3']"));
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void confirm() {
    click(By.cssSelector(".js-confirm"));
  }

  public boolean isElementPresent(By locator) {
    return wd.findElements(locator).size() > 0;
  }
}
