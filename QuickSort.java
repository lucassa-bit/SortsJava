import java.util.Arrays;

class QuickSort {
    int partition(int array[], int low, int high) {
        if (low < high) {
            System.out.println(String.format("Começo: %d, Fim: %d\n", low, high) +
                    "-------------------------\n");
            int pivot = array[low];
            int i = low - 1, j = high;

            while (i < j) {
                i++;

                while (i <= high && array[i] < pivot) {
                    i++;
                }

                while (j >= low && array[j] > pivot) {
                    j--;
                }

                if (i <= high && i < j) {
                    System.out.println("Valor " + array[i] + " é trocado por " + array[j]);
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

            if (i < j) {
                int temp = array[j];
                array[j] = array[low];
                array[low] = temp;
            }

            System.out.println("\n------ Resultado --------\n" +
                    Arrays.toString(Arrays.copyOfRange(array, low, high + 1)) +
                    "\n-------------------------\n");

            return j;
        }
        return low;
    }

    void sort(int array[], int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            sort(array, low, pi);
            sort(array, pi + 1, high);
        }
    }

    public static void main(String args[]) {
        // int array[] = { 5, 2, 6, 1, 3, 4 };
        int array[] = { 13, 19, 9, 5, 12, 8 };
        int n = array.length;

        QuickSort ob = new QuickSort();

        System.out.println("== VALOR INICIAL ==\n" + Arrays.toString(array));

        ob.sort(array, 0, n - 1);

        System.out.println("== RESULTADO FINAL ==\n" + Arrays.toString(array));
    }
}