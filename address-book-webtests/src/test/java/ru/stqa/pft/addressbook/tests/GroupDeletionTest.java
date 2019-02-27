package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase {
  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().groupPage();
    if (!app.group().present()) {
      app.group().create(new GroupData().withName("For deletion"));
    }
  }


  @Test
  public void testGroupDeleting() throws Exception {
    List<GroupData> before = app.group().list();
    app.goTo().groupPage();
    app.group().selectGroup(before.size() - 1);
    app.group().deleteSelectedGroups();
    app.goTo().groupPage();
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);

    /*for (int i = 0; i < after.size(); i++) {
      Assert.assertEquals(before.get(i), after.get(i));
    } */

    Assert.assertEquals(before, after);
  }
}
