package heapsort;

public class HeapSort {

    private int heapSize;

    public void sort(Integer[] array){
        heapSize = array.length;
        buildMaxHeap(array);

        for (int i = array.length - 1; i > 0 ; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            heapSize = heapSize -1;
            maxHeapify(array, 0);
        }
    }

    private void maxHeapify(Integer[] array, int index){

        //int heapSize = array.length;
        int left = left(index);
        int right = right(index);
        int largest;


        if (left < heapSize && array[left] > array[index]){
            largest = left;
        } else {
            largest = index;
        }

        if (right < heapSize && array[right] > array[largest]){
            largest = right;
        }

        if (largest != index){
            int temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;
            maxHeapify(array, largest);
        }
    }

    private void buildMaxHeap(Integer[] array){

        for (int i = heapSize/2; i >= 0 ; i--) {
            maxHeapify(array, i);
        }
    }

    private int left(int index){
        return (2 * index) + 1;
    }

    private int right(int index){
        return (2 * index) + 2;
    }

}
