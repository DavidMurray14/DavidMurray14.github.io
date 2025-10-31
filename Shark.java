//This code is made by Emmitt Murray. It is the code for the sharks in Shark2.java.
public class Shark {
    String name;
    int age;
    int kills;
    String species;
    int anger;
    int strength;

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
    public void changeName(String newName) { //Code to change the sharks names.
        this.name = newName;
        System.out.println("New name: " + this.name);
    }
    public void aggression() { //code to make the sharks aggressive.
        this.anger = 100;
    }
    public void strength() { //code to make the sharks strong.
        this.strength = 100;
    }
    public void madder() { //code to make the sharks more mad.
        this.anger += 10;
    }
    public static class Greatwhite extends Shark { //Greatwhite shark subclass.
        public Greatwhite(String name, int age, int kills) {
            super(name, age, kills);
            this.species = "Great White";
            this.anger = 75;
            this.strength = 100;
        }
    }
    public static class TigerShark extends Shark { //Tigershark subclass.
        public TigerShark(String name, int age, int kills) {
            super(name, age, kills);
            this.species = "Tiger Shark";
            this.anger = 110;
            this.strength = 80;
        }
    }
}
