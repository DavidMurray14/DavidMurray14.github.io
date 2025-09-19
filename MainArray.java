//I am Emmitt. This code is supposed to make an array from numbers 1 to 100 and say if they are even or odd. It then has to calculate the sum of the numbers.
public class MainArray {
    public static void main(String[] args) throws Exception {
        int[] array = new int[100];
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1; 
            if (array[i] % 2 == 0) {
                System.out.println(array[i] + " even");
            } else {
                System.out.println(array[i] + " odd");
            }
            sum += array[i]; 
        }
        System.out.println("Sum: " + sum);
    }
}