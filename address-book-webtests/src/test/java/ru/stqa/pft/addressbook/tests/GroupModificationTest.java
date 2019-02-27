package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest  extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().groupPage();
    if (!app.group().present()) {
      app.group().create(new GroupData().withName("For deletion"));
    }
  }

  @Test
  public void testGroupModification() {

    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    int index = 0;
    GroupData group = new GroupData().withId(before.get(index).getId()).withName("Modified").withFooter("Test 5").withHeader( "Test 5");
    app.group().modify(index, group);
    app.goTo().groupPage();
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId()) ;
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);
  }



}