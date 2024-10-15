package com.java.loader.applet;

import com.java.loader.c;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;
import org.jnativehook.GlobalScreen;

final class p implements ActionListener {
  p(d paramd, JToggleButton paramJToggleButton) {}
  
  public final void actionPerformed(ActionEvent paramActionEvent) {
    if (!this.a.isSelected()) {
      this.a.setText(c.a());
      return;
    } 
    c.c = true;
    this.a.setText("...");
    GlobalScreen.addNativeKeyListener(new q(this, this.a));
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\applet\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */