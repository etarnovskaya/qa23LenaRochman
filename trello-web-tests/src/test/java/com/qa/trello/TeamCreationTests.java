package com.qa.trello;

import org.testng.annotations.Test;


public class TeamCreationTests extends TestBase {

  @Test
  public void testTeamCreation() throws InterruptedException {
    initTeamCreation();
    fillTeamForm("Team_test");
    inviteTeamLater();
    confirmTeamCreation();
    Thread.sleep(2000);
    returnToHomePage();

  }

}
