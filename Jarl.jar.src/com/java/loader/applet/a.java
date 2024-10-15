package com.java.loader.applet;

import javax.swing.JSlider;

public final class a extends JSlider {
  public a() {
    a a1;
    (a1 = this).setOrientation(0);
  }
  
  public a(int paramInt1, int paramInt2) {
    super(5, 25);
    a a1;
    (a1 = this).setOrientation(0);
  }
  
  public final void updateUI() {
    setUI(new RangeSliderUI(this));
    updateLabelUIs();
  }
  
  public final int getValue() {
    return super.getValue();
  }
  
  public final void setValue(int paramInt) {
    int i;
    if ((i = getValue()) == paramInt)
      return; 
    int j = getExtent();
    paramInt = Math.min(Math.max(getMinimum(), paramInt), i + j);
    i = j + i - paramInt;
    getModel().setRangeProperties(paramInt, i, getMinimum(), getMaximum(), getValueIsAdjusting());
  }
  
  public final int a() {
    return getValue() + getExtent();
  }
  
  public final void a(int paramInt) {
    int i = getValue();
    paramInt = Math.min(Math.max(0, paramInt - i), getMaximum() - i);
    setExtent(paramInt);
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\applet\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */