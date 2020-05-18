package task3;

import static task3.Helper.createArray;
import static task3.Helper.createArrayWithoutDoubles;
import static task3.IsDoubles.*;

public class Main {
    public static void main(String[] args) {
        Integer [] array1 = createArray();
        Integer [] array2 = createArrayWithoutDoubles();

        System.out.println("Резултат поиска дубликатов в массиве array1: " + isDoubles(array1,IsDoubles::isSameNumber,true));
        System.out.println("Резултат поиска дубликатов в массиве array2: " + isDoubles(array2,IsDoubles::isSameNumber,true));

        System.out.print("Результат поиска всех дубликатов в массиве ( сомнительный вывод :) ) :\n" + isDoubles(array1,IsDoubles::isSameNumber,false));
    }
}
