package com.qa.trello;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardCreationTestsMy extends TestBase {


  @Test(enabled = false)
  public void testBoardCreation() {
    //initBoardCreation

    //fillBoardForm

    app.click(By.cssSelector(".W6rMLOx8U0MrPx"));
    app.click(By.xpath("//ul//li[1])"));

    //confirmBoardCreation
    //returnToHomePage

  }


}
