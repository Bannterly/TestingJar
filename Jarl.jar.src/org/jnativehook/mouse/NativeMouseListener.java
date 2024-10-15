package org.jnativehook.mouse;

import java.util.EventListener;

public interface NativeMouseListener extends EventListener {
  void nativeMouseClicked(NativeMouseEvent paramNativeMouseEvent);
  
  void nativeMousePressed(NativeMouseEvent paramNativeMouseEvent);
  
  void nativeMouseReleased(NativeMouseEvent paramNativeMouseEvent);
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\org\jnativehook\mouse\NativeMouseListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */