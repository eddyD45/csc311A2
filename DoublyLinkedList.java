/*
 *  Java Program to Implement Doubly Linked List
 */
 
import java.io.IOException;
import java.util.Scanner;
 
/*  Class Node  */
class Node
{
    protected int data;
    protected Node head;		//previous node reference
    protected Node tail;		//next node reference
 
    /*  Constructor  */
    public Node()
    {
        head = null;
        tail = null;
        data = 0;
    }    
    /*  Constructor  */
    public Node(int d,Node n, Node m)
    {
        data = d;
        head = n;
        tail = m;
    }    
    /*  Function to set link to previous node and next node */
    public void setHead(Node n)
    {
        head = n;
    }
    /*  Function to set link to previous node and next node */
    public void setTail(Node n)
    {
        tail = n;
    }    
    /*  Function to set data to current Node  */
    public void setData(int d)
    {
        data = d;
    }    
    /*  Function to get link to previous node  */
    public Node getHead()
    {
        return head;
    }
    /*  Function to get link to next node  */
    public Node getTail()
    {
        return tail;
    }  
    /*  Function to get data from current Node  */
    public int getData()
    {
        return data;
    }
}
 
/* Class linkedList */
class linkedList
{
    protected Node start;
    protected Node end ;
    public int size ;
 
    /*  Constructor  */
    public linkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {
        return start == null;
    }
    /*  Function to get size of list  */
    public int getSize()
    {
        return size;
    }    
    /*  Function to insert an element at begining  */
    public void insertAtStart(int val)
    {
        Node nptr = new Node(val, null, null);    
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            nptr.setTail(start);
            start.setHead(nptr);
            start = nptr;
        }
    }
    /*  Function to insert an element at end  */
    public void insertAtEnd(int val)
    {
        Node nptr = new Node(val,null,null);    
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            //end.setLink(nptr);
        	end.setTail(nptr);
        	nptr.setHead(end);
            end = nptr;
        }
    }
    /*  Function to insert an element at position  */
    public void insertAtPos(int val , int pos)
    {
        Node nptr = new Node(val, null,null);                
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getTail() ;
                ptr.setTail(nptr);
                nptr.setHead(ptr);
                nptr.setTail(tmp);
                tmp.setHead(nptr);
                break;
            }
            ptr = ptr.getTail();
        }
        size++ ;
    }
    /*  Function to delete an element at position  */
    public void deleteAtPos(int pos)
    {        
        if (pos == 1) 
        {
            start = start.getTail();
            start.setHead(null);
            size--; 
            return ;
        }
        if (pos == size) 
        {
            Node s = start;
            Node t = start;
            while (s != end)
            {
                t = s;
                s = s.getTail();
            }
            end = t;
            end.setTail(null);
            size --;
            return;
        }
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getTail();
                tmp = tmp.getTail();
                ptr.setTail(tmp);
                tmp.setHead(ptr);
                break;
            }
            ptr = ptr.getTail();
        }
        size-- ;
    }    
    /*  Function to display elements  */
    public void display()
    {
        System.out.print("\nDoubly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }    
        if (start.getTail() == null) 
        {
            System.out.println(start.getData() );
            return;
        }
        Node ptr = start;
        System.out.print(start.getData()+ "->");
        ptr = start.getTail();
        while (ptr.getTail() != null)
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getTail();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}
 
/*  Class SinglyLinkedList  */
public class DoublyLinkedList
{    
    public static void main(String[] args) throws IOException
    {             

        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        linkedList list = new linkedList(); 
        
        //populating linked list with values from "numbers.txt" file using method from "filereader.java"
    	int [] numberArray = filereader.intfileToArray("numbers.txt");
        for(int i = 0; i < numberArray.length; i++ ) {
        	list.insertAtEnd(numberArray[i]);
        }
        
        System.out.println("Doubly Linked List Test\n");          
        char ch;
        /*  Perform list operations  */
        do
        {
            System.out.println("\nDoubly Linked List Operations\n");
            System.out.println("1. insert at begining");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. check empty");
            System.out.println("6. get size");            
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                list.insertAtStart( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to insert");
                list.insertAtEnd( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to insert");
                int num = scan.nextInt() ;
                System.out.println("Enter position");
                int pos = scan.nextInt() ;
                if (pos <= 1 || pos > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.insertAtPos(num, pos);
                break;                                          
            case 4 : 
                System.out.println("Enter position");
                int p = scan.nextInt() ;
                if (p < 1 || p > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.deleteAtPos(p);
                break;
            case 5 : 
                System.out.println("Empty status = "+ list.isEmpty());
                break;                   
            case 6 : 
                System.out.println("Size = "+ list.getSize() +" \n");
                break;                         
             default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /*  Display List  */ 
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
}