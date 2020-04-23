package com.qa.trello.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager{
  WebDriver wd;
  BoardHelper board;
  TeamHelper team;
  SessionHelper session;
  String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() throws InterruptedException {
    if(browser.equals(BrowserType.CHROME)){
      wd = new ChromeDriver();
    }if(browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
    }if(browser.equals(BrowserType.EDGE)){
      wd = new EdgeDriver();
    }

    wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    wd.manage().window().maximize();
    wd.navigate().to("https://trello.com/");

    session = new SessionHelper(wd);
    session.loginAtlasiianAcc("rochman.elena@gmail.com", "12345.com");

    board= new BoardHelper(wd);
    team = new TeamHelper(wd);
  }

  public void stop() {
    wd.quit();
  }

  public SessionHelper getSession() {
    return session;
  }

  public BoardHelper getBoard() {
    return board;
  }

  public TeamHelper getTeam() {
    return team;
  }
}
