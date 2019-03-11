package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase {

  @Test
  public void testContactPhone(){
    app.goTo().home();
    ContactData contact = app.contacts().allWithPhones().iterator().next();
    ContactData contactInfoFromEditForm = app.contacts().infoFromEditForm(contact);

    assertThat(contact.getHomePhone(), equalTo(cleanedPhone(contactInfoFromEditForm.getHomePhone())));
    assertThat(contact.getMobilePhone(), equalTo(cleanedPhone(contactInfoFromEditForm.getMobilePhone())));
    assertThat(contact.getWorkPhone(), equalTo(cleanedPhone(contactInfoFromEditForm.getWorkPhone())));
  }

  public String cleanedPhone(String phone) {
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
}
