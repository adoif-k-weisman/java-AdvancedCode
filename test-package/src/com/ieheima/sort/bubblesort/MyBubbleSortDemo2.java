package com.ieheima.sort.bubblesort;

public class MyBubbleSortDemo2 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 4};
        //1 2 3 4 5
        bubbleSort(arr);

    }

    private static void bubbleSort(int[] arr) {
        //外层循环控制的是次数 比数组的长度少一次.
        for (int i = 0; i < arr.length -1; i++) {
            //内存循环就是实际循环比较的
            //-1 是为了让数组不要越界
            //-i 每一轮结束之后,我们就会少比一个数字.
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
