package lesson6HomeWork;

public class Dog extends Animal{
    private static int countDogs;

    public Dog(String name){
        super(name);
        countDogs+=1;
    }

    public int getCountDogs() {
        return countDogs;
    }

    @Override
    public void run (int distance){
        if(distance<500 && distance>0){
            System.out.println("Пёс " + name + " пробежал " + distance + " метров");
        }else{
            System.out.println("Неверная дистанция");
        }
    }

    @Override
    public void swim(int distance){
        if(distance<10 && distance>0){
            System.out.println("Пёс " + name + " проплыл " + distance + " метров");
        }else{
            System.out.println("Неверная дистанция");
        }
    }
}
