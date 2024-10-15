package com.java.loader;

import java.awt.Robot;
import java.security.SecureRandom;

public class a {
  private Robot a;
  
  private long a = new Robot();
  
  static double a() {
    double d1 = Double.MAX_VALUE;
    double d2 = Double.MIN_VALUE;
    for (byte b = 0; b < 20; b++) {
      double d4 = System.nanoTime();
      (new SecureRandom()).nextInt();
      double d5;
      double d6;
      if ((d6 = (d5 = System.nanoTime()) - d4) < d1 && d6 > 0.0D) {
        d1 = d6;
      } else if (d6 > d2 && d6 > 0.0D) {
        d2 = d6;
      } 
    } 
    String str = String.valueOf(d2 / d1);
    double d3;
    return ((d3 = Double.valueOf("0." + str.substring(str.indexOf('.') + 2)).doubleValue()) < 0.1D) ? a() : d3;
  }
  
  public a() {
    this.a = 0L;
  }
  
  public long a() {
    return this.a;
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic currentTimeMillis : ()J
    //   4: putfield a : J
    //   7: aload_0
    //   8: getfield a : Ljava/awt/Robot;
    //   11: sipush #1024
    //   14: invokevirtual mousePress : (I)V
    //   17: return
  }
  
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Ljava/awt/Robot;
    //   4: sipush #1024
    //   7: invokevirtual mouseRelease : (I)V
    //   10: return
  }
  
  public void c() {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic currentTimeMillis : ()J
    //   4: putfield a : J
    //   7: aload_0
    //   8: getfield a : Ljava/awt/Robot;
    //   11: sipush #4096
    //   14: invokevirtual mousePress : (I)V
    //   17: return
  }
  
  public void d() {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Ljava/awt/Robot;
    //   4: sipush #4096
    //   7: invokevirtual mouseRelease : (I)V
    //   10: return
  }
  
  public void a(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iload_1
    //   3: ifeq -> 35
    //   6: iload_1
    //   7: iconst_1
    //   8: iadd
    //   9: istore_1
    //   10: invokestatic a : ()D
    //   13: iload_1
    //   14: i2d
    //   15: dmul
    //   16: d2i
    //   17: istore_3
    //   18: invokestatic a : ()D
    //   21: ldc2_w 0.5
    //   24: dcmpl
    //   25: ifle -> 32
    //   28: iload_3
    //   29: goto -> 34
    //   32: iload_3
    //   33: ineg
    //   34: istore_3
    //   35: iconst_0
    //   36: istore_1
    //   37: iload_2
    //   38: ifeq -> 70
    //   41: iload_2
    //   42: iconst_1
    //   43: iadd
    //   44: istore_1
    //   45: invokestatic a : ()D
    //   48: iload_1
    //   49: i2d
    //   50: dmul
    //   51: d2i
    //   52: istore_1
    //   53: invokestatic a : ()D
    //   56: ldc2_w 0.5
    //   59: dcmpl
    //   60: ifle -> 67
    //   63: iload_1
    //   64: goto -> 69
    //   67: iload_1
    //   68: ineg
    //   69: istore_1
    //   70: aload_0
    //   71: getfield a : Ljava/awt/Robot;
    //   74: invokestatic getPointerInfo : ()Ljava/awt/PointerInfo;
    //   77: invokevirtual getLocation : ()Ljava/awt/Point;
    //   80: getfield x : I
    //   83: iload_3
    //   84: iadd
    //   85: invokestatic getPointerInfo : ()Ljava/awt/PointerInfo;
    //   88: invokevirtual getLocation : ()Ljava/awt/Point;
    //   91: getfield y : I
    //   94: iload_1
    //   95: iadd
    //   96: invokevirtual mouseMove : (II)V
    //   99: return
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */