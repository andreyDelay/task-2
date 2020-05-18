package task2;

import java.util.HashSet;

/**
 * Try to solve the task#2
 */
public class BadSolution {
    private HashSet<Integer> set = new HashSet<>();
    /**
     * The method creates an Array and fill it with random int values
     * by using Math.Random util
     * @return - returns new Array of size 500
     */
    public int [] createArray() {
        int [] arraySource = new int[50];
        int counter = 0;
        boolean trigger = false;
        do{
            int tmp = (int)(Math.random() * 100) + 1;
            trigger = set.add(tmp);
            if (trigger) {
                arraySource[counter] = tmp;
                counter++;
            }
        }while (counter < arraySource.length);
        return arraySource;
    }

    /**
     *
     * @param currentArray - incoming Array
     */
    public void printArray(int [] currentArray) {
        for (int i = 0; i < currentArray.length; i++) {
            System.out.print("index " + i + ": " + currentArray[i]);
            System.out.println();
        }
    }

    /**
     * Method for sorting incoming Array
     * @param currentArray - incoming Array that will be divided in the method
     * @param arrayLength - length of currentArray
     */
    public void mergeSort(int [] currentArray, int arrayLength) {
        if (arrayLength < 2) {
            return;
        }
        int mid = arrayLength >> 1; //division of array length by 2
        int [] left = new int[mid]; //creating left part with length "half of currentArray"
        int [] right = new int[arrayLength - mid]; //creating right part with length "half of currentArray"

        /*
        Two loops for copying incomingArray into left and right arrays
         */
        for (int i = 0; i < mid; i++) {
            left[i] = currentArray[i];
        }
            for (int i = mid; i < arrayLength; i++) {
                right[i - mid] = currentArray[i];
            }

            //new calling (recursion) of this method with new parameters created in this method
        mergeSort(left,mid);
        mergeSort(right,arrayLength - mid);

        merge(currentArray, left,right,mid,arrayLength-mid);
    }

    /**
     *
     * @param currentArray - general (destination) Array
     * @param left - left part of divided general Array, size depends of depth of recursion
     * @param right - right part of divided general Array, size depends of depth of recursion
     * @param leftIndex - size of the left Array part
     * @param rightIndex - size of the right Array part
     */
    private void merge(int[] currentArray, int[] left, int[] right, int leftIndex, int rightIndex) {
        int i = 0;
        int j = 0;
        int k = 0;
        /*
        Comparing of left and right arrays elements one by one
        and incrementation of rightIndex or leftIndex index
        according condition current block
         */
        while (i < leftIndex && j < rightIndex) {
            if(left[i] < right[j]) {
                currentArray[k++] = left[i++];
            }
            else {
                currentArray[k++] = right[j++];
            }
        }
        /*
        If any array contains elements that wasn't include in the destination Array
        this loops are for adding the elements
         */
        while (i < leftIndex) {
            currentArray[k++] = left[i++];
        }
        while (j < rightIndex) {
            currentArray[k++] = right[j++];
        }
    }

    //НЕ ИСПОЛЬЗУЕТСЯ
    public String getIndexesThatGiveRequiredSum(int [] arrayForSearching, int requiredSum) {
        mergeSort(arrayForSearching,arrayForSearching.length);
        printArray(arrayForSearching);
        int shift = 1;
        int currentIndex;
        int tmp;
        int nearestResult;

        do {
            currentIndex = arrayForSearching.length>>shift;
            tmp = arrayForSearching[currentIndex];
            shift++;
        }while (requiredSum >> 1 >(requiredSum - tmp));

        if ((tmp + arrayForSearching[++currentIndex]) < requiredSum) {
            for (int i = ++currentIndex; i < arrayForSearching.length; i++) {
                nearestResult = tmp + arrayForSearching[i];
                if (nearestResult == requiredSum)
                    return new String(
                            "Индексы , которые дают необходимую сумму: " + tmp + "," + currentIndex +
                                    " Данные1.1: " + arrayForSearching[tmp] + ", " + arrayForSearching[currentIndex]
                    );
                if (nearestResult > requiredSum)
                    return new String(
                            "Найдено приблизительное совпадение: "
                                    + tmp + "," + currentIndex +
                                    " Данные1: " + arrayForSearching[tmp] + ", " + arrayForSearching[currentIndex]
                            );
            }
        }
        else {
            for (int i = --currentIndex; i >= 0; i--) {
                nearestResult = tmp + arrayForSearching[i];
                if (nearestResult == requiredSum)
                    return new String(
                            "Индексы , которые дают необходимую сумму: " + tmp + "," + currentIndex +
                                    " Данные2.1: " + arrayForSearching[tmp] + ", " + arrayForSearching[currentIndex]
                    );
                if (nearestResult < requiredSum)
                    return new String(
                            "Найдено приблизительное совпадение: "
                                    + tmp + "," + currentIndex +
                                    " Данные2: " + arrayForSearching[tmp] + ", " + arrayForSearching[currentIndex]
                    );
            }
        }

        return null;
    }

}
