import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {

        int a = 1 + 1 + 2 * 3 * 4;
        int b = 10;

        int[] arr = {5, 3, 4, 2, 1};
        bubbleSort(arr);
        for (int i : arr) {
//            System.out.print(i + " ");
            System.out.print(i + " ");

        }
    }

    public static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = arr.length - 1; i > 0; --i) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
