package task3;
import java.util.ArrayList;
import java.util.Arrays;

public class IsDoubles {

    static <T> boolean isDoubles(T [] currentArray, Matcher<T> m, boolean singleMatch) {
        Arrays.sort(currentArray);

        if (singleMatch) {
            for (int i = 0; i < currentArray.length - 1; i++) {
                if (m.func(currentArray[i],currentArray[i + 1]))
                    return true;
            }
        }
        else {
            ArrayList<String> result = new ArrayList<>();
            System.out.print("Содержимое текущего массива: \n");
            for(T val : currentArray)
                System.out.println(val);

            for (int i = 0; i < currentArray.length - 1; i++) {
                if(m.func(currentArray[i],currentArray[i + 1])) {
                    result.add("Найден дубликат числа: " + currentArray[i]);
                    i++; //Предотвращаем вывод , если идёт три подряд
                }
            }
            if (result.size() > 0) {
                System.out.print("Найдены дубликаты :\n");
                for(String element: result)
                    System.out.println(element);

                return true;
            }
        }
        return false;
    }

    public static<T> boolean isSameNumber(T v1, T v2) {
        return v1 == v2;
    }
}
