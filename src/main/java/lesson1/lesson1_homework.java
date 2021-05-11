package lesson1;

public class lesson1_homework {

    public static void main(String[] args) {
        printSumSign();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printSumSign(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign(){
        int a = 3;
        int b = -73;

        if (a+b >= 0){
            System.out.println("Сумма положительная");
        }else{
            System.out.println("Сумма отрицателльная");
        }
    }

    public static void printColor(){
        int value = 1000;
        if (value <= 0) {
            System.out.println("Red");
        }else if (0 < value && value <= 100) {
            System.out.println("Yellow");
        } else {
            System.out.println("Green");
        }
    }

    public static void compareNumbers(){
        int a = 5;
        int b = 7;

        if (a >= b){
            System.out.println("a >= b");
        }else{
            System.out.println("a < b");
        }
    }
}
