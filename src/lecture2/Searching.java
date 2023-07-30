package lecture2;

public class Searching {

    public static void main(String[] args) {
        int[] array = new int[] {
                9,8,0,2,5,1,7,4,1
        };

        System.out.println(binarySearch(array, 9));
    }
    // простой перебор
    public static int find(int[] array, int value) {
        for (int i=0; i< array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int value) {
        return binarySearch(array, value, 0, array.length-1);
    }
    //бинарный поиск
    public static int binarySearch(int[] array, int value, int min, int max) {
        int midpoint;

        if (max < min) {
            return -1;
        } else {
            midpoint = (max - min) / 2 + min; //поиск середины
        }
        if (array[midpoint] < value) {
            return binarySearch(array, value, midpoint + 1, max);
        } else {
            if (array[midpoint] > value) {
                return binarySearch(array, value, min, midpoint - 1);
            } else {
                return midpoint;
            }
        }
    }

    //быстрая сортировка

    public static void quickSort(int[] array, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do {
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }
            while (array[rightPosition] > pivot) {
                rightPosition--;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        } while (leftPosition <= rightPosition);
        if (leftPosition < endPosition) {
            quickSort(array, startPosition, rightPosition);
        }
    }
}
