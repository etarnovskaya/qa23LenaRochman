package com.qa.trello.tests;

import com.qa.trello.model.Board;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
     if (!app.getBoard().isOnBoardsPage()) {
      app.getBoard().click(By.cssSelector("[href$=boards]"));
    }
  }

  @DataProvider
  public Iterator<Object[]> validBoardsEasy() throws IOException {
    List<Object[]> list = new ArrayList<>();
    list.add(new Object[]{"aaaaaaa","No team", "blue"});
    list.add(new Object[]{"1111111","No team", "orange"});
    list.add(new Object[]{"hkhkhkjhkh_ghhjgjgjhg - ghgjgjhgjhgjh","No team"});
    return  list.iterator();
  }




  @Test(enabled = false, dataProvider = "validBoardsEasy")
  public void testBoardCreation(String boardName, String boardTeam, String color) throws InterruptedException {

    Board board = new Board().withName(boardName).withTeam(boardTeam).withColor(color);

    int before = app.getBoard().getBoardsCount();
    System.out.println(before);
    app.getBoard().initBoardCreation();

    app.getBoard().fillBoardForm(board);

        //    .withColor("red"));
    app.getBoard().confirmBoardCreation();
    app.getBoard().returnToHomePage();
    int after = app.getBoard().getBoardsCount();
    System.out.println(after);

    Assert.assertEquals(after, before + 1);

  }




  @Test
  public void testBoardCreationOLD() throws InterruptedException {
    int before = app.getBoard().getBoardsCount();
   // System.out.println(new File(".").getAbsolutePath());
    app.getBoard().initBoardCreation();
    app.getBoard().fillBoardForm(
            new Board()
                    .withName("Test "+ System.currentTimeMillis())
                    .withTeam("No team"));
                   // .withColor("red"));
    app.getBoard().confirmBoardCreation();
    app.getBoard().returnToHomePage();
    int after = app.getBoard().getBoardsCount();

    Assert.assertEquals(after, before + 1);

  }


}
