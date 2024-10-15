package org.jnativehook;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

public class SwingDispatchService extends AbstractExecutorService {
  private boolean running = false;
  
  public SwingDispatchService() {
    this.running = true;
  }
  
  public void shutdown() {
    this.running = false;
  }
  
  public List<Runnable> shutdownNow() {
    this.running = false;
    return new ArrayList<Runnable>(0);
  }
  
  public boolean isShutdown() {
    return !this.running;
  }
  
  public boolean isTerminated() {
    return !this.running;
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return true;
  }
  
  public void execute(Runnable paramRunnable) {
    EventQueue.invokeLater(paramRunnable);
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\org\jnativehook\SwingDispatchService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */