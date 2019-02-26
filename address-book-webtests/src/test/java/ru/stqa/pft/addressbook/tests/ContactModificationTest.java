package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactModificationTest extends TestBase {
  @Test
  public void testContactModification() throws Exception {
    app.getNavigationHelper().returnHome();
    if (!app.getContactHelper().isContactPresent()) {
      app.getContactHelper().createContact(new ContactData("For modification", null, null ,null, null, null, null, null, "June", "22", "1987")  );
    }
    app.getNavigationHelper().returnHome();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().modifySelectedContact(before.get(before.size()-1).getId());
    ContactData contact = new ContactData(before.get(before.size()-1).getId(),"Alina", "Modified", null ,null, null, null, null, null, "August", "31", null );
    app.getContactHelper().fillInContactFields(contact);
    app.getContactHelper().submitContactModification();

    app.getNavigationHelper().returnHome();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size()-1);
    before.add(contact);

    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId()) ;
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
