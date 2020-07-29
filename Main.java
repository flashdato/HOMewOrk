package ge.george;

import com.sun.source.tree.BinaryTree;
import ge.george.binarytree.BinarySearchTree;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

    }
    public static int binarySearch(int[] arr, int x)
    {
        int head = 0,end= arr.length-1,i;
        while (head <= end) {
            i= head + (end - head) / 2;
            if (arr[i] == x)
                return i;
            if (arr[i] < x)
                head = i + 1;
            else
                end = i - 1;
        }
        return -1;
    }

}


