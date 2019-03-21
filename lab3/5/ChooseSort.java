package Ex5;

public class ChooseSort {
    public double sort(int[] array,String g){
        long tStart = 0;
        switch(g){
            case "bubble":{
                tStart = System.currentTimeMillis();
                BubbleSort bubbleSort=new BubbleSort();
                bubbleSort.bubbleSort(array);
            }
            case "quickSort": {
                tStart = System.currentTimeMillis();
                QuickSort quickSort = new QuickSort();
                quickSort.quickSort(array);
            }
            case "mergeSort":{
                tStart = System.currentTimeMillis();
                MergeSort mergeSort=new MergeSort();
                mergeSort.mergeSort(array);
            }
            case "insertionSort":{
                tStart = System.currentTimeMillis();
                InsertionSort insertionSort=new InsertionSort();
                insertionSort.insertionSort(array);
            }
            case "shellSort":{
                tStart = System.currentTimeMillis();
                ShellSort shellSort=new ShellSort();
                shellSort.shellSort(array);
            }

        }
        long tEnd = System.currentTimeMillis();
        double elapsedSeconds = (tEnd-tStart) / 1000.0;
        return elapsedSeconds;
    }

}
