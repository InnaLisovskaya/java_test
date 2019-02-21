package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() throws Exception {
    app.getNavigationHelper().returnHome();
    app.getContactHelper().selectContact();
    app.getContactHelper().modifySelectedContact();
    app.getContactHelper().fillInContactFields(new ContactData("Alina", "Lisovskaya", "Inka", null, null, "Alina's address", "8877665544", "innalis1985@mail.ru", "August", "31", "1985"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnHome();
  }
}
