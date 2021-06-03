package lesson7HomeWork;

public class MainClass {
    public static void main(String[] args) {
        Cat cat0 = new Cat("Barsik", 5);
        Plate plate = new Plate(100);
        plate.info();
        cat0.eat(plate);
        plate.info();
        cat0.catInfo();
        plate.addFood(120);
        plate.info();
        Cat[]cats = new Cat[5];
        cats[0] = cat0;
        cats[1] = new Cat("Mursik", 6);
        cats[2] = new Cat("Persik", 7);
        cats[3] = new Cat("Worsik", 8);
        cats[4] = new Cat("Birsik", 9);
        for (Cat cat:cats) {
            cat.eat(plate);
            cat.catInfo();
        }
        plate.info();
    }
}
