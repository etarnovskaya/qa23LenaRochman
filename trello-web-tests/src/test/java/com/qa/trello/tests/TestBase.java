package com.qa.trello.tests;

import com.qa.trello.framework.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {


  protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws InterruptedException {
    app.init();

  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }


}
