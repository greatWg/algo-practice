public class MergeSort {
    int[] input = { 3, 5, 6, 1, 2};

    public int[] sort ( int low, int high){
        if (low<high) {
            int mid = (low + high) / 2;
            sort( low, mid);
            sort(mid + 1, high);
            merge(low, mid, high);
        }
        return input;
    }

    private int[] merge ( int low, int mid, int high) {

        int[] helper = new int[high];
        for (int i=0; i<high; i++){
            helper[i]= input[i];
        }
        printArray(input);
        int i = low;
        int j = mid;
        int k = high;

        while (i<= mid  && j<= high){
            if (helper[i]<= helper[j])
            {
                input[k]= helper[i];
                i++;
            }else {
                input[k]= helper[j];
                j++;
            }
            k++;
        }
        while (i <= mid){
            input[k]= helper[i];
            i++; k++;
        }
        return input;
    }

    public void printArray(int[] array){
        for (int i=0; i< array.length; i++){
            System.out.print( array[i]+ " ");
        }
    }

}

