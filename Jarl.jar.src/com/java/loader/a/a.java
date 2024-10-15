package com.java.loader.a;

import com.java.loader.c;
import java.util.ArrayList;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public final class a implements NativeKeyListener {
  private ArrayList a = new ArrayList();
  
  public final void nativeKeyPressed(NativeKeyEvent paramNativeKeyEvent) {
    boolean bool = (this.a.contains(Integer.valueOf(paramNativeKeyEvent.getKeyCode())) && c.a.contains(Integer.valueOf(paramNativeKeyEvent.getKeyCode()))) ? true : false;
    this.a.add(Integer.valueOf(paramNativeKeyEvent.getKeyCode()));
    if (this.a.containsAll(c.a) && c.a.contains(Integer.valueOf(paramNativeKeyEvent.getKeyCode())) && !c.c && !bool)
      c.a(!c.a()); 
  }
  
  public final void nativeKeyReleased(NativeKeyEvent paramNativeKeyEvent) {
    while (this.a.contains(new Integer(paramNativeKeyEvent.getKeyCode())))
      this.a.remove(new Integer(paramNativeKeyEvent.getKeyCode())); 
  }
  
  public final void nativeKeyTyped(NativeKeyEvent paramNativeKeyEvent) {}
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */