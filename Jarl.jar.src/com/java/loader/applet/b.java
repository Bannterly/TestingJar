package com.java.loader.applet;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public final class b implements ChangeListener {
  public b(RangeSliderUI paramRangeSliderUI) {}
  
  public final void stateChanged(ChangeEvent paramChangeEvent) {
    if (!RangeSliderUI.a(this.a) && !RangeSliderUI.b(this.a)) {
      this.a.calculateThumbLocation();
      RangeSliderUI.a(this.a).repaint();
    } 
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\applet\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */