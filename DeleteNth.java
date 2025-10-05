import java.util.*;

public class DeleteNth {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addMid(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteNthfromEnd(int n) {
           //calculate size
           int sz =0;
           Node temp = head;
            while(temp != null) {
                 temp = temp.next;
                 sz++;
            } 


        if(n == sz) {
             head = head. next;  // remove first
             return;
        }
          
          //fsz-n
           int i=1;
           int iToFind = sz-n;
           Node prev = head;
           while(i < iToFind){
            prev = prev.next;
           i++;
           }
             prev.next = prev.next.next;
             return;
        }

    public void print() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println();
        System.out.println(" size of LL is :" + size);
        System.out.println();

    }

    public static void main(String args[]) {
        // LinkedList ll = new LinkedList();
        DeleteNth ll = new DeleteNth();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        // ll.print();
        // ll.addMid(2, 8);
        // ll.print();
        ll.deleteNthfromEnd(2);
        ll.print();

    }
}