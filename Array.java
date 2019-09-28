package com.company;

public class Array {

    int length;
    int[] arr;

    Array (int length) {
        this.length = length;
        arr = new int[this.length];
    }

    public void input() {
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.println("Введите " + length + " чисел");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
    }

    public void random() {
        for (int i = 0; i < length; i++)
            arr[i] = -10000 + (int)(Math.random() * 20000);
    }

    public void lrout() {
        for (int i: arr)
            System.out.print(i + " ");
    }

    public void rlout() {
        for (int i = length - 1; i >=0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    public boolean check(int a) {
        int max = Integer.MIN_VALUE;
        int maxCount = 0, aCount = 0;
        for (int i: arr) {
            if (i > max) {
                max = i;
                maxCount = 0;
            }
            if (i == max)
                maxCount++;
            if (i == a)
                aCount++;
        }
        return maxCount > aCount;
    }

    public void ordering() {
        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = index; j < length; j++) {
                if (Math.abs(arr[j]) % 10 == i) {
                    int temp = arr[index];
                    arr[index] = arr[j];
                    arr[j] = temp;
                    index++;
                }
            }
        }
    }
}

