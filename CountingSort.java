import java.util.Arrays;

public class CountingSort {
  void countSort(int array[], int size) {
    int[] output = new int[size + 1];

    int max = array[0];
    for (int i = 1; i < size; i++) {
      if (array[i] > max)
        max = array[i];
    }
    int[] count = new int[max + 1];

    for (int i = 0; i < max; ++i) {
      count[i] = 0;
    }

    for (int i = 0; i < size; i++) {
      count[array[i]]++;
      System.out.println(String.format("Adicionando valor %d\n", array[i]) +
          Arrays.toString(count) +
          "\n-------------------------");
    }

    for (int i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }

    for (int i = size - 1; i >= 0; i--) {
      output[count[array[i]] - 1] = array[i];
      count[array[i]]--;
    }

    for (int i = 0; i < size; i++) {
      array[i] = output[i];
    }
  }

  public static void main(String args[]) {
    int[] array = { 5, 2, 6, 1, 3, 4 };
    int size = array.length;

    CountingSort cs = new CountingSort();

    System.out.println("== VALOR INICIAL ==\n" + Arrays.toString(array) +
        "\n-------------------------");

    cs.countSort(array, size);

    System.out.println("== RESULTADO FINAL ==\n" + Arrays.toString(array));
  }
}
