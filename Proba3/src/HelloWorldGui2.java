import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.SwingUtilities;

public class HelloWorldGui2 extends JFrame { 

HelloWorldGui2() { 
JLabel helloLabel = new JLabel("Hello World"); 
add(helloLabel); 
this.setSize(100, 100); 
setLocationRelativeTo(null); 
setDefaultCloseOperation(EXIT_ON_CLOSE); 
setVisible(true); 
} 

public static void main(String args[]) { 
SwingUtilities.invokeLater(new Runnable() { 
public void run() { 
HelloWorldGui2 ex = new HelloWorldGui2(); 
ex.setVisible(true); 
} 
}); 
} 
}
