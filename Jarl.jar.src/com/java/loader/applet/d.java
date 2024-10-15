package com.java.loader.applet;

import com.java.loader.c;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

public final class d extends JFrame {
  private int a;
  
  private Font a;
  
  private BufferedImage a;
  
  private int b;
  
  private Font b;
  
  private BufferedImage b;
  
  private Font c;
  
  public d() {
    NumberFormat numberFormat;
    this.a = false;
    this.b = false;
    this.a = null;
    this.b = null;
    this.c = null;
    setTitle("Chicken");
    setBounds(100, 100, 297, 322);
    setDefaultCloseOperation(3);
    getContentPane().setLayout((LayoutManager)null);
    setUndecorated(true);
    setResizable(false);
    setBackground(new Color(46, 49, 54));
    getContentPane().setBackground(new Color(46, 49, 54));
    addMouseMotionListener(new e(this));
    addMouseListener(new k(this));
    BufferedImage bufferedImage1 = a("/res/button.png");
    BufferedImage bufferedImage2 = a("/res/x.png");
    BufferedImage bufferedImage3 = a("/res/min.png");
    BufferedImage bufferedImage4 = a("/res/checkbox.png");
    BufferedImage bufferedImage5 = a("/res/checkbox_checked.png");
    BufferedImage bufferedImage6 = a("/res/button_active.png");
    this.a = a("/res/logo.png");
    this.b = a("/res/logo_active.png");
    BufferedImage bufferedImage7 = a("/res/settings.png");
    BufferedImage bufferedImage8 = a("/res/destruct.png");
    try {
      if (c.e) {
        this.a = (BufferedImage)Font.createFont(0, getClass().getResourceAsStream("/Lato-Regular.ttf")).deriveFont(13.0F);
        this.b = (BufferedImage)Font.createFont(0, getClass().getResourceAsStream("/Lato-Regular.ttf")).deriveFont(16.0F);
        this.c = Font.createFont(0, getClass().getResourceAsStream("/Lato-Regular.ttf")).deriveFont(11.0F);
      } else {
        File file = new File();
        this("Lato-Regular.ttf");
        this.a = (BufferedImage)Font.createFont(0, file).deriveFont(13.0F);
        file = new File();
        this("Lato-Regular.ttf");
        this.b = (BufferedImage)Font.createFont(0, file).deriveFont(16.0F);
        file = new File();
        this("Lato-Regular.ttf");
        this.c = Font.createFont(0, file).deriveFont(11.0F);
      } 
      GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
      if (c.e) {
        graphicsEnvironment.registerFont(Font.createFont(0, getClass().getResourceAsStream("/Lato-Regular.ttf")));
      } else {
        File file = new File();
        this("Lato-Regular.ttf");
        graphicsEnvironment.registerFont(Font.createFont(0, file));
      } 
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } catch (FontFormatException fontFormatException) {
      fontFormatException.printStackTrace();
    } 
    JPanel jPanel3 = new JPanel();
    jPanel3.setBounds(5, 5, 50, 15);
    getContentPane().add(jPanel3);
    jPanel3.setLayout((LayoutManager)null);
    jPanel3.setOpaque(false);
    JButton jButton1 = new JButton(new ImageIcon(bufferedImage2));
    jButton1.addActionListener(new l(this));
    jButton1.setBorder(BorderFactory.createEmptyBorder());
    jButton1.setBounds(0, 0, 15, 15);
    jButton1.setOpaque(false);
    jButton1.setContentAreaFilled(false);
    jButton1.setBorderPainted(false);
    jPanel3.add(jButton1);
    JButton jButton2 = new JButton(new ImageIcon(bufferedImage3));
    jButton2.addActionListener(new m(this));
    jButton2.setBorder(BorderFactory.createEmptyBorder());
    jButton2.setBounds(20, 0, 15, 15);
    jButton2.setOpaque(false);
    jButton2.setContentAreaFilled(false);
    jButton2.setBorderPainted(false);
    jPanel3.add(jButton2);
    JLabel jLabel1 = new JLabel(new ImageIcon(this.a));
    jLabel1.setBounds(272, 5, 21, 21);
    getContentPane().add(jLabel1);
    c.a(new n(this, jLabel1));
    JPanel jPanel1 = new JPanel();
    jPanel1.setBounds(5, 28, 288, 64);
    getContentPane().add(jPanel1);
    jPanel1.setLayout((LayoutManager)null);
    jPanel1.setOpaque(false);
    JButton jButton4 = new JButton(new ImageIcon(bufferedImage8));
    jButton4.setBounds(jPanel1.getWidth() / 2 - 74, 0, 64, 64);
    jButton4.setOpaque(false);
    jButton4.setContentAreaFilled(false);
    jButton4.setBorderPainted(false);
    jButton4.setToolTipText("Self-destruct");
    jPanel1.add(jButton4);
    jButton4.addActionListener(new o(this));
    JButton jButton3 = new JButton(new ImageIcon(bufferedImage7));
    jButton3.setBounds(jPanel1.getWidth() / 2 + 10, 0, 64, 64);
    jButton3.setOpaque(false);
    jButton3.setContentAreaFilled(false);
    jButton3.setBorderPainted(false);
    jButton3.setToolTipText("Settings");
    jPanel1.add(jButton3);
    JPanel jPanel2 = new JPanel();
    jPanel2.setBounds(5, 96, 288, 218);
    jPanel2.setOpaque(false);
    getContentPane().add(jPanel2);
    jPanel2.setLayout((LayoutManager)null);
    JLabel jLabel7 = new JLabel("Toggle Button");
    this.a.deriveFont(13.0F);
    jLabel7.setFont((Font)this.a);
    jLabel7.setFont(new Font("Lato", 0, 13));
    jLabel7.setForeground(Color.WHITE);
    jLabel7.setBounds(6, 11, 103, 16);
    jPanel2.add(jLabel7);
    JToggleButton jToggleButton = new JToggleButton(new ImageIcon(bufferedImage1));
    jToggleButton.setSelectedIcon(new ImageIcon(bufferedImage6));
    jToggleButton.setBounds(179, 8, 103, 19);
    jToggleButton.setOpaque(false);
    jToggleButton.setContentAreaFilled(false);
    jToggleButton.setBorderPainted(false);
    jToggleButton.setBorder(BorderFactory.createEmptyBorder());
    jToggleButton.setFont((Font)this.a);
    jToggleButton.setText(c.a());
    jToggleButton.setHorizontalTextPosition(0);
    jToggleButton.setVerticalTextPosition(0);
    jToggleButton.addActionListener(new p(this, jToggleButton));
    jPanel2.add(jToggleButton);
    JLabel jLabel6 = new JLabel("Tick If Hot");
    jLabel6.setFont((Font)this.a);
    jLabel6.setForeground(Color.WHITE);
    jLabel6.setFont((Font)this.a);
    jLabel6.setBounds(6, 39, 157, 16);
    jPanel2.add(jLabel6);
    JCheckBox jCheckBox2 = new JCheckBox("");
    jCheckBox2.setIcon(new ImageIcon(bufferedImage4));
    jCheckBox2.setSelectedIcon(new ImageIcon(bufferedImage5));
    jCheckBox2.setBounds(254, 39, 28, 16);
    jCheckBox2.setOpaque(false);
    jCheckBox2.setContentAreaFilled(false);
    jCheckBox2.setBorderPainted(false);
    jPanel2.add(jCheckBox2);
    JLabel jLabel5 = new JLabel("CPS Drops");
    jLabel5.setFont((Font)this.a);
    jLabel5.setForeground(Color.WHITE);
    jLabel5.setBounds(6, 67, 80, 16);
    jPanel2.add(jLabel5);
    jLabel5 = new JLabel("");
    jLabel5.setFont((Font)this.a);
    jLabel5.setBounds(73, 67, 14, 16);
    jPanel2.add(jLabel5);
    jLabel5.setForeground(new Color(200, 200, 200));
    jLabel5.addMouseListener(new r(this, jLabel5));
    JCheckBox jCheckBox1 = new JCheckBox("");
    jCheckBox1.setSelected(c.b);
    jCheckBox1.setIcon(new ImageIcon(bufferedImage4));
    jCheckBox1.setSelectedIcon(new ImageIcon(bufferedImage5));
    jCheckBox1.setOpaque(false);
    jCheckBox1.setContentAreaFilled(false);
    jCheckBox1.setBorderPainted(false);
    jCheckBox1.setBounds(254, 67, 28, 16);
    jCheckBox1.addActionListener(new s(this, jCheckBox1));
    jPanel2.add(jCheckBox1);
    JLabel jLabel4 = new JLabel("");
    this.a.deriveFont(13.0F);
    jLabel4.setFont((Font)this.a);
    jLabel4.setForeground(Color.WHITE);
    jLabel4.setBounds(6, 95, 184, 16);
    jPanel2.add(jLabel4);
    jLabel4 = new JLabel("");
    jLabel4.setBounds(41, 95, 14, 16);
    jPanel2.add(jLabel4);
    jLabel4.setFont((Font)this.a);
    jLabel4.setForeground(new Color(200, 200, 200));
    jLabel4.addMouseListener(new f(this, jLabel4));
    jLabel4 = new JLabel("Bitches:");
    jLabel4.setForeground(Color.WHITE);
    this.a.deriveFont(13.0F);
    jLabel4.setFont((Font)this.a);
    jLabel4.setBounds(204, 95, 49, 16);
    jPanel2.add(jLabel4);
    jLabel4 = new JLabel("Money:");
    jLabel4.setForeground(Color.WHITE);
    jLabel4.setFont((Font)this.a);
    jLabel4.setBounds(204, 115, 49, 16);
    jPanel2.add(jLabel4);
    try {
      MaskFormatter maskFormatter = new MaskFormatter();
      this("|#|");
    } catch (ParseException parseException) {
      parseException.printStackTrace();
      parseException = null;
    } 
    JFormattedTextField jFormattedTextField4 = new JFormattedTextField((JFormattedTextField.AbstractFormatter)parseException);
    jFormattedTextField4.setBorder((Border)null);
    jFormattedTextField4.setOpaque(true);
    jFormattedTextField4.setFont((Font)this.a);
    jFormattedTextField4.setHorizontalAlignment(0);
    jFormattedTextField4.setText("|" + c.e + "|");
    jFormattedTextField4.setBounds(254, 90, 28, 26);
    jPanel2.add(jFormattedTextField4);
    JFormattedTextField jFormattedTextField1 = new JFormattedTextField((JFormattedTextField.AbstractFormatter)parseException);
    jFormattedTextField1.setBorder((Border)null);
    jFormattedTextField1.setOpaque(true);
    jFormattedTextField1.setFont((Font)this.a);
    jFormattedTextField1.setHorizontalAlignment(0);
    jFormattedTextField1.setText("|" + c.f + "|");
    jFormattedTextField1.setBounds(254, 110, 28, 26);
    jPanel2.add(jFormattedTextField1);
    jFormattedTextField4.addActionListener(new g(this, jFormattedTextField4));
    jFormattedTextField1.addActionListener(new h(this, jFormattedTextField1));
    JLabel jLabel3 = new JLabel("Left Click");
    this.a.deriveFont(15.0F);
    jLabel3.setFont((Font)this.a);
    jLabel3.setForeground(Color.WHITE);
    jLabel3.setHorizontalAlignment(0);
    jLabel3.setBounds(6, 143, 276, 16);
    jPanel2.add(jLabel3);
    a a = new a(5, 25);
    a.setValue(c.a);
    a.a(c.b);
    a.setBorder(BorderFactory.createEmptyBorder());
    a.setFocusable(false);
    a.setOpaque(false);
    a.setBounds(6, 160, 276, 29);
    jPanel2.add(a);
    jLabel3 = null;
    try {
      NumberFormat numberFormat1 = NumberFormat.getInstance();
      numberFormat = numberFormat1;
      numberFormat1.setMaximumIntegerDigits(2);
      numberFormat = numberFormat1;
    } catch (NumberFormatException numberFormatException) {
      numberFormatException.printStackTrace();
    } 
    JFormattedTextField jFormattedTextField2 = new JFormattedTextField(numberFormat);
    jFormattedTextField2.setBorder((Border)null);
    jFormattedTextField2.setOpaque(true);
    jFormattedTextField2.setHorizontalAlignment(0);
    jFormattedTextField2.setBounds(6, 182, 28, 26);
    jFormattedTextField2.setValue(Integer.valueOf(a.getValue()));
    jPanel2.add(jFormattedTextField2);
    JFormattedTextField jFormattedTextField3 = new JFormattedTextField(numberFormat);
    jFormattedTextField3.setBorder((Border)null);
    jFormattedTextField3.setOpaque(true);
    jFormattedTextField3.setHorizontalAlignment(0);
    jFormattedTextField3.setBounds(254, 182, 28, 26);
    jFormattedTextField3.setValue(Integer.valueOf(a.a()));
    jPanel2.add(jFormattedTextField3);
    a.addChangeListener(new i(this, jFormattedTextField2, a, jFormattedTextField3));
    j j = new j(this, jFormattedTextField2, jFormattedTextField3, a);
    jFormattedTextField2.addActionListener(j);
    jFormattedTextField3.addActionListener(j);
    jFormattedTextField4.setEnabled(false);
    jFormattedTextField1.setEnabled(false);
    JLabel jLabel2 = new JLabel("Chicken");
    jLabel2.setBounds(5, 5, 288, 16);
    getContentPane().add(jLabel2);
    jLabel2.setHorizontalAlignment(0);
    jLabel2.setFont((Font)this.b);
    jLabel2.setForeground(Color.WHITE);
  }
  
  private BufferedImage a(String paramString) {
    try {
      if (c.e)
        return ImageIO.read(getClass().getResourceAsStream(paramString)); 
      File file = new File();
      String str = paramString;
      if (paramString.startsWith("/"))
        str = paramString.substring(1); 
      this(str);
      BufferedImage bufferedImage = ImageIO.read(file);
    } catch (IOException iOException) {
      iOException.printStackTrace();
      iOException = null;
    } 
    return (BufferedImage)iOException;
  }
}


/* Location:              C:\Users\danzi\Downloads\Jarl.jar!\com\java\loader\applet\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */