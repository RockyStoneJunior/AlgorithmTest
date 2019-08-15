package QuickSort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};

        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }


    public void quickSort(int[] arr, int start, int end) {

        if (start < end) {
            int pi = partition(arr, start, end);
            quickSort(arr, start, pi - 1);
            quickSort(arr, pi + 1, end);
        }
    }

    public int partition(int[] arr, int low, int high) {

        int pivot = arr[high];

        int i = low;
        int j = high;

        while (true) {
            while ((i < j) && (arr[i] <= pivot)) {
                i++;
            }

            if (i < j) {
                arr[j--] = arr[i];
            } else {
                break;
            }

            while ((i < j) && (arr[j] >= pivot)) {
                j--;
            }

            if (i < j) {
                arr[i] = arr[j];
            } else {
                break;
            }
        }

        arr[i] = pivot;

        return i;
    }
}
