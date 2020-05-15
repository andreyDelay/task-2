public class TaskRealize {
    public static void main(String[] args) {
        BadSolution solution = new BadSolution();
        int [] arr = solution.createArray();

        AnotherSolution anotherSolution = new AnotherSolution();
        String result = anotherSolution.getIndexesThatGiveRequiredSum(arr, 8);
        System.out.println(result);
    }

}
