/*
Name:Mashael waleed 
ID:
Section Number:BBC

Date:16/5/2023
Assignment:Assignment3

 */
package URLStackSystem;

public class webPagesStackArray {
//data feild
int maxSize;    
private int top;    
private String [] webStack;


//Constructors 
 public webPagesStackArray (int size){
 webStack=new String [size];
 maxSize=size; 
 top=-1;
 } 
 
 //methods//
 /////////////////////////////////IS EMPTY OR NOT///////////////////////////////
 public Boolean isEmpty(){
     return (top==-1);
 
 }
 //////////////////////////////////IS FULL OR NOT///////////////////////////////
  public Boolean isFull(){
     return (top==maxSize-1);
  }
 
/////////////////////////////////////////PUSH/////////////////////////////////// 
public void Push(String url) {
if(isFull())
    System.out.println("can not Push stack is full");
else{

webStack[++top]=url;

}
    
}
////////////////////////////////////////POP/////////////////////////////////////

public String Pop() {
if(isEmpty()){
    System.out.println("can not Pop any element from empty stack ");
    return null;
}
else
return webStack[top--];   
}
//////////////////////////////////////////TOP///////////////////////////////////

public String Top(){

return webStack[top];


}
////////////////////////////METHOD TO DELETE ALL CONTENT////////////////////////

public String clearAll(){
    String all="";
while (!isEmpty()){
    all+=Pop()+"\n";}

return all;
}






    
}
