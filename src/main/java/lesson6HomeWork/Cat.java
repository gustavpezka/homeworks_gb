package lesson6HomeWork;

public class Cat extends Animal{
    private static int countCats;
    private static int maxRunningDistance = 200;
    private static int minRunningDistance = 0;

    public Cat(String name){
        super(name);
        countCats+=1;
    }

    public int getCountCats() {
        return countCats;
    }

    @Override
    public void run (int distance){
        if(distance<maxRunningDistance && distance>minRunningDistance){
            System.out.println("Кот " + name + " пробежал " + distance + " метров");
        }else{
            System.out.println("Неправильная дистанция");
        }
    }

    @Override
    public void swim(int distance){
        System.out.println("Не умеет плавать");
    }
}
