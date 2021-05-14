package lessons;

public class lesson2_homework {
    public static void main(String[] args) {
        System.out.println(checkSum(5,10));
        checkEvenOdd(436);
        System.out.println(checkNegative(0));
        printStrings("Oppagangnamstyle", 3);
        System.out.println(checkLeapYear(1795));
    }

    public static boolean checkSum(int a, int b){
        if (a+b >= 10 && a+b <= 20){
            return true;
        }else {
            return false;
        }
    }

    public static void  checkEvenOdd(int a){
        if (a % 2 == 0){
            System.out.println("Even");
        }else {
            System.out.println("Odd");
        }
    }

    public static boolean checkNegative(int a){
        if (a >= 0){
            return false;
        }else{
            return true;
        }
    }

    public static void printStrings(String string, int count){
        for (int i = 0; i < count; i++) {
            System.out.println(string);
        }
    }

    public static boolean checkLeapYear(int a){
        if (a % 4 == 0){
            if (a%100 == 0){
                if (a%400==0){
                    return true;
                }else {
                   return false;
                }
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
}
