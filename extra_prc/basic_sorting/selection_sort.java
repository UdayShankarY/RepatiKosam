import java.util.*;
class selection_sort{
    public static void selection_sort(int arr[]) {
        for(int i = 0;i<arr.length;i++){
            int min_idx = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j] < arr[min_idx]){
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void selection_sort_dsc(int arr[]) {
        for(int i = 0;i<arr.length;i++){
            int min_idx = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j] > arr[min_idx]){
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
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
        selection_sort(arr);
        printarr(arr);

        System.out.println();

        selection_sort_dsc(arr);
        printarr(arr);
        }
}