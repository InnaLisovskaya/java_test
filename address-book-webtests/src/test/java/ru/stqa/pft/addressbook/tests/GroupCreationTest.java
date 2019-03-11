package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {
  @Test
  public void testGroupCreation() throws Exception {

    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("Created new");
    app.group().create(group);
    app.goTo().groupPage();
    Groups after = app.group().all();

   // group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
   // before.add(group);


    assertThat(after, equalTo(before
            .withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    assertThat(after.size(), equalTo( before.size() + 1));
  }
}
