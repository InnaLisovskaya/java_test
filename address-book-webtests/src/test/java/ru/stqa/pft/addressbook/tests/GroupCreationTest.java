package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;

public class GroupCreationTest extends TestBase {
  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("test1", "test2", null));
    app.getNavigationHelper().gotoGroupPage();
    int after = app.getGroupHelper().getGroupCount();

    Assert.assertEquals(after, before + 1);
  }
}
