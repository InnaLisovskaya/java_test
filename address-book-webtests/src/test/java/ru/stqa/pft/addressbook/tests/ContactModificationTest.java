package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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

    Contacts before = app.contacts().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("Alina").withLastName("Modified").withbMonth("August").withbDay("31").withbYear("1969") ;

    app.contacts().modify(contact);
    app.goTo().home();

    Contacts after = app.contacts().all();
    Assert.assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }


}
