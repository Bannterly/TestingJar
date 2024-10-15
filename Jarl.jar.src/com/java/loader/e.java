package com.java.loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class e {
  private static File a = new File("config.txt");
  
  private static PrintWriter a;
  
  static {
    try {
      a.createNewFile();
    } catch (IOException iOException2) {
      IOException iOException1;
      (iOException1 = null).printStackTrace();
    } 
    try {
      a = new PrintWriter(new FileOutputStream((File)a, true));
      return;
    } catch (FileNotFoundException fileNotFoundException2) {
      FileNotFoundException fileNotFoundException1;
      (fileNotFoundException1 = null).printStackTrace();
      return;
    } 
  }
  
  public static void a() {
    try {
      a = new PrintWriter((File)a, "UTF-8");
    } catch (FileNotFoundException|java.io.UnsupportedEncodingException fileNotFoundException2) {
      FileNotFoundException fileNotFoundException1;
      (fileNotFoundException1 = null).printStackTrace();
    } 
    String str = "";
    for (byte b = 0; b < c.a.size() - 1; b++)
      str = String.valueOf(str) + c.a.get(b) + ":"; 
    str = String.valueOf(str) + c.a.get(c.a.size() - 1);
    a.print(String.valueOf(str) + ",");
    a.print(String.valueOf(c.a) + ",");
    a.print(String.valueOf(c.b) + ",");
    a.print(String.valueOf(c.b) + ",");
    a.print(String.valueOf(c.d) + ",");
    a.print(String.valueOf(c.e) + ",");
    a.print(String.valueOf(c.f) + ",");
    a.print(String.valueOf(c.a) + ",");
    a.print(String.valueOf(c.c) + ",");
    a.print(c.d);
    a.println();
    a.flush();
  }
  
  public static void b() {
    Scanner scanner = null;
    try {
      scanner = new Scanner((File)a, "UTF-8");
    } catch (FileNotFoundException fileNotFoundException) {}
    String str = "";
    if (scanner.hasNextLine())
      str = scanner.nextLine(); 
    String[] arrayOfString = (str = (str == null) ? "" : str).split(",");
    try {
      if (arrayOfString[0].contains(":")) {
        String[] arrayOfString1;
        int i = (arrayOfString1 = arrayOfString[0].split(":")).length;
        for (byte b = 0; b < i; b++) {
          str = arrayOfString1[b];
          c.a.add(Integer.valueOf(Integer.parseInt(str)));
        } 
      } else {
        c.a.add(Integer.valueOf(Integer.parseInt(arrayOfString[0])));
      } 
      c.a = Integer.parseInt(arrayOfString[1]);
      c.b = Integer.parseInt(arrayOfString[2]);
      c.b = Boolean.parseBoolean(arrayOfString[3]);
      c.d = Boolean.parseBoolean(arrayOfString[4]);
      c.e = Integer.parseInt(arrayOfString[5]);
      c.f = Integer.parseInt(arrayOfString[6]);
      c.a = Boolean.parseBoolean(arrayOfString[7]);
      c.c = Integer.parseInt(arrayOfString[8]);
      c.d = Integer.parseInt(arrayOfString[9]);
      return;
    } catch (NumberFormatException|ArrayIndexOutOfBoundsException numberFormatException) {
      c.a();
      return;
    } 
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */