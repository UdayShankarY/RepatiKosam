import java.util.*;
class Counting_sort{
    public static void counting_sort_asc(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            largest = Math.max(largest,arr[i]);
        }
        int freq [] = new int [largest+1];

        for(int i = 0;i<arr.length;i++){
            freq[arr[i]]++;
        }
        int j =0;
        for(int i = 0;i<freq.length;i++){
            while(freq[i] > 0){
                arr[j] = i;
                j++;
                freq[i]--;
            }
        }
    }


    //descending
    public static void counting_sort_des(int arr[]) {
    int largestD = Integer.MIN_VALUE;

        for(int i = 0;i<arr.length;i++){
            largestD = Math.max(largestD,arr[i]);
        }
        int freq[] = new int[largestD+1]; 
        for(int i = 0;i<arr.length;i++){
            freq[arr[i]]++;
        }
        int k = 0;
        for(int i = freq.length-1;i>=0;i--){
            while(freq[i] > 0){
                arr[k] = i;
                freq[i]--; 
                k++;
            }
        }
    }

    public static void printarr(int arr[]) {
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {8,1,7,3,6,4,5,2,9,10};
        counting_sort_asc(arr);
        printarr(arr);

        System.out.println();

        counting_sort_des(arr);
        printarr(arr);
        }
}