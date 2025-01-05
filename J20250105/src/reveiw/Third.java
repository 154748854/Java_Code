package reveiw;

import java.util.Arrays;

public class Third {
    public static void main3(String[] args) {

    }
    public static void main2(String[] args) {
        //二分查找
        int[] arr = {0,1,2,3,4,5,6};
        System.out.println(binarySearch(arr,6));
    }
    public static int binarySearch(int[] arr, int toFind) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if(toFind < arr[mid])   right = mid -1;
            else if (toFind > arr[mid]) left = mid + 1;
            else return mid;
        }
        return -1;
    }
    public static void main1(String[] args) {
        //数组拷贝
        int[] arr = {1,2,3,4,5,6};

        int[] newArr = Arrays.copyOf(arr,arr.length);
        arr[0] = 4;
        System.out.println(Arrays.toString(newArr));
        int[] arr3 = Arrays.copyOfRange(arr,2,4);
        //注意区间是左闭右开
        System.out.println(Arrays.toString(arr3));

    }
}
