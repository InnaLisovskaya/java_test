package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.models.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillInGroupForm(GroupData groupData) {

    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());

  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup(int i) {
    wd.findElements(By.name("selected[]")).get(i).click();
  }

  public void modifySelectedGroups() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void createGroup(GroupData groupData) {
    initGroupCreation();
    fillInGroupForm(groupData);
    submitGroupCreation();
  }

  public boolean isThereAGroup() {
    if (isElementPresent(By.name("selected[]"))) {
      return true;
    }
    return false;
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> getGroupList() {
    List<GroupData> groups = new ArrayList<GroupData>();

    List<WebElement>  elements = wd.findElements(By.cssSelector("span.group"));

    for( WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("Value"));
      GroupData group = new GroupData(id, name, null, null);
      groups.add(group);
    }

    return groups;
  }
}

