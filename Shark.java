//This code is made by Emmitt Murray. It is three sharks with atrributes and a behavior to make them grow older.
public class Shark {
    String name;
    int age;
    int kills;

    public Shark(String name, int age, int kills) { //Constructor for the sharks.
        this.name = name;
        this.age = age;
        this.kills = kills;
    }
    public void growOlder() { //Code to grow the sharks.
        this.age += 1;
        System.out.println(name + " is now " + age + " years old.");
    }
    public static void main(String[] args) { //The sharks are created.
        Shark myShark = new Shark("Chomp Chomp III", 15, 101000);
        Shark myShark2 = new Shark("Chomp Chomp IV", 5, 101);
        Shark otherShark = new Shark("Chomp Chomp V", 1, 11);
        
        System.out.println("The sharks right now:"); //The sharks current attributes.
        System.out.println("Shark one is " + myShark.name + ", age " + myShark.age + ", kills " + myShark.kills);
        System.out.println("Shark two is " + myShark2.name + ", age " + myShark2.age + ", kills " + myShark2.kills);
        System.out.println("Shark three is " + otherShark.name + ", age " + otherShark.age + ", kills " + otherShark.kills);
        
        System.out.println("\nA year later:"); //The sharks grow older.
        myShark.growOlder();
        myShark2.growOlder();
        otherShark.growOlder();
    }
}