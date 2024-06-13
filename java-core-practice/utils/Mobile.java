package utils;
class Mobile{
    int price;
    String brand;
    // static variable 
    static String name;

    static {
        name = "Phone";
        System.out.println("in static block");
    }

    Mobile(){
        price = 1000;
        brand = "jdjd";
        System.out.println("in constructor");
    }
    public void show() {
        System.out.println(brand + " " + price + " " + name);
        
    }
    // static method
    public static void show1() {
        System.out.println("In static method");
        // cannot access non static variables here only static variables are allowed, only way possible is to pass the object as argument in the static method
        System.out.println();
    }
    public static void show1(Mobile obj) {
        System.out.println("In static method");
        // cannot access non static variables here only static variables are allowed, only way possible is to pass the object as argument in the static method
        System.out.println(obj.brand + " " + obj.price + " " + name);
    }

}
