package com.codeHeap.threads.Fibonacci;


public class Fibonacci {

    public int fibonacci1(int n) {
        if (n < 2) {
            return 1;
        }
        int[] results = new int[n + 1];
        results[0] = 1;
        results[1] = 1;
        for (int i = 2; i <= n; i++) {
            results[i] = results[i - 1] + results[i - 2];
        }
        return results[n];
    }

    public int fibonacci2(int n) {
        int before = 0;
        int last = 1;

        for (int i = 0; i < n; i++) {
            last = last + before;
            before = last - before;
        }
        return last;
    }

    public int fibonacci3(int n) {
        if (n < 2) {
            return 1;
        }
        return fibonacci3(n - 1) + fibonacci3(n - 2);
    }

    public int fibonacci4(int n) {
        int[][] result = {{1, 0}, {0, 1}};
        int[][] mat = {{0, 1}, {1, 1}};

        while (n > 0) {
            if ((1 & n) == 1) {
                --n;
                result = mult(result, mat);
            }
            mat = mult(mat, mat);
            n >>= 1;
        }

        return result[1][1];
    }

    private int[][] mult(int[][] first, int[][] second) {

        int[][] result = new int[first.length][second[0].length];

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second[0].length; j++) {
                for (int k = 0; k < second[0].length; k++) {
                    result[i][j] += first[i][k] * second[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        for (int i = 0; i < 20; i++) {
            System.out.println(
                    fib.fibonacci1(i) + " " +
                            fib.fibonacci2(i) + " " +
                            fib.fibonacci3(i) + " " +
                            fib.fibonacci4(i)
            );
        }

        int[][] m0 = {{1, 0}, {0, 1}};
        int[][] matr = fib.mult(m0,
                new int[][]{
                        new int[]{0, 1},
                        new int[]{1, 1}
                });

        for (int i = 0; i < matr.length; i++) {
            for (int i1 = 0; i1 < matr[0].length; i1++) {
                System.out.print(matr[i][i1] + ", ");
            }
            System.out.println();
        }
    }
}
