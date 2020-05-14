package com.qa.trello.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager{
  WebDriver wd;
  BoardHelper board;
  TeamHelper team;
  SessionHelper session;
  ProfileHelper profile;
  String browser;
  Properties properties;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() throws InterruptedException, IOException {
    if(browser.equals(BrowserType.CHROME)){
      wd = new ChromeDriver();
    }if(browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
    }if(browser.equals(BrowserType.EDGE)){
      wd = new EdgeDriver();
    }

    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    //wd.manage().window().maximize();

    properties = new Properties();

    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));




    wd.navigate().to(properties.getProperty("web.baseURL"));

    session = new SessionHelper(wd);

    session.loginAtlasiianAcc(
            properties.getProperty("web.user"), properties.getProperty("web.pwd"));
    Thread.sleep(5000);

    board= new BoardHelper(wd);
    team = new TeamHelper(wd);
    profile = new ProfileHelper(wd);
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

  public ProfileHelper getProfile() {
    return profile;
  }
}
