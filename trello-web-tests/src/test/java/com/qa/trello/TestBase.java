package com.qa.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
  WebDriver wd;
  WebDriverWait wait; //класс ждать, если нужно подождать подгрузку на странице принудительно


  @BeforeMethod
  public void setUp() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    wd.manage().window().maximize();
    wd.navigate().to("https://trello.com/");
    login("rochman.elena@gmail.com", "12345.com");

  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }

  public void fillForm(String nameOfTeam, By locatorTeamType) {
    type(By.cssSelector("[class='_1CLyNodCAa-vQi']"), nameOfTeam);
    click(By.id("teamTypeSelect"));
    click(locatorTeamType);
  }

  public void returnToHomePage() {
    click(By.cssSelector("[class='_2BQG4yPMt5s_hu _2hgn5meZL7bJdx _1ctYJ9-gOV_hrm _3Xj1tqB73NcWn3']"));
    click(By.cssSelector("[class='_2BQG4yPMt5s_hu _2hgn5meZL7bJdx _1ctYJ9-gOV_hrm _3Xj1tqB73NcWn3']"));
  }

  public void confirmTeamCreation() {
    click(By.cssSelector("[type='submit']"));
    click(By.cssSelector("[class='eg0KI5SqghoOFd']"));
  }

  public void initTeamCreation() {
    click(By.cssSelector("[class='icon-add icon-sm _2aV_KY1gTq1qWc']"));
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void initLogin() {
    click(By.cssSelector("[href='/login']"));
  }

  public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void fillLoginForm(String userEmail, String password) {
    type(By.name("user"), userEmail);
    type(By.name("password"), password);
  }

  public void confirmLogin() {
    click(By.id("login"));
  }


  public void fillLoginFormAtlassianAcc(String userEmail, String password) {
    type(By.name("user"), userEmail);
    click(By.cssSelector("#login.button-green"));
    type(By.cssSelector("input#password"), password);
  }

  protected void initBoardCreation() {
    click(By.name("add"));
    click(By.cssSelector("[data-test-id='header-create-board-button']"));
  }

  protected void confirmBoardCreation() {
    click(By.cssSelector("[class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']"));
  }

  protected void fillBoardForm(String nameOfBoard, String colorOfBoard) {
    type(By.cssSelector("[data-test-id='create-board-title-input']"), nameOfBoard);
    click(By.cssSelector(colorOfBoard));
  }

  public void login(String email, String password) {
    initLogin();
    fillLoginForm(email, password);
    confirmLogin();
  }
}
