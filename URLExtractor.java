import java.io.*;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Pattern;
public class URLExtractor {
    public static void scanAndPrint(Scanner in)
   
    {  
        String line = "";
    while(in.hasNextLine()) {
        line=in.nextLine().trim();
        int s=0,l=0;
        line=line.toLowerCase();
        String tag="";
        String aline="";
        int c=0,x=0;
        String tokens[]=line.split(">");
        for(int t=0;t<tokens.length;t++){
            line=tokens[t];
        for (int i = 0; i <line.length(); i++) {
            if(i<line.length()-4){
                tag=line.substring(i, i+2);
            }
            if(tag.equals("<a")){
            //System.out.println(line.substring(line.indexOf(tag)));
            aline=line.substring(line.indexOf(tag));
            //System.out.println(aline);
            x=aline.indexOf("\"");
            String index="";
            for(int count=x+1;count<aline.length();count++){
            if(count<aline.length()){
                //System.out.print(aline.substring(count, count+1));
                index=aline.substring(count, count+1);
                //System.out.print(index);
                if(index.equals("\"")){
                    c=count;
                    break;
                }
            }
              
            }
             String a=aline.substring(x+1,c);
             MyURL parse=new MyURL();
            String res1=parse.parseURL(a);
            System.out.println(res1);
            //System.out.println(aline.substring(x+1,c));
        
            }
             
              
        }
        }
     
        }
    in.close();
    return;
      
}
   
   
    private static boolean matchServer(String url,String str)
    {
    
        {
            String str1=str;
           
            if(url=="" || url==null)
            {    System.out.println("this is false");
                return false;
            }
           
            if(str1=="" || str1==null)
            {
                System.out.println("this is false");
                return false;
            }
           
            for(int i=0; i < url.length();i++)
               
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
                        System.out.println("this is true");
                        return true;
                   
                    }
                   
                    break;
                }
               
            }
           
            System.out.println("this is false");
           
        return false;
    }
}

  public static void scanAndPrint(Scanner in,String str)
        {
        String line = "";
        while(in.hasNextLine()) {
            line=in.nextLine().trim();
            int s=0,l=0;
            line=line.toLowerCase();
            String tag="";
            String aline="";
            int c=0,x=0;
            String tokens[]=line.split(">");
            for(int t=0;t<tokens.length;t++){
                line=tokens[t];
            for (int i = 0; i <line.length(); i++) {
                if(i<line.length()-4){
                    tag=line.substring(i, i+2);
                }
                if(tag.equals("<a")){
                //System.out.println(line.substring(line.indexOf(tag)));
                aline=line.substring(line.indexOf(tag));
                //System.out.println(aline);
                x=aline.indexOf("\"");
                String index="";
                for(int count=x+1;count<aline.length();count++){
                if(count<aline.length()){
                    //System.out.print(aline.substring(count, count+1));
                    index=aline.substring(count, count+1);
                    //System.out.print(index);
                    if(index.equals("\"")){
                        c=count;
                        break;
                    }
                }
                  
                }
                 String a=aline.substring(x+1,c);
                    //matchServer(a,str);   // calling matchServer method to check string condtion
                    
                    if( matchServer(a,str)==true) // calling matchServer method to check string condtion
                    {
                 MyURL parse=new MyURL();
                String res1=parse.parseURL(a);
                System.out.println(res1);
                    }
                //System.out.println(aline.substring(x+1,c));
                    }
                }
                 
                  
            }
            }
        in.close();
         return;
            }
      
public static void main(String[] args) throws IOException {
	  matchServer("http://www.google.com","google.com");
	    matchServer("http://www.Guardian.co.uk/global-development","guardian");
	    matchServer(null,"guardian.co.uk");
	    matchServer("http://theguardian.com","theguardian.com");
	    matchServer("http://www.facebook.com","FACEBOOK");
	    matchServer("http://www.yahoo.co.in",null);
	if(args.length==1)
  {   
		String path = new String(args[0]);  
		 File inFile = new File(path); 
		 Scanner f1 = new Scanner(inFile);
		 scanAndPrint(f1);
		 Scanner f2 = new Scanner(inFile);
		  scanAndPrint(f2,"guardian");
  }

		 else {
			 Scanner in1=new Scanner(System.in);
			 String path = in1.nextLine();
			 Scanner f1 = new Scanner(new File(path));
			 scanAndPrint(f1);
			Scanner p=new Scanner(System.in); 
			scanAndPrint(p,"guardian");

			 }
		  }
	
	}


		 
		