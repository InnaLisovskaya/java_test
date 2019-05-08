import javax.swing.*;
import java.awt.*;

public class PoolAnimate {
  int x = 1;
  int y = 1;

  public static void main(String[] args) {
    PoolAnimate gui = new PoolAnimate();
    gui.go();
  }

  public void go() {
    JFrame frame = new JFrame();
    MyDrawP panel = new MyDrawP();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(panel);
    frame.setSize(500, 270);
    frame.setVisible(true);

    for(int i = 0; i< 124; i++) {
      x++; y++;
      panel.repaint();
      try {
        Thread.sleep(25);
      } catch (Exception ex) {}
    }
  }

  class MyDrawP extends JPanel {
    public void paintComponent(Graphics g) {
      g.setColor(Color.WHITE);
      g.fillRect(0,0,500, 250);
      g.setColor(Color.BLUE);
      g.fillRect(x,y,500-x*2, 250-y*2);
    }
  }
}
