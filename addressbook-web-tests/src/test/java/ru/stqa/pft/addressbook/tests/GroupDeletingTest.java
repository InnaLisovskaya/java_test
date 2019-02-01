package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletingTest extends TestBase {
  @Test
  public void testGroupDeleting() throws Exception {
    app.gotoGroupPage();
    app.selectGroup();
    app.deleteSelectedGroups();
    app.gotoGroupPage();
  }
}
