import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;

public class MainClass {
  JButton button;
  JFrame frame;
  JLabel label;
  JRadioButton radiobutton;
  int i = 0;
  String one_of_names;
  private String[] namesArray = {"Quinz", "Nerds are welcome", "Do it like a Sallinger"};

  public static void main(String[] args) {
    MainClass gui = new MainClass();
    gui.go();
  }

  public void go() {
    frame = new JFrame();
    label = new JLabel("Majestic Marvelous Quiz!");
    button = new JButton("Click here");
    radiobutton = new JRadioButton("The answer");

    button.addActionListener(new LabelListener());
    radiobutton.addActionListener(new RadioButtonListener());


    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.getContentPane().add(BorderLayout.EAST, button);
    frame.getContentPane().add(BorderLayout.WEST, radiobutton);
    frame.getContentPane().add(BorderLayout.NORTH, label);

    frame.setSize(300, 300);
    frame.setVisible(true);
  }



  class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      button.setText("Clicked");
    }
  }

  class LabelListener implements ActionListener {
  //  int i = 0;

    public void actionPerformed(ActionEvent event) {
      if (i>2) {
        i = 0;
      }
      one_of_names = namesArray[i];
      label.setText(one_of_names);
      i++;
    }
  }

  class RadioButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      label.setText("The answer is choosen!");
    }
  }
}
