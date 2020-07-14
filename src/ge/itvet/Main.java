package ge.itvet;

import java.util.Arrays;

class Main {
    public static void main(String[] arg) {
        int[] arr = {-5, -10, 0, -3, 8, 5, -1, 10};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void countSort(int[] arr)
    {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];
        for (int value : arr) {
            count[value - min]++;
        }

        for (int i = 1; i < count.length; i++)
        {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--)
        {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
