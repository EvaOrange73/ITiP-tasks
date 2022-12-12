import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class level5 {
    public static void main(String[] args) {
        //ex1
        System.out.println("----------ex1----------");
        System.out.println(Arrays.toString(encrypt("Hello")));
        System.out.println(decrypt(new int[]{72, 33, -73, 84, -12, -3, 13, -13, -68}));
        System.out.println(Arrays.toString(encrypt("Sunshine")));

        //ex2
        System.out.println("----------ex2----------");
        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canMove("Queen", "C4", "D6"));

        //ex3
        System.out.println("----------ex3----------");
        System.out.println(canComplete("butl", "beautiful"));
        System.out.println(canComplete("butlz", "beautiful"));
        System.out.println(canComplete("tulb", "beautiful"));
        System.out.println(canComplete("bbutl", "beautiful"));

        //ex4
        System.out.println("----------ex4----------");
        System.out.println(sumDigProd(16, 28));
        System.out.println(sumDigProd(0));
        System.out.println(sumDigProd(1, 2, 3, 4, 5, 6));

        //ex5
        System.out.println("----------ex5----------");
        System.out.println(sameVowelGroup(new String[]{"toe", "ocelot", "maniac"}));
        System.out.println(sameVowelGroup(new String[]{"many", "carriage", "emit", "apricot", "animal"}));
        System.out.println(sameVowelGroup(new String[]{"hoops", "chuff", "bot", "bottom"}));

        //ex6
        System.out.println("----------ex6----------");
        System.out.println(validateCard(1234567890123456L));
        System.out.println(validateCard(1234567890123452L));

        //ex7
        System.out.println("----------ex7----------");
        System.out.println(numToEng(0));
        System.out.println(numToEng(18));
        System.out.println(numToEng(126));
        System.out.println(numToEng(909));

        System.out.println(numToRu(0));
        System.out.println(numToRu(18));
        System.out.println(numToRu(126));
        System.out.println(numToRu(909));

        //ex8
        System.out.println("----------ex8----------");
        System.out.println(getSha256Hash("password123"));
        System.out.println(getSha256Hash(("Fluffy@home")));
        System.out.println(getSha256Hash("Hey dude!"));

        //ex9
        System.out.println("----------ex9----------");
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(correctTitle("sansa stark, lady of winterfell."));
        System.out.println(correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));

        //ex10
        System.out.println("----------ex10---------");
        System.out.println(hexLattice(1));
        System.out.println(hexLattice(7));
        System.out.println(hexLattice(19));
        System.out.println(hexLattice(21));
    }

    private static int[] encrypt(String message) {
        int[] encodedMessage = new int[message.length()];
        encodedMessage[0] = message.charAt(0);
        for (int i = 1; i < message.length(); i++) {
            encodedMessage[i] = message.charAt(i - 1) - message.charAt(i);
        }
        return encodedMessage;
    }

    private static String decrypt(int[] code) {
        String message = "";
        message += (char) code[0];
        for (int i = 1; i < code.length; i++) {
            message += (char) (message.charAt(i - 1) + code[i]);
        }
        return message;
    }

    private static boolean canMove(String type, String start, String end) {
        char wStart = start.charAt(0);
        int hStart = start.charAt(1);
        char wEnd = end.charAt(0);
        int hEnd = end.charAt(1);

        int deltaW = Math.abs(wStart - wEnd);
        int deltaH = Math.abs(hStart - hEnd);

        switch (type) {
            case ("King"):
                if ((deltaW == 0 || deltaW == 1) || (deltaH == 0 || deltaH == 1)) return true;
                break;
            case ("Rook"):
                if (deltaW == 0 || deltaH == 0) return true;
                break;
            case ("Bishop"):
                if (deltaW == deltaH) return true;
                break;
            case ("Queen"):
                if (deltaW == 0 || deltaH == 0 || deltaW == deltaH) return true;
                break;
            case ("Knight"):
                if ((deltaW == 2 && deltaH == 1) || (deltaW == 1 && deltaH == 2)) return true;
                break;
            case ("Pawn"):
                if (hEnd - hStart == 1 || hEnd - hStart == 2) return true;
                break;
        }
        return false;
    }

    private static boolean canComplete(String letters, String word) {
        String patternString = "";
        for (char ch : letters.toCharArray()) {
            patternString += ch;
            patternString += ".*";
        }
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(word);
        return matcher.find();
    }

    private static int sumDigProd(int... numbers) {
        int n = Arrays.stream(numbers).sum();
        while (n > 10) {
            int newN = 1;
            while (n > 0) {
                newN *= n % 10;
                n = (n - n % 10) / 10;
            }
            n = newN;
        }
        return n;
    }

    private static ArrayList<String> sameVowelGroup(String[] words) {
        ArrayList<String> answer = new ArrayList<>();
        String vowels = "eyuioa";
        String missingVowels = "";
        for (char ch : vowels.toCharArray()) {
            if (words[0].indexOf(ch) == -1) {
                missingVowels += ch;
            }
        }

        for (String word : words) {
            boolean flag = true;
            for (char ch : missingVowels.toCharArray()) {
                if (!(word.indexOf(ch) == -1)) {
                    flag = false;
                }
            }
            if (flag) answer.add(word);
        }
        return answer;
    }

    private static boolean validateCard(Long num) {
        int checkDigit = (int) (num % 10);
        num = (num - num % 10) / 10;
        String numReversed = new StringBuffer(String.valueOf(num)).reverse().toString();
        int[] digitArray = new int[numReversed.length()];
        for (int i = 0; i < numReversed.length(); i++) {
            int digit = numReversed.charAt(i);
            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 10) {
                    digit = (digit % 10) + ((digit - digit % 10) / 10);
                }
            }
            digitArray[i] = digit;
        }
        int sum = Arrays.stream(digitArray).sum();
        return 10 - sum % 10 == checkDigit;
    }

    private static String numToEng(int num) {
        if (num == 0) return "zero";

        String answer = "";
        int hundreds = num / 100;
        int tens = num % 100 / 10;
        int units = num % 10;
        String[][] numbers = new String[][]{new String[]{"zero", "one", "two", "three", "fore", "five", "six", "seven", "eight", "nine"},
                new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"},
                new String[]{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"}
        };


        if (hundreds > 0) answer += numbers[0][hundreds] + " hundred ";

        if (tens == 1) {
            answer += numbers[1][units];
            return answer;
        }

        if (tens > 1) answer += numbers[2][units] + " ";
        if (units > 0) answer += numbers[0][units];
        return answer;
    }

    private static String numToRu(int num) {
        if (num == 0) return "ноль";

        String answer = "";
        int hundreds = num / 100;
        int tens = num % 100 / 10;
        int units = num % 10;
        String[][] numbers = new String[][]{new String[]{"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
                new String[]{"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"},
                new String[]{"", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"},
                new String[]{"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"}
        };
        if (hundreds > 0) answer += numbers[3][hundreds] + " ";

        if (tens == 1) {
            answer += numbers[1][units];
            return answer;
        }

        if (tens > 1) answer += numbers[2][tens] + " ";
        if (units > 0) answer += numbers[0][units];
        return answer;
    }

    private static String getSha256Hash(String str) {
        return Hashing.sha256().hashString(str, StandardCharsets.UTF_8).toString();
    }

    private static String correctTitle(String title) {
        String[] words = title.split(" ");
        String newTitle = "";
        for (String word : words) {
            word = word.toLowerCase();
            if (!(word.equals("and") || word.equals("the") || word.equals("of") || word.equals("in"))) {
                char firstChar = Character.toUpperCase(word.charAt(0));
                word = firstChar + word.substring(1);
            }
            newTitle += word + " ";
        }
        return newTitle;
    }

    private static String hexLattice(int size) {
        int n = 1;
        int i = 1;
        while (n < size) {
            n += 6 * i;
            i++;
        }
        if (n != size) return "Invalid";
        String answer = "";
        int stringLen = i * 4 - 3;
        for (int j = 0; j < i; j++) {
            answer = drowLine(i, answer, stringLen, j);
        }
        for (int j = i - 2; j >= 0; j--) {
            answer = drowLine(i, answer, stringLen, j);
        }

        return answer;
    }

    private static String drowLine(int i, String answer, int stringLen, int j) {
        int spaces = (stringLen - (i + j) * 2 + 1) / 2;
        for (int k = 0; k < spaces; k++) answer += " ";
        for (int k = 0; k < i + j; k++) answer += "o ";
        answer += "\n";
        return answer;
    }

}
