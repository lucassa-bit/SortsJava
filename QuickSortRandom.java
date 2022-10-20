import java.util.Arrays;
import java.util.Random;

public class QuickSortRandom {
    static void random(int array[], int low, int high) {
        Random rand = new Random();
        int pivot = rand.nextInt(high - low) + low;

        int temp1 = array[pivot];
        array[pivot] = array[high];
        array[high] = temp1;
    }

    static int partition(int array[], int low, int high) {
        random(array, low, high);
        int pivot = array[high];

        System.out.println(String.format("Começo: %d, Fim: %d\n", low, high) +
                    "-------------------------\n");

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                System.out.println("Valor " + array[i] + " é trocado por " + array[j]);

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        System.out.println("\n------ Resultado --------\n" +
                Arrays.toString(Arrays.copyOfRange(array, low, high + 1)) +
                "\n-------------------------\n");

        return i + 1;
    }

    static void sort(int array[], int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            sort(array, low, pi - 1);
            sort(array, pi + 1, high);
        }
    }

    public static void main(String args[]) {
        //int array[] = { 5, 2, 6, 1, 3, 4 };
        int array[] = { 13, 19, 9, 5, 12, 8 };
        int n = array.length;

        System.out.println("== VALOR INICIAL ==\n" + Arrays.toString(array));

        sort(array, 0, n - 1);

        System.out.println("== RESULTADO FINAL ==\n" + Arrays.toString(array));
    }
}
