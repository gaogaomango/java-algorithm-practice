class MergeSort {
  public static void main(String[] args) {
    // System.out.println("\nGiven array");
    // int arr[] = { 12, 11, 13, 5, 6, 7 };
    // printArray(arr);

    // sort(arr, 0, arr.length - 1);
    // System.out.println("\nSorted array");
    // printArray(arr);

    System.out.println("\nGiven array");
    int arr[] = { 38, 27, 43, 3, 9, 82, 10 };
    printArray(arr);

    sort(arr, 0, arr.length - 1);
    System.out.println("\nSorted array");
    printArray(arr);

  }

  private static void sort(int arr[], int left, int right) {
    if (left < right) {
      int midium = (left + right) / 2;

      sort(arr, left, midium);
      sort(arr, midium + 1, right);

      merge(arr, left, midium, right);
    }
  }

  private static void merge(int arr[], int left, int midium, int right) {
    int leftArrSize = midium - left + 1;
    int rightArrSize = right - midium;

    int leftArr[] = new int[leftArrSize];
    int rightArr[] = new int[rightArrSize];

    for (int i = 0; i < leftArrSize; i++) {
      leftArr[i] = arr[left + i];
    }
    // System.out.println("leftArr");
    // printArray(leftArr);
    for (int i = 0; i < rightArrSize; i++) {
      // rightArr[i] = arr[midium + 1 + i];
      rightArr[i] = arr[midium + 1 + i];
    }
    // System.out.println("rightArr");
    // printArray(rightArr);

    int i = 0, j = 0;

    int k = left;
    while (i < leftArrSize && j < rightArrSize) {
      if (leftArr[i] <= rightArr[j]) {
        arr[k] = leftArr[i];
        i++;
      } else {
        arr[k] = rightArr[j];
        j++;
      }
      k++;
    }

    while (i < leftArrSize) {
      arr[k] = leftArr[i];
      i++;
      k++;
    }

    while (j < rightArrSize) {
      arr[k] = rightArr[j];
      j++;
      k++;
    }

  }

  private static void printArray(int arr[]) {
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }
}