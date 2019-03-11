package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    Groups before = app.group().all();
    int index = 0;   GroupData modifiedGroup = before.iterator().next();
    app.goTo().groupPage();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("Modified 2").withFooter("Test 5").withHeader( "Test 5");
    app.group().modify(group);
    app.goTo().groupPage();
    Groups after = app.group().all();
    Assert.assertEquals(after.size(), before.size());

  //  before.remove(modifiedGroup);
 //   before.add(group);

  //  Assert.assertEquals(before, after);

    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }



}