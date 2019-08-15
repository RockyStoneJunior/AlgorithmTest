package HeapSort;

public class MyHeapSort {

    public static void main(String[] args){

        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};

        MyHeapSort myHeapSort = new MyHeapSort();
        myHeapSort.heapSort(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public void heapify(int[] arr, int n, int index){

        int left_child = index*2  + 1;
        int right_child = index*2 + 2;
        int largest = index;

        if(left_child < n && arr[left_child] > arr[largest]){
            largest = left_child;
        }

        if(right_child < n && arr[right_child] > arr[largest]){
            largest = right_child;
        }

        if(largest != index){
            int tmp = arr[largest];
            arr[largest] = arr[index];
            arr[index] = tmp;

            heapify(arr, n, largest);
        }
    }

    public void heapSort(int[] arr){

        int n = arr.length;

        for(int i = (n - 1)/2; i >= 0; i--){
            heapify(arr, n, i);
        }

        for(int i = n - 1; i > 0; i--){
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr, i, 0);
        }
    }
}
