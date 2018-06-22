package code;

class LinkedList
{
    Node head;
    int size;
    
    public LinkedList()
    {
        head = null;
        size = 0;
    } // LinkedList
    
    public LinkedList(int n)
    {
        head = new Node(n);
        size++;
    } // LinkedList
    
    /**
     *    Append an element to the LinkedList.
     */
    public void add(int data)
    {
        Node node = new Node(data);
        if(head == null) head = node;
        else
        {
            Node tail = head;
            while(tail.next != null) tail = tail.next;
            tail.next = node;
        } // if else
        size++;
    } // add
    
    /**
     *    Print the LinkedList.
     */
    public void show()
    {
        Node node = head;
        System.out.print("\nLinkedList: Head -> ");
        while(node != null)
        {
            System.out.print(node.data+" -> ");
            node = node.next;
        } // while
        System.out.println("null");
    } // add
    
    /**
     *    Return the reference of the first occurence of the 'data'.
     *    Return null if 'data' is not present in the LinkedList.
     */
    public Node find(int data)
    {
        Node current = head;
        while (current != null)
        {
            if (current.data == data) return current;
            current = current.next;
        } // while
        return null;
    } // find
    
    /**
     *    Rempve duplicates from a Linked List. CTCI LinkedList Ch 3. Problem #1.
     */
    public void removeDuplicates()
    {
        Node iNode = head;
        while(iNode != null)
        {
            int data = iNode.data;
            Node previous = iNode;
            Node jNode = iNode.next;
            while (jNode != null)
            {
                if (jNode.data == data) previous.next = jNode.next;
                else previous = jNode;
               
                jNode = jNode.next;
            } // while
            iNode = iNode.next;
        } // while
        
    } // removeDuplicates
    
    /**
     *   Find k-th to the last element of a Linked List. CTCI LinkedList Ch 3. Problem #2.
     */
    public void findKthLast(int k)
    {
        if(k < 1 || k > size)
        {
            System.out.println("k can not be smaller than 1 or greater than the list size.");
            System.out.println("Value supplied for k: "+k+". Valid Range for k: 0 < k < "+size);
            return;
        }
        Node current = head;
        int n = size - k;
        for(int i = 0; i<n; i++) current = current.next;
        System.out.println("k-th to the last element: "+current.data);
        
    } // findKthLast
    
    /**
     *    Delets the middle node, given it's reference.
     */
    public void deleteMiddleNode(Node n)
    {
        if (n.next == null)
        {
            System.out.println("Can not delete the last node in the LinkedList.");
            return;
        }
        n.data = n.next.data;
        n.next = n.next.next;
    }  // deleteMiddleNode
    
    public boolean isPalindromeRec(Node front, int k, Node prev, Node middle)
    {
        if( k != size/2)
        {
            return isPalindromeRec(front.next, k+1, front, middle.next);
        }
        if(front.data != middle.data)
        {
            return false;
        }
        else
        {
            return isPalindromeRec(prev, k, prev, middle.next.next);
        }
    } // isPalindromeRec
    
    private int findSize()
    {
        int n = 0;
        Node node = head;
        while(node != null)
        {
            node = node.next;
            n++;
        }
        return n;
    }
    
    //intersect based on reference, do not check data
    public int intersectNode(LinkedList secondList)
    {
        int n1 = size;
        int n2 = secondList.findSize();
        int k = n1 - n2;
        boolean firstLonger = true;
        if (n2 > n1)
        {
            k = n2 - n1;
            firstLonger = false;
        }
        Node firstHead = head;
        Node secondHead = secondList.head;
        if (firstLonger) for(int i=1; i<=k; i++) firstHead = firstHead.next;
        else for(int i=1; i<=k; i++) secondHead = secondHead.next;
        while(firstHead != null)
        {
            if(firstHead.next == secondHead.next)
                return firstHead.next.data;
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        } // while
       return -1;
        
    } // intersectNode
    
    //return the first node of a cycle in list
    public int findHeadOfLoop()
    {
        Node slow = head;
        Node fast = head;
        while (true)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast.data == slow.data) break;
        } // while
        fast = head;
        while(fast != slow)
        {
            fast = fast.next;
            slow = slow.next;
        } // while
        return slow.data;
    } // findHeadOfLoop
    
} // class LinkedList