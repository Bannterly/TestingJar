package com.java.loader;

import com.java.loader.a.a;
import com.java.loader.a.b;
import com.java.loader.applet.d;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseListener;

public class c {
  public static int a;
  
  public static int b;
  
  public static int c;
  
  public static int d;
  
  public static int e;
  
  public static int f;
  
  public static boolean a;
  
  public static boolean b;
  
  public static boolean c;
  
  public static boolean d;
  
  private static boolean f;
  
  public static ArrayList a;
  
  private static f a;
  
  public static boolean e;
  
  public c() {
    e = !c.class.getResource("Start.class").toString().startsWith("file:");
    Runtime.getRuntime().addShutdownHook(new Thread(new d(this)));
    a = (f)new ArrayList();
    e.b();
    c = false;
    d d;
    (d = new d()).setVisible(true);
    LogManager.getLogManager().reset();
    Logger logger;
    (logger = Logger.getLogger(GlobalScreen.class.getPackage().getName())).setLevel(Level.OFF);
    try {
      GlobalScreen.registerNativeHook();
    } catch (NativeHookException nativeHookException) {
      (logger = null).printStackTrace();
    } 
    GlobalScreen.addNativeMouseListener((NativeMouseListener)new b());
    GlobalScreen.addNativeKeyListener((NativeKeyListener)new a());
  }
  
  public static String a() {
    if (a == null || a.size() == 0)
      return "null"; 
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < a.size() - 1; b++)
      stringBuilder.append(String.valueOf(NativeKeyEvent.getKeyText(((Integer)a.get(b)).intValue())) + " + "); 
    stringBuilder.append(NativeKeyEvent.getKeyText(((Integer)a.get(a.size() - 1)).intValue()));
    return stringBuilder.toString();
  }
  
  public static void a(boolean paramBoolean) {
    f = paramBoolean;
    if (a != null)
      a.a(paramBoolean); 
  }
  
  public static boolean a() {
    return f;
  }
  
  public static void a(f paramf) {
    a = paramf;
  }
  
  public static void a() {
    (a = (f)new ArrayList()).add(Integer.valueOf(33));
    a = 9;
    b = true;
    b = true;
    d = true;
    e = false;
    f = false;
    a = false;
    c = true;
    d = true;
    e.a();
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */