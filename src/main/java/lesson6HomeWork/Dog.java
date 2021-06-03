package lesson6HomeWork;

public class Dog extends Animal{
    private static int countDogs;
    private static int maxRunningDistance = 200;
    private static int minRunningDistance = 0;
    private static int minSwimmingDistance = 0;
    private static int maxSwimmingDistance = 10;

    public Dog(String name){
        super(name);
        countDogs+=1;
    }

    public int getCountDogs() {
        return countDogs;
    }

    @Override
    public void run (int distance){
        if(distance<maxRunningDistance && distance>minRunningDistance){
            System.out.println("Пёс " + name + " пробежал " + distance + " метров");
        }else{
            System.out.println("Неверная дистанция");
        }
    }

    @Override
    public void swim(int distance){
        if(distance<maxSwimmingDistance && distance>minSwimmingDistance){
            System.out.println("Пёс " + name + " проплыл " + distance + " метров");
        }else{
            System.out.println("Неверная дистанция");
        }
    }
}
