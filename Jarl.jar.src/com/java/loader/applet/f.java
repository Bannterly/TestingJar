package com.java.loader.applet;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

final class f implements MouseListener {
  private JFrame a;
  
  f(d paramd, JLabel paramJLabel) {}
  
  public final void mouseReleased(MouseEvent paramMouseEvent) {}
  
  public final void mousePressed(MouseEvent paramMouseEvent) {}
  
  public final void mouseExited(MouseEvent paramMouseEvent) {
    this.a.setVisible(false);
    this.a.dispose();
  }
  
  public final void mouseEntered(MouseEvent paramMouseEvent) {
    this.a = (JLabel)new JFrame();
    this.a.setType(Window.Type.UTILITY);
    this.a.setBackground(new Color(66, 69, 74));
    this.a.getContentPane().setBackground(new Color(66, 69, 74));
    this.a.setUndecorated(true);
    this.a.setLocation((this.a.getLocationOnScreen()).x + 15, (this.a.getLocationOnScreen()).y + 10);
    this.a.setSize(395, 85);
    this.a.getContentPane().setLayout((LayoutManager)null);
    JLabel jLabel;
    (jLabel = new JLabel("<html><b color=\"red\"><i>Currently disabled</b></i><br>While autoclicking, VeneClicker will simulate mouse movements for the user.<br><br><code><span bgcolor=\"#6A6D72\">|X-Axis|</span></code> The absolute value of the x-axis jitter range. -x &lt;= val &lt;= x<br><code><span bgcolor=\"#6A6D72\">|Y-Axis|</span></code> The absolute value of the y-axis jitter range. -y &lt;= val &lt;= y</html>")).setFont(d.a((d)this.a));
    jLabel.setBounds(5, 5, 385, 75);
    jLabel.setForeground(new Color(42, 172, 255));
    jLabel.setBorder(BorderFactory.createEmptyBorder());
    this.a.getContentPane().add(jLabel);
    this.a.setVisible(true);
  }
  
  public final void mouseClicked(MouseEvent paramMouseEvent) {}
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\applet\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */