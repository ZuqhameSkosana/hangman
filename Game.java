/*

ZUQHAME SKOSANA
SKSZUQ001
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Game implements ActionListener{
   
   private JTextField user_Input;
   
   private String word;
   
   private JTextArea jtext_output;
   private String x = "";
   private int image_jpg = 1;
   private String word_g[];
   
   private boolean wrong_output = true;
   
   public Game(JTextField user_Input, String word, JTextArea OutputField, String[] word_g){
      this.word = word;
      
      this.word_g = word_g;
      this.user_Input = user_Input;
      this.jtext_output = OutputField;
   }
   
   public int getDifficultSet(int diff_level){
      image_jpg+= diff_level;
      return image_jpg;
   }
   
   public boolean get_wrong_output(){
      return wrong_output;
   }
   
   public void actionPerformed(ActionEvent e){
      try{
      
         String l = user_Input.getText();
         jtext_output.append("Guess \'" + l + "\'\n");
         wrong_output = true;
         int k=0;
         
        
         while(k<word.length()){
            String alp = word.charAt(k) + "";
            if (alp.equalsIgnoreCase(l)) {
               word_g[k] = l;
               wrong_output = false;
            }
            k++;
         }
         
         
         x="";
         for (String _guessing : word_g) {
           
            x=x+ _guessing;
         
         }
         
         System.out.println(word);
         
         System.out.println(x);
         
         if (wrong_output) {
            jtext_output.append("Not correct!\n");
         
         }
         else if(!(x.equals(word))){
            jtext_output.append(x + "\n");
         }
         else{
            jtext_output.append(x + "\n");
            
            System.out.println(x);
            
           
            JOptionPane.showMessageDialog(null, "Congradualtions you have won!"); 
         
            user_Input.setEditable(false);
         
            
         }
         
      }
      catch(Exception exception){
         System.out.println(exception+"");//catch excetion if an error appears
      }
      
      
   }
   
}