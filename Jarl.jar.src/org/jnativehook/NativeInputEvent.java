package org.jnativehook;

import java.awt.Toolkit;
import java.util.EventObject;

public class NativeInputEvent extends EventObject {
  private static final long serialVersionUID = -6960142969790223296L;
  
  private int id;
  
  private long when;
  
  private int modifiers;
  
  private short reserved;
  
  public static final int SHIFT_L_MASK = 1;
  
  public static final int CTRL_L_MASK = 2;
  
  public static final int META_L_MASK = 4;
  
  public static final int ALT_L_MASK = 8;
  
  public static final int SHIFT_R_MASK = 16;
  
  public static final int CTRL_R_MASK = 32;
  
  public static final int META_R_MASK = 64;
  
  public static final int ALT_R_MASK = 128;
  
  public static final int SHIFT_MASK = 17;
  
  public static final int CTRL_MASK = 34;
  
  public static final int META_MASK = 68;
  
  public static final int ALT_MASK = 136;
  
  public static final int BUTTON1_MASK = 256;
  
  public static final int BUTTON2_MASK = 512;
  
  public static final int BUTTON3_MASK = 1024;
  
  public static final int BUTTON4_MASK = 2048;
  
  public static final int BUTTON5_MASK = 4096;
  
  public NativeInputEvent(Class<GlobalScreen> paramClass, int paramInt1, long paramLong, int paramInt2) {
    super(paramClass);
    this.id = paramInt1;
    this.when = paramLong;
    this.modifiers = paramInt2;
    this.reserved = 0;
  }
  
  public int getID() {
    return this.id;
  }
  
  public long getWhen() {
    return this.when;
  }
  
  public int getModifiers() {
    return this.modifiers;
  }
  
  public void setModifiers(int paramInt) {
    this.modifiers = paramInt;
  }
  
  private void setReserved(short paramShort) {
    this.reserved = paramShort;
  }
  
  public static String getModifiersText(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder(255);
    if ((paramInt & 0x11) != 0) {
      stringBuilder.append(Toolkit.getProperty("AWT.shift", "Shift"));
      stringBuilder.append('+');
    } 
    if ((paramInt & 0x22) != 0) {
      stringBuilder.append(Toolkit.getProperty("AWT.control", "Ctrl"));
      stringBuilder.append('+');
    } 
    if ((paramInt & 0x44) != 0) {
      stringBuilder.append(Toolkit.getProperty("AWT.meta", "Meta"));
      stringBuilder.append('+');
    } 
    if ((paramInt & 0x88) != 0) {
      stringBuilder.append(Toolkit.getProperty("AWT.alt", "Alt"));
      stringBuilder.append('+');
    } 
    if ((paramInt & 0x100) != 0) {
      stringBuilder.append(Toolkit.getProperty("AWT.button1", "Button1"));
      stringBuilder.append('+');
    } 
    if ((paramInt & 0x200) != 0) {
      stringBuilder.append(Toolkit.getProperty("AWT.button2", "Button2"));
      stringBuilder.append('+');
    } 
    if ((paramInt & 0x400) != 0) {
      stringBuilder.append(Toolkit.getProperty("AWT.button3", "Button3"));
      stringBuilder.append('+');
    } 
    if ((paramInt & 0x800) != 0) {
      stringBuilder.append(Toolkit.getProperty("AWT.button4", "Button4"));
      stringBuilder.append('+');
    } 
    if ((paramInt & 0x1000) != 0) {
      stringBuilder.append(Toolkit.getProperty("AWT.button5", "Button5"));
      stringBuilder.append('+');
    } 
    if (stringBuilder.length() > 0)
      stringBuilder.deleteCharAt(stringBuilder.length() - 1); 
    return stringBuilder.toString();
  }
  
  public String paramString() {
    StringBuilder stringBuilder = new StringBuilder(255);
    stringBuilder.append("id=");
    stringBuilder.append(getID());
    stringBuilder.append(',');
    stringBuilder.append("when=");
    stringBuilder.append(getWhen());
    stringBuilder.append(',');
    stringBuilder.append("mask=");
    stringBuilder.append(Integer.toBinaryString(getModifiers()));
    stringBuilder.append(',');
    stringBuilder.append("modifiers=");
    stringBuilder.append(getModifiersText(getModifiers()));
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\org\jnativehook\NativeInputEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */