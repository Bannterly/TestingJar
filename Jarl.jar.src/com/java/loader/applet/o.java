package com.java.loader.applet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

final class o implements ActionListener {
  o(d paramd) {}
  
  public final void actionPerformed(ActionEvent paramActionEvent) {
    int i;
    if ((i = JOptionPane.showConfirmDialog(null, "Are you sure you would like to destruct?", "Destruct", 0)) == 0)
      System.exit(69); 
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\applet\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */