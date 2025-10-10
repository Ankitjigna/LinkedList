import java.util.*;
public class DoublyLL{
    public static class Node{
        int data;
        Node next;
        Node prev;
        public  Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
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
        head.prev = newNode;
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
        tail.prev = tail;
        tail = newNode;
        }

        public int removeFirst(){
            if(size == 0){
                System.out.println("DoublyLL is Empty");
                return Integer.MIN_VALUE;
            }
            else if(size == 1){
                int val = head.data;
                head = tail = null;
                size = 0;
                return val;
            }
            int val = head.data;
            head = head.next;
            head.prev = null;
            size--;
            return val;
        }

        public int removeLast(){
            if(size == 0){
                System.out.println("DoublyLL is Empty");
                return Integer.MIN_VALUE;
            }
            else if(size == 1){
                int val = head.data;
                head = tail = null;
                size = 0;
                return val;
            }
            
            Node prev = head;
            for( int i=0 ; i<size-2 ; i++){
                prev = prev.next;
            }
            int val = tail.data;
            tail = tail.prev;
            tail.next = null;
            size--;
            return val;
        }

        public static void print(){
            if(head == null){
            System.out.println("DoublyLL is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data +"<->" );
            temp = temp.next;
        }
        System.out.println();
        }

        public static void main(String args[]){
        // LinkedList ll = new LinkedList();
        DoublyLL ll = new DoublyLL();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.addFirst(9);

        ll.print(); 
        System.out.println(ll.size);

        ll.removeFirst();
        ll.print(); 
        System.out.println(ll.size);

        ll.removeLast();
        ll.print(); 
        System.out.println(ll.size);

        ll.addLast(8);
        ll.print(); 
        System.out.println(ll.size);
    }
 }
