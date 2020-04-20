package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper  extends  HelperBase{
  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void loginAtlasiianAcc(String email, String pwd) throws InterruptedException {
    initLogin();
    fillLoginFormAtlassianAcc(email, pwd);
    confirmLoginAtlassian();
  }

  public void confirmLoginAtlassian() {
    click(By.cssSelector("#login-submit"));
  }

  public void initLogin() {
    click(By.cssSelector("[href='/login']"));
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

  public void login(String email, String password) {
    initLogin();
    fillLoginForm(email, password);
    confirmLogin();
  }
}
