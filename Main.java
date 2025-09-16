//I am Emmitt. This code is made to count to 100 and say if the numbers are even or odd.
public class Main {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " even");
            } else {
                System.out.println(i + " odd");
            }
        }
        System.out.println(" = 5050");
    }
}
