package checkRegularExpression;

import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
  
public class Test  
{ 
    public static void main(String[] args)  
    { 
        String s1 = "CREATE TABLE `user_roles`"; 
        
          
        Pattern p = Pattern.compile("[`][a-zA-Z]+_[a-zA-Z]+[`]"); 
          
        Matcher m1 = p.matcher(s1); 
        
          
        System.out.println("Words from string \"" + s1 + "\" : "); 
        while (m1.find()) { 
            System.out.println(m1.group()); 
        } 
          
   
         
          
    } 
} 