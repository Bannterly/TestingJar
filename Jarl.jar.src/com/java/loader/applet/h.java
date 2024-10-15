package com.java.loader.applet;

import com.java.loader.c;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;

final class h implements ActionListener {
  h(d paramd, JFormattedTextField paramJFormattedTextField) {}
  
  public final void actionPerformed(ActionEvent paramActionEvent) {
    c.f = Integer.valueOf(((String)this.a.getValue()).substring(1, 2)).intValue();
    System.out.println(c.f);
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\applet\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */