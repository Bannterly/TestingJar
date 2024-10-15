package org.jnativehook.mouse;

import java.util.EventListener;

public interface NativeMouseMotionListener extends EventListener {
  void nativeMouseMoved(NativeMouseEvent paramNativeMouseEvent);
  
  void nativeMouseDragged(NativeMouseEvent paramNativeMouseEvent);
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\org\jnativehook\mouse\NativeMouseMotionListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */