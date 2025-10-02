import java.util.*;
public class Search{
    public static class Node{
        int data;
        Node next;

        public  Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public  Node head;
    public  Node tail;
    public  int size;

    // Add First

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


// add last


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

//print

    public void print(){
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data  );
            temp = temp.next;
        }
        System.out.println();
        System.out.println(" size of LL is :" + size);
        System.out.println();



    }

    // Iterative Search(linear Srach)

    public int ittSearch(int key){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){
                return i;  // key found
            }
            temp = temp.next;
            i++;
        }
        return -1;  // key not found
    }


    public static void main(String args[]){
         // LinkedList ll = new LinkedList();
        Search ll = new Search();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(7);
        ll.addLast(4);
        ll.print();
        System.out.println(" found at index : "+ll.ittSearch(2));
    }
}