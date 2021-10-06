import java.util.*;
class DoubleLinkedList {
    Node start;
    class Node{
        int data;
        Node next,prev;
        Node(int d){
            data = d;
        }
    }
    void InsertAtEnd(int d){
        Node newNode = new Node(d);
        newNode.next = null;
        newNode.prev = null;
        if(start == null)
            start = newNode;
        else{
            Node temp = start;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }
    void InsertAfter(int n,int a){
        Node newNode = new Node(n);
        Node temp = start;
        Node temp1;
        while(temp != null){
            if(temp.next == null && temp.data == a){
                temp.next = newNode;
                newNode.prev = temp;
                newNode.next = null;
                return ;
            }
            else if(temp.data == a){
                temp1 = temp.next;
                temp.next = newNode;
                newNode.prev = temp;
                newNode.next = temp1;
                temp1.prev = newNode;
                return;
            }
            temp = temp.next;
        }
        System.out.println("No such result found");
    }
    void InsertPosition(int n,int p){
        Node newNode = new Node(n);
        newNode.next = null;
        if(p == 1){
            newNode.next = start;
            start.prev = newNode;
            start = newNode;
        }
        else{
            Node temp = start;
            Node temp1;
            for(int i=2;i<p;i++){
                temp = temp.next;
            }
            temp1 = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
            newNode.next = temp1;
            temp1.prev = newNode;
        }
    }
    void DeletionPosition(int d){
        Node temp = start;
        Node temp1;
        if(d == 1)
            start = temp.next;
        else{
            for(int i=2;i<d;i++){
                temp = temp.next;
            }
            if(temp.next == null){
                temp.prev.next = null;
                temp = null;
            }
            else{
                temp1 = temp.next;
                temp.next = temp1.next;
                temp1.next.prev = temp;
            }
        }
    }
    void Display(){
        Node temp = start;
        if(start == null)
            System.out.println("List is empty");
        else{
            while(temp.next != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println(temp.data);
        }
    }
    void ReverseDisplay(){
        Node temp = start;
        while(temp.next != null){
            temp = temp.next;
        }
        while(temp != start){
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println(temp.data);
    }
    public static void main(String args[]){
        DoubleLinkedList list = new DoubleLinkedList();
        int i,n,a;
        char c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1)To Insert at end  2)To Insert at position  3)To insert after  4)To Delete  5)To Display  6)To ReverseDisplay  7)To Exit ");
        while(true){
            System.out.print("Enter your choice : ");
            i = sc.nextInt();
            switch(i){
                case 1:
                    System.out.print("Want to enter a number (Y/N) : ");
                    c = sc.next().charAt(0);
                    if(c == 'N' || c == 'n')
                        break;
                    System.out.print("Enter the number to be inserted at end : ");
                    n = sc.nextInt();
                    list.InsertAtEnd(n);
                    break;
                case 2:
                    System.out.print("Want to enter a number (Y/N) : ");
                    c = sc.next().charAt(0);
                    if(c == 'N' || c == 'n')
                        break;
                    System.out.print("Enter the number to be inserted at which position : ");
                    n = sc.nextInt();
                    a = sc.nextInt();
                    list.InsertPosition(n,a);
                    break;
                case 3:
                    System.out.print("Want to enter a number (Y/N) : ");
                    c = sc.next().charAt(0);
                    if(c == 'N' || c == 'n')
                        break;
                    System.out.print("Enter the number to be inserted after which value : ");
                    n = sc.nextInt();
                    a = sc.nextInt();
                    list.InsertAfter(n,a);
                    break;
                case 4:
                    System.out.print("Want to delete a number (Y/N) : ");
                    c = sc.next().charAt(0);
                    if(c == 'N' || c == 'n')
                        break;
                    System.out.print("Enter the position to be deleted : ");
                    n = sc.nextInt();
                    list.DeletionPosition(n);
                    break;
                case 5:
                    list.Display();
                    break;
                case 6:
                    list.ReverseDisplay();
                    break;
                case 7:
                    return ;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
