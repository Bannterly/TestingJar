package org.jnativehook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URL;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.jar.Attributes;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;
import java.util.logging.Logger;

public class DefaultLibraryLocator implements NativeLibraryLocator {
  private static Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
  
  public Iterator<File> getLibraries() {
    ArrayList<File> arrayList = new ArrayList(1);
    String str1 = System.getProperty("jnativehook.lib.name", "JNativeHook");
    String str2 = GlobalScreen.class.getPackage().getName().replace('.', '/');
    String str3 = System.mapLibraryName(str1);
    str3 = str3.replaceAll("\\.jnilib$", "\\.dylib");
    StringBuilder stringBuilder = new StringBuilder("/");
    stringBuilder.append(str2).append("/lib/");
    stringBuilder.append(NativeSystem.getFamily().toString().toLowerCase()).append('/');
    stringBuilder.append(NativeSystem.getArchitecture().toString().toLowerCase()).append('/');
    stringBuilder.append(str3);
    int i = str3.lastIndexOf('.');
    String str4 = str3.substring(0, i) + '-';
    String str5 = str3.substring(i);
    String str6 = null;
    InputStream inputStream = GlobalScreen.class.getResourceAsStream(stringBuilder.toString());
    if (inputStream != null) {
      try {
        URL uRL = GlobalScreen.class.getProtectionDomain().getCodeSource().getLocation();
        JarInputStream jarInputStream = new JarInputStream(uRL.openStream());
        Manifest manifest = jarInputStream.getManifest();
        if (manifest != null) {
          Attributes attributes = manifest.getAttributes(str2);
          if (attributes != null) {
            String str7 = attributes.getValue("Specification-Version");
            String str8 = attributes.getValue("Implementation-Version");
            str6 = str7 + '.' + str8;
          } else {
            logger.warning("Invalid library manifest!\n");
          } 
        } else {
          logger.warning("Cannot find library manifest!\n");
        } 
        jarInputStream.close();
      } catch (IOException iOException) {
        logger.severe(iOException.getMessage());
      } 
      File file = null;
      if (str6 != null) {
        file = new File(System.getProperty("java.io.tmpdir"), str4 + str6 + str5);
        if (file.exists())
          arrayList.add(file); 
      } 
      if (arrayList.isEmpty())
        try {
          if (file == null)
            file = File.createTempFile(str4, str5); 
          byte[] arrayOfByte = new byte[4096];
          FileOutputStream fileOutputStream = new FileOutputStream(file);
          MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
          DigestInputStream digestInputStream = new DigestInputStream(inputStream, messageDigest);
          int j;
          while ((j = digestInputStream.read(arrayOfByte)) != -1)
            fileOutputStream.write(arrayOfByte, 0, j); 
          digestInputStream.close();
          inputStream.close();
          fileOutputStream.close();
          String str = (new BigInteger(1, messageDigest.digest())).toString(16).toUpperCase();
          if (str6 == null) {
            str6 = str;
            File file1 = new File(System.getProperty("java.io.tmpdir"), str4 + str6 + str5);
            if (file.renameTo(file1))
              file = file1; 
          } 
          System.setProperty("jnativehook.lib.version", str6);
          arrayList.add(file);
          logger.info("Library extracted successfully: " + file.getPath() + " (0x" + str + ").\n");
        } catch (IOException iOException) {
          throw new IllegalStateException(iOException.getMessage(), iOException);
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
          throw new IllegalStateException(noSuchAlgorithmException.getMessage(), noSuchAlgorithmException);
        }  
    } else {
      logger.severe("Unable to extract the native library " + stringBuilder.toString() + "!\n");
    } 
    return arrayList.iterator();
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\org\jnativehook\DefaultLibraryLocator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */