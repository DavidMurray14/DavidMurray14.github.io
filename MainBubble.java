// I am Emmitt. This program is supposed to bubble sort an array.
public class MainBubble {

    public static void main(String[] args) {
        int[] array = {5, 3, 8, 4, 2};
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
        }
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
