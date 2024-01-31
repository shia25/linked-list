import java.util.Scanner;

class LinkedList { 

    Node head;  
      
    static class Node { 
        int data; 
        Node next; 
        //constructor 0f node
        Node(int d){
            data = d; 
            next=null;
        } 
    } 

   //Insert node at the beginning of the list 
   public static LinkedList insert_start(LinkedList list, int data)
    { 
        // We create the new node 
        Node newNode = new Node(data); 
  
        //Now we link the node to the list

        // newNode is getting memory of list.head to store it
        newNode.next = list.head;

        // newNode becomes head of list
        list.head = newNode;

       // Return the modified list 
        return list; 
    } 
  
    //Display the content of the linked list 
    public static void printList(LinkedList list) 
    { 
        Node tmp = list.head; 
        if(tmp!=null)
         {
           System.out.println("The content of the list is:");
           // Traverse the list 
           while (tmp != null) { 
            // Print the data at current node 
            System.out.print(tmp.data);
   
            // Move to next node 
            tmp = tmp.next; 
            if(tmp!= null)
                   System.out.print("->");
        } 
        System.out.println(" ");
        }
        else
           System.out.println("The list is empty");
    } 
   
    //Delete the first element with data part equal to x
    public static LinkedList delete(LinkedList list, int x)
   {
     Node tmp=list.head;
     Node prev;

     if(tmp==null)
         {System.out.println("There is nothing to delete");
         return list; }
      else
      {

         //Case 1: x is found in the first node

          //if head of list is x
         if(tmp.data==x)
         {
             // we are copying/transferring the memory of first element or head memory
             // and storing  into next the element or tmp

             //the action of coping/ transferring the memory of the first element to next element removes it from the list
             //the element with no memory is automatically removed by the programming language except some like C

             // we are transferring memory of head to next element based on code reading
          list.head=tmp.next; //head points to the second element
          return list;
         }

         else   //Case 2: X is not in the first position, we must keep searching
         {
         prev=tmp;
         tmp=tmp.next;
         while(tmp!=null)
          {
              if(tmp.data==x)
              {
                 prev.next=tmp.next;
                 return list;
               }
             //This line assigns the reference stored in tmp to the variable prev
             //prev typically holds a reference to the node that precedes tmp
             prev=tmp; // remember this is our current memory holder
             // the variable tmp to point to the next node in the linked list
             // By updating tmp to tmp.next, you're effectively moving to the next node in the linked list
             tmp=tmp.next;
           }   
          }
         System.out.println("Element not found");
        return list;
    }

}

//Implement the function lenghtList() that returns the number of elements of
//the list. Modify the main menu to include this function in the options


    public static int lenghtList(LinkedList list){
        Node tmp = list.head;
        // can't call linkedList length
        // maiking a counter for list length called listLength
        int listLength = 0;

        if (tmp == null) {
            System.out.println("List is empty");
            return 0;
        }
        // this while loop runs while list is not null
        while (tmp != null){
            //increasing counter for every time
            listLength++;
            // detects a new node or next tmp
            tmp = tmp.next;
        }
        //returning counter
        return listLength;

        }

    // Implement the function printListK(K) that prints the first K elements of the
    //list. The number K is entered by the user. Modify the main menu to include this function
    //in the options. If the list has a number of items N lower than K, the message “The list
    //has only N elements” must be displayed. If the user enters a negative number, an error
    //message must be printed.
    public static void printListK(LinkedList list, int k){

        int n = lenghtList(list);
        if(k<0){
            System.out.println("Please insert a positive integer");
        }
        else if(n < k){
            System.out.println("The list has only "+ n +" elements ");
        }
        else {
            // defining tmp to declare list head
            Node tmp = list.head;
            // this for loop traverses through list until k
            for (int i = 0; i < k; i++) {
                // for each iteration printing list data (tmp.data)
                System.out.print(tmp.data + " ");
                // moving to next tmp
                tmp = tmp.next;
            }
            System.out.println();
        }
    }

    //Implement the function countList(x) that returns the number of times x
    //appears in the list. The number x is entered by the user. Modify the main menu to
    //include this function in the options.

    public static int countList(LinkedList list, int x){
        Node tmp = list.head;
        int counterX = 0;

        while(tmp != null){
            if (tmp.data == x){
                counterX++;
            }
            // moving to next tmp
            tmp = tmp.next;
        }
        return counterX;
    }


    public static void main(String[] args)
    {
        //create a new list
        LinkedList list = new LinkedList();

        //Create variable to read from keyboard
        Scanner scan = new Scanner(System.in);
        int option, x;


        do
        {
            System.out.println("Select your option:");
            System.out.println("0: Quit the programme");
            System.out.println("1: Insert an element to the beginning of the list");
            System.out.println("2: Delete an element to the list");
            System.out.println("3: Print the content of the list");
            System.out.println("4: Print the number of element in the list");
            System.out.println("5: Print the first K elements of the list");
            System.out.println("6: Print number of times x appears in the list");


            option=scan.nextInt();
            if(option==1)
            {
                System.out.println("What number do you want to insert?");
                x=scan.nextInt();
                list=insert_start(list, x);
                printList(list);
            }

            if(option==2)
            {
                System.out.println("What number do you want to delete?");
                x=scan.nextInt();
                list=delete(list, x);
                printList(list);
            }

            if(option==3)
                printList(list);


            if(option==4){
                //creating a variable length to store out of method lengthList
                int length = lenghtList(list);
                System.out.println("Number of elements in the list: " + length);

            }

            if(option==5){
                System.out.println("Enter the number of elements you want to print:");
                int k = scan.nextInt();
                printListK(list, k);
            }
            if(option==6){
                System.out.println("What number do you want to Check?");
                x=scan.nextInt();
                int count = countList(list,x);
                System.out.println("The number " + x + " appears " + count + " times in the list");
            }

            if(option==0)
                System.out.println("Good bye!");



        } while(option!=0);

    }

}
