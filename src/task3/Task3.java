package task3;

import java.util.ArrayList;
import java.util.Arrays;

public class Task3 {

    interface Matcher<T> {
        T func(int [] currentArray);
    }

    public static void main(String[] args) {
        //Создаём новый массив, предположительно всегда с дубликатами
        //затем передаём это в метод для поиска первого найденного дубликата чисел
        int [] array1 = createArray();
        int [] array2 = createArrayWithoutDoubles();

        boolean rlt1 = isDoublesInArray(currentArray -> {
            Arrays.sort(currentArray);
            for (int i = 0; i < currentArray.length - 1; i++) {
                if (currentArray[i] == currentArray[i + 1])
                    return true;
            }
            return false;
        },array1);
        System.out.println("Резултат поиска дубликатов в массиве array1: " + rlt1);

        boolean rlt2 = isDoublesInArray(currentArray -> {
            Arrays.sort(currentArray);
            for (int i = 0; i < currentArray.length - 1; i++) {
                if (currentArray[i] == currentArray[i + 1])
                    return true;
            }
            return false;
        },array2);
        System.out.println("Резултат поиска дубликатов в массиве array2: " + rlt2);

        /*
        Отдельный вариант реализации
        А так же для вывода более полных данных о дубликатах в массиве
         */
        Matcher<ArrayList<String>> allMatches = (currentArray -> {
           ArrayList<String> result = new ArrayList<>();
           Arrays.sort(currentArray);

            System.out.println("Содержимое текущего массива: \n");
            for(int val : currentArray)
                System.out.println(val);

            for (int i = 0; i < currentArray.length - 1; i++) {
                if(currentArray[i] == currentArray[i + 1]) {
                    result.add("Найден дубликат числа: " + currentArray[i]);
                    i++; //Предотвращаем вывод , если идёт три подряд
                }
            }

           return result;
        });
        ArrayList<String> doubles = getAllDoublesInArray(allMatches, array1);
        System.out.println("Результат поиска всех дубликатов в массиве :\n" + doubles);
    }

//--------------------------------Методы для реализации задачи--------------------------------
    //Тут не понял как избежать, и можно ли вообще, кастования типов...
    private static boolean isDoublesInArray(Matcher m, int [] currentArray) {
        return (boolean)m.func(currentArray);
    }

    private static ArrayList<String> getAllDoublesInArray(Matcher m, int[] currentArray) {
        return (ArrayList<String>)m.func(currentArray);
    }


//--------------------------------Создания массивов--------------------------------
    private static int [] createArray() {
        int [] array = new int[20];
        for (int i = 0; i < 20; i++)
            array[i] = (int) (Math.random() * 20) + 1;
        return array;
    }

    private static int [] createArrayWithoutDoubles() {
        int [] array = new int[20];
        for (int i = 0; i < 20; i++)
            array[i] = i << 1;
        return array;
    }
}
