package calculator.view;

public class Output {
    public static void printError(String error) {
        System.out.printf("[ERROR] %s\n", error);
    }

    public static void printResult(int result){
        System.out.printf("결과 : %s\n", result);
    }
}
