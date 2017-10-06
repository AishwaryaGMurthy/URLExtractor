import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class ArticleIndexer {private static boolean matchServer(String url,String str)
{
    String link=url;
    String str1=str;
    
    if(link=="" || link==null)
    {    
        return false;
    }
    
    if(str1=="" || str1==null)
    {
        return false;
    }
    
    
    for(int i=0; i < link.length();i++)
        
    {
          int sindex;
          int index;
          int rest;
          String state1;
          String state;
          
          
        String check=url.substring(i, i+1);
        
        if(check.equalsIgnoreCase("/"))
        {
            index=url.indexOf("/");
            rest=index+2;
        
            state1=url.substring(rest);
          
            
             if(state1.contains("/"))
            {
            sindex=state1.indexOf("/");    
            state=state1.substring(0,sindex);
            }
            else
            {
            state=state1.substring(0,state1.length());
            }
            
            //System.out.println(state);
            state=state.toLowerCase();
            str1=str1.toLowerCase();
            
            if(state.contains(str1))
            {
                //System.out.println("this is true");
                return true;
            
            }
            
            break;
        }
        
    }
    
    //System.out.println("this is false");
    
return false;
}
        

public static void scanAndPrint(Scanner in,String str)
{
  
  //System.out.println("calling second method\n");
  
    Map<String,Integer> st=new HashMap<String, Integer> ();
    
    
    String str2=str;
    String line = "";
    String key;
    String res1="";
    int value=0;
    while(in.hasNextLine()) 
    
    {
        line=in.nextLine().trim();
        
        // fetching link starts with http:
        
        line=line.toLowerCase();
        if(line.startsWith("http"))
        {
               int strthttp=line.indexOf(' ');
               key=line.substring(0, strthttp);
               
            if( matchServer(key,str2)==true) // calling matchServer method to check string condtion
                {
             MyURL parse=new MyURL();
             res1=parse.parseURL(key);
            // System.out.println((res1));             
              
              if(!st.containsKey(res1))
              {
                  st.put(res1,value);
                   value++;
              }
              
           }    
            
       }        
           
        String hash="";
        int s=0,l=0;
        line=line.toLowerCase();
        String tag="";
        String aline="";
        int c=0,x=0;
        String tokens[]=line.split(">");
        for(int t=0;t<tokens.length;t++) 
        {
            line=tokens[t];
        for (int i = 0; i <line.length(); i++) 
        {
            if(i<line.length()-4)
            {
                tag=line.substring(i, i+2);
       
            }
            
            
            if(tag.equals("<a"))
           {
           
            aline=line.substring(line.indexOf(tag));
            x=aline.indexOf("\"");
            String index="";
            
         for(int count=x+1;count<aline.length();count++)
         {
                if(count<aline.length())
                {
                index=aline.substring(count, count+1);
                   if(index.equals("\""))
                    {
                    c=count;
                    break;
                     }
                 }
               
           } // third for loop 
            
             key=aline.substring(x+1,c);
             
                
                if( matchServer(key,str2)==true) // calling matchServer method to check string condtion
                 {
                MyURL parse=new MyURL();
                 res1=parse.parseURL(key);
            
                // adding hash function to assign sequence number
                
                if(!st.containsKey(res1))
                {
                st.put(res1,value);
                value++;
                }
                
        
                }
            }
                
             
      }// second for loop
            
      
        
   } // third for loop
        
     
        
}    
   for(String j : st.keySet())
         System.out.println(j+ " " + st.get(j));
   
}
public static void main(String[] args) throws IOException { 

Scanner b = new Scanner(new File("/rmt/csfiles/pgrads/mbva620/scrape.txt"));

scanAndPrint(b,"guardian");    

}}
