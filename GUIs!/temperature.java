
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Window2 extends JFrame implements ActionListener {
 private Container pane;

    private JButton b,c;
 private JLabel l;
 private JTextField t;

 
  //CONSTRUCTOR SETS EVERYTHING UP
  public Window2() {
     this.setTitle("Temperature Conversion");
     this.setSize(600,400);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
     pane = this.getContentPane();
     pane.setLayout(new BorderLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
    
     b = new JButton("Convert to Farenheit");
     c = new JButton("Convert to Celsius");
     l = new JLabel("Converted Value");
     t = new JTextField(12);
     pane.add(l);
     pane.add(b);
     pane.add(t);
     pane.add(c);
 }

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     Window2 g = new Window2();
     g.setVisible(true);
  }
}
