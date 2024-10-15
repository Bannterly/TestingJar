package org.eclipse.jdt.internal.jarinjarloader;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;

public final class b extends URLConnection {
  private ClassLoader a;
  
  public b(URL paramURL, ClassLoader paramClassLoader) {
    super(paramURL);
    this.a = paramClassLoader;
  }
  
  public final void connect() {}
  
  public final InputStream getInputStream() {
    String str = URLDecoder.decode(this.url.getFile(), "UTF-8");
    InputStream inputStream;
    if ((inputStream = this.a.getResourceAsStream(str)) == null)
      throw new MalformedURLException("Could not open InputStream for URL '" + this.url + "'"); 
    return inputStream;
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\org\eclipse\jdt\internal\jarinjarloader\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */