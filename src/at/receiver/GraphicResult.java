package at.receiver;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;



public class GraphicResult {

  private class MyPanel extends JPanel{

    private String name;
    private float value;

    public void setNameAndValue(String name, float value){
      this.name = name;
      this.value = value;
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D)g;
      g2d.setColor(Color.CYAN);
      int height = (int)value*10;
      g2d.fillRect(20,700 - height, 100, height);
      g2d.setColor(Color.BLACK);
      g2d.drawString(String.format("%s: %.2f", name, value), 20, 20);

    }
  }

  private JFrame frame;
  private MyPanel drawPanel;

  public GraphicResult()
  {
    frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(160,1000);
    drawPanel = new MyPanel();
    frame.add(drawPanel);
    frame.setVisible(true);


  }

  public void logResult(String sensorName, float sensorData){

    drawPanel.setNameAndValue(sensorName, sensorData);
    frame.repaint();

  }

}
