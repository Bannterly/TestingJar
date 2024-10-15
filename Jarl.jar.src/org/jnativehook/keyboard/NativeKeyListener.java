package org.jnativehook.keyboard;

import java.util.EventListener;

public interface NativeKeyListener extends EventListener {
  void nativeKeyPressed(NativeKeyEvent paramNativeKeyEvent);
  
  void nativeKeyReleased(NativeKeyEvent paramNativeKeyEvent);
  
  void nativeKeyTyped(NativeKeyEvent paramNativeKeyEvent);
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\org\jnativehook\keyboard\NativeKeyListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */