package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test (enabled = false)
  public void testContactCreation() throws Exception {
    app.goTo().returnHome();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Inna", "Lisovskaya", null ,null, null, null, null, null, "August", "31", null );
    app.getContactHelper().createContact(contact);
    app.goTo().returnHome();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size()+1);

    before.add(contact);

    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId()) ;
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
