package com.qa.trello;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {


  @Test
  public void testBoardCreation() {
    int before = app.getBoardsCount();
    app.initBoardCreation();
    app.fillBoardForm("Test", "[title='blue']");
    app.confirmBoardCreation();
    app.returnToHomePage();
    int after = app.getBoardsCount();

    Assert.assertEquals(after, before + 1);

  }


}
