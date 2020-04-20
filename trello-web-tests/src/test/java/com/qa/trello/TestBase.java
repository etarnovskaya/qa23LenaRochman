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
  public void setUp() throws InterruptedException {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    wd.manage().window().maximize();
    wd.navigate().to("https://trello.com/");
    loginAtlasiianAcc("rochman.elena@gmail.com", "12345.com");

  }

  private void loginAtlasiianAcc(String email, String pwd) throws InterruptedException {
    initLogin();
    fillLoginFormAtlassianAcc(email, pwd);
    confirmLoginAtlassian();
  }

  public void confirmLoginAtlassian() {
    click(By.cssSelector("#login-submit"));
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }

  public void fillTeamForm(String nameOfTeam) {
    type(By.cssSelector("[data-test-id=header-create-team-name-input]"), nameOfTeam);
    click(By.id("teamTypeSelect"));
    click(By.cssSelector("[data-test-id^=header-create-team-type] li"));
  }

  public void returnToHomePage() {
    click(By.cssSelector("[name='house']"));
   // click(By.cssSelector("[class='_2BQG4yPMt5s_hu _2hgn5meZL7bJdx _1ctYJ9-gOV_hrm _3Xj1tqB73NcWn3']"));
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


  public void fillLoginFormAtlassianAcc(String userEmail, String password) throws InterruptedException {
    type(By.name("user"), userEmail);
    click(By.cssSelector("#login.button-green"));
    Thread.sleep(5000);
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
    click(By.cssSelector("button.W6rMLOx8U0MrPx"));
    click(By.xpath("//li[1]/button[@class='_2jR0BZMM5cBReR']"));
    click(By.cssSelector(colorOfBoard));
  }

  public void login(String email, String password) {
    initLogin();
    fillLoginForm(email, password);
    confirmLogin();
  }

  public void permanentlyDeleteBoard() {
    click(By.cssSelector(".js-delete"));
    confirm();
  }

  protected void initBoardDeletionInMoreMenu() {
    clickCloseBoardFromMoreMenu();
    confirm();
  }

  public void confirm() {
    click(By.cssSelector(".js-confirm"));
  }

  public void clickCloseBoardFromMoreMenu() {
    click(By.cssSelector(".js-close-board"));
  }

  public void clickMoreButton() {
    click(By.cssSelector(".js-open-more"));
  }

  public void openFirstPersonalBoard() {
    click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
  }

  public int getBoardsCount() {
    return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
  }

  public void createBoard(){
    initBoardCreation();
    fillBoardForm("Test", "[title='blue']");
    confirmBoardCreation();
    returnToHomePage();
  }

  public void inviteTeamLater() {
    if (isElementPresent(By.cssSelector("[data-test-id=show-later-button]"))) {
      click(By.cssSelector("[data-test-id=show-later-button]"));
    }
  }

  public  boolean isElementPresent(By locator){
    return wd.findElements(locator).size()>0;
  }
}
