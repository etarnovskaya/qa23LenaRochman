package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileHelper extends  HelperBase {
  public ProfileHelper(WebDriver wd) {
    super(wd);
  }

  public void clickOnAvatar() {
    click(By.cssSelector("[data-test-id=header-member-menu-button]"));
  }

  public void selectProfileAndVisibility() {
    click(By.cssSelector("[data-test-id=header-member-menu-profile]"));
  }

  public void goToAtlassianProfile() {
    click(By.cssSelector("a[href$=manage-profile]"));
  }
}
