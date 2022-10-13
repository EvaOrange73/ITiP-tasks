public class level1 {
    public static void main(String[] args) {
        //ex1
        System.out.println("----------ex1----------");
        System.out.println(remainder(1, 3));
        System.out.println(remainder(3, 4));
        System.out.println(remainder(-9, 45));
        System.out.println(remainder(5, 5));

        //ex2
        System.out.println("----------ex2----------");
        System.out.println(triArea(3, 2));
        System.out.println(triArea(7, 4));
        System.out.println(triArea(10, 10));

        //ex3
        System.out.println("----------ex3----------");
        System.out.println(animals(2, 3, 5));
        System.out.println(animals(1, 2, 3));
        System.out.println(animals(5, 2, 8));

        //ex4
        System.out.println("----------ex4----------");
        System.out.println(profitableGamble(0.2, 50, 9));
        System.out.println(profitableGamble(0.9, 1, 2));
        System.out.println(profitableGamble(0.9, 3, 2));

        //ex5
        System.out.println("----------ex5----------");
        System.out.println(operation(24, 15, 9));
        System.out.println(operation(24, 26, 2));
        System.out.println(operation(15, 11, 11));

        //ex6
        System.out.println("----------ex6----------");
        System.out.println(ctoa('A'));
        System.out.println(ctoa('m'));
        System.out.println(ctoa('['));
        System.out.println(ctoa('\\'));

        //ex7
        System.out.println("----------ex7----------");
        System.out.println(addUpTo(3));
        System.out.println(addUpTo(10));
        System.out.println(addUpTo(7));

        //ex8
        System.out.println("----------ex8----------");
        System.out.println(nextEdge(8, 10));
        System.out.println(nextEdge(5, 7));
        System.out.println(nextEdge(9, 2));

        //ex9
        System.out.println("----------ex9----------");
        System.out.println(sumOfCubes(new int[]{1, 5, 9}));
        System.out.println(sumOfCubes(new int[]{3, 4, 5}));
        System.out.println(sumOfCubes(new int[]{2}));
        System.out.println(sumOfCubes(new int[]{}));

        //ex10
        System.out.println("----------ex10---------");
        System.out.println(abcmath(42, 5, 10));
        System.out.println(abcmath(5, 2, 1));
        System.out.println(abcmath(1, 2, 3));

    }

    public static int remainder(int a, int b) {
        return a % b;
    }

    public static int triArea(int a, int h) {
        return a * h / 2;
    }

    public static int animals(int chickens, int cows, int pigs) {
        return chickens * 2 + cows * 4 + pigs * 4;
    }

    public static boolean profitableGamble(double prob, double prize, double pay) {
        return prob * prize > pay;
    }

    public static String operation(int N, int a, int b) {
        if (a + b == N) return "added";
        if (a - b == N || b - a == N) return "subtracted";
        if (a * b == N) return "multiplied";
        if (a / b == N || b / a == N) return "divided";
        return "none";
    }

    public static int ctoa(char a) {
        return (int) a;
    }

    public static int addUpTo(int x) {
        int answer = 0;
        for (int i = 1; i <= x; i++) {
            answer += i;
        }
        return answer;
    }

    public static int nextEdge(int a, int b) {
        return a + b - 1;
    }

    public static int sumOfCubes(int[] a) {
        int answer = 0;
        for (int i : a) {
            answer += Math.pow(i, 3);
        }
        return answer;
    }

    public static boolean abcmath(int a, int b, int c){
        for (int i = 0; i < b; i++){
            a += a;
        }
        return a % c == 0;
    }
}
