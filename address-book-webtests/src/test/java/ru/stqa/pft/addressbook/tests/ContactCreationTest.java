package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().home();
    Contacts before = app.contacts().all();
    ContactData contact = new ContactData()
            .withFirstName("Inna").withLastName("Lisovskaya").withbMonth("April").withbDay("9").withbYear("1989") ;
    app.contacts().create(contact);
    app.goTo().home();
    Contacts after = app.contacts().all();
    Assert.assertEquals(after.size(), before.size()+1);

  //  contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
  //  before.add(contact);
  //  Assert.assertEquals(before, after);

    assertThat(after, equalTo(before
            .withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
