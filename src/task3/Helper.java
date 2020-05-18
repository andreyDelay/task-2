package task3;

public class Helper {

    //--------------------------------Создания массивов--------------------------------
    public static Integer [] createArray() {
        Integer [] array = new Integer[20];
        for (int i = 0; i < 20; i++)
            array[i] = (int) (Math.random() * 20) + 1;
        return array;
    }

    public static Integer [] createArrayWithoutDoubles() {
        Integer [] array = new Integer[20];
        for (int i = 0; i < 20; i++)
            array[i] = i << 1;
        return array;
    }
}
