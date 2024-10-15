package com.java.loader.applet;

import com.java.loader.c;
import javax.swing.JFormattedTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

final class i implements ChangeListener {
  i(d paramd, JFormattedTextField paramJFormattedTextField1, a parama, JFormattedTextField paramJFormattedTextField2) {}
  
  public final void stateChanged(ChangeEvent paramChangeEvent) {
    this.a.setValue(Integer.valueOf(c.a = this.a.getValue()));
    this.b.setValue(Integer.valueOf(c.b = this.a.a()));
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\applet\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */