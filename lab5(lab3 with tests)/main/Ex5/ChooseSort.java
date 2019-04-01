package Ex5;

public class ChooseSort {
    public double sort(int[] array,SortAlgorithm g){
        long tStart = System.currentTimeMillis();
        switch(g){
            case BUBBLE:{
                BubbleSort bubbleSort=new BubbleSort();
                bubbleSort.bubbleSort(array);
                break;
            }
            case QUICK: {
                QuickSort quickSort = new QuickSort();
                quickSort.quickSort(array);
                break;
            }
            case MERGE:{
                MergeSort mergeSort=new MergeSort();
                mergeSort.mergeSort(array);
                break;
            }
            case INSERT:{
                InsertionSort insertionSort=new InsertionSort();
                insertionSort.insertionSort(array);
            }
            case SHELL:{
                ShellSort shellSort=new ShellSort();
                shellSort.shellSort(array);
            }

        }
        long tEnd = System.currentTimeMillis();
        double elapsedSeconds = (tEnd-tStart) / 1000.0;
        return elapsedSeconds;
    }

}
