package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.goTo().groupPage();
    app.group().selectGroupById(deletedGroup);
    app.group().delete();
    app.goTo().groupPage();
    Groups after = app.group().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    //before.remove(deletedGroup);

    /*for (int i = 0; i < after.size(); i++) {
      Assert.assertEquals(before.get(i), after.get(i));
    } */

    assertThat(after, equalTo(before.without(deletedGroup)));
  }
}
