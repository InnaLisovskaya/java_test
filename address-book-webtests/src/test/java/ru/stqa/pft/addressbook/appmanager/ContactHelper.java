package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.GroupData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initContactCreation() {
    if (!isElementPresent(By.tagName("h1"))
            || !wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")) {
      click(By.linkText("add new"));
    }
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillInContactFields(ContactData contactData) {

    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("byear"), contactData.getbYear());

    attach(By.name("photo"), contactData.getPhoto());

    selectField(By.name("bday"), contactData.getbDay());
    selectField(By.name("bmonth"), contactData.getbMonth());

  }

  public void selectContact(int i) {
    wd.findElement(By.cssSelector("input[value='"+ i + "']")).click();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void selectContactForModification(ContactData contact) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", contact.getId()))).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void create(ContactData contactData) {
    initContactCreation();
    fillInContactFields(contactData);
    submitContactCreation();
  }

  @Override
  public String toString() {
    return "ContactHelper{" +
            "wd=" + wd +
            '}';
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));

    for( WebElement element : elements) {
      String lastName = element.findElement(By.xpath("td[2]")).getText();
      String firstName = element.findElement(By.xpath("td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("Value"));
      ContactData contact = new ContactData()
              .withId(id).withFirstName(firstName).withLastName(lastName);
      contacts.add(contact);
    }

    return contacts;
  }

  public void delete(ContactData contact) {
    selectContact(contact.getId());
    deleteSelectedContacts();
  }

  public void modify(ContactData contact) {
    selectContactForModification(contact);
    fillInContactFields(contact);
    submitContactModification();
  }

  public ContactData infoFromEditForm (ContactData contact) {
     selectContactForModification(contact);
     String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
     String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
     String home = wd.findElement(By.name("home")).getAttribute("value");
     String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
     String work = wd.findElement(By.name("work")).getAttribute("value");
     wd.navigate().back();
     return new ContactData().withId(contact.getId()).withFirstName(firstName).withLastName(lastName)
             .withMobilePhone(mobile).withHomePhone(home).withWorkPhone(work);
  }

  public Set<ContactData> allWithPhones() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));

    for( WebElement element : elements) {
      String lastName = element.findElement(By.xpath("td[2]")).getText();
      String firstName = element.findElement(By.xpath("td[3]")).getText();
      String allPhones = element.findElement(By.xpath("td[6]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("Value"));
      ContactData contact = new ContactData()
              .withId(id).withFirstName(firstName).withLastName(lastName)
              .withAllPhones(allPhones);
      contacts.add(contact);
    }

    return contacts;
  }
}
