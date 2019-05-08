import javafx.scene.layout.Background;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainClass {
  JButton buttonGo, buttonNext;
  JFrame frame;
  JLabel label, label2, emptyLabel, questionLabel;
  JRadioButton radiobutton1, radiobutton2, radiobutton3;
  JPanel mainPanel, northPanel;
  JTextField textField;
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
    label2 = new JLabel("Let's get started!");
    questionLabel = new JLabel("Here is the question:");
    emptyLabel = new JLabel("\n");
    buttonGo = new JButton("Go!");
    buttonNext = new JButton("Next >>");
    radiobutton1 = new JRadioButton("The answer 1");
    radiobutton2 = new JRadioButton("The answer 2");
    radiobutton3 = new JRadioButton("The answer 3");
    mainPanel = new MyPanel();
    northPanel = new MyPanel();
    textField = new JTextField("Please input your name here", 20);

    //конструктор диспетчера BoxLayout (компоненты, ось)
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));

  //  label.setBackground(Color.WHITE);
  //  northPanel.setBackground(Color.DARK_GRAY);

    mainPanel.add(label2);
    mainPanel.add(buttonGo);
    northPanel.add(label);
    northPanel.add(textField);
    mainPanel.add(radiobutton1);

    //button.addActionListener(new LabelListener());
    buttonGo.addActionListener(new ButtonGoListener());
    radiobutton1.addActionListener(new RadioButton1Listener());
    radiobutton2.addActionListener(new RadioButton2Listener());
    radiobutton3.addActionListener(new RadioButton3Listener());
    textField.addActionListener(new TextFieldListener());
    buttonNext.addActionListener(new ButtonNextListener());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(BorderLayout.NORTH, northPanel);
    frame.getContentPane().add(BorderLayout.WEST, mainPanel);

    frame.setSize(300, 300);
    frame.setVisible(true);
  }



  class ButtonGoListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      System.out.println(textField.getText());
      label2.setText("You are in the system now!");
      northPanel.remove(textField);
      mainPanel.remove(label2);
      mainPanel.remove(buttonGo);
      mainPanel.add(questionLabel);
      mainPanel.add(buttonNext);
    //  mainPanel.add(questionLabel);
  //    frame.removeAll();
    }
  }

  class LabelListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if (i>2) {
        i = 0;
      }
      one_of_names = namesArray[i];
      label.setText(one_of_names);
      i++;
    }
  }

  class RadioButton1Listener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
   //   label.setText("The answer is choosen!");
      System.out.println(radiobutton1.getText());
      radiobutton2.setSelected(false);
      radiobutton3.setSelected(false);
    }
  }

  class RadioButton2Listener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      //   label.setText("The answer is choosen!");
      System.out.println(radiobutton2.getText());
      radiobutton1.setSelected(false);
      radiobutton3.setSelected(false);
    }
  }

  class RadioButton3Listener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      //   label.setText("The answer is choosen!");
      System.out.println(radiobutton3.getText());
      radiobutton2.setSelected(false);
      radiobutton1.setSelected(false);
    }
  }
  class TextFieldListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      System.out.println(textField.getText());

    }
  }

  class MyPanel extends JPanel {
    public void paintComponent(Graphics g) {
    }
  }

  class ButtonNextListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      label.setText("Next question is :");
      mainPanel.remove(questionLabel);
      mainPanel.remove(buttonNext);
      mainPanel.add(radiobutton1);
      mainPanel.add(radiobutton2);
      mainPanel.add(radiobutton3);
      mainPanel.add(buttonNext);


    }
  }
}
