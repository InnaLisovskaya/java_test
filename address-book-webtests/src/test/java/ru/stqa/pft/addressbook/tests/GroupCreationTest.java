package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTest extends TestBase {
  @Test
  public void testGroupCreation() throws Exception {

    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData().withName("Created new");
    app.group().create(group);
    app.goTo().groupPage();
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(group);

   //comparator<? super GroupData> byId = (Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
   // int max = after.stream().max( (o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
   // group.setId(after.stream().max( (o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId()) ;
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);
  }
}
