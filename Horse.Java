//Simple horse class created by Kim Gross
//for CTE Software Development class 2022

public class Horse {
    String name;// current name of the horse
    int birthYear;//year the horse was born
    String[] names; //array of old names of the horse
    int numberofNames=0; //how many old names are there.
    public Horse(String horseName, int year){ //horse constructor needs its name and birth year.
        name=horseName; //assigns the name of the horse to the horseName which was sent in the construtor.
        birthYear=year; //assigns the year to the birthYear that was sent in the constructor;
    };
    
    public int age (){
        // calculate the horse's age based on the current year and the birth year
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        return currentYear - birthYear;
    }; 
    public void changeName (String newName){//change the name but save the old name
        names[numberofNames]=name;
        numberofNames++;
        name=newName;
    };
    public String toString (){
        return name;
    };    
}
//Code by Emmitt David Murray.
public class Main {
    public static void main(String[] args) {
        Horse myHorse = new Horse("Emmitt", 2010); //Horse one
         System.out.println("Horse 1 : " + myHorse.name + "Birth year " + myHorse.age());

        Horse myHorse = new Horse("David", 1776); //Horse two
            System.out.println("Horse 2 : " + myHorse.name + "Birth year " + myHorse.age());

        Horse myHorse = new Horse("Murray", 1498); //And horse three
            System.out.println("Horse 3 : " + myHorse.name + "Birth year " + myHorse.age());
    }
}