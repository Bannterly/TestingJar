package org.jnativehook;

import java.util.Locale;

public class NativeSystem {
  public static Family getFamily() {
    Family family;
    String str = System.getProperty("os.name");
    if (str.equalsIgnoreCase("freebsd")) {
      family = Family.FREEBSD;
    } else if (str.equalsIgnoreCase("openbsd")) {
      family = Family.OPENBSD;
    } else if (str.equalsIgnoreCase("mac os x")) {
      family = Family.DARWIN;
    } else if (str.equalsIgnoreCase("solaris") || str.equalsIgnoreCase("sunos")) {
      family = Family.SOLARIS;
    } else if (str.equalsIgnoreCase("linux")) {
      family = Family.LINUX;
    } else if (str.toLowerCase(Locale.ROOT).startsWith("windows")) {
      family = Family.WINDOWS;
    } else {
      family = Family.UNSUPPORTED;
    } 
    return family;
  }
  
  public static Arch getArchitecture() {
    Arch arch;
    String str = System.getProperty("os.arch");
    if (str.equalsIgnoreCase("arm")) {
      arch = Arch.ARM;
    } else if (str.equalsIgnoreCase("sparc")) {
      arch = Arch.SPARC;
    } else if (str.equalsIgnoreCase("sparc64")) {
      arch = Arch.SPARC64;
    } else if (str.equalsIgnoreCase("ppc") || str.equalsIgnoreCase("powerpc")) {
      arch = Arch.PPC;
    } else if (str.equalsIgnoreCase("ppc64") || str.equalsIgnoreCase("powerpc64")) {
      arch = Arch.PPC64;
    } else if (str.equalsIgnoreCase("x86") || str.equalsIgnoreCase("i386") || str.equalsIgnoreCase("i486") || str.equalsIgnoreCase("i586") || str.equalsIgnoreCase("i686")) {
      arch = Arch.x86;
    } else if (str.equalsIgnoreCase("x86_64") || str.equalsIgnoreCase("amd64") || str.equalsIgnoreCase("k8")) {
      arch = Arch.x86_64;
    } else {
      arch = Arch.UNSUPPORTED;
    } 
    return arch;
  }
  
  public enum Arch {
    ARM, SPARC, SPARC64, PPC, PPC64, x86, x86_64, UNSUPPORTED;
    
    public String toString() {
      return super.toString().toLowerCase(Locale.ROOT);
    }
  }
  
  public enum Family {
    FREEBSD, OPENBSD, DARWIN, SOLARIS, LINUX, WINDOWS, UNSUPPORTED;
    
    public String toString() {
      return super.toString().toLowerCase(Locale.ROOT);
    }
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\org\jnativehook\NativeSystem.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */