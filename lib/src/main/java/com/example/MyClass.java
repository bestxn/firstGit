package com.example;

public class MyClass {
    public static void main(String[] args){
        //------------------------------
//        int j = 0;
//        for (int i = 0; i < 100; i++) {
//            j = ++j;
//        }
//        System.out.printf("hellow c:"+j);

       int[] a = new int[]{5,4,9,6,3,8};
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = 1; j < arr.length-i; j++) {
//                if(arr[j+1]<arr[j]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//        System.out.printf("hellow c:"+arr[3]);
        /*快速排序  通过内部循环第一次遍历数组找到最小的元素与数组的第一个元素交换位置，
          第二次遍历数组找到第二小的元素与数组的第二个元素交换位置，
        当内存循环找到最小的元素并交换位置后下次遍历时应该避开这个最小元素*/
        for(int i=0;i<a.length;i++){
            int temp=a[i];
            int flag=i;
            for(int j=i+1;j<a.length;j++){
                if(temp>a[j]){
                    temp=a[j];
                    flag=j;
                }
            }
            if(flag!=i){
                a[flag]=a[i];
                a[i]=temp;
            }
        }

        System.out.printf("hellow c:"+a[4]);


    }
}
