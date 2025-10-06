import java.util.*;
public class Palindrome{

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
        // Finding mid Node 
        private Node findMidNode(Node head){
            Node slow = head;
            Node fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        /// Palindrome

        public boolean checkPalindrome(){
            if(head == null || head.next  == null){
                return true;
            }

            // finding mid
            Node mid = findMidNode(head);

            // Reverse 2nd half of linkedList
            Node curr = mid;
            Node prev = null;
            while(curr != null){
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node right = prev;
            Node left = head;
            // checking equal 

            while(right != null){
                if(left.data != right.data){
                    return false;
                }
                left = left.next;
                right = right.next;
            }
            return true;
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


        public static void main(String args[]){
        // Java Collections Framework

        // Create
        Palindrome ll = new Palindrome();

        // Add

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);
        // Print

        System.out.println(ll);
        System.out.println(ll.checkPalindrome());

    }
}