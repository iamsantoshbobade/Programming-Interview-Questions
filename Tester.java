package code;

import java.util.Hashtable;

public class Tester
{
    private static LinkedList createLinkedList(int data[])
    {
        LinkedList list = new LinkedList(data[0]);
        for (int i=1;i<data.length;i++) list.add(data[i]);        
        return list;
    } // createLinkedList
    
    private static void linkedListTester()
    {
        int a[] = {10,15,30,25,70,60};
        LinkedList list = createLinkedList(a);
        list.show();
        boolean f = list.isPalindromeRec(list.head,1,list.head,list.head);
        System.out.println(f);
        list.findKthLast(8);
        Node n = list.find(70);
//        if (n != null)
//            list.deleteMiddleNode(n);
//        list.removeDuplicates();
        list.show();
        Node tail = list.find(a[a.length-1]);
        tail.next = n;
        System.out.println(list.findHeadOfLoop());
//        list.show();
        
//        int b[] = {20,90,40,50};
//        LinkedList list2 = createLinkedList(b);
//        list2.show();
//        Node tail2 = list2.find(50);
//        tail2.next = n;
//        list2.show();
//        System.out.println("Intersecting at: "+list.intersectNode(list2));
    } // linkedListTester
    
    private static void printMatrix(int a[][], int m, int n)
    {
         System.out.println("Array:");
         for(int i = 0; i<m ;i++) 
         {
             System.out.print("[");
             for(int j=0; j<n; j++)
                 System.out.print(a[i][j]+"\t");
             System.out.println("]");
         } // for
        
    } // printMatrix
    
    private static void arraysandstringtester()
    {
        ArraysAndStrings obj = new ArraysAndStrings();
//        System.out.println(obj.isOneEditAway("pale","ple"));
//        System.out.println(obj.compress("aabcccccaaaaaaaaaaaaaaaaaaaarsdghawdsnjkllllllllllll"));
        int m = 4, elem = 1;
        int a[][] = new int[m][m];
        for(int i = 0; i<m ;i++) for(int j=0; j<m; j++) a[i][j]=elem++;
        printMatrix(a,m,m);
        obj.rotateMatrixIP(a,m);
        printMatrix(a,m,m);
    } // arraysandstringtester
    
    public static void main(String[] args)
    {
//        linkedListTester();
//        arraysandstringtester();
          
        
	} // main

} // class Tester