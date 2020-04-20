package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardCreationTestsMy extends TestBase {


  @Test(enabled = false)
  public void testBoardCreation() {
    //initBoardCreation

    //fillBoardForm

    app.getBoard().click(By.cssSelector(".W6rMLOx8U0MrPx"));
    app.getBoard().click(By.xpath("//ul//li[1])"));

    //confirmBoardCreation
    //returnToHomePage

  }


}
