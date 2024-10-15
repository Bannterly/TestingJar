package org.jnativehook;

import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;
import javax.swing.event.EventListenerList;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseMotionListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

public final class GlobalScreen {
  private static Logger log = Logger.getLogger(GlobalScreen.class.getPackage().getName());
  
  private static NativeHookThread hookThread;
  
  private static ExecutorService eventExecutor = new DefaultDispatchService();
  
  private static EventListenerList eventListeners = new EventListenerList();
  
  public static void addNativeKeyListener(NativeKeyListener paramNativeKeyListener) {
    if (paramNativeKeyListener != null)
      eventListeners.add(NativeKeyListener.class, paramNativeKeyListener); 
  }
  
  public static void removeNativeKeyListener(NativeKeyListener paramNativeKeyListener) {
    if (paramNativeKeyListener != null)
      eventListeners.remove(NativeKeyListener.class, paramNativeKeyListener); 
  }
  
  public static void addNativeMouseListener(NativeMouseListener paramNativeMouseListener) {
    if (paramNativeMouseListener != null)
      eventListeners.add(NativeMouseListener.class, paramNativeMouseListener); 
  }
  
  public static void removeNativeMouseListener(NativeMouseListener paramNativeMouseListener) {
    if (paramNativeMouseListener != null)
      eventListeners.remove(NativeMouseListener.class, paramNativeMouseListener); 
  }
  
  public static void addNativeMouseMotionListener(NativeMouseMotionListener paramNativeMouseMotionListener) {
    if (paramNativeMouseMotionListener != null)
      eventListeners.add(NativeMouseMotionListener.class, paramNativeMouseMotionListener); 
  }
  
  public static void removeNativeMouseMotionListener(NativeMouseMotionListener paramNativeMouseMotionListener) {
    if (paramNativeMouseMotionListener != null)
      eventListeners.remove(NativeMouseMotionListener.class, paramNativeMouseMotionListener); 
  }
  
  public static void addNativeMouseWheelListener(NativeMouseWheelListener paramNativeMouseWheelListener) {
    if (paramNativeMouseWheelListener != null)
      eventListeners.add(NativeMouseWheelListener.class, paramNativeMouseWheelListener); 
  }
  
  public static void removeNativeMouseWheelListener(NativeMouseWheelListener paramNativeMouseWheelListener) {
    if (paramNativeMouseWheelListener != null)
      eventListeners.remove(NativeMouseWheelListener.class, paramNativeMouseWheelListener); 
  }
  
  public static void registerNativeHook() throws NativeHookException {
    if (hookThread == null || !hookThread.isAlive()) {
      hookThread = new NativeHookThread();
      synchronized (hookThread) {
        hookThread.start();
        try {
          hookThread.wait();
        } catch (InterruptedException interruptedException) {
          throw new NativeHookException(interruptedException);
        } 
        NativeHookException nativeHookException = hookThread.getException();
        if (nativeHookException != null)
          throw nativeHookException; 
      } 
    } 
  }
  
  public static void unregisterNativeHook() throws NativeHookException {
    if (isNativeHookRegistered())
      synchronized (hookThread) {
        hookThread.disable();
        try {
          hookThread.join();
        } catch (InterruptedException interruptedException) {
          throw new NativeHookException(interruptedException.getCause());
        } 
      }  
  }
  
  public static boolean isNativeHookRegistered() {
    return (hookThread != null && hookThread.isAlive());
  }
  
  public static native void postNativeEvent(NativeInputEvent paramNativeInputEvent);
  
  public static void dispatchEvent(NativeInputEvent paramNativeInputEvent) {
    if (eventExecutor != null)
      eventExecutor.execute(new EventDispatchTask(paramNativeInputEvent)); 
  }
  
  public static void setEventDispatcher(ExecutorService paramExecutorService) {
    if (eventExecutor != null)
      eventExecutor.shutdown(); 
    eventExecutor = paramExecutorService;
  }
  
  static {
    String str = System.getProperty("jnativehook.lib.name", "JNativeHook");
    try {
      System.loadLibrary(str);
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      String str1 = System.getProperty("jnativehook.lib.locator", "org.jnativehook.DefaultLibraryLocator");
      try {
        NativeLibraryLocator nativeLibraryLocator = Class.forName(str1).<NativeLibraryLocator>asSubclass(NativeLibraryLocator.class).newInstance();
        Iterator<File> iterator = nativeLibraryLocator.getLibraries();
        while (iterator.hasNext()) {
          File file = iterator.next();
          if (file.exists() && file.isFile() && file.canRead())
            System.load(file.getPath()); 
        } 
      } catch (Exception exception) {
        log.severe(exception.getMessage());
        throw new UnsatisfiedLinkError(exception.getMessage());
      } 
    } 
  }
  
