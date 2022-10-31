import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class level3 {
    public static void main(String[] args) {
        //ex1
        System.out.println("----------ex1----------");
        System.out.println(solutions(1, 0, -1));
        System.out.println(solutions(1, 0, 0));
        System.out.println(solutions(1, 0, 1));

        //ex2
        System.out.println("----------ex2----------");
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(findZip("all zip files are compressed"));

        //ex3
        System.out.println("----------ex3----------");
        System.out.println(checkPerfect(6));
        System.out.println(checkPerfect(28));
        System.out.println(checkPerfect(496));
        System.out.println(checkPerfect(12));
        System.out.println(checkPerfect(97));

        //ex4
        System.out.println("----------ex4----------");
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(flipEndChars("ada"));
        System.out.println(flipEndChars("Ada"));
        System.out.println(flipEndChars("z"));

        //ex5
        System.out.println("----------ex5----------");
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(isValidHexCode("#EAECEE"));
        System.out.println(isValidHexCode("#eaecee"));
        System.out.println(isValidHexCode("#CD5C58C"));
        System.out.println(isValidHexCode("#CD5C5Z"));
        System.out.println(isValidHexCode("#CD5C&C"));
        System.out.println(isValidHexCode("CD5C5C"));

        //ex6
        System.out.println("----------ex6----------");
        System.out.println(same(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7}));
        System.out.println(same(new int[]{9, 8, 7, 6}, new int[]{4, 4, 3, 1}));
        System.out.println(same(new int[]{2}, new int[]{3, 3, 3, 3, 3}));

        //ex7
        System.out.println("----------ex7----------");
        System.out.println(isKaprekar(3));
        System.out.println(isKaprekar(5));
        System.out.println(isKaprekar(297));

        //ex8
        System.out.println("----------ex8----------");
        System.out.println(longestZero("01100001011000"));
        System.out.println(longestZero("100100100"));
        System.out.println(longestZero("11111"));

        //ex9
        System.out.println("----------ex9----------");
        System.out.println(nextPrime(12));
        System.out.println(nextPrime(24));
        System.out.println(nextPrime(11));

        //ex10
        System.out.println("----------ex10---------");
        System.out.println(rightTriangle(3, 4, 5));
        System.out.println(rightTriangle(145, 105, 100));
        System.out.println(rightTriangle(70, 130, 110));
    }

    private static int solutions(int a, int b, int c) {
        double d = Math.pow(b, 2) - 4 * a * c;
        if (d > 0) return 2;
        if (d == 0) return 1;
        return 0;
    }

    private static int findZip(String s) {
        Pattern pattern = Pattern.compile("zip");
        Matcher matcher = pattern.matcher(s);
        int k = 0;
        while (matcher.find()) {
            k += 1;
            if (k == 2) return matcher.start();
        }
        return -1;
    }

    private static boolean checkPerfect(int x) {
        int sum = 0;
        for (int i = 1; i < x; i++) {
            if (x % i == 0) sum += i;
        }
        return sum == x;
    }

    private static String flipEndChars(String s) {
        if (s.length() < 2) return "Incompatible";
        if (s.charAt(0) == s.charAt(s.length() - 1)) return "Two's a pair.";
        return s.charAt(s.length() - 1) + s.substring(1, s.length() - 1) + s.charAt(0);
    }

    private static boolean isValidHexCode(String hexCode) {
        return Pattern.matches("#[a-fA-F0-9]{6}", hexCode);
    }

    private static boolean same(int[] arr1, int[] arr2) {
        return getK(arr1) == getK(arr2);
    }

    private static int getK(int[] arr) {
        int k = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) break;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    k -= 1;
                    arr[j] = 0;
                }
            }
        }
        return k;
    }

    private static boolean isKaprekar(int x) {
        int y = x * x;
        int k = 1;
        while (y % Math.pow(10, k) != y) k++;
        if (k == 1) return y == x;
        if (k % 2 == 0) k = (int) Math.pow(10, k / 2);
        else k = (int) Math.pow(10, k / 2 + 1);
        int right = (int) (y % k);
        int left = (int) ((y - y % k) / k);
        return right + left == x;
    }

    private static String longestZero(String s) {
        int max_k = 0;
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') k += 1;
            else {
                if (k > max_k) max_k = k;
                k = 0;
            }
        }
        String answer = "";
        for (int i = 0; i < max_k; i++) answer += "0";
        return answer;
    }

    private static int nextPrime(int n) {
        while (true) {
            int k = 0;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    k++;
                }
            }
            if (k == 0) return n;
            n++;
        }
    }

    private static boolean rightTriangle(int a, int b, int c) {
        return a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a;
    }
}
