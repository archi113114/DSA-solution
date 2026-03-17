import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class linked_list {
    // question 39 

     public static void question39() {
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        ListNode reversed = reverseList(head);

        System.out.print("Reversed List: ");
        printList(reversed);
    }
    
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
         while (curr != null) {
            ListNode next = curr.next; 
            curr.next = prev;          
            prev = curr;               
            curr = next;               
        }

        return prev; 
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

     // question 40

      public static void question40() {
       
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

       
        head.next.next.next.next = head.next;

        boolean result = hasCycle(head);
        System.out.println("Does the linked list have a cycle? " + result);
    }

    
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

                ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         
            fast = fast.next.next;    

            if (slow == fast) {
                return true; 
            }
        }

        return false; 
    }

     // question 41  

     public static void question41() {
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.print("Original List: ");
        printList(head);

        ListNode middle = middleNode(head);

        System.out.print("Middle Node and onwards: ");
        printList(middle);
    }

   
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

         while (fast != null && fast.next != null) {
            slow = slow.next;        
            fast = fast.next.next;   
        }

        return slow; 
    }

    
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

     // question 42

      public static void question42() {
       
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        System.out.print("List1: ");
        printList(list1);

        System.out.print("List2: ");
        printList(list2);

        ListNode merged = mergeTwoLists(list1, list2);

        System.out.print("Merged List: ");
        printList(merged);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        
        if (list1 != null) tail.next = list1;
        if (list2 != null) tail.next = list2;

        return dummy.next;
    }

        public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        question39(); 
        question40();
        question41();
        question42();
    }
}
    
   
    


   
   
