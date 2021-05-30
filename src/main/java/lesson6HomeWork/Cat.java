package lesson6HomeWork;

public class Cat extends Animal{
    private static int countCats;

    public Cat(String name){
        super(name);
        countCats+=1;
    }

    public int getCountCats() {
        return countCats;
    }

    @Override
    public void run (int distance){
        if(distance<200 && distance>0){
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
