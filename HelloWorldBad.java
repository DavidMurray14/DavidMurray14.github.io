//This code was created by Kim Gross for his java class.
//This file is fixed by Emmitt Murray as part of the class.
class HelloWorldBad {
    public static void main(String[] args) {
        
        for (int i=0;i<25;i++){
            System.out.println("the value of i is " + i);
            if (i==1){ //Added another = sign to make it a comparison
                System.out.println("i is equal to 1");
            }
        }    
        }
    }
