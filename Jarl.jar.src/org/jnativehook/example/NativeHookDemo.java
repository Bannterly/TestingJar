package org.jnativehook.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.SwingDispatchService;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseMotionListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

public class NativeHookDemo extends JFrame implements ActionListener, ItemListener, NativeKeyListener, NativeMouseInputListener, NativeMouseWheelListener, WindowListener {
  private static final long serialVersionUID = 1541183202160543102L;
  
  private JMenu menuSubListeners;
  
  private JMenuItem menuItemQuit;
  
  private JMenuItem menuItemClear;
  
  private JCheckBoxMenuItem menuItemEnable;
  
  private JCheckBoxMenuItem menuItemKeyboardEvents;
  
  private JCheckBoxMenuItem menuItemButtonEvents;
  
  private JCheckBoxMenuItem menuItemMotionEvents;
  
  private JCheckBoxMenuItem menuItemWheelEvents;
  
  private JTextArea txtEventInfo;
  
  private static final Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
  
  public NativeHookDemo() {
    setTitle("JNativeHook Demo");
    setLayout(new BorderLayout());
    setDefaultCloseOperation(2);
    setSize(600, 300);
    addWindowListener(this);
    JMenuBar jMenuBar = new JMenuBar();
    JMenu jMenu1 = new JMenu("File");
    jMenu1.setMnemonic(70);
    jMenuBar.add(jMenu1);
    this.menuItemQuit = new JMenuItem("Quit", 81);
    this.menuItemQuit.addActionListener(this);
    this.menuItemQuit.setAccelerator(KeyStroke.getKeyStroke(115, 8));
    this.menuItemQuit.getAccessibleContext().setAccessibleDescription("Exit the program");
    jMenu1.add(this.menuItemQuit);
    JMenu jMenu2 = new JMenu("View");
    jMenu2.setMnemonic(86);
    jMenuBar.add(jMenu2);
    this.menuItemClear = new JMenuItem("Clear", 67);
    this.menuItemClear.addActionListener(this);
    this.menuItemClear.setAccelerator(KeyStroke.getKeyStroke(67, 3));
    this.menuItemClear.getAccessibleContext().setAccessibleDescription("Clear the screen");
    jMenu2.add(this.menuItemClear);
    jMenu2.addSeparator();
    this.menuItemEnable = new JCheckBoxMenuItem("Enable Native Hook");
    this.menuItemEnable.addItemListener(this);
    this.menuItemEnable.setMnemonic(72);
    this.menuItemEnable.setAccelerator(KeyStroke.getKeyStroke(72, 3));
    jMenu2.add(this.menuItemEnable);
    this.menuSubListeners = new JMenu("Listeners");
    this.menuSubListeners.setMnemonic(76);
    jMenu2.add(this.menuSubListeners);
    this.menuItemKeyboardEvents = new JCheckBoxMenuItem("Keyboard Events");
    this.menuItemKeyboardEvents.addItemListener(this);
    this.menuItemKeyboardEvents.setMnemonic(75);
    this.menuItemKeyboardEvents.setAccelerator(KeyStroke.getKeyStroke(75, 3));
    this.menuSubListeners.add(this.menuItemKeyboardEvents);
    this.menuItemButtonEvents = new JCheckBoxMenuItem("Button Events");
    this.menuItemButtonEvents.addItemListener(this);
    this.menuItemButtonEvents.setMnemonic(66);
    this.menuItemButtonEvents.setAccelerator(KeyStroke.getKeyStroke(66, 3));
    this.menuSubListeners.add(this.menuItemButtonEvents);
    this.menuItemMotionEvents = new JCheckBoxMenuItem("Motion Events");
    this.menuItemMotionEvents.addItemListener(this);
    this.menuItemMotionEvents.setMnemonic(77);
    this.menuItemMotionEvents.setAccelerator(KeyStroke.getKeyStroke(77, 3));
    this.menuSubListeners.add(this.menuItemMotionEvents);
    this.menuItemWheelEvents = new JCheckBoxMenuItem("Wheel Events");
    this.menuItemWheelEvents.addItemListener(this);
    this.menuItemWheelEvents.setMnemonic(87);
    this.menuItemWheelEvents.setAccelerator(KeyStroke.getKeyStroke(87, 3));
    this.menuSubListeners.add(this.menuItemWheelEvents);
    setJMenuBar(jMenuBar);
    this.txtEventInfo = new JTextArea();
    this.txtEventInfo.setEditable(false);
    this.txtEventInfo.setBackground(new Color(255, 255, 255));
    this.txtEventInfo.setForeground(new Color(0, 0, 0));
    this.txtEventInfo.setText("");
    JScrollPane jScrollPane = new JScrollPane(this.txtEventInfo);
    jScrollPane.setPreferredSize(new Dimension(375, 125));
    add(jScrollPane, "Center");
    logger.setUseParentHandlers(false);
    logger.setLevel(Level.ALL);
    ConsoleHandler consoleHandler = new ConsoleHandler();
    consoleHandler.setFormatter(new LogFormatter());
    consoleHandler.setLevel(Level.WARNING);
    logger.addHandler(consoleHandler);
    GlobalScreen.setEventDispatcher((ExecutorService)new SwingDispatchService());
    setVisible(true);
  }
  
