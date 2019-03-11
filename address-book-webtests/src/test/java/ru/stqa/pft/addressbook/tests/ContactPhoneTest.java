package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase {

  @Test
  public void testContactPhone(){
    app.goTo().home();
    ContactData contact = app.contacts().allWithPhones().iterator().next();
    ContactData contactInfoFromEditForm = app.contacts().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneTest::cleanedPhone)
            .collect(Collectors.joining("\n"));
  }

  public static String cleanedPhone(String phone) {
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
}
