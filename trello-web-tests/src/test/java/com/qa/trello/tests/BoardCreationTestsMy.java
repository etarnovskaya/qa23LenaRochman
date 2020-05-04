package com.qa.trello.tests;

import com.qa.trello.model.Board;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTestsMy extends TestBase {
  @DataProvider
  public Iterator<Object[]> validBoards() throws IOException {
    List<Object[]> list = new ArrayList<>();
    BufferedReader reader =
            new BufferedReader(new FileReader(new File("src/test/resources/boards.csv")));
    String line = reader.readLine();
    while (line != null){
      String[] split = line.split(";");
      list.add(new Object[]{new Board().withName(split[0]).withTeam(split[1]).withColor(split[2])});
      line = reader.readLine();
    }

    return list.iterator();
  }


  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    if (!app.getBoard().isOnBoardsPage()) {
      app.getBoard().click(By.cssSelector("[href$=boards]"));
    }
    Thread.sleep(3000);
  }

//    @Test(enabled = false, dataProvider = "validBoards", dataProviderClass = DataProviders.class)
//  public void testBoardCreationFromHeaderFromCSV(Board board) throws InterruptedException {
//    int before = app.getBoard().getBoardsCount();
//    app.getBoard().clickOnPlusButton();
//    app.getBoard().selectCreateBoardFromDropDown();
//    app.getBoard().fillBoardForm(board);
//    app.getBoard().confirmBoardCreation();
//    app.getBoard().pause(15000);
//    app.getHeader().returnToHomePage();
//    int after = app.getBoard().getBoardsCount();
//    Assert.assertEquals(after, before+1);
//  }

  @Test(dataProvider = "validBoards")
  public void testBoardCreation(Board board) throws InterruptedException {
    int before = app.getBoard().getBoardsCount();
    app.getBoard().initBoardCreation();
    app.getBoard().fillBoardForm(board);//new Board().withName("jj").withTeam("No team").withColor("orange"));
    app.getBoard().confirmBoardCreation();
    app.getBoard().returnToHomePage();
    int after = app.getBoard().getBoardsCount();

    Assert.assertEquals(after, before + 1);

  }



}
