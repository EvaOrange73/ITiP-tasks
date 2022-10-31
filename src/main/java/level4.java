import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class level4 {
    public static void main(String[] args) {
        //ex1
        System.out.println("----------ex1----------");
        System.out.println(text_processor(10, 7, "hello my name is Bessie and this is my essay"));

        //ex2
        System.out.println("----------ex2----------");
        System.out.println(split("()()()"));
        System.out.println(split("((()))"));
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(split("((())())(()(()()))"));

        //ex3
        System.out.println("----------ex3----------");
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(toSnakeCase("helloEdabit"));
        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(toSnakeCase("getColor"));

        //ex4
        System.out.println("----------ex4----------");
        System.out.println(overTime(new double[]{9, 17, 30, 1.5}));
        System.out.println(overTime(new double[]{16, 18, 30, 1.8}));
        System.out.println(overTime(new double[]{13.25, 15, 30, 1.5}));

        //ex5
        System.out.println("----------ex5----------");
        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println(BMI("55 kilos", "1.65 meters"));
        System.out.println(BMI("154 pounds", "2 meters"));

        //ex6
        System.out.println("----------ex6----------");
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));

        //ex7
        System.out.println("----------ex7----------");
        System.out.println(toStarShorthand("abbccc"));
        System.out.println(toStarShorthand("77777geff"));
        System.out.println(toStarShorthand("abc"));
        System.out.println(toStarShorthand(""));

        //ex8
        System.out.println("----------ex8----------");
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println(doesRhyme("You are off to the races", "a splendid day."));
        System.out.println(doesRhyme("and frequently do?", "you gotta move."));

        //ex9
        System.out.println("----------ex9----------");
        System.out.println(trouble(451999277, 41177722899L));
        System.out.println(trouble(1222345, 12345));
        System.out.println(trouble(666789, 12345667));
        System.out.println(trouble(33789, 12345337));

        //ex10
        System.out.println("----------ex10---------");
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println(countUniqueBooks("ZZABCDEF", 'Z'));
    }

    private static String text_processor(int n, int k, String text) {
        String[] words = text.split(" ");
        String answer = "";
        int len = 0;
        for (String word : words) {
            len += word.length();
            if (len <= k) {
                if (answer.isEmpty()) {
                    answer += word;
                } else {
                    answer += " " + word;
                }
            } else {
                answer += "\n" + word;
                len = word.length();
            }
        }
        return answer;
    }

    private static ArrayList<String> split(String brackets) {
        ArrayList<String> answer = new ArrayList<String>();
        int open = 0;
        int close = 0;
        String cluster = "";
        for (char bracket : brackets.toCharArray()) {
            if (bracket == '(') open++;
            else if (bracket == ')') close++;
            cluster += bracket;
            if (open == close) {
                answer.add(cluster);
                cluster = "";
                open = 0;
                close = 0;
            }
        }
        return answer;
    }

    private static String toCamelCase(String text) {
        String answer = "";
        boolean f = false;
        for (char ch : text.toCharArray()) {
            if (ch == '_') {
                f = true;
            } else {
                if (f) {
                    answer += Character.toUpperCase(ch);
                    f = false;
                } else answer += ch;
            }

        }
        return answer;
    }

    private static String toSnakeCase(String text) {
        String answer = "";
        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                answer += "_" + Character.toLowerCase(ch);
            } else {
                answer += ch;
            }
        }
        return answer;
    }

    private static String overTime(double[] data) {
        float time = 17 - 9;
        float overtime = 0;
        if (data[0] < 9) { //сверхурочные утренние часы
            overtime += 9 - data[0];
        } else {
            time -= data[0] - 9;
        }

        if (data[1] > 17) { //сверхурочные утренние часы
            overtime += data[1] - 17;
        } else {
            time -= 17 - data[1];
        }
        return "$" + (time + overtime * data[3]) * data[2];
    }

    private static String BMI(String weight, String height){
        double w = Double.parseDouble(weight.split(" ")[0]);
        if (Objects.equals(weight.split(" ")[1], "pounds")) w /= 2.205;
        double h = Double.parseDouble(height.split(" ")[0]);
        if (Objects.equals(height.split(" ")[1], "inches")) h /= 39.37;
        double bmi = w / h / h;
        if (bmi < 18.5) return String.format("%.1f", bmi) + " Underweight";
        if (bmi < 24.9) return String.format("%.1f", bmi) + " Normal weight";
        return String.format("%.1f", bmi) + " Overweight";
    }

    private static int bugger(int n){
        if (n < 10) return 0;
        int m = 1;
        while (n > 0){
            m *= n % 10;
            n = (n - n % 10) / 10;
        }
        return bugger(m) + 1;
    }

    private static String toStarShorthand(String str){
        if (str.isEmpty()) return "";
        String answer = "";
        char currentCharacter = str.charAt(0);
        int k = 0;
        str += '*';
        for (char ch : str.toCharArray()){
            if (ch == currentCharacter) k += 1;
            else {
                answer += currentCharacter;
                if (k > 1) answer += "*" + k;
                k = 1;
                currentCharacter = ch;
            }
        }
        return answer;
    }

    private static String getVowels(String sentence){
        String[] words = sentence.split(" ");
        String last_word = words[words.length - 1].toLowerCase();
        return last_word.replaceAll("[^eyuioa]", "");
    }

    private static boolean doesRhyme(String first, String second){
        return Objects.equals(getVowels(first), getVowels(second));
    }

    private static boolean trouble(long num1, long num2){
        String n1 = Long.toString(num1);
        String n2 = Long.toString(num2);
        Pattern pattern1 = Pattern.compile("(\\d)\\1{2}");
        Matcher matcher1 = pattern1.matcher(n1);
        while (matcher1.find()){
            char num = n1.charAt(matcher1.start());
            Pattern pattern2 = Pattern.compile(new String(new char[]{num, num}));
            Matcher matcher2 = pattern2.matcher(n2);
            if (matcher2.find()) return true;
        }
        return false;
    }

    private static int countUniqueBooks(String stringSequence, char bookEnd){
        int uniqCounter = 0;
        boolean flag = false;
        String uniq = "";
        for (char ch: stringSequence.toCharArray()) {
            if (ch == bookEnd){
                flag = !flag;
                if (flag){
                    uniq = "";
                } else {
                    uniqCounter += uniq.length();
                }
            } else if (flag){
                if (uniq.indexOf(ch) == -1) uniq += ch;
            }
        }
        return uniqCounter;
    }
}
