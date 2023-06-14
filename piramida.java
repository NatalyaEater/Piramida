// Реализовать алгоритм пирамидальной сортировки (HeapSort)

import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class piramida {
    public static void main(String[] args) {
        int[] onearr = { 23, 3, 7, 53, 2 };
        piramida ob = new piramida();
        ob.sort(onearr);
    }
    public void sort(int arr[])
    {
        Logger logger = Logger.getLogger(piramida.class.getName());
        FileHandler fh;
        try {
            fh = new FileHandler("log.txt");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            int n = arr.length;
            for (int i = n / 2 - 1; i >= 0; i--){
                heapify(arr, n, i);
                logger.info("Sorted array" + Arrays.toString(arr));
            }
               
            for (int i=n-1; i>=0; i--)
            {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                heapify(arr, i, 0);
                logger.info("Sorted array" + Arrays.toString(arr));
            }
            
        }
            catch (Exception e) {
                e.printStackTrace();
            }
    }

    void heapify(int arr[], int n, int i)
    {
        int largest = i; 
        int l = 2*i + 1; 
        int r = 2*i + 2; 

        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}