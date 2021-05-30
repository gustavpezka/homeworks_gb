package lesson6HomeWork;

public class testingOnAnimalsIsUnethical {

    public static void main(String[] args) {
        Animal animal = new Animal("RAAAGH!!!");
        Animal animal1 = new Animal("RAAAGH!!!");
        Animal animal2 = new Animal("RAAAGH!!!");
        Cat cat = new Cat("Fifi");
        Cat cat1 = new Cat("Fufu");
        Cat cat2 = new Cat("Fafa");
        Cat cat3 = new Cat("Fefe");
        Cat cat4 = new Cat("Fofo");
        cat.swim(150);
        cat.run(150);
        Dog dog = new Dog("Bobo");
        Dog dog1 = new Dog("Baba");
        Dog dog2 = new Dog("Bebe");
        Dog dog3 = new Dog("Bubu");
        Dog dog4 = new Dog("Bibi");
        dog.run(400);
        dog.swim(5);
        System.out.println(dog.getCountDogs());
        System.out.println(cat.getCountCats());
        System.out.println(cat.getAnimalCount());
    }
}
