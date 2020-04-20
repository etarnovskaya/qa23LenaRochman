package com.qa.trello.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager{
  WebDriver wd;
  BoardHelper board;
  TeamHelper team;
  SessionHelper session;

  public void init() throws InterruptedException {
    wd = new ChromeDriver();
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
