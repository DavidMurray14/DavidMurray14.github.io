public class Ship implements Comparable<Ship> { //This code is made by Emmitt Murray. It compares ships by speed.
    String name; // name of the ship
    int speed; // speed in knots

    public Ship(String name, int speed) { // Constructor for the ships
        this.name = name;
        this.speed = speed;
    }

    // The ships being created
    static Ship ship1 = new Ship("Iowa", 33);
    static Ship ship2 = new Ship("Yamato", 27);
    static Ship ship3 = new Ship("Bismarck", 30);
    static Ship ship4 = new Ship("Derflinger", 26);
    static Ship ship5 = new Ship("Kongo", 28);
    static Ship ship6 = new Ship("Fletcher", 38);
    static Ship ship7 = new Ship("Shimakaze", 41);
    static Ship ship8 = new Ship("Amagi", 30);
    static Ship ship9 = new Ship("Nelson", 23);
    static Ship ship10 = new Ship("Hood", 32);

    public int compareTo(Ship o) {
        return Integer.compare(this.speed, o.speed);
    }

    // Comparing the ships
    public static void compareShips() {
        Ship[] ships = {ship1, ship2, ship3, ship4, ship5, ship6, ship7, ship8, ship9, ship10};
        for (int i = 0; i < ships.length; i++) {
            for (int j = i + 1; j < ships.length; j++) {
                int result = ships[i].compareTo(ships[j]);
                if (result > 0) {
                    System.out.println(ships[i].name + " is faster than " + ships[j].name);
                } else if (result < 0) {
                    System.out.println(ships[i].name + " is slower than " + ships[j].name);
                } else {
                    System.out.println(ships[i].name + " has the same speed as " + ships[j].name);
                }
            }
        }
    }

    
    public static void main(String[] args) {
        compareShips();
    }

}
