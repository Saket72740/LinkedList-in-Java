import java.util.*;
class SingleLinkedList{
    Node START = null;
    class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
        }
    }
    void InsertionAtBeginning(int d){
        Node newNode = new Node(d);
        newNode.next = START;
        START = newNode;
    }
    void InsertionAfter(int data,int item){
        Node temp = START;
        Node temp1;
        Node newNode = new Node(data);
        while(temp.next != null){
            if(temp.data == item){
                temp1 = temp.next;
                temp.next = newNode;
                newNode.next = temp1;
                return ;
            }
            temp = temp.next;
        }
        System.out.println("No such element found");
    }
    void InsertionBefore(int a,int n){
        Node temp = START;
        Node temp1;
        Node newNode = new Node(a);
        while(temp.next != null){
            if(temp.next.data == n){
                temp1 = temp.next;
                temp.next = newNode;
                newNode.next = temp1;
                return ;
            }
            temp = temp.next;
        }
        System.out.println("No such element found");
    }
    void DeletionPosition(int p){
        int i;
        Node temp = START;
        if(p == 1){
            START = temp.next;
        }
        else{
            for(i=2;i<p && temp.next != null;i++){
                temp = temp.next;
            }
            if(temp.next == null)
                temp = null;
            temp.next = temp.next.next;
        }
    }
    void ReverseList(){
        Node prev,now,next;
        prev = null;
        now = START;
        while(now != null){
            next = now.next;
            now.next = prev;
            prev = now;
            now = next;
        }
        START = prev;
    }
    void Display(){
        Node temp = START;
        if(temp == null)
            System.out.println("List is empty");
        else {
            while (temp.next != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println(temp.data);
        }
    }
    public static void main(String args[]){
        SingleLinkedList list = new SingleLinkedList();
        int a,n;
        char c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1)To Insert at Beginning 2)To InsertAfter a value 3)To Insert Before a value 4)To Delete a value 5)To Display 6)To reverse LinkedList 7)To Exit :");
        while(true){
            System.out.print("Enter your choice : ");
            int i = sc.nextInt();
            switch(i){
                case 1:
                    System.out.print("Want to enter a number (Y/N) : ");
                    c = sc.next().charAt(0);
                    if(c == 'n' || c == 'N')
                        break;
                    System.out.print("Enter the number to insert at beginning : ");
                    n = sc.nextInt();
                    list.InsertionAtBeginning(n);
                    break;
                case 2:
                    System.out.print("Want to enter a number InsertionAfter (Y/N) : ");
                    c = sc.next().charAt(0);
                    if(c == 'n' || c == 'N')
                        break;
                    System.out.print("Enter the number to insert after which number : ");
                    n = sc.nextInt();
                    a = sc.nextInt();
                    list.InsertionAfter(n,a);
                    break;
                case 3:
                    System.out.print("Want to enter a number InsertionBefore (Y/N) : ");
                    c = sc.next().charAt(0);
                    if(c == 'n' || c == 'N')
                        break;
                    System.out.print("Enter the number to insert before which number : ");
                    n = sc.nextInt();
                    a = sc.nextInt();
                    list.InsertionBefore(n,a);
                    break;
                case 4:
                    System.out.print("Want to Delete a number (Y/N) : ");
                    c = sc.next().charAt(0);
                    if(c == 'n' || c == 'N')
                        break;
                    System.out.print("Enter the number to be deleted : ");
                    n = sc.nextInt();
                    list.DeletionPosition(n);
                    break;
                case 5:
                    list.Display();
                    break;
                case 6:
                    list.ReverseList();
                    break;
                case 7:
                    return ;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}