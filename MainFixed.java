
//I am Emmitt. This code is made to count to 100 and say if the numbers are even or odd. It then calculates the sum of all the numbers.
public class MainFixed {
    public static void main(String[] args) throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " even");
            } else {
                System.out.println(i + " odd");
            }
            sum += i;
        }
        System.out.println("Sum = " + sum);
    }
}