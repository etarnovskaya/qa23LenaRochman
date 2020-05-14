package com.qa.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends  TestBase {
  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    if(!app.getBoard().isOnBoardsPage()){
    app.getBoard().openBoardsPage();
   }
    if(app.getBoard().getBoardsCount()==0){
      app.getBoard().createBoard();
    }
  }



  @Test(enabled = false)
  public void testBoardNameModification() throws InterruptedException {

    app.getBoard().openFirstPersonalBoard();
    app.getBoard().changeName();
    app.getBoard().returnToHomePage();

  }
}
