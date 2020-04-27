package com.qa.trello.tests;

import org.testng.annotations.Test;


public class TeamCreationTests extends TestBase {

  @Test
  public void testTeamCreation()  {
    app.getTeam().initTeamCreation();
    app.getTeam().fillTeamForm("Team_test");
    app.getTeam().confirmTeamCreation();
    app.getTeam().inviteTeamLater();

    app.getTeam().returnToHomePage();

  }

}
