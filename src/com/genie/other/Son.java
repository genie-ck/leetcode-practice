package com.genie.other;

import java.util.Scanner;

public class Son extends Base {
    public void method() {
        System.out.println("Son");
    }

    public void method1() {
        System.out.println("SonB");
    }

    public static void main(String[] args) {
        Base base = new Base();
        base.method1();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int n = 0;
        int actualSum = 0;
        for (int i = 1; i <= N; i++) {
            int sum = i * i + (i - 1) * (i - 1);
            if (sum <= N) {
                n = i;
                actualSum = sum;
            } else {
                break;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {
            for (int j = 0; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 3; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("实际使用" + actualSum + "剩余" + (N - actualSum));
    }
}
