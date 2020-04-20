package com.qa.trello;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {


  protected ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws InterruptedException {
    app.init();

  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }


}
