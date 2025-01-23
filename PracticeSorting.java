package SortingAlgortihms;

import java.util.Arrays;

public class PracticeSorting {
    public static void main(String[] args) {
        int [] arr = {5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

     public static void sort(int [] arr){
        SelectionSort(arr);
     }

    public static void SelectionSort(int [] arr){
        for(int i = 0;i< arr.length-1;i++){
            int minimumIdx = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[minimumIdx]){
                    minimumIdx=j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minimumIdx];
            arr[minimumIdx]=temp;

        }
    }

    public static void BubbleSort(int [] arr){
        for(int i = 0;i< arr.length;i++){
            for(int j =0;j< arr.length-i-1;j++){
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j]=temp;
            }
        }
    }

    public static void InsertionSort(int [] arr){
        for(int i =1;i<arr.length;i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }


}
