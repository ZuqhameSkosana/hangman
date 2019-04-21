import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

public class PatternMatcher implements ActionListener{
   
   private JTextField user_inputF;
   
   private JList search_Output_List;
   
   private WordList word_list;
   
//constructor//+++++++++++++++++++++++++++++++++++++++++++++++++
   
   public PatternMatcher(JTextField user_inputF, WordList word_list, JList search_Output_List){
   
      super();
      
      this.word_list = word_list;
      this.search_Output_List = search_Output_List;
      this.user_inputF = user_inputF;
      
     
      
   }
   
   DefaultListModel <Word> modelling_List = new DefaultListModel<>();

   public DefaultListModel <Word> getListmodel(){
    
      return modelling_List;
   }

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   public void actionPerformed(ActionEvent e){
   
      Pattern pat = new Pattern(user_inputF.getText());
      
      String key="dictionary.txt";
      
      
      try{
         word_list = WordList.readFromFile(key);
      
      }
      catch(Exception error){
      
         System.out.println(error+"");
      
      }
      
      WordList word_l = new WordList();
      GUI _g_ = new GUI();
      
      
      for(Word _word:word_list){
         if(pat.matches(_word)){
            word_l.add(_word);
            modelling_List.addElement(_word);
            
         }
      }
      
   
   }
}