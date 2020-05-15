public class AnotherSolution {
    /**
     * This method
     * @param arrayForSearching - incoming array for searching the required result
     * @param requiredSum - a random incoming number
     * @currentElement - element of the arrayForSearching according current loop's index
     * @residue - a result of statement (requiredSum - currentElement), after we got a this number we start searching
     * @result - it is an index with the same number as residue
     * @return - returns a String with description of work's result
     */
    public String getIndexesThatGiveRequiredSum(int [] arrayForSearching, int requiredSum) {
        BadSolution badSolution = new BadSolution();
        badSolution.mergeSort(arrayForSearching, arrayForSearching.length);
        badSolution.printArray(arrayForSearching);

        for (int i = 0; i < arrayForSearching.length; i++) {

            int currentElement = arrayForSearching[i];
            int residue = requiredSum - currentElement;
            int result = fastSearch(residue, arrayForSearching);
            if (result > 0) {
                if ((currentElement + arrayForSearching[result]) == requiredSum) {
                    //return new String("ok");
                    // для тестирования нужно раскоментировать эту строку, а следующие две закомментировать
                    return new String("Необходимые индексы массива: " + i + ", " + result +
                            "\n" + "числа, находящиеся по данным индексам: " + currentElement + ", " + arrayForSearching[result]);
                }
            }
        }

        return null; // new String("При текущей генерации массива нужной комбинации чисел не нашлось");
    }

    /**
     * This method for searching requiredResidue
     * @param requiredResidue - a result of statement (requiredSum - currentElement)
     * @param arrayForSearching - incoming array for searching
     * @return - returns an index with required element
     */
    private int fastSearch(int requiredResidue,int [] arrayForSearching) {
        int mid = arrayForSearching.length >> 1;
        if (requiredResidue < arrayForSearching[mid]) {
            for (int i = 0; i < mid; i++) {
                if (requiredResidue == arrayForSearching[i]) return i;
            }
        }
        else {
            for (int i = ++mid; i < arrayForSearching.length; i++) {
                if (requiredResidue == arrayForSearching[i]) return i;
            }
        }
        return -1;
    }

}
