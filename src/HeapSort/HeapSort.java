package HeapSort;

public class HeapSort {

    public static void main(String[] args){
        int[] arr = new int[]{2,7,4,9,10,5,8};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSrot(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public void heapify(int[] arr, int n, int index){

        int left_child = 2*index + 1;
        int right_child = 2*index + 2;
        int parent = index;
        int tmp;

        while ((left_child < n) && (right_child < n)){

            if (arr[left_child] > arr[parent]) {
                tmp = arr[parent];
                arr[parent] = arr[left_child];
                arr[left_child] = tmp;
                parent = left_child;
            }else if (arr[right_child] > arr[parent]) {
                tmp = arr[parent];
                arr[parent] = arr[right_child];
                arr[right_child] = tmp;
                parent  = right_child;
            }else{
                break;
            }

            left_child = 2*parent + 1;
            right_child = 2*parent + 2;
        }

        if(left_child < n){
            if (arr[left_child] > arr[parent]) {
                tmp = arr[parent];
                arr[parent] = arr[left_child];
                arr[left_child] = tmp;
            }
        }
    }

//    void heapify(int arr[], int n, int i)
//    {
//        int largest = i; // Initialize largest as root
//        int l = 2*i + 1; // left = 2*i + 1
//        int r = 2*i + 2; // right = 2*i + 2
//
//        // If left child is larger than root
//        if (l < n && arr[l] > arr[largest])
//            largest = l;
//
//        // If right child is larger than largest so far
//        if (r < n && arr[r] > arr[largest])
//            largest = r;
//
//        // If largest is not root
//        if (largest != i)
//        {
//            int swap = arr[i];
//            arr[i] = arr[largest];
//            arr[largest] = swap;
//
//            // Recursively heapify the affected sub-tree
//            heapify(arr, n, largest);
//        }
//    }

    public void heapSrot(int[] arr){
        int n = arr.length;

        for(int i = (n - 1)/2; i > 0; i--){
            heapify(arr, n, i);
        }

        int tmp;
        for(int i = n - 1; i >= 0; i--){
            tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr, i, 0);
        }
    }
}
