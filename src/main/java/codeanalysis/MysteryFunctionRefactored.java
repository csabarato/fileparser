package main.java.codeanalysis;

public class MysteryFunctionRefactored {

    public static void main(String[] args) {
        int [] data = {-14, 42, -42};

        for (int i = 0; i < data.length; i++) {
            data[i] = sumOfDigitSquares(data[i]);
        }

        for (int value : data) {
            System.out.println(value);
        }
    }

    private static int sumOfDigitSquares(int input) {

        int result = 0;

        while (input != 0) {
            result += (int) Math.pow(input % 10, 2);
            input /= 10;
        }
        return result;
    }

}
