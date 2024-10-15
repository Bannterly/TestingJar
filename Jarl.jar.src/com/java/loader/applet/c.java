package com.java.loader.applet;

import java.awt.event.MouseEvent;
import javax.swing.plaf.basic.BasicSliderUI;

public final class c extends BasicSliderUI.TrackListener {
  public c(RangeSliderUI paramRangeSliderUI) {
    super(paramRangeSliderUI);
  }
  
  public final void mousePressed(MouseEvent paramMouseEvent) {
    if (!RangeSliderUI.a(this.a).isEnabled())
      return; 
    this.currentMouseX = paramMouseEvent.getX();
    this.currentMouseY = paramMouseEvent.getY();
    if (RangeSliderUI.a(this.a).isRequestFocusEnabled())
      RangeSliderUI.a(this.a).requestFocus(); 
    boolean bool1 = false;
    boolean bool2 = false;
    if (RangeSliderUI.c(this.a) || RangeSliderUI.a(this.a).getMinimum() == RangeSliderUI.a(this.a).getValue()) {
      if (RangeSliderUI.a(this.a).contains(this.currentMouseX, this.currentMouseY)) {
        bool2 = true;
      } else if (RangeSliderUI.b(this.a).contains(this.currentMouseX, this.currentMouseY)) {
        bool1 = true;
      } 
    } else if (RangeSliderUI.b(this.a).contains(this.currentMouseX, this.currentMouseY)) {
      bool1 = true;
    } else if (RangeSliderUI.a(this.a).contains(this.currentMouseX, this.currentMouseY)) {
      bool2 = true;
    } 
    if (bool1) {
      switch (RangeSliderUI.a(this.a).getOrientation()) {
        case 1:
          this.offset = this.currentMouseY - (RangeSliderUI.b(this.a)).y;
          break;
        case 0:
          this.offset = this.currentMouseX - (RangeSliderUI.b(this.a)).x;
          break;
      } 
      RangeSliderUI.a(this.a, false);
      RangeSliderUI.b(this.a, true);
      return;
    } 
    RangeSliderUI.b(this.a, false);
    if (bool2) {
      switch (RangeSliderUI.a(this.a).getOrientation()) {
        case 1:
          this.offset = this.currentMouseY - (RangeSliderUI.a(this.a)).y;
          break;
        case 0:
          this.offset = this.currentMouseX - (RangeSliderUI.a(this.a)).x;
          break;
      } 
      RangeSliderUI.a(this.a, true);
      RangeSliderUI.c(this.a, true);
      return;
    } 
    RangeSliderUI.c(this.a, false);
  }
  
  public final void mouseReleased(MouseEvent paramMouseEvent) {
    RangeSliderUI.b(this.a, false);
    RangeSliderUI.c(this.a, false);
    RangeSliderUI.a(this.a).setValueIsAdjusting(false);
    super.mouseReleased(paramMouseEvent);
  }
  
  public final void mouseDragged(MouseEvent paramMouseEvent) {
    if (!RangeSliderUI.a(this.a).isEnabled())
      return; 
    this.currentMouseX = paramMouseEvent.getX();
    this.currentMouseY = paramMouseEvent.getY();
    if (RangeSliderUI.a(this.a)) {
      int i;
      int j;
      int k;
      int m;
      int n;
      RangeSliderUI.a(this.a).setValueIsAdjusting(true);
      c c1;
      switch (RangeSliderUI.a((c1 = this).a).getOrientation()) {
        case 1:
          i = (RangeSliderUI.b(c1.a)).height / 2;
          j = c1.currentMouseY - c1.offset;
          k = (RangeSliderUI.c(c1.a)).y;
          m = (RangeSliderUI.c(c1.a)).y + (RangeSliderUI.c(c1.a)).height - 1;
          n = RangeSliderUI.a(c1.a, RangeSliderUI.a(c1.a).getValue() + RangeSliderUI.a(c1.a).getExtent());
          if (RangeSliderUI.d(c1.a)) {
            m = n;
          } else {
            k = n;
          } 
          j = Math.min(j = Math.max(j, k - i), m - i);
          c1.a.setThumbLocation((RangeSliderUI.b(c1.a)).x, j);
          i = j + i;
          RangeSliderUI.a(c1.a).setValue(c1.a.valueForYPosition(i));
          return;
        case 0:
          i = (RangeSliderUI.b(c1.a)).width / 2;
          j = c1.currentMouseX - c1.offset;
          k = (RangeSliderUI.c(c1.a)).x;
          m = (RangeSliderUI.c(c1.a)).x + (RangeSliderUI.c(c1.a)).width - 1;
          n = RangeSliderUI.b(c1.a, RangeSliderUI.a(c1.a).getValue() + RangeSliderUI.a(c1.a).getExtent());
          if (RangeSliderUI.d(c1.a)) {
            k = n;
          } else {
            m = n;
          } 
          j = Math.min(j = Math.max(j, k - i), m - i);
          c1.a.setThumbLocation(j, (RangeSliderUI.b(c1.a)).y);
          i = j + i;
          RangeSliderUI.a(c1.a).setValue(c1.a.valueForXPosition(i));
          return;
      } 
      return;
    } 
    if (RangeSliderUI.b(this.a)) {
      int i;
      int j;
      int k;
      int m;
      int n;
      RangeSliderUI.a(this.a).setValueIsAdjusting(true);
      c c1;
      switch (RangeSliderUI.a((c1 = this).a).getOrientation()) {
        case 1:
          i = (RangeSliderUI.b(c1.a)).height / 2;
          j = c1.currentMouseY - c1.offset;
          k = (RangeSliderUI.c(c1.a)).y;
          m = (RangeSliderUI.c(c1.a)).y + (RangeSliderUI.c(c1.a)).height - 1;
          n = RangeSliderUI.a(c1.a, RangeSliderUI.a(c1.a).getValue());
          if (RangeSliderUI.d(c1.a)) {
            k = n;
          } else {
            m = n;
          } 
          j = Math.min(j = Math.max(j, k - i), m - i);
          RangeSliderUI.a(c1.a, (RangeSliderUI.b(c1.a)).x, j);
          i = j + i;
          RangeSliderUI.a(c1.a).setExtent(c1.a.valueForYPosition(i) - RangeSliderUI.a(c1.a).getValue());
          return;
        case 0:
          i = (RangeSliderUI.b(c1.a)).width / 2;
          j = c1.currentMouseX - c1.offset;
          k = (RangeSliderUI.c(c1.a)).x;
          m = (RangeSliderUI.c(c1.a)).x + (RangeSliderUI.c(c1.a)).width - 1;
          n = RangeSliderUI.b(c1.a, RangeSliderUI.a(c1.a).getValue());
          if (RangeSliderUI.d(c1.a)) {
            m = n;
          } else {
            k = n;
          } 
          j = Math.min(j = Math.max(j, k - i), m - i);
          RangeSliderUI.a(c1.a, j, (RangeSliderUI.b(c1.a)).y);
          i = j + i;
          RangeSliderUI.a(c1.a).setExtent(c1.a.valueForXPosition(i) - RangeSliderUI.a(c1.a).getValue());
          return;
      } 
    } 
  }
  
  public final boolean shouldScroll(int paramInt) {
    return false;
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\applet\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */