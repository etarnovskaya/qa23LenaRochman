package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
    String trello = wd.getWindowHandle();
    System.out.println(trello);
    click(By.cssSelector("a[href$=manage-profile]"));

    List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());
    if (!availableWindows.isEmpty()){
      wd.switchTo().window(availableWindows.get(1));
    }

    //now selenium on Atlassian page
    String atlassianAcc = wd.getWindowHandle();
    System.out.println(atlassianAcc);

  }

  public void initChangeProfilePhoto() {
    WebElement avatar = wd.findElement(By.cssSelector("[data-test-selector=profile-avatar]"));
    new Actions(wd).moveToElement(avatar).perform();
    click(By.cssSelector("[data-test-selector=trigger-avatar-picker]"));
  }


public void attachFile(By locator, File file){
    wd.findElement(locator).sendKeys(file.getAbsolutePath());
}

  public void uploadPhoto() throws InterruptedException {
    attachFile(By.cssSelector("button #image-input"),
            new File("C:\\Users\\Elena\\Documents\\GitHub\\qa23LenaRochman\\trello-web-tests\\src\\test\\resources\\cat_small.png"));

    Thread.sleep(2000);
   click(By.xpath("//*[contains(text(), 'Upload')]"));
    Thread.sleep(2000);


  }

  public boolean avatarAdded() {
    return isElementPresent(By.xpath("//*[contains(text(), 'Avatar added')]"));
  }

  public void returnToTrello() throws InterruptedException {
    List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());
    wd.close();
    wd.switchTo().window(availableWindows.get(0));

    Thread.sleep(5000);
  }
}