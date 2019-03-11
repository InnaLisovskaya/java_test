package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import java.util.Set;

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
    Set<ContactData> before = app.contacts().all();
    ContactData deletedContact = before.iterator().next();
    app.contacts().delete(deletedContact);
    app.goTo().home();
    Set<ContactData> after = app.contacts().all();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }


}