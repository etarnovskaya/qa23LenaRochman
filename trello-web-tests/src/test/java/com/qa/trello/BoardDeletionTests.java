package com.qa.trello;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardDeletionTests extends  TestBase {
  @Test
  public void testBoardDeletion(){
    openFirstPersonalBoard();
    clickMoreButton();
    initBoardDeletionInMoreMenu();

    permanentlyDeleteBoard();
    returnToHomePage();

  }

  public void permanentlyDeleteBoard() {
    click(By.cssSelector(".js-delete"));
    confirm();
  }

  private void initBoardDeletionInMoreMenu() {
    clickCloseBoardFromMoreMenu();
    confirm();
  }

  public void confirm() {
    click(By.cssSelector(".js-confirm"));
  }

  public void clickCloseBoardFromMoreMenu() {
    click(By.cssSelector(".js-close-board"));
  }

  public void clickMoreButton() {
    click(By.cssSelector(".js-open-more"));
  }

  public void openFirstPersonalBoard() {
    click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
  }
}
