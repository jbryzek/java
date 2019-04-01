package Ex5;

public class QuickSort {
    public void quickSort(int[] array){
        int begin=0;
        int end=array.length-1;
        quickSort1(array,begin,end);
    }

    public void quickSort1(int[] arr,int begin,int end){
        if(begin<end){
            int partitionIndex=partition(arr,begin,end);
            quickSort1(arr,begin,partitionIndex-1);
            quickSort1(arr,partitionIndex+1,end);
        }
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = (int)arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = (int)arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = (int)arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}
