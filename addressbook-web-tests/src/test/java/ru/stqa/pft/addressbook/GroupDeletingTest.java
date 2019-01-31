package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupDeletingTest extends TestBase {
  @Test
  public void testGroupDeleting() throws Exception {
    gotoGroupPage();
    selectGroup();
    deleteSelectedGroups();
    gotoGroupPage();
  }
}
