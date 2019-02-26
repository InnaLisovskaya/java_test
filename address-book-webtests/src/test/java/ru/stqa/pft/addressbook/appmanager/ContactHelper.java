package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.GroupData;

import java.util.ArrayList;
import java.util.List;
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

    selectField(By.name("bday"), contactData.getbDay());
    selectField(By.name("bmonth"), contactData.getbMonth());

  }

  public void selectContact(int i) {
    wd.findElements(By.name("selected[]")).get(i).click();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void modifySelectedContact(int byId) {
    click(By.xpath("//a[contains(@href,'edit.php?id=" + byId + "')]"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public boolean isContactPresent() {
    if (isElementPresent(By.name("selected[]"))) {
      return true;
    }
    return false;
  }

  public void createContact(ContactData contactData) {
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

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));

    for( WebElement element : elements) {
      String lastName = element.findElement(By.xpath("td[2]")).getText();
      String firstName = element.findElement(By.xpath("td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("Value"));
      ContactData contact = new ContactData(id, firstName, lastName, null, null, null, null, null, null, null, null, null);
      contacts.add(contact);
    }

    return contacts;
  }
}
