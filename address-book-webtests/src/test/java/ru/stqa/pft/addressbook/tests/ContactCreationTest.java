package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().home();
    Contacts before = app.contacts().all();
    File photo = new File("src/test/resources/stru.jpg");
    ContactData contact = new ContactData()
            .withFirstName("Inna").withLastName("Lisovskaya").withbMonth("April").withbDay("9").withbYear("1989")
            .withPhoto(photo);

    app.contacts().create(contact);
    app.goTo().home();
    Contacts after = app.contacts().all();
    Assert.assertEquals(after.size(), before.size()+1);
    assertThat(after, equalTo(before
            .withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test (enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/stru.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());

  }
}
