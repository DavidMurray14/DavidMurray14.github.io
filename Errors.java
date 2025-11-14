//This code is made by Emmitt Murray. It makes errors and and then uses exceptions to fix them.
public class Errors {
    // Array Out-of-bounds error.
    public void arrayOutOfBounds() {
        try {
            int[] array = {1, 2, 3};
            int x = array[4];
            System.out.println("Value: " + x);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Caught out-of-bounds: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Errors e = new Errors();
        e.Zero();
        e.arrayOutOfBounds();
    }
    //Division by zero error.
    public void Zero() {
        try {
            System.out.println(10/0);
        } catch (ArithmeticException ex) {
            System.out.println("Caught arithmetic error: " + ex.getMessage());
        }
    }
}

