import  java.util.*;
class inbuilt_sort {
    public static void printarr(int arr[]) {
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

        public static void printarrObject(Integer arr[]) {
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {8,1,5,6,8,7}; 

        //normal sort
        Arrays.sort(arr);
        printarr(arr);
        System.out.println();
        System.out.println();

        // sort in range
        int arr1[] = {8,1,5,6,8,7};
        Arrays.sort(arr1,0,3);
        printarr(arr1);
        System.out.println(); 

        // sort reverse
        Integer arr2[] = {8,1,5,6,8,7};
        Arrays.sort(arr2,Collections.reverseOrder());
        System.out.println();
        printarrObject(arr2);

        // sort reverse in range
        System.out.println();
        Integer arr3[] = {8,1,5,6,8,7};
        Arrays.sort(arr2,0,3,Collections.reverseOrder());
        System.out.println();
        printarrObject(arr3);




    }
}