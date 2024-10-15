package org.eclipse.jdt.internal.jarinjarloader;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class JarRsrcLoader {
  public static void main(String[] paramArrayOfString) {
    a a = a();
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    URL.setURLStreamHandlerFactory(new d(classLoader));
    URL[] arrayOfURL = new URL[a.a.length];
    for (byte b = 0; b < a.a.length; b++) {
      String str;
      if ((str = a.a[b]).endsWith("/")) {
        arrayOfURL[b] = new URL("rsrc:" + str);
      } else {
        arrayOfURL[b] = new URL("jar:rsrc:" + str + "!/");
      } 
    } 
    URLClassLoader uRLClassLoader = new URLClassLoader(arrayOfURL, null);
    Thread.currentThread().setContextClassLoader(uRLClassLoader);
    Method method;
    Class<?> clazz;
    (method = (clazz = Class.forName((String)a.a, true, uRLClassLoader)).getMethod("main", new Class[] { paramArrayOfString.getClass() })).invoke(null, new Object[] { paramArrayOfString });
  }
  
  private static a a() {
    Enumeration<URL> enumeration = Thread.currentThread().getContextClassLoader().getResources("META-INF/MANIFEST.MF");
    while (enumeration.hasMoreElements()) {
      try {
        URL uRL;
        InputStream inputStream;
        if ((inputStream = (uRL = enumeration.nextElement()).openStream()) != null) {
          a a = new a((byte)0);
          Manifest manifest;
          Attributes attributes = (manifest = new Manifest(inputStream)).getMainAttributes();
          a.a = (String[])attributes.getValue("Rsrc-Main-Class");
          String str;
          if ((str = attributes.getValue("Rsrc-Class-Path")) == null)
            str = ""; 
          a.a = a(str);
          if (a.a != null && !a.a.trim().equals(""))
            return a; 
        } 
      } catch (Exception exception) {}
    } 
    System.err.println("Missing attributes for JarRsrcLoader in Manifest (Rsrc-Main-Class, Rsrc-Class-Path)");
    return null;
  }
  
  private static String[] a(String paramString) {
    if (paramString == null)
      return null; 
    ArrayList<String> arrayList = new ArrayList();
    for (int i = 0; i < paramString.length(); i = j + 1) {
      int j;
      if ((j = paramString.indexOf(' ', i)) == -1)
        j = paramString.length(); 
      if (j > i)
        arrayList.add(paramString.substring(i, j)); 
    } 
    return arrayList.<String>toArray(new String[arrayList.size()]);
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\org\eclipse\jdt\internal\jarinjarloader\JarRsrcLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */