package utils;
class Human {
    private String name;
    private int age;

    public Human() {
        name = "John";
        age = 12;
        System.out.println("Default Constructor");
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Parameterised Constructor");
    }

    // getters
    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    // setters
    public void setAge(int age){
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }
}
