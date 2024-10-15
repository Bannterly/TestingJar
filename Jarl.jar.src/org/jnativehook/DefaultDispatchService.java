package org.jnativehook;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DefaultDispatchService extends ThreadPoolExecutor {
  public DefaultDispatchService() {
    super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), new ThreadFactory() {
          public Thread newThread(Runnable param1Runnable) {
            Thread thread = new Thread(param1Runnable);
            thread.setName("JNativeHook Dispatch Thread");
            thread.setDaemon(true);
            return thread;
          }
        });
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\org\jnativehook\DefaultDispatchService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */