package com.java.loader.applet;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

final class r implements MouseListener {
  private JFrame a;
  
  r(d paramd, JLabel paramJLabel) {}
  
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
    this.a.setSize(395, 75);
    this.a.getContentPane().setLayout((LayoutManager)null);
    JLabel jLabel;
    (jLabel = new JLabel("<html>CPS Drops destroys manual heuristics by occasionally attempting to drop your CPS below the minimum threshold.<br></html>")).setFont(d.a((d)this.a));
    jLabel.setBounds(5, 5, 385, 65);
    jLabel.setForeground(new Color(42, 172, 255));
    jLabel.setBorder(BorderFactory.createEmptyBorder());
    this.a.getContentPane().add(jLabel);
    this.a.setVisible(true);
  }
  
  public final void mouseClicked(MouseEvent paramMouseEvent) {}
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\applet\r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */