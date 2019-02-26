package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {
  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("Created new", "Test 5", "Test 5");
    app.getGroupHelper().createGroup(group);
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(group);

    int max = 0;

    for (GroupData g : after) {
      if (g.getId() > max) {
        max = g.getId();
      }
    }

    group.setId(max);

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