  private static class EventDispatchTask implements Runnable {
    private NativeInputEvent event;
    
    public EventDispatchTask(NativeInputEvent param1NativeInputEvent) {
      this.event = param1NativeInputEvent;
    }
    
    public void run() {
      if (this.event instanceof NativeKeyEvent) {
        processKeyEvent((NativeKeyEvent)this.event);
      } else if (this.event instanceof NativeMouseWheelEvent) {
        processMouseWheelEvent((NativeMouseWheelEvent)this.event);
      } else if (this.event instanceof NativeMouseEvent) {
        switch (this.event.getID()) {
          case 2500:
          case 2501:
          case 2502:
            processButtonEvent((NativeMouseEvent)this.event);
            break;
          case 2503:
          case 2504:
            processMouseEvent((NativeMouseEvent)this.event);
            break;
        } 
      } else if (this.event instanceof NativeMouseWheelEvent) {
        processMouseWheelEvent((NativeMouseWheelEvent)this.event);
      } 
    }
    
    private void processKeyEvent(NativeKeyEvent param1NativeKeyEvent) {
      byte b;
      NativeKeyListener[] arrayOfNativeKeyListener = GlobalScreen.eventListeners.getListeners(NativeKeyListener.class);
      switch (param1NativeKeyEvent.getID()) {
        case 2401:
          for (b = 0; b < arrayOfNativeKeyListener.length; b++)
            arrayOfNativeKeyListener[b].nativeKeyPressed(param1NativeKeyEvent); 
          break;
        case 2400:
          for (b = 0; b < arrayOfNativeKeyListener.length; b++)
            arrayOfNativeKeyListener[b].nativeKeyTyped(param1NativeKeyEvent); 
          break;
        case 2402:
          for (b = 0; b < arrayOfNativeKeyListener.length; b++)
            arrayOfNativeKeyListener[b].nativeKeyReleased(param1NativeKeyEvent); 
          break;
      } 
    }
    
    private void processButtonEvent(NativeMouseEvent param1NativeMouseEvent) {
      byte b;
      NativeMouseListener[] arrayOfNativeMouseListener = GlobalScreen.eventListeners.getListeners(NativeMouseListener.class);
      switch (param1NativeMouseEvent.getID()) {
        case 2500:
          for (b = 0; b < arrayOfNativeMouseListener.length; b++)
            arrayOfNativeMouseListener[b].nativeMouseClicked(param1NativeMouseEvent); 
          break;
        case 2501:
          for (b = 0; b < arrayOfNativeMouseListener.length; b++)
            arrayOfNativeMouseListener[b].nativeMousePressed(param1NativeMouseEvent); 
          break;
        case 2502:
          for (b = 0; b < arrayOfNativeMouseListener.length; b++)
            arrayOfNativeMouseListener[b].nativeMouseReleased(param1NativeMouseEvent); 
          break;
      } 
    }
    
    private void processMouseEvent(NativeMouseEvent param1NativeMouseEvent) {
      byte b;
      NativeMouseMotionListener[] arrayOfNativeMouseMotionListener = GlobalScreen.eventListeners.getListeners(NativeMouseMotionListener.class);
      switch (param1NativeMouseEvent.getID()) {
        case 2503:
          for (b = 0; b < arrayOfNativeMouseMotionListener.length; b++)
            arrayOfNativeMouseMotionListener[b].nativeMouseMoved(param1NativeMouseEvent); 
          break;
        case 2504:
          for (b = 0; b < arrayOfNativeMouseMotionListener.length; b++)
            arrayOfNativeMouseMotionListener[b].nativeMouseDragged(param1NativeMouseEvent); 
          break;
      } 
    }
    
    private void processMouseWheelEvent(NativeMouseWheelEvent param1NativeMouseWheelEvent) {
      NativeMouseWheelListener[] arrayOfNativeMouseWheelListener = GlobalScreen.eventListeners.getListeners(NativeMouseWheelListener.class);
      for (byte b = 0; b < arrayOfNativeMouseWheelListener.length; b++)
        arrayOfNativeMouseWheelListener[b].nativeMouseWheelMoved(param1NativeMouseWheelEvent); 
    }
  }
  
  private static class NativeHookThread extends Thread {
    private NativeHookException exception;
    
    public NativeHookThread() {
      setName("JNativeHook Hook Thread");
      setDaemon(false);
      setPriority(10);
    }
    
    public void run() {
      this.exception = null;
      try {
        enable();
      } catch (NativeHookException nativeHookException) {
        this.exception = nativeHookException;
      } 
      synchronized (this) {
        notifyAll();
      } 
    }
    
    public NativeHookException getException() {
      return this.exception;
    }
    
    private native void enable() throws NativeHookException;
    
    public native void disable() throws NativeHookException;
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\org\jnativehook\GlobalScreen.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */