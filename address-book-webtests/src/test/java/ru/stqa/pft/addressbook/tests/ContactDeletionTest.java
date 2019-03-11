package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().home();
    if (app.contacts().all().size() == 0) {
      app.contacts().create(new ContactData().
              withFirstName("For deletion").withbMonth("June").withbDay("22").withbYear("1999")
      );
    }
  }

  @Test
  public void testContactDeletion() throws Exception{
    app.goTo().home();
    Contacts before = app.contacts().all();
    ContactData deletedContact = before.iterator().next();
    app.contacts().delete(deletedContact);
    app.goTo().home();
    Contacts after = app.contacts().all();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(deletedContact);
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}