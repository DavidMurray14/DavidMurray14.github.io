//This code is made by Emmitt Murray. It is a linked list.
import java.util.Scanner;

public class linked {

    static class Student {
        String name;
        int age;
        int kills;

        public Student(String name, int age, int kills) {
            this.name = name;
            this.age = age;
            this.kills = kills;
        }
    }

    static class Node {
        Student data;
        Node next;

        public Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public linked() {
        this.head = null;
    }

    public void addNode(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    //Add to front
    public void addFront(Student student) {
        Node newNode = new Node(student);
        newNode.next = head;
        head = newNode;
    }

    //Add to back
    public void addBack(Student student) {
        addNode(student);
    }

    //Add to index
    public void addAtIndex(int index, Student student) {
        if (index <= 0 || head == null) {
            addFront(student);
            return;
        }
        Node newNode = new Node(student);
        Node current = head;
        int i = 0;
        while (current.next != null && i < index - 1) {
            current = current.next;
            i++;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    //Add to the middle
    public void addMiddle(Student student) {
        int mid = size() / 2;
        addAtIndex(mid, student);
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    //Print front to back
    public void printForward() {
        Node current = head;
        while (current != null) {
            Student s = current.data;
            System.out.println(s.name + ", age=" + s.age + ", kills=" + s.kills);
            current = current.next;
        }
    }

    //Print back to front
    public void printBackward() {
        printBackwardHelper(head);
    }

    private void printBackwardHelper(Node node) {
        if (node == null) return;
        printBackwardHelper(node.next);
        Student s = node.data;
        System.out.println(s.name + ", age=" + s.age + ", kills=" + s.kills);
    }
    //Remove front
    public boolean removeFront() {
        if (head == null) return false;
        head = head.next;
        return true;
    }

    //Remove back
    public boolean removeBack() {
        if (head == null) return false;
        if (head.next == null) {
            head = null;
            return true;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        return true;
    }

    //Remove at index
    public boolean removeAtIndex(int index) {
        if (head == null) return false;
        if (index <= 0) return removeFront();
        Node current = head;
        int i = 0;
        while (current.next != null && i < index - 1) {
            current = current.next;
            i++;
        }
        if (current.next == null) return false;
        current.next = current.next.next;
        return true;
    }



    public static void main(String[] args) {
        linked list = new linked();
        //Seed list
        list.addNode(new Student("David Murray", 20, 3));
        list.addNode(new Student("Emmitt Murray", 15, 0));
        list.addNode(new Student("John Seed", 31, 105));

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu: 1=Add Front 2=Add Back 3=Add Middle 4=Remove Front 5=Remove Back 6=Remove Middle 7=Done (print and exit)");
            System.out.print("Choice: ");
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid input");
                continue;
            }

            switch (choice) {
                case 1: //Add front
                    Student s1 = readStudent(sc);
                    list.addFront(s1);
                    break;
                case 2: //Add back
                    Student s2 = readStudent(sc);
                    list.addBack(s2);
                    break;
                case 3: //Add middle
                    Student s3 = readStudent(sc);
                    list.addMiddle(s3);
                    break;
                case 4: //Remove front
                    System.out.println(list.removeFront() ? "Removed front" : "List empty");
                    break;
                case 5: //Remove back
                    System.out.println(list.removeBack() ? "Removed back" : "List empty");
                    break;
                case 6: //Remove middle
                    int mid = list.size() / 2;
                    System.out.println(list.removeAtIndex(mid) ? "Removed middle" : "Nothing removed");
                    break;
                case 7:
                    System.out.println("\nFinal list (forward):");
                    list.printForward();
                    System.out.println("\nFinal list (backward):");
                    list.printBackward();
                    System.out.println("Exiting.");
                    sc.close();
                    return;
                default:
                    System.out.println("Unknown choice");
            }
        }
        
    }

    private static Student readStudent(Scanner sc) {
        System.out.print("Name: ");
        String name = sc.nextLine();
        int age = 0;
        int kills = 0;
        try {
            System.out.print("Age: ");
            age = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Invalid age, set to 0");
        }
        try {
            System.out.print("Kills: ");
            kills = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Invalid kills, set to 0");
        }
        return new Student(name, age, kills);
    }
}