  public void actionPerformed(ActionEvent paramActionEvent) {
    if (paramActionEvent.getSource() == this.menuItemQuit) {
      dispose();
    } else if (paramActionEvent.getSource() == this.menuItemClear) {
      this.txtEventInfo.setText("");
    } 
  }
  
  public void itemStateChanged(ItemEvent paramItemEvent) {
    ItemSelectable itemSelectable = paramItemEvent.getItemSelectable();
    if (itemSelectable == this.menuItemEnable) {
      try {
        if (paramItemEvent.getStateChange() == 1) {
          GlobalScreen.registerNativeHook();
        } else {
          GlobalScreen.unregisterNativeHook();
        } 
      } catch (NativeHookException nativeHookException) {
        this.txtEventInfo.append("Error: " + nativeHookException.getMessage() + "\n");
      } 
      this.menuItemEnable.setState(GlobalScreen.isNativeHookRegistered());
      this.menuSubListeners.setEnabled(this.menuItemEnable.getState());
    } else if (itemSelectable == this.menuItemKeyboardEvents) {
      if (paramItemEvent.getStateChange() == 1) {
        GlobalScreen.addNativeKeyListener(this);
      } else {
        GlobalScreen.removeNativeKeyListener(this);
      } 
    } else if (itemSelectable == this.menuItemButtonEvents) {
      if (paramItemEvent.getStateChange() == 1) {
        GlobalScreen.addNativeMouseListener((NativeMouseListener)this);
      } else {
        GlobalScreen.removeNativeMouseListener((NativeMouseListener)this);
      } 
    } else if (itemSelectable == this.menuItemMotionEvents) {
      if (paramItemEvent.getStateChange() == 1) {
        GlobalScreen.addNativeMouseMotionListener((NativeMouseMotionListener)this);
      } else {
        GlobalScreen.removeNativeMouseMotionListener((NativeMouseMotionListener)this);
      } 
    } else if (itemSelectable == this.menuItemWheelEvents) {
      if (paramItemEvent.getStateChange() == 1) {
        GlobalScreen.addNativeMouseWheelListener(this);
      } else {
        GlobalScreen.removeNativeMouseWheelListener(this);
      } 
    } 
  }
  
  public void nativeKeyPressed(NativeKeyEvent paramNativeKeyEvent) {
    displayEventInfo((NativeInputEvent)paramNativeKeyEvent);
  }
  
  public void nativeKeyReleased(NativeKeyEvent paramNativeKeyEvent) {
    displayEventInfo((NativeInputEvent)paramNativeKeyEvent);
  }
  
  public void nativeKeyTyped(NativeKeyEvent paramNativeKeyEvent) {
    displayEventInfo((NativeInputEvent)paramNativeKeyEvent);
  }
  
  public void nativeMouseClicked(NativeMouseEvent paramNativeMouseEvent) {
    displayEventInfo((NativeInputEvent)paramNativeMouseEvent);
  }
  
  public void nativeMousePressed(NativeMouseEvent paramNativeMouseEvent) {
    displayEventInfo((NativeInputEvent)paramNativeMouseEvent);
  }
  
  public void nativeMouseReleased(NativeMouseEvent paramNativeMouseEvent) {
    displayEventInfo((NativeInputEvent)paramNativeMouseEvent);
  }
  
  public void nativeMouseMoved(NativeMouseEvent paramNativeMouseEvent) {
    displayEventInfo((NativeInputEvent)paramNativeMouseEvent);
  }
  
  public void nativeMouseDragged(NativeMouseEvent paramNativeMouseEvent) {
    displayEventInfo((NativeInputEvent)paramNativeMouseEvent);
  }
  
  public void nativeMouseWheelMoved(NativeMouseWheelEvent paramNativeMouseWheelEvent) {
    displayEventInfo((NativeInputEvent)paramNativeMouseWheelEvent);
  }
  
