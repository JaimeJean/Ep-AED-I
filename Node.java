/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep1;

public class Node {
    
  private int element;
  private Node next;

  public Node(int s, Node n){
    this.element = s;
    this.next = n;
  }

  public int getElement(){ 
      return this.element; 
  }
  
  public Node getNext(){
      return this.next; 
  }
  
  public void setElement(int newElement){
      this.element = newElement; 
  
  }
  
  public void setNext(Node newNext){ 
      this.next = newNext;
  }
    
}
