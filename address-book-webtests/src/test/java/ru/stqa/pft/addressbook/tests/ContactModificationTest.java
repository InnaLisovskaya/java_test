package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import java.util.Set;

public class ContactModificationTest extends TestBase {


  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().home();
    if (app.contacts().all().size() == 0) {
      app.contacts().create(new ContactData()
              .withFirstName("New for modification").withLastName("New Modified").withbMonth("June").withbDay("22").withbYear("1999")   );
    }
  }


  @Test
  public void testContactModification() throws Exception {

    app.goTo().home();

    Set<ContactData> before = app.contacts().all();
    int index = before.size()-1;
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("Alina").withLastName("Modified").withbMonth("August").withbDay("31").withbYear("1969") ;

    app.contacts().modify(contact);
    app.goTo().home();

    Set<ContactData> after = app.contacts().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }


}
