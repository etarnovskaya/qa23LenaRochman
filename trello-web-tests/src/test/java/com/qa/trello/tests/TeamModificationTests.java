package com.qa.trello.tests;

import org.testng.annotations.Test;

public class TeamModificationTests extends  TestBase {
  @Test
  public void TestTeammodification(){
    app.getTeam().openTeamSettings();
    //app.getTeam().changeTeamName();

  }
}
