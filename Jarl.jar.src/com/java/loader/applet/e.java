package com.java.loader.applet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

final class e implements MouseMotionListener {
  e(d paramd) {}
  
  public final void mouseMoved(MouseEvent paramMouseEvent) {}
  
  public final void mouseDragged(MouseEvent paramMouseEvent) {
    int j = paramMouseEvent.getXOnScreen();
    int i = paramMouseEvent.getYOnScreen();
    this.a.setLocation(j - d.a(this.a), i - d.b(this.a));
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\applet\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */