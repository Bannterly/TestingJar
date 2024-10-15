package org.eclipse.jdt.internal.jarinjarloader;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

public final class d implements URLStreamHandlerFactory {
  private ClassLoader a;
  
  public d(ClassLoader paramClassLoader) {
    this.a = paramClassLoader;
  }
  
  public final URLStreamHandler createURLStreamHandler(String paramString) {
    return "rsrc".equals(paramString) ? new c(this.a) : null;
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\org\eclipse\jdt\internal\jarinjarloader\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */