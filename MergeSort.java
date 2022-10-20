import java.util.Arrays;

public class MergeSort {

    void merge(int array[], int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = array[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = array[q + 1 + j];

        int i = 0, j = 0, k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                if (array[k] != L[i])
                    System.out.println("Valor " + array[k] + " é trocado por " + L[i]);
                array[k] = L[i];
                i++;
            } else {
                if (array[k] != M[j])
                    System.out.println("Valor " + array[k] + " é trocado por " + M[j]);
                array[k] = M[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = M[j];
            j++;
            k++;
        }
    }

    void mergeSort(int array[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            System.out.println(
                    String.format("Começo: %d, Meio: %d, Fim: %d\n", left, mid, right) + "-------------------------\n");
            merge(array, left, mid, right);
            System.out.println("\n------ Resultado --------\n" +
                    Arrays.toString(Arrays.copyOfRange(array, left, right + 1)) +
                    "\n-------------------------\n");
        }
    }

public static void main(String args[]) {
    int[] array = { 50, 22, 85, 14, 31, 20 };
    // int[] array = { 35, 77, 44, 38, 22, 56 };
    MergeSort ob = new MergeSort();
    System.out.println("== ENTRADA INICIAL ==\n" +
        Arrays.toString(array));

    System.out.println("");
    ob.mergeSort(array, 0, array.length - 1);

    System.out.println("== RESULTADO FINAL ==\n" + Arrays.toString(array));
}

}
