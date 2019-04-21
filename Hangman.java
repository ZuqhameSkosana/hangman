//importing

/*
ZUQHAMESKOSANA
SKSZUQ001

*/
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;


public class Hangman{
   
   private static JFrame j_frame = new JFrame(); private static JPanel J_panel = new JPanel(); private static JLabel lbl_pic = new JLabel();
   
   private static JLabel label_guess = new JLabel("guess:");
   
   private static JLabel lbl = new JLabel("Level:");
   
   private static JTextField text_Inpt = new JTextField();
   private static JTextArea txt_result_output = new JTextArea();
   private static JScrollPane scroll_pane = new JScrollPane(txt_result_output);
   
   static String beginning="1";
   private static JTextField txt = new JTextField(beginning);
   
       
   public static void get_Pic(int picture_number){
      ImageIcon img_icon = new ImageIcon("state"+picture_number+".GIF");
      
      lbl_pic.setIcon(img_icon);
   }
   
   public static void GUI(){
   
      int num1=30;
      //jframe
      j_frame.setSize(new Dimension(605, 605));
      
      j_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      j_frame.setLayout(null);
      
      j_frame.add(J_panel);
     
     //j panel
      J_panel.setLayout(null);
      J_panel.add(label_guess);
      J_panel.add(text_Inpt);
      J_panel.add(txt);
      J_panel.add(scroll_pane);
      J_panel.add(lbl);
     

      get_Pic(1);
      J_panel.add(lbl_pic);
      J_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "WIN OR HANG YOURSELf"));
      J_panel.setBackground(Color.PINK);
      J_panel.setBounds(45, 45, 505, 355);
      label_guess.setBounds(num1+5,num1+5,num1+20+5,40+5);
      text_Inpt.setBounds(85,35,105,25);
      text_Inpt.setBorder(BorderFactory.createLineBorder(Color.RED));
      txt_result_output.setEditable(false);
      txt_result_output.setBorder(BorderFactory.createLineBorder(Color.RED));
      scroll_pane.setBounds(35,85,155,255);
      scroll_pane.setBorder(BorderFactory.createLineBorder(Color.RED));
      lbl.setBounds(215,35,85,25);
      
      txt.setBounds(295,35,40,25);
      
      //lbl
      
      lbl_pic.setBounds(215,85,185,255);
      lbl_pic.setBorder(BorderFactory.createLineBorder(Color.BLUE));
      
      
     
     
     //visible frame
      j_frame.setVisible(true);
   }
   
   public static void main(String[] args){
      
      try{
      
         GUI();
         String fileWords="dictionary.txt";
         WordList word_list;
         word_list = (new WordList()).readFromFile(fileWords);
         
         String string = (word_list.toString()).replace("{", "");
         
         string = string.replace("}", "");
         
         String Array_stringWord[] = string.split(", ");
         int len=Array_stringWord.length-1;
         int rand_generation = (new Random()).nextInt(len);
         
         String[] gueesRand = new String[Array_stringWord[rand_generation].length()];
         
         int iy=0;
        
         while(iy<gueesRand.length){
            gueesRand[iy] = "-";
            txt_result_output.append("-");
            iy++;
         
         }
        
         txt_result_output.append(""+"\n");
         Game _game  = new Game(text_Inpt, Array_stringWord[rand_generation], txt_result_output, gueesRand);
         int stop=11;
         text_Inpt.addActionListener(
         
            new ActionListener() {
         
               public void actionPerformed(ActionEvent e) {
               boolean bool=false;
         
                  _game.actionPerformed(e);
         
                  text_Inpt.setText("");
                  
                  if(_game.get_wrong_output()){
                  
                     int u = Integer.parseInt(txt.getText());
                  
                     int int_num = _game.getDifficultSet(u);
                  
                     if(int_num < stop){
                        get_Pic(int_num);
                        J_panel.add(lbl_pic);
                     }
                     
                     else if(int_num >= stop){
                        get_Pic(stop);
                        J_panel.add(lbl_pic);
                        JOptionPane.showMessageDialog(null, "=======\nYou Lost=======!"); 
                        text_Inpt.setEditable(bool);
                     }
                  }
               
               }
            }
            );
       }catch(Exception exception){System.out.println(exception+"");}
   }

}