  private void displayEventInfo(NativeInputEvent paramNativeInputEvent) {
    this.txtEventInfo.append("\n" + paramNativeInputEvent.paramString());
    try {
      if (this.txtEventInfo.getLineCount() > 100)
        this.txtEventInfo.replaceRange("", 0, this.txtEventInfo.getLineEndOffset(this.txtEventInfo.getLineCount() - 1 - 100)); 
      this.txtEventInfo.setCaretPosition(this.txtEventInfo.getLineStartOffset(this.txtEventInfo.getLineCount() - 1));
    } catch (BadLocationException badLocationException) {
      this.txtEventInfo.setCaretPosition(this.txtEventInfo.getDocument().getLength());
    } 
  }
  
  public void windowActivated(WindowEvent paramWindowEvent) {}
  
  public void windowClosing(WindowEvent paramWindowEvent) {}
  
  public void windowDeactivated(WindowEvent paramWindowEvent) {}
  
  public void windowDeiconified(WindowEvent paramWindowEvent) {}
  
  public void windowIconified(WindowEvent paramWindowEvent) {}
  
  public void windowOpened(WindowEvent paramWindowEvent) {
    requestFocusInWindow();
    this.menuItemEnable.setSelected(true);
    this.txtEventInfo.append("JNativeHook Version " + System.getProperty("jnativehook.lib.version"));
    this.txtEventInfo.append("\nAuto Repeat Rate: " + System.getProperty("jnativehook.key.repeat.rate"));
    this.txtEventInfo.append("\nAuto Repeat Delay: " + System.getProperty("jnativehook.key.repeat.delay"));
    this.txtEventInfo.append("\nDouble Click Time: " + System.getProperty("jnativehook.button.multiclick.iterval"));
    this.txtEventInfo.append("\nPointer Sensitivity: " + System.getProperty("jnativehook.pointer.sensitivity"));
    this.txtEventInfo.append("\nPointer Acceleration Multiplier: " + System.getProperty("jnativehook.pointer.acceleration.multiplier"));
    this.txtEventInfo.append("\nPointer Acceleration Threshold: " + System.getProperty("jnativehook.pointer.acceleration.threshold"));
    try {
      this.txtEventInfo.setCaretPosition(this.txtEventInfo.getLineStartOffset(this.txtEventInfo.getLineCount() - 1));
    } catch (BadLocationException badLocationException) {
      this.txtEventInfo.setCaretPosition(this.txtEventInfo.getDocument().getLength());
    } 
    this.menuItemKeyboardEvents.setSelected(true);
    this.menuItemButtonEvents.setSelected(true);
    this.menuItemMotionEvents.setSelected(true);
    this.menuItemWheelEvents.setSelected(true);
  }
  
  public void windowClosed(WindowEvent paramWindowEvent) {
    try {
      GlobalScreen.unregisterNativeHook();
    } catch (NativeHookException nativeHookException) {
      nativeHookException.printStackTrace();
    } 
    System.runFinalization();
    System.exit(0);
  }
  
  public static void main(String[] paramArrayOfString) {
    StringBuffer stringBuffer = (new StringBuffer("\n")).append("JNativeHook: Global keyboard and mouse hooking for Java.\n").append("Copyright (C) 2006-2015 Alexander Barker.  All Rights Received.\n").append("https://github.com/kwhat/jnativehook/\n").append("\n").append("JNativeHook is free software: you can redistribute it and/or modify\n").append("it under the terms of the GNU Lesser General Public License as published\n").append("by the Free Software Foundation, either version 3 of the License, or\n").append("(at your option) any later version.\n").append("\n").append("JNativeHook is distributed in the hope that it will be useful,\n").append("but WITHOUT ANY WARRANTY; without even the implied warranty of\n").append("MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n").append("GNU General Public License for more details.\n").append("\n").append("You should have received a copy of the GNU Lesser General Public License\n").append("along with this program.  If not, see <http://www.gnu.org/licenses/>.\n");
    System.out.println(stringBuffer);
    SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            new NativeHookDemo();
          }
        });
  }
  
  private final class LogFormatter extends Formatter {
    private LogFormatter() {}
    
    public String format(LogRecord param1LogRecord) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(new Date(param1LogRecord.getMillis())).append(" ").append(param1LogRecord.getLevel().getLocalizedName()).append(":\t").append(formatMessage(param1LogRecord));
      if (param1LogRecord.getThrown() != null)
        try {
          StringWriter stringWriter = new StringWriter();
          PrintWriter printWriter = new PrintWriter(stringWriter);
          param1LogRecord.getThrown().printStackTrace(printWriter);
          printWriter.close();
          stringBuilder.append(stringWriter.toString());
          stringWriter.close();
        } catch (Exception exception) {} 
      return stringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\org\jnativehook\example\NativeHookDemo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */