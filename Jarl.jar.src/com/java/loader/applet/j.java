package com.java.loader.applet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;

final class j implements ActionListener {
  j(d paramd, JFormattedTextField paramJFormattedTextField1, JFormattedTextField paramJFormattedTextField2, a parama) {}
  
  public final void actionPerformed(ActionEvent paramActionEvent) {
    int i = ((Number)this.a.getValue()).intValue();
    int k = ((Number)this.b.getValue()).intValue();
    if (i <= k && i >= this.a.getMinimum() && k <= this.a.getMaximum()) {
      this.a.setValue(i);
      this.a.a(k);
    } 
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\applet\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */