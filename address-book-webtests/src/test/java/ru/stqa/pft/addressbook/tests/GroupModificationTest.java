package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupModificationTest  extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().groupPage();
    if (!app.group().present()) {
      app.group().create(new GroupData().withName("For modification"));
    }
  }

  @Test
  public void testGroupModification() {

    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    int index = 0;   GroupData modifiedGroup = before.iterator().next();
    app.goTo().groupPage();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("Modified 2").withFooter("Test 5").withHeader( "Test 5");
    app.group().modify(group);
    app.goTo().groupPage();
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedGroup);
    before.add(group);

    Assert.assertEquals(before, after);
  }



}