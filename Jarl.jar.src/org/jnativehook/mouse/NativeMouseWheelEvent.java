package org.jnativehook.mouse;

public class NativeMouseWheelEvent extends NativeMouseEvent {
  private static final long serialVersionUID = -183110294708745910L;
  
  public static final int WHEEL_UNIT_SCROLL = 1;
  
  public static final int WHEEL_BLOCK_SCROLL = 2;
  
  private int scrollAmount;
  
  private int scrollType;
  
  private int wheelRotation;
  
  public NativeMouseWheelEvent(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
    super(paramInt1, paramLong, paramInt2, paramInt3, paramInt4, paramInt5);
    this.scrollType = paramInt6;
    this.scrollAmount = paramInt7;
    this.wheelRotation = paramInt8;
  }
  
  public int getScrollAmount() {
    return this.scrollAmount;
  }
  
  public int getScrollType() {
    return this.scrollType;
  }
  
  public int getWheelRotation() {
    return this.wheelRotation;
  }
  
  public String paramString() {
    StringBuilder stringBuilder = new StringBuilder(super.paramString());
    stringBuilder.append(",scrollType=");
    switch (getScrollType()) {
      case 1:
        stringBuilder.append("WHEEL_UNIT_SCROLL");
        stringBuilder.append(",scrollAmount=");
        stringBuilder.append(getScrollAmount());
        stringBuilder.append(",wheelRotation=");
        stringBuilder.append(getWheelRotation());
        return stringBuilder.toString();
      case 2:
        stringBuilder.append("WHEEL_BLOCK_SCROLL");
        stringBuilder.append(",scrollAmount=");
        stringBuilder.append(getScrollAmount());
        stringBuilder.append(",wheelRotation=");
        stringBuilder.append(getWheelRotation());
        return stringBuilder.toString();
    } 
    stringBuilder.append("unknown scroll type");
    stringBuilder.append(",scrollAmount=");
    stringBuilder.append(getScrollAmount());
    stringBuilder.append(",wheelRotation=");
    stringBuilder.append(getWheelRotation());
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\org\jnativehook\mouse\NativeMouseWheelEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */