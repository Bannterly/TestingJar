package com.java.loader.applet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSliderUI;

class RangeSliderUI extends BasicSliderUI {
  private Color a;
  
  private Rectangle a;
  
  private boolean a = new Color(42, 172, 255);
  
  private transient boolean b;
  
  private transient boolean c;
  
  public RangeSliderUI(a parama) {
    super(parama);
  }
  
  public void installUI(JComponent paramJComponent) {
    this.a = new Rectangle();
    super.installUI(paramJComponent);
  }
  
  protected BasicSliderUI.TrackListener createTrackListener(JSlider paramJSlider) {
    return new c(this);
  }
  
  protected ChangeListener createChangeListener(JSlider paramJSlider) {
    return new b(this);
  }
  
  protected void calculateThumbSize() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial calculateThumbSize : ()V
    //   4: aload_0
    //   5: getfield a : Ljava/awt/Rectangle;
    //   8: aload_0
    //   9: getfield thumbRect : Ljava/awt/Rectangle;
    //   12: getfield width : I
    //   15: aload_0
    //   16: getfield thumbRect : Ljava/awt/Rectangle;
    //   19: getfield height : I
    //   22: invokevirtual setSize : (II)V
    //   25: return
  }
  
  protected void calculateThumbLocation() {
    super.calculateThumbLocation();
    if (this.slider.getSnapToTicks()) {
      int j = this.slider.getValue() + this.slider.getExtent();
      int k = j;
      int m = this.slider.getMajorTickSpacing();
      int n = this.slider.getMinorTickSpacing();
      int i1 = 0;
      if (n > 0) {
        i1 = n;
      } else if (m > 0) {
        i1 = m;
      } 
      if (i1 != 0) {
        int i2;
        if ((j - this.slider.getMinimum()) % i1 != 0) {
          float f;
          i2 = Math.round(f = (j - this.slider.getMinimum()) / i1);
          i2 = this.slider.getMinimum() + i2 * i1;
        } 
        if (i2 != j)
          this.slider.setExtent(i2 - this.slider.getValue()); 
      } 
    } 
    if (this.slider.getOrientation() == 0) {
      int j = xPositionForValue(this.slider.getValue() + this.slider.getExtent());
      this.a.x = j - this.a.width / 2;
      this.a.y = this.trackRect.y;
      return;
    } 
    int i = yPositionForValue(this.slider.getValue() + this.slider.getExtent());
    this.a.x = this.trackRect.x;
    this.a.y = i - this.a.height / 2;
  }
  
  protected Dimension getThumbSize() {
    return new Dimension(12, 12);
  }
  
  public void paint(Graphics paramGraphics, JComponent paramJComponent) {
    super.paint(paramGraphics, paramJComponent);
    Rectangle rectangle = paramGraphics.getClipBounds();
    if (this.a) {
      if (rectangle.intersects(this.thumbRect))
        a(paramGraphics); 
      if (rectangle.intersects(this.a)) {
        b(paramGraphics);
        return;
      } 
    } else {
      if (rectangle.intersects(this.a))
        b(paramGraphics); 
      if (rectangle.intersects(this.thumbRect))
        a(paramGraphics); 
    } 
  }
  
  public void paintTrack(Graphics paramGraphics) {
    super.paintTrack(paramGraphics);
    Rectangle rectangle = this.trackRect;
    if (this.slider.getOrientation() == 0) {
      int m = this.thumbRect.x + this.thumbRect.width / 2;
      int n = this.a.x + this.a.width / 2;
      int i1 = rectangle.height / 2 - 2;
      Color color1 = paramGraphics.getColor();
      paramGraphics.translate(rectangle.x, rectangle.y + i1);
      paramGraphics.setColor(this.a);
      for (byte b1 = 0; b1 <= 3; b1++)
        paramGraphics.drawLine(m - rectangle.x, b1, n - rectangle.x, b1); 
      paramGraphics.translate(-rectangle.x, -(rectangle.y + i1));
      paramGraphics.setColor(color1);
      return;
    } 
    int i = this.thumbRect.x + this.thumbRect.width / 2;
    int j = this.a.x + this.a.width / 2;
    int k = rectangle.width / 2 - 2;
    Color color = paramGraphics.getColor();
    paramGraphics.translate(rectangle.x + k, rectangle.y);
    paramGraphics.setColor(this.a);
    for (byte b = 0; b <= 3; b++)
      paramGraphics.drawLine(b, i - rectangle.y, b, j - rectangle.y); 
    paramGraphics.translate(-(rectangle.x + k), -rectangle.y);
    paramGraphics.setColor(color);
  }
  
  public void paintThumb(Graphics paramGraphics) {}
  
  private void a(Graphics paramGraphics) {
    Rectangle rectangle;
    int i = (rectangle = this.thumbRect).width;
    int j = rectangle.height;
    paramGraphics = paramGraphics.create();
    Shape shape = a(i - 1, j - 1);
    paramGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    paramGraphics.translate(rectangle.x, rectangle.y);
    paramGraphics.setColor(new Color(255, 199, 60));
    paramGraphics.fill(shape);
    paramGraphics.dispose();
  }
  
  private void b(Graphics paramGraphics) {
    boolean bool;
    int i = (bool = this.a).width;
    int j = bool.height;
    paramGraphics = paramGraphics.create();
    Shape shape = a(i - 1, j - 1);
    paramGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    paramGraphics.translate(bool.x, bool.y);
    paramGraphics.setColor(new Color(216, 73, 63));
    paramGraphics.fill(shape);
    paramGraphics.dispose();
  }
  
  private static Shape a(int paramInt1, int paramInt2) {
    Ellipse2D.Double double_;
    return double_ = new Ellipse2D.Double(0.0D, 0.0D, paramInt1, paramInt2);
  }
  
  public void scrollByBlock(int paramInt) {
    synchronized (this.slider) {
      int i;
      if ((i = (this.slider.getMaximum() - this.slider.getMinimum()) / 10) <= 0 && this.slider.getMaximum() > this.slider.getMinimum())
        i = 1; 
      paramInt = i * ((paramInt > 0) ? 1 : -1);
      if (this.a) {
        i = ((a)this.slider).a();
        ((a)this.slider).a(i + paramInt);
      } else {
        i = this.slider.getValue();
        this.slider.setValue(i + paramInt);
      } 
      return;
    } 
  }
  
  public void scrollByUnit(int paramInt) {
    synchronized (this.slider) {
      paramInt = 1 * ((paramInt > 0) ? 1 : -1);
      if (this.a) {
        int i = ((a)this.slider).a();
        ((a)this.slider).a(i + paramInt);
      } else {
        int i = this.slider.getValue();
        this.slider.setValue(i + paramInt);
      } 
      return;
    } 
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\applet\RangeSliderUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */