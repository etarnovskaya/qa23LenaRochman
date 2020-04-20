package com.qa.trello;

import org.testng.annotations.Test;


public class TeamCreationTests extends TestBase {

  @Test
  public void testTeamCreation() throws InterruptedException {
    app.initTeamCreation();
    app.fillTeamForm("Team_test");
    app.inviteTeamLater();
    app.confirmTeamCreation();
    Thread.sleep(2000);
    app.returnToHomePage();

  }

}
