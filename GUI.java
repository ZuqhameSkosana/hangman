import javax.swing.*;
import java.awt.*;

public class GUI{
   
   
   WordList w_List = new WordList();
   public static JList list = new JList();
  
   static JFrame j=new JFrame();
   // Contructor methods
   public GUI(){
      
      j.setSize(300,600);
      
      j.setTitle("    Word Puzzle Solver");
     
      j.setLayout(new GridLayout(0,1));
      
      j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      

      JPanel panel_numer1 = new JPanel();
      panel_numer1.setBackground(Color.BLUE);
           
      panel_numer1.setPreferredSize(new Dimension(420, 40));
      
      JPanel panel_numer2 = new JPanel();
      
      JButton btn=new JButton();
      btn.setPreferredSize( new Dimension( 30, 30 ));
      
      panel_numer2.setBackground(Color.PINK);
      
      panel_numer2.setPreferredSize(new Dimension(420, 320));
      
      JTextField txt_F = new JTextField();
      
      txt_F.setPreferredSize( new Dimension( 150, 25 ));
      
      
      JLabel lbl_1 = new JLabel("Pattern");
      
      lbl_1.setPreferredSize(new Dimension(200, 24));
      
      
      panel_numer1.add(lbl_1);
      
      panel_numer1.add(txt_F);
    
            
      JLabel lbl_2 = new JLabel("Matches");
      
      lbl_2.setPreferredSize(new Dimension(200, 24));
     
      PatternMatcher t = new PatternMatcher(txt_F, w_List, list);
      
       JList<Word> list = new JList<Word>(t.getListmodel());
      
      txt_F.addActionListener(t);
      
      JScrollPane scrl_P = new JScrollPane(list);
      
      scrl_P.setPreferredSize(new Dimension(250, 200));
   

      
      panel_numer2.add(lbl_2);
      panel_numer2.add(scrl_P);
      j.add(panel_numer1);
      j.add(panel_numer2);
      
   
   }
   

   public static void main(String args[]){
      GUI _gui = new GUI();
     
      j.setVisible(true);
   }
}