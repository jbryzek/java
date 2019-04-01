package Ex4;

public class Exercise4 {
    public int[] solution (float[] arr,int target) throws NoSolutionException {
        float[] newArr=new float[arr.length];
        System.arraycopy(arr,0,newArr,0,arr.length);
        int[] result= new int[2];
        for(int i=0;i<2;i++){
            result[i]=0;
        }
        int begin=0;
        int end=arr.length-1;
        quickSort(arr,begin,end);
        boolean ifPossible=false;
        while(begin<end){
            if(arr[begin]+arr[end]==target){
                ifPossible=true;
                break;
            }
            else if(arr[begin]+arr[end]<target){
                    begin++;
                }
                else{
                    end--;
                }

        }
        if(ifPossible==false){
            throw new NoSolutionException();
        }
        else {
            for(int i=0;i<newArr.length;i++){
                if(newArr[i]==arr[begin]){
                    result[0]=i;
                }
                if(newArr[i]==arr[end]){
                    result[1]=i;
                }
            }
        }
        return result;
    }

    private int partition(float[] arr, int begin, int end) {
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

    public void quickSort(float[] arr,int begin,int end){
        if(begin<end){
            int partitionIndex=partition(arr,begin,end);
            quickSort(arr,begin,partitionIndex-1);
            quickSort(arr,partitionIndex+1,end);
        }
    }
}
