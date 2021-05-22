package lessons;

import java.util.Arrays;

public class lesson3_homework {
    public static void main(String[] args) {
/////Задание 1
        int[] arrayZerosToHeroes = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        zerosToHeroes(arrayZerosToHeroes);
        System.out.println(Arrays.toString(arrayZerosToHeroes));

/////Задание 2
        int[] arrayToHundred = new int[100];
        toHundred(arrayToHundred);
        System.out.println(Arrays.toString(arrayToHundred));
/////Задание 3
        int[] arrayDoubleLessThanSix = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        doubleLessThanSix(arrayDoubleLessThanSix);
        System.out.println(Arrays.toString(arrayToHundred));
/////Задание 4
        int[][] arrayFillDiagonals = new int[6][6];
        fillDiagonals(arrayFillDiagonals);
        for (int i = 0; i < arrayFillDiagonals.length; i++) {
            for (int j = 0; j < arrayFillDiagonals[i].length; j++) {
                System.out.print(arrayFillDiagonals[i][j]);
            }
            System.out.println();
        }
/////Задание 5
        int len = 10;
        int initialValue = 2;
        System.out.println(Arrays.toString(returnArray(len,initialValue)));
/////Задание 6
        int[] minmax = {2,5,17,23,86,23,55,3,1,4,67,93};
        minMax(minmax);
/////Задание 7
        int[] checkbalance = {1,1,1,2,1,2,2,10};
        System.out.println(checkBalance(checkbalance));
/////Задание 8
        int[] shift = {1,2,3,5,7,8,9,3,4};
        shiftArray(shift,5);
    }

    public static void zerosToHeroes (int[] arrayZerosToHeroes){
        for (int i = 0; i < arrayZerosToHeroes.length; i++) {
            if (arrayZerosToHeroes[i] == 0){
                arrayZerosToHeroes[i] = 1;
            }else if (arrayZerosToHeroes[i] == 1){
                arrayZerosToHeroes[i] = 0;
            }
        }
    }

    public static void toHundred (int[] arrayToHundred){
        for (int i = 0; i < 100; i++) {
            arrayToHundred[i] = i+1;
        }
    }

    public static void doubleLessThanSix (int[] arrayDoubleLessThanSix){
        for (int i = 0; i < arrayDoubleLessThanSix.length; i++) {
            if (arrayDoubleLessThanSix[i] < 6){
                arrayDoubleLessThanSix[i] = arrayDoubleLessThanSix[i]*2;
            }
        }
    }

    public static void fillDiagonals (int[][] arrayFillDiagonals){
        for (int i = 0; i < arrayFillDiagonals.length; i++) {
            arrayFillDiagonals[i][i] = 1;
            for (int j = 0; j < arrayFillDiagonals[i].length; j++) {
                if (i+j == 5){
                    arrayFillDiagonals[i][arrayFillDiagonals.length - 1 - i] = 1;
                }
            }
        }
    }

    public static int[] returnArray (int len, int initialValue){
        int[] array = new int[len];
        Arrays.fill(array,initialValue);
        return array;
    }

    public static void minMax(int[] arrayMinMax){
        int min = arrayMinMax[0];
        int max = arrayMinMax[0];
        for (int i = 0; i < arrayMinMax.length; i++) {
            if (arrayMinMax[i] > max){
                max = arrayMinMax[i];
            }
            if (arrayMinMax[i] < min){
                min = arrayMinMax[i];
            }
        }
        System.out.println("minimum - " + min + " ; maximum - " + max);
    }

    public static boolean checkBalance(int[] checkbalance){
        int newsum = 0;
        int sum = Arrays.stream(checkbalance).sum();
        for (int i = 0; i < checkbalance.length; i++) {
            newsum += checkbalance[i];
            System.out.println(newsum);
            if(newsum == sum/2 && sum%2 == 0) {
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
        System.out.println(Arrays.toString(array));
    }
}
