package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {
  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillInGroupForm(new GroupData("Test 1", "Test 2", "Test 3"));
    app.submitGroupCreation();
    app.gotoGroupPage();
  }
}
