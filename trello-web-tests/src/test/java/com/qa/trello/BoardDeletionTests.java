package com.qa.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends  TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    if(getBoardsCount()==0){
      createBoard();
    }
  }

  @Test
  public void testBoardDeletion(){
    int before = getBoardsCount();
    openFirstPersonalBoard();
    clickMoreButton();
    initBoardDeletionInMoreMenu();

    permanentlyDeleteBoard();
    returnToHomePage();
    int after = getBoardsCount();
    System.out.println("was: " + before+ " now: " + after );
    Assert.assertEquals(after, before-1);

  }

  @Test
  public void testBoardName(){
    openFirstPersonalBoard();
    changeName();
}

  public void changeName() {
    //click on name
    wd.findElement(By.cssSelector(".js-rename-board")).click();
    //type text and enter
    wd.findElement(By.cssSelector("input.js-board-name-input")).sendKeys("ggg"+ Keys.ENTER);
  }
  }
