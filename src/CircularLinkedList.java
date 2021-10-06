import java.util.*;
class CircularLinkedList{
    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
        }
    }
    Node InsertionEmpty(Node last,int d){
        if(last != null)
            return last;
        Node newNode = new Node(d);
        last = newNode;
        last.next = last;
        return last;
    }
    Node InsertionAtBeginning(Node last,int d){
        if(last == null){
            return InsertionEmpty(last,d);
        }
        Node newNode = new Node(d);
        newNode.next = last.next;
        last.next = newNode;
        return last;
    }
    Node InsertionAtEnd(Node last,int d){
        if(last == null)
            return InsertionEmpty(last,d);
        Node newNode = new Node(d);
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
        return last;
    }
    Node InsertionAfter(Node last,int d,int a){
        if(last == null)
            return null;
        Node p = last.next;
        Node newNode = new Node(d);
        do{
            if(p.data == a){
                newNode.next = p.next;
                p.next = newNode;
                if(p == last)
                    last = newNode;
                return last;
            }
            p = p.next;
        }while(p != last.next);
        System.out.println("No such value found");
        return last;
    }
    void DeletionAtBeginning(Node last){
        if(last == null){
            System.out.println("List is empty");
            return ;
        }
        Node temp = last.next;
        last.next = temp.next;
    }
    Node DeletionAtEnd(Node last){
        if(last == null){
            System.out.println("List is empty");
            return null;
        }
        Node temp = last.next;
        while(temp.next != last){
            temp = temp.next;
        }
        temp.next = last.next;
        last = temp;
        return last;
    }
    Node DeletionAtPosition(Node last,int p){
        if(last == null){
            System.out.println("List is empty");
            return null;
        }
        Node temp = last.next;
        if(p==1) {
            last.next = temp.next;
            return last;
        }
        for(int i=1;i<p-1;i++){
            temp = temp.next;
        }
        Node temp1 = temp.next;
        temp.next = temp1.next;
        return last;
    }
    void Display(Node last){
        Node temp = last.next;
        if(last == null)
            System.out.println("List is empty");
        do{
            System.out.print(temp.data + " ");
            temp = temp.next;
        }while(temp != last.next);
        System.out.println();
    }
    public static void main(String args[]){
        CircularLinkedList list = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);
        int n,i,p;
        char c;
        Node last = null;
        System.out.println("Enter 1)To InsertAtBeginning 2)To InsertAtEnd 3)To InsertAfter 4)To DeleteAtBeginning 5)To DeleteAtEnd 6)To DeleteAtPosition 7)To Display 8)To Exit ");
        while(true){
            System.out.print("Enter your choice : ");
            i = sc.nextInt();
            switch(i){
                case 1:
                    System.out.print("Want to Insert a number (Y/N) : ");
                    c = sc.next().charAt(0);
                    if(c == 'n' || c == 'N')
                        break;
                    System.out.print("Enter the number to be inserted : ");
                    n = sc.nextInt();
                    last = list.InsertionAtBeginning(last,n);
                    break;
                case 2:
                    System.out.print("Want to Insert a number (Y/N) : ");
                    c = sc.next().charAt(0);
                    if(c == 'n' || c == 'N')
                        break;
                    System.out.print("Enter the number to be inserted : ");
                    n = sc.nextInt();
                    last = list.InsertionAtEnd(last,n);
                    break;
                case 3:
                    System.out.print("Want to Insert a number (Y/N) : ");
                    c = sc.next().charAt(0);
                    if(c == 'n' || c == 'N')
                        break;
                    System.out.print("Enter the number to be inserted after which value : ");
                    n = sc.nextInt();
                    p = sc.nextInt();
                    last = list.InsertionAfter(last,n,p);
                    break;
                case 4:
                    System.out.print("Want to Delete the number at starting (Y/N) : ");
                    c = sc.next().charAt(0);
                    if(c == 'n' || c == 'N')
                        break;
                    list.DeletionAtBeginning(last);
                    break;
                case 5:
                    System.out.print("Want to Delete the number at End (Y/N) : ");
                    c = sc.next().charAt(0);
                    if(c == 'n' || c == 'N')
                        break;
                    last = list.DeletionAtEnd(last);
                    break;
                case 6:
                    System.out.print("Want to Delete the number at Position (Y/N) : ");
                    c = sc.next().charAt(0);
                    if(c == 'n' || c == 'N')
                        break;
                    System.out.print("Enter the position to be deleted : ");
                    p = sc.nextInt();
                    last = list.DeletionAtPosition(last,p);
                    break;
                case 7:
                    list.Display(last);
                    break;
                case 8:
                    return ;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}