package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import java.util.Set;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().home();
    Set<ContactData> before = app.contacts().all();
    ContactData contact = new ContactData()
            .withFirstName("Inna").withLastName("Lisovskaya").withbMonth("April").withbDay("9").withbYear("1989") ;
    app.contacts().create(contact);
    app.goTo().home();
    Set<ContactData> after = app.contacts().all();
    Assert.assertEquals(after.size(), before.size()+1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
