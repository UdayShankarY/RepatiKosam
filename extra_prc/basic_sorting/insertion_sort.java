import java.util.*;
class insertion_sort{ // O(N^2)
    public static void insertion_sort_asc(int arr[]) {
        
        for(int i = 1;i<arr.length-1;i++){
            int curr = arr[i];
            int prev = i-1;
            while(prev >= 0 && arr[prev] > curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr; 
        }
    }

    public static void insertion_sort_dsc(int arr[]) {
        for(int i = 1;i<arr.length;i++){
            int curr = arr[i];
            int prev = i-1;
            while(prev >= 0 && arr[prev] < curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr; 
        }
    }


    public static void printarr(int arr[]) {
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {8,1,7,3,6,4,5,2,9,10};
    
        System.out.println();
        insertion_sort_asc(arr);
        printarr(arr);

        System.out.println();
        insertion_sort_dsc(arr);
        printarr(arr);
        }
}