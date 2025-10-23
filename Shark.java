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
    public void attack() { //Code for the sharks to attack.
        this.kills += 100;
        System.out.println(name + " has killed prey and now has " + kills + " kills.");
    }
    public void promotion() { //Code for the sharks to get a promotion.
        System.out.println(name + " has been promoted for kills");
    }
    public void changeName(String newName) {
        this.name = newName;
        System.out.println("New name: " + this.name);
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

        System.out.println("\nAfter hunting:"); //The sharks go hunting.
        myShark.attack();
        myShark2.attack();
        otherShark.attack();

        System.out.println("\nThe sharks now:"); //The sharks new attributes.
        System.out.println("Shark one is " + myShark.name + ", age " + myShark.age + ", kills " + myShark.kills);
        System.out.println("Shark two is " + myShark2.name + ", age " + myShark2.age + ", kills " + myShark2.kills);
        System.out.println("Shark three is " + otherShark.name + ", age " + otherShark.age + ", kills " + otherShark.kills);

        System.out.println("\nPromotions:"); //Chomp Chomp III gets a promotion.
        myShark.promotion();

        System.out.println("\nChomp Chomp III gets a new title"); //New name.
        myShark.changeName("Chomp Chomp the Great");

        System.out.println("\nThe sharks now:"); //The final sharks.
        System.out.println("Shark one is " + myShark.name + ", age " + myShark.age + ", kills " + myShark.kills);
        System.out.println("Shark two is " + myShark2.name + ", age " + myShark2.age + ", kills " + myShark2.kills);
        System.out.println("Shark three is " + otherShark.name + ", age "  + otherShark.age + ", kills " + otherShark.kills);
    }
}