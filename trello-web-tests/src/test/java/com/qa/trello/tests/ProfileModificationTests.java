package com.qa.trello.tests;

import org.testng.annotations.Test;

public class ProfileModificationTests extends  TestBase {

  @Test
  public void testChangeProfileAvatar(){
    app.getProfile().clickOnAvatar();
    app.getProfile().selectProfileAndVisibility();
    app.getProfile().goToAtlassianProfile();
    //initChangeProfilePhoto();
    //uploadPhoto();

  }



}
