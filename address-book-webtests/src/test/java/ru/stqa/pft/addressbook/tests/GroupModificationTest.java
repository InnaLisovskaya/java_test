package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;

public class GroupModificationTest  extends TestBase {

  @Test
  public void testGroupModification() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("For deletion", "Test 2", "Test 3"));
    }
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroup(0);
    app.getGroupHelper().modifySelectedGroups();
    app.getGroupHelper().fillInGroupForm(new GroupData("Test 5", "Test 5", "Test 5"));
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().gotoGroupPage();
    int after = app.getGroupHelper().getGroupCount();

    Assert.assertEquals(after, before );
  }

}