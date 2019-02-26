package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() throws Exception{
    app.getNavigationHelper().returnHome();
    if (!app.getContactHelper().isContactPresent()) {
      app.getContactHelper().createContact(new ContactData("For deletion", null, null ,null, null, null, null, null, "June", "22", "1987") );
    }
    app.getNavigationHelper().returnHome();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(0);
    app.getContactHelper().deleteSelectedContacts();
    app.getNavigationHelper().returnHome();
    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(0);
    Assert.assertEquals(before, after);
  }
}