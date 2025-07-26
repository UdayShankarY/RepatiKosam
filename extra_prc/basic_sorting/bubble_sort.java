class bubble_sort{
    public static void bubble_sort_asc(int arr[]) {
        for(int i = 0;i<arr.length-1;i++){
            for(int j = 0;j<arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
            }
        }
    }

        public static void bubble_sort_dsc(int arr[]) {
        for(int i = 0;i<arr.length-1;i++){
            for(int j = 0;j<arr.length-1-i;j++){
                if(arr[j] < arr[j+1]){
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
            }
        }
    }

    public static void printarr(int arr[]) {
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {8,1,7,3,6,4,5,2,9,10};
        bubble_sort_asc(arr);
        printarr(arr);
        System.out.println();
        bubble_sort_dsc(arr);
        printarr(arr);
}
}