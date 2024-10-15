package com.java.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Start {
  public static void main(String[] paramArrayOfString) {
    if (paramArrayOfString.length != 1) {
      System.exit(0);
      return;
    } 
    try {
      URL uRL = new URL("https://veneclicker.com/api/user/validate_auth_cookie/?cookie=" + paramArrayOfString[0]);
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRL.openStream()));
      String str;
      while ((str = bufferedReader.readLine()) != null) {
        if (str.contains("\"valid\":true"));
      } 
      return;
    } catch (IOException iOException) {
      (paramArrayOfString = null).printStackTrace();
      return;
    } 
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\Start.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */