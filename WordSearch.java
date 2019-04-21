import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class WordSearch{
   
   private static JFrame frame = new JFrame();
   private static JPanel Box1 = new JPanel();
   private static JPanel Box2 = new JPanel();
   private static Box box = Box.createVerticalBox();
   private static JLabel lblPattern = new JLabel("Pattern");
   private static JLabel lblMatches = new JLabel("Matches");
   private static JTextField txtInput = new JTextField();
   private static JList list = new JList();
   private static JScrollPane scroll = new JScrollPane(list);
   
   
   // align the title to the centre
   private static void titleAlign(JFrame frame) {

      frame.setSize(new Dimension(460, 420));
      frame.setFont(new Font("System", Font.PLAIN, 20));
      Font f = frame.getFont();
      FontMetrics fm = frame.getFontMetrics(f);
      int x = fm.stringWidth("Word Puzle Solver");
      int y = fm.stringWidth(" ");
      int z = frame.getWidth()/2 - (x/2);
      int w = z/y;
      String pad = "";
      pad = String.format("%"+w+"s", pad);
      frame.setTitle(pad+"Word Puzle Solver");

    }
    
   // building the GUI structure
   public static void GUI(){
      
      titleAlign(frame);
      
      lblPattern.setFont(new Font("System", Font.PLAIN, 15));
      lblMatches.setFont(new Font("System", Font.PLAIN, 15));
      
      lblPattern.setBounds(30, 20, 60, 20);
      txtInput.setBounds(110,20,250,30);
      
      lblMatches.setBounds(30, 0, 60, 20);
      scroll.setBounds(110, 0, 250, 150);
 
      Box1.setBounds(30, 30, 400, 100);
      Box1.setLayout(null);
      Box1.add(lblPattern);
      Box1.add(txtInput);
            
      Box2.setBounds(30, 150, 400, 200);
      Box2.setLayout(null);
      Box2.add(lblMatches);
      Box2.add(scroll);
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(null);
      frame.add(Box1);
      frame.add(Box2);
      frame.setVisible(true);
   }
   
   public static void main(String[] args){
       GUI();
       WordList wl = new WordList();
       PatternMatcher pm = new PatternMatcher(txtInput, wl, list);
       
       txtInput.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            pm.actionPerformed(evt);
         }
       });
   }
}