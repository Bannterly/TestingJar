package com.java.loader.a;

import com.java.loader.c;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

public final class b implements NativeMouseListener {
  private com.java.loader.b a;
  
  private boolean a = new com.java.loader.b(false);
  
  public b() {
    this.a.start();
    this.a = false;
  }
  
  public final void nativeMousePressed(NativeMouseEvent paramNativeMouseEvent) {
    if (paramNativeMouseEvent.getButton() == 1 && System.currentTimeMillis() - this.a.a() <= 20L) {
      this.a = true;
      return;
    } 
    if (paramNativeMouseEvent.getButton() == 1 && c.a()) {
      this.a.a(true);
      this.a = true;
    } 
  }
  
  public final void nativeMouseReleased(NativeMouseEvent paramNativeMouseEvent) {
    if (paramNativeMouseEvent.getButton() == 1 && this.a) {
      this.a = false;
      return;
    } 
    if (paramNativeMouseEvent.getButton() == 1)
      this.a.a(false); 
  }
  
  public final void nativeMouseClicked(NativeMouseEvent paramNativeMouseEvent) {}
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */