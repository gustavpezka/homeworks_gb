package lessons;

import java.util.Arrays;

public class lesson3_homework {
    public static void main(String[] args) {
/////Задание 1
        int[] zerostoheros = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        zerosToHeroes(zerostoheros);
        for (int i = 0; i < zerostoheros.length; i++) {
            System.out.println(zerostoheros[i]);
        }
/////Задание 2
        int[] tohundred = new int[100];
        toHundred(tohundred);
        for (int i = 0; i < tohundred.length; i++) {
            System.out.println(tohundred[i]);
        }
/////Задание 3
        int[] doublelessthansix = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        doubleLessThanSix(doublelessthansix);
        for (int i = 0; i < doublelessthansix.length; i++) {
            System.out.println(doublelessthansix[i]);
        }
/////Задание 4
        int[][] filldiagonals = new int[6][6];
        fillDiagonals(filldiagonals);
        for (int i = 0; i < filldiagonals.length; i++) {
            for (int j = 0; j < filldiagonals[i].length; j++) {
                System.out.print(filldiagonals[i][j]);
            }
            System.out.println();
        }
/////Задание 5
        int len = 10;
        int initialValue = 2;
        for (int i = 0; i < len; i++) {
            System.out.println(returnArray(len,initialValue)[i]);
        }
/////Задание 6
        int[] minmax = {2,5,17,23,86,23,55,3,1,4,67,93};
        minMax(minmax);
/////Задание 7
        int[] checkbalance = {1,1,1,2,1,2,2};
        System.out.println(checkBalance(checkbalance));
/////Задание 8
        int[] shift = {1,2,3,5,7,8,9,3,4};
        shiftArray(shift,5);
    }

    public static void zerosToHeroes (int[] zerostoheros){
        for (int i = 0; i < zerostoheros.length; i++) {
            if (zerostoheros[i] == 0){
                zerostoheros[i] = 1;
            }else if (zerostoheros[i] == 1){
                zerostoheros[i] = 0;
            }
        }
    }

    public static void toHundred (int[] tohundred){
        for (int i = 0; i < 100; i++) {
            tohundred[i] = i+1;
        }
    }

    public static void doubleLessThanSix (int[] doublelessthansix){
        for (int i = 0; i < doublelessthansix.length; i++) {
            if (doublelessthansix[i] < 6){
                doublelessthansix[i] = doublelessthansix[i]*2;
            }
        }
    }

    public static void fillDiagonals (int[][] filldiagonals){
        for (int i = 0; i < filldiagonals.length; i++) {
            filldiagonals[i][i] = 1;
            for (int j = 0; j < filldiagonals[i].length; j++) {
                if (i+j == 5){
                    filldiagonals[i][j] = 1;
                }
            }
        }
    }

    public static int[] returnArray (int len, int initialValue){
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static void minMax(int[] minmax){
        int min = minmax[0];
        int max = minmax[0];
        for (int i = 0; i < minmax.length; i++) {
            if (minmax[i] > max){
                max = minmax[i];
            }
            if (minmax[i] < min){
                min = minmax[i];
            }
        }
        System.out.println("minimum - " + min + " ; maximum - " + max);
    }

    public static boolean checkBalance(int[] checkbalance){
        int sum = 0;
        for (int i = 0; i < checkbalance.length; i++) {
            sum += checkbalance[i];
        }
        if (sum%2 != 0) {
            return false;
        }
        int newsum = 0;
        for (int i = 0; i < checkbalance.length; i++) {
            newsum += checkbalance[i];
            if(newsum == sum/2) {
                return true;
            }
        }
        return false;
    }

    public static void shiftArray(int[] array, int n){
        if (n<0){
            for (int i = n; i < 0; i++) {
                int first = array[0];
                for (int j = 1; j < array.length; j++) {
                    array[j-1] = array[j];
                }
                array[array.length-1] = first;
            }
        }else if (n>0){
            for (int i = 0; i < n; i++) {
                int last = array[array.length-1];
                for (int j = array.length-1; j > 0 ; j--) {
                    array[j] = array[j-1];
                }
                array[0]=last;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
