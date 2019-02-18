package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoAddContactPage();
    app.getContactHelper().fillInContactFields(new ContactData("Inna", "Lisovskaya", "Inka", "title", "My Company", "454016, Chelyabinsk, Molod st., 59-96", "8877665544", "innalis1985@mail.ru", "August", "31", "1985"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnHome();
  }

}
