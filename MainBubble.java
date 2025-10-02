// I am Emmitt. This program is supposed to bubble sort an array.
public class MainBubble {
//Bubble sort code.
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 4, 2}; //Numbers to be sorted.
        //Main program.
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swapTwoNumbers(array, i, i + 1); //Using the swap method.
                    isSorted = false;
                }
            }
        }
        for (int num : array) {
            System.out.print(num + " "); //Printing the final result after sorting. 
        }
    }
//Code for swapping two numbers.
    private static void swapTwoNumbers(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }
}
