import java.util.*;
public class LoopCycle{

    public static class Node{
        int data;
        Node next;
        public  Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }


    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public boolean isCycle(){
       Node slow = head;
       Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next;//+2
             if(slow == fast) {
                return true; //cycle exists
         } 
    }
     return false; //cycle doesn't exist
 }
    

    
    public String toString() {
         StringBuilder sb = new StringBuilder();
         Node temp = head;
         sb.append("[");     
         while (temp != null) {
             sb.append(temp.data);
             if (temp.next != null) sb.append(", ");
             temp = temp.next;
              }
         sb.append("]");
         return sb.toString();
         }


        public static void removeCycle(){
         //detect cycle
         Node slow = head;
         boolean cycle = false;
         Node fast = head;
         while(fast != null && fast.next != null) { 
            slow =slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;
            }
         }
            if(cycle == false){ 
                return;
            }
            //find meeting point
            slow = head;
            Node prev = null; //last node
            while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
         }
           //remove cycle -> last.next = null
             prev.next = null;
     } 


    public static void main(String args[]){
        LoopCycle ll = new LoopCycle();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(0);
        ll.addFirst(2);
        ll.addFirst(0);
        System.out.println(ll);

        //  manually create a cycle
        ll.tail.next = ll.head.next; // tail points to second node, forming a loop
        System.out.println(ll.isCycle());
        ll.removeCycle();
        System.out.println(ll.isCycle());

         
    }
}