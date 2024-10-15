package com.java.loader.applet;

import com.java.loader.c;
import java.util.ArrayList;
import javax.swing.JToggleButton;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

final class q implements NativeKeyListener {
  private ArrayList a;
  
  q(p paramp, JToggleButton paramJToggleButton) {}
  
  public final void nativeKeyTyped(NativeKeyEvent paramNativeKeyEvent) {}
  
  public final void nativeKeyReleased(NativeKeyEvent paramNativeKeyEvent) {
    c.a.clear();
    ArrayList<Integer> arrayList = new ArrayList();
    for (Integer integer : this.a) {
      if (!arrayList.contains(integer))
        arrayList.add(integer); 
    } 
    c.a.addAll(arrayList);
    this.a.setText(c.a());
    this.a.setSelected(false);
    GlobalScreen.removeNativeKeyListener(this);
    c.c = false;
  }
  
  public final void nativeKeyPressed(NativeKeyEvent paramNativeKeyEvent) {
    this.a.add(Integer.valueOf(paramNativeKeyEvent.getKeyCode()));
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\applet\q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */