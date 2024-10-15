package com.java.loader;

import java.awt.AWTException;

public final class b extends Thread {
  private a a;
  
  private boolean a = false;
  
  private boolean b = false;
  
  public b(boolean paramBoolean) {
    try {
      this.a = new a();
      return;
    } catch (AWTException aWTException2) {
      AWTException aWTException1;
      (aWTException1 = null).printStackTrace();
      return;
    } 
  }
  
  public final void run() {
    // Byte code:
    //   0: lconst_1
    //   1: invokestatic a : (J)V
    //   4: aload_0
    //   5: getfield a : Z
    //   8: ifeq -> 0
    //   11: getstatic com/java/loader/c.b : Z
    //   14: ifeq -> 45
    //   17: invokestatic a : ()D
    //   20: ldc2_w 0.7
    //   23: dcmpl
    //   24: ifle -> 39
    //   27: getstatic com/java/loader/c.a : I
    //   30: i2d
    //   31: ldc2_w 0.75
    //   34: dmul
    //   35: d2i
    //   36: goto -> 48
    //   39: getstatic com/java/loader/c.a : I
    //   42: goto -> 48
    //   45: getstatic com/java/loader/c.a : I
    //   48: istore_1
    //   49: sipush #1000
    //   52: iload_1
    //   53: idiv
    //   54: sipush #1000
    //   57: getstatic com/java/loader/c.b : I
    //   60: idiv
    //   61: isub
    //   62: iconst_1
    //   63: iadd
    //   64: istore_1
    //   65: invokestatic a : ()D
    //   68: iload_1
    //   69: i2d
    //   70: dmul
    //   71: d2i
    //   72: sipush #1000
    //   75: getstatic com/java/loader/c.b : I
    //   78: idiv
    //   79: iadd
    //   80: i2l
    //   81: lstore_2
    //   82: bipush #11
    //   84: istore_1
    //   85: invokestatic a : ()D
    //   88: iload_1
    //   89: i2d
    //   90: dmul
    //   91: d2i
    //   92: bipush #30
    //   94: iadd
    //   95: i2l
    //   96: lstore #4
    //   98: lload_2
    //   99: lload #4
    //   101: lsub
    //   102: lstore_2
    //   103: lload #4
    //   105: invokestatic a : (J)V
    //   108: aload_0
    //   109: getfield b : Z
    //   112: ifeq -> 125
    //   115: aload_0
    //   116: getfield a : Lcom/java/loader/a;
    //   119: invokevirtual d : ()V
    //   122: goto -> 132
    //   125: aload_0
    //   126: getfield a : Lcom/java/loader/a;
    //   129: invokevirtual b : ()V
    //   132: lload_2
    //   133: invokestatic a : (J)V
    //   136: aload_0
    //   137: getfield a : Z
    //   140: ifeq -> 0
    //   143: aload_0
    //   144: getfield b : Z
    //   147: ifeq -> 160
    //   150: aload_0
    //   151: getfield a : Lcom/java/loader/a;
    //   154: invokevirtual c : ()V
    //   157: goto -> 167
    //   160: aload_0
    //   161: getfield a : Lcom/java/loader/a;
    //   164: invokevirtual a : ()V
    //   167: getstatic com/java/loader/c.e : I
    //   170: ifeq -> 0
    //   173: getstatic com/java/loader/c.f : I
    //   176: ifeq -> 0
    //   179: aload_0
    //   180: getfield a : Lcom/java/loader/a;
    //   183: getstatic com/java/loader/c.e : I
    //   186: getstatic com/java/loader/c.f : I
    //   189: invokevirtual a : (II)V
    //   192: goto -> 0
  }
  
  public final long a() {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Lcom/java/loader/a;
    //   4: invokevirtual a : ()J
    //   7: lreturn
  }
  
  private static void a(long paramLong) {
    try {
      sleep(paramLong);
      return;
    } catch (InterruptedException interruptedException2) {
      InterruptedException interruptedException1;
      (interruptedException1 = null).printStackTrace();
      return;
    } 
  }
  
  public final void a(boolean paramBoolean) {
    this.a = paramBoolean;
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */