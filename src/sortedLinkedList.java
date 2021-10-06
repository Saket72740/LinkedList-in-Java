import java.util.*;
public class sortedLinkedList {
    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
        }
    }
    Node Insertion(Node start,int d){
        Node newNode = new Node(d);
        if(start == null || start.data > d){
            newNode.next = start;
            start = newNode;
            return start;
        }
        else{
            Node temp = start;
            while(temp.next != null && temp.next.data < d){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return start;
    }
    void SearchList(Node start,int d){
        Node temp = start;
        int i=1;
        while(temp != null){
            if(temp.data == d) {
                System.out.println(d + " found at " + i + " position");
                return;
            }
            temp = temp.next;
            i++;
        }
        System.out.println(d + " not found in list");
    }
    void Display(Node start){
        Node temp = start;
        while(temp.next != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
    public static void main(String args[]){
        sortedLinkedList list = new sortedLinkedList();
        Node start = null;
        int n,i;
        char c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1)To Insert  2)To search  3)To Display  4)To exit");
        while(true){
            System.out.print("Enter your choice : ");
            i = sc.nextInt();
            switch(i){
                case 1:
                    System.out.print("Want to insert a number (Y/N) : ");
                    c = sc.next().charAt(0);
                    System.out.print("Enter the number to be inserted : ");
                    n = sc.nextInt();
                    start = list.Insertion(start,n);
                    break;
                case 2:
                    System.out.println("Want to search a number (Y/N) : ");
                    c = sc.next().charAt(0);
                    if(c == 'N' || c == 'n')
                        break;
                    System.out.print("Enter the number to be search : ");
                    n = sc.nextInt();
                    list.SearchList(start,n);
                    break;
                case 3:
                    list.Display(start);
                    break;
                case 4:
                    return ;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}
