import org.junit.Assert;

public class Test {
    /**
     * Тест работает не всегда, так как массив заполняется случайными числами
     * чтобы тест работал корректно, необходимо закомментировать строки 25, 26 класса AnotherSolution
     * и раскомментировать строку 24 класса AnotherSolution
     * @throws Exception
     */
    @org.junit.Test
    public void testTask2() throws Exception {
        BadSolution solution = new BadSolution();
        int [] arr = solution.createArray();
        AnotherSolution anotherSolution = new AnotherSolution();

        for (int i = 0; i < arr.length; i++) {
            int tmp = (int) (Math.random() * 20) + 10;
            //System.out.println(tmp);
            String result = anotherSolution.getIndexesThatGiveRequiredSum(arr, tmp);
            //System.out.println(result);
            Assert.assertEquals("ok", result);
        }


    }
}
