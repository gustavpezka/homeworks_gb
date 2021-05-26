package lessons;

class Person {
    private String name;
    private String position;
    private String email;
    private String telephone;
    private int payment;
    private int age;

    Person(String name, String position, String email, String telephone, int payment, int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.payment = payment;
        this.age = age;
    }

    int getAge(){
        return age;
    }

    void printPersonalInfo(){
        System.out.println(this.name + ", " + this.position + ", "
                + this.telephone + ", " + this.email + ", " + this.telephone + ", " + this.payment + ", " + this.age);
    }
}
