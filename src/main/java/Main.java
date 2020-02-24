import redis.clients.jedis.Jedis;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        List<String> abc = jedis.lrange("abc", 1, 100);
        System.out.println(abc);
        jedis.close();

    }

    public static void quickSort(int[] arr, int low, int high) {

        if (low > high) {
            return;
        }

        int pivot, i, j, tmp;

        i = low;
        j = high;
        pivot = arr[low];

        while (i < j) {
            //先找右边比pivot小的数
            while (arr[j] >= pivot && i < j) {
                j --;
            }

            while (arr[i] <= pivot && i <j ) {
                i ++;
            }

            //交换位置
            if (i < j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        //i和j相遇 与pivot交换位置
        arr[low] = arr[i];
        arr[i] = pivot;

        quickSort(arr, low, i - 1);
        quickSort(arr,i + 1, high);
    }

    public static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int midVal = arr[mid];
            if (midVal > target) {
                right = mid - 1;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static String reverseString(String s) {
        byte[] bytes = s.getBytes();

        for (int i = 0, j = bytes.length - 1; i < j; i++, j--) {
            byte temp = bytes[i];
            bytes[i] = bytes[j];
            bytes[j] = temp;
        }

        return new String(bytes);
    }

    //冒泡排序的核心：从第一个元素开始 两两比较 值大的交换位置
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    System.out.println(String.format("交换%d:%d", j, j + 1));
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    System.out.println(Arrays.toString(arr));
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            System.out.println("------------------------");
        }
    }

}