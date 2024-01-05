package print;

public class PrintArray {
    public static void printArray(int[] array) {
        if (array == null) return;
        System.out.print("[");
        int i;
        for (i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        if (array.length != 0) {
            System.out.print(array[i]);
        }
        System.out.print("]");
    }
}
