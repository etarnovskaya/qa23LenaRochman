package com.qa.trello;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends  TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
//    if(!isOnBoardsPage()){
//////      click(By.cssSelector("[href$=boards]"));
//////    }
    if(app.getBoardsCount()==0){
      app.createBoard();
    }
  }

  @Test
  public void testBoardNameModification(){
    app.openFirstPersonalBoard();
    app.changeName();
    app.returnToHomePage();
  }
}
