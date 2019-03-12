package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import org.testng.annotations.Parameters;
import ru.stqa.pft.addressbook.models.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

  @Parameter(names = "-c", description = "Groups count")
  public int count;

  @Parameter(names = "-f", description = "target file")
  public String filename;

  public static void main (String[] args) throws IOException {

    GroupDataGenerator generator = new GroupDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }



    generator.run();

   // int count = Integer.parseInt(args[0]);
   // File file = new File(args[1]);
  }

  private void run() throws IOException {
    List<GroupData> groups = generateGroups(count);
    save(groups, new File(filename));
  }

  private static void save(List<GroupData> groups, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (GroupData group : groups) {
      writer.write(String.format ("%s %s %s\n", group.getName(), group.getHeader(), group.getFooter()));
    }
    writer.close();
  }

  private static List<GroupData> generateGroups(int count) {

    List<GroupData> groups = new ArrayList<GroupData>();
    for(int i = 0; i < count; i ++) {
      groups.add(new GroupData()
              .withName(String.format("test %s", i))
              .withHeader(String.format("header %s", i))
              .withFooter(String.format("footer %s", i)));
    }
    return groups;
  }
}
