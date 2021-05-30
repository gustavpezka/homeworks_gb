package lesson6HomeWork;

class Animal {
    public String name;
    public static int animalCount;

    public Animal(String name){
        this.name = name;
        animalCount+=1;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public void run(int distance){
        System.out.println(name + " пробежал " + distance + " метров");
    }

    public void swim(int distance){
        System.out.println(name + " проплыл " + distance + " метров");
    }

}
