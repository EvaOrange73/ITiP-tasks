import java.util.Arrays;
import java.util.regex.Pattern;

public class level2 {
    public static void main(String[] args) {
        //ex1
        System.out.println("----------ex1----------");
        System.out.println(repeat("mice", 5));
        System.out.println(repeat("hello", 3));
        System.out.println(repeat("stop", 1));

        //ex2
        System.out.println("----------ex2----------");
        System.out.println(differenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println(differenceMaxMin(new int[]{44, 32, 86, 19}));

        //ex3
        System.out.println("----------ex3----------");
        System.out.println(isAvgWhole(new int[]{1, 3}));
        System.out.println(isAvgWhole(new int[]{1, 2, 3, 4}));
        System.out.println(isAvgWhole(new int[]{1, 5, 6}));
        System.out.println(isAvgWhole(new int[]{1, 1, 1}));
        System.out.println(isAvgWhole(new int[]{9, 2, 2, 5}));
        //ex4
        System.out.println("----------ex4----------");
        System.out.println(Arrays.toString(cumulativeSum(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(cumulativeSum(new int[]{1, -2, 3})));
        System.out.println(Arrays.toString(cumulativeSum(new int[]{3, 3, -2, 408, 3, 3})));

        //ex5
        System.out.println("----------ex5----------");
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(getDecimalPlaces("400"));
        System.out.println(getDecimalPlaces("3.1"));

        //ex6
        System.out.println("----------ex6----------");
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(7));
        System.out.println(fibonacci(12));

        //ex7
        System.out.println("----------ex7----------");
        System.out.println(isValid("59001"));
        System.out.println(isValid("853a7"));
        System.out.println(isValid("732 32"));
        System.out.println(isValid("393939"));

        //ex8
        System.out.println("----------ex8----------");
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));

        //ex9
        System.out.println("----------ex9----------");
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));

        //ex10
        System.out.println("----------ex10---------");
        System.out.println(boxSeq(0));
        System.out.println(boxSeq(1));
        System.out.println(boxSeq(2));

    }


    private static String repeat(String str, int n) {
        String answer = "";
        for (char ch : str.toCharArray()) {
            for (int i = 0; i < n; i++) {
                answer += ch;
            }
        }
        return answer;
    }

    private static int differenceMaxMin(int[] numbers) {
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            } else if (number < min) {
                min = number;
            }
        }
        return (int) (max - min);
    }

    private static boolean isAvgWhole(int[] numbers) {
        double avg = 0;
        for (int number : numbers) {
            avg += number;
        }
        avg = avg / numbers.length;
        return avg == (int) avg;
    }

    private static int[] cumulativeSum(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] += numbers[i - 1];
        }
        return numbers;
    }

    private static int getDecimalPlaces(String s) {
        boolean flag = false;
        int k = 0;
        for (char ch : s.toCharArray()){
            if (flag) k += 1;
            if (ch == '.') flag = true;
        }
        return k;
    }

    private static int fibonacci(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static boolean isValid(String s) {
        return Pattern.matches("\\d{5}", s);
    }

    private static boolean isStrangePair(String first, String second) {
        if (first.isEmpty() || second.isEmpty()) return true;
        return first.charAt(0) == second.charAt(second.length() - 1)
                && first.charAt(first.length() - 1) == second.charAt(0);
    }

    private static boolean isPrefix(String word, String prefix) {
        for (int i = 0; i < prefix.length() - 2; i++){
            if (word.charAt(i) != prefix.charAt(i)) return false;
        }
        return true;
    }

    private static boolean isSuffix(String word, String suffix) {
        for (int i = 1; i < suffix.length() - 1; i++){
            if (word.charAt(word.length() - i) != suffix.charAt(suffix.length() - i)) return false;
        }
        return true;
    }

    private static int boxSeq(int n) {
        int answer = 0;
        for (int i = 0; i < n; i++){
            if (i % 2 == 0) answer += 3;
            else answer -= 1;
        }
        return answer;
    }
}
