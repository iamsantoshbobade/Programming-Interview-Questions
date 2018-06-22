package code;

class Stack
{
    int data[];
    int top;
    int size;
    
    /**
     *    Create a stack with a default size of 10.
     */
    public Stack()
    {
        size = 10;
        data = new int[size];
        top = -1;
    } // Stack
    
    /**
     *    Create a stack with the given size 'n'.
     */
    public Stack(int n)
    {
        size = n;
        data = new int[size];
        top = -1;
    } // Stack
    
    /**
     *    Pushes an element on top of the stack.
     */
    public void push(int elem)
    {
        if(isFull())
        {
            System.out.println("Stack is full. Can not push element.");
            return;
        }
        data[++top] = elem;      
    } // push
    
    /**
     *    Pushes an element on top of the stack.
     */
    public int pop()
    {
        if(isEmpty())
        {
            System.out.println("Stack is empty. Can not pop element.");
            return -999999999;
        }
        return data[top--];      
    } // pop
    
    /**
     *    Checks if the stack is full.
     */
    private boolean isFull()
    {
        return top == size-1;
    } // isFull
    
    /**
     *    Checks if the stack is empty.
     */
    private boolean isEmpty()
    {
        return top == -1;
    } // isEmpty
} // class Stack