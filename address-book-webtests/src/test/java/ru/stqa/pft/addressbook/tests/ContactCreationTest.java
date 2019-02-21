package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().createContact(new ContactData("Inna", "Lisovskaya", null, null, null, null, null, null, "August", "31", "1986"));
    app.getNavigationHelper().returnHome();
  }

}
