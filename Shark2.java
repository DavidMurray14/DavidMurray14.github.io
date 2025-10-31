// This is the code that runs the sharks created in Shark.java.
public class Shark2 {
    public static void main(String[] args) { //The sharks are created.
    Shark myShark = new Shark.Greatwhite("Chomp Chomp III", 15, 101000);
    Shark myShark2 = new Shark.Greatwhite("Chomp Chomp IV", 5, 101);
    Shark otherShark = new Shark.Greatwhite("Chomp Chomp V", 1, 11);
    Shark.TigerShark Challenger = new Shark.TigerShark("The Challenger", 15, 100000);
        
    System.out.println("The sharks right now:"); //The sharks current attributes.
    System.out.println("Shark one is " + myShark.name + ", age " + myShark.age + ", kills " + myShark.kills + ", species " + myShark.species + ", anger " + myShark.anger + ", strength " + myShark.strength);
    System.out.println("Shark two is " + myShark2.name + ", age " + myShark2.age + ", kills " + myShark2.kills + ", species " + myShark2.species + ", anger " + myShark2.anger + ", strength " + myShark2.strength);
    System.out.println("Shark three is " + otherShark.name + ", age " + otherShark.age + ", kills " + otherShark.kills + ", species " + otherShark.species + ", anger " + otherShark.anger + ", strength " + otherShark.strength);
    System.out.println("Shark four is a newcomer: " + Challenger.name + ", age " + Challenger.age + ", kills " + Challenger.kills + ", species " + Challenger.species + ", anger " + Challenger.anger + ", strength " + Challenger.strength);
        
        System.out.println("\nA year later:"); //The sharks grow older.
        myShark.growOlder();
        myShark2.growOlder();
        otherShark.growOlder();
        Challenger.growOlder();

        System.out.println("\nAfter hunting:"); //The sharks go hunting.
        myShark.attack();
        myShark2.attack();
        otherShark.attack();
        Challenger.attack();

        Challenger.madder(); //The challenger gets madder.
        Challenger.strength(); //The challenger gets stronger.
        System.out.println("The Challenger is getting angrier and stronger.");

    System.out.println("\nThe sharks now:"); //The sharks new attributes.
    System.out.println("Shark one is " + myShark.name + ", age " + myShark.age + ", kills " + myShark.kills + ", species " + myShark.species + ", anger " + myShark.anger + ", strength " + myShark.strength);
    System.out.println("Shark two is " + myShark2.name + ", age " + myShark2.age + ", kills " + myShark2.kills + ", species " + myShark2.species + ", anger " + myShark2.anger + ", strength " + myShark2.strength);
    System.out.println("Shark three is " + otherShark.name + ", age " + otherShark.age + ", kills " + otherShark.kills + ", species " + otherShark.species + ", anger " + otherShark.anger + ", strength " + otherShark.strength);
    System.out.println("Shark four is " + Challenger.name + ", age " + Challenger.age + ", kills " + Challenger.kills + ", species " + Challenger.species + ", anger " + Challenger.anger + ", strength " + Challenger.strength);    

        System.out.println("\nChomp Chomp III gets a new title"); //New name.
        myShark.changeName("Chomp Chomp the Great");
        System.out.println("\nThe Challenger gets a new title");
        Challenger.changeName("The Threat");

    System.out.println("\nThe sharks now:"); //The final sharks.
    System.out.println("Shark one is " + myShark.name + ", age " + myShark.age + ", kills " + myShark.kills + ", species " + myShark.species + ", anger " + myShark.anger + ", strength " + myShark.strength);
    System.out.println("Shark two is " + myShark2.name + ", age " + myShark2.age + ", kills " + myShark2.kills + ", species " + myShark2.species + ", anger " + myShark2.anger + ", strength " + myShark2.strength);
    System.out.println("Shark three is " + otherShark.name + ", age "  + otherShark.age + ", kills " + otherShark.kills + ", species " + otherShark.species + ", anger " + otherShark.anger + ", strength " + otherShark.strength);
    System.out.println("Shark four is " + Challenger.name + ", age " + Challenger.age + ", kills " + Challenger.kills + ", species " + Challenger.species + ", anger " + Challenger.anger + ", strength " + Challenger.strength);
    }
}