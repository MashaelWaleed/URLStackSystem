/*
Name:Mashael waleed 
ID:
Section Number:BBC
Email:
Date:16/5/2023
Assignment:Assignment3
*/

package URLStackSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class URLStackSystem {
   
public static void main(String[] args) throws FileNotFoundException {
    //create file and Scanner objects
    File file1=new File("intialInformationStack.txt");
    Scanner read1=new Scanner(file1);
    
    File file2=new File ("CommandsStack.txt");
    Scanner read2= new Scanner(file2); 
   
    //create PrintWriter object
    PrintWriter write =new PrintWriter("OutputStack.txt");
    //create Array for the names of tabs
    String [] tabsArr={"T1","T2","T3","history"};
    //create arrayList to store the stacks 
    ArrayList < webPagesStackArray>myStacksList=new ArrayList();
    //three stacks for Tab1 Tab2 Tab3 
    myStacksList.add(new webPagesStackArray(10));
    myStacksList.add(new webPagesStackArray(10));
    myStacksList.add(new webPagesStackArray(10));
    //history stack
    myStacksList.add(new webPagesStackArray(50));
    
 
    //print the header on output file
    write.println("                               Welcome to URL Stack System                                   ");
    write.println("                  -----------------------------------------------------               	"); 
    //varible to use
     String tab;String url;
     String command =read2.next();
    do{
        
   //==========================SWITCH TO TEST COMMAND CASES ==========================//   
       switch (command) {  
   /////////////////////////////////////////////////////////////////////////////       
           
           
   //=====================================1===================================// 
         case "STARTUP" :  
   //=========================================================================//       
   //-----read from file1-----//
       int num= read1.nextInt();
       for(int i=0; i<num;i++){
           //read info 
       tab=read1.next();
       url=read1.next();
        //push url in correct stack using pushStack method 
          if(tab.equalsIgnoreCase("T1"))
           pushStack(myStacksList,0,url);
          if(tab.equalsIgnoreCase("T2"))
           pushStack(myStacksList,1,url);
          if(tab.equalsIgnoreCase("T3"))
           pushStack(myStacksList,2,url);
          
           write.println("The URL ("+url+") was pushed into Stack "+tab); 
       }
       //close first scanner 
       read1.close();
       //print line
       write.println("\n------------------------------------------------------------------------\n");
       
       write.flush();
       break;
   //=========================================2===============================//
         case "GO_FORWARD":
   //=========================================================================//          
            //read info from file2 
             tab=read2.next();
             url=read2.next();
             //search for index of correct tab
             int result =search(tab,tabsArr);
             //check if tab found or not 
          if(result>=0)
                if(myStacksList.get(result).isFull())
                  write.println("The ("+tab+") stack is full, the following URL ("+url+") cannot be stored");
                else{
                    //if not full--> call push method
                  pushStack(myStacksList,result,url);
                  write.println("The URL ("+url+") was pushed into Stack "+tab); 
                  write.println("------------------------------------------------------------------------"); }
          
             //if not found
         else{
             write.println("This tab is not found");}
             write.flush();
             break;
   //========================================3================================//          
         case "GO_BACK":
   //=========================================================================//       
             tab=read2.next();
           
             result =search(tab,tabsArr);
             if(myStacksList.get(result).isEmpty())
                  write.println("The ("+tab+") stack is empty you cannot delete from it");
              else{
                 //delete from stack//
                 if(myStacksList.get(3).isFull()){//if history stack full delete only using pop method
                   write.println("");  
                  popStack(myStacksList,result);}
                 
                 /*if not full--> call a method to (push the Url to be deleted )
                 into history stack and delete it using pop method*/
                 else
                 pushInHistoryStack(myStacksList,result);
             }
             
             write.flush();
             break;
   //========================================4================================//          
         case  "DISPLAY_ALL_VISITED":
   //=========================================================================//  
             //print content of all tabs 
            for(int i=0;i<tabsArr.length;i++) {
                //print stacks of normal tabs
                if(i!=3)
             write.println("The content of Stack "+tabsArr[i]+":"); 
                //print hestory stack
                else {
             write.println("The content of the "+tabsArr[i]+" stack :"); } 
             write.println("_________________________");
             write.println(myStacksList.get(i).clearAll());
             write.println("");}
            
            write.flush();
          }//end switch
    
         command=read2.next();
      }while(!command.equalsIgnoreCase("QUIT"));
       //print
       write.println("============================");
       write.println("        Best Wishes         ");
       write.println("============================");
       read2.close();
       write.close();
    }





///////////////////////////////SEARCH FOR CORRECT STACK/////////////////////////
public static int search(String tab,String[]t){
//return index of correct tab
for(int i=0;i<t.length;i++){
if(t[i].equalsIgnoreCase(tab))
    return i;}
//return -1 if not found
return -1;
}

/////////////////////////////////////PUSH METHOD ///////////////////////////////
public static void pushStack(ArrayList <webPagesStackArray>myStacksList,int tabIndex,String url){
  //push into a normal stack 
  myStacksList.get(tabIndex).Push(url);

}
/////////////////////////////////////POP METHOD ////////////////////////////////
public static String popStack(ArrayList <webPagesStackArray>myStacksList,int tabIndex){
  //pop from a stack
  return myStacksList.get(tabIndex).Pop();

}

///////////////////////////PUSH METHOD FOR HISTORY STACK////////////////////////
public static void pushInHistoryStack(ArrayList <webPagesStackArray>myStacksList,int tabIndex){
  //push into history stack and delete it from its original stack
  myStacksList.get(3).Push(popStack(myStacksList,tabIndex));

}

////////////////////////////////////////////////////////////////////////////////
    
}
