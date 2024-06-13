// imports all the files in the package utils, but not folders inside
// import utils.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// class Mobile{
//     int price;
//     String brand;
//     // static variable 
//     static String name;

//     static {
//         name = "Phone";
//         System.out.println("in static block");
//     }

//     Mobile(){
//         price = 1000;
//         brand = "jdjd";
//         System.out.println("in constructor");
//     }
//     public void show() {
//         System.out.println(brand + " " + price + " " + name);
        
//     }
//     // static method
//     public static void show1() {
//         System.out.println("In static method");
//         // cannot access non static variables here only static variables are allowed, only way possible is to pass the object as argument in the static method
//         System.out.println();
//     }
//     public static void show1(Mobile obj) {
//         System.out.println("In static method");
//         // cannot access non static variables here only static variables are allowed, only way possible is to pass the object as argument in the static method
//         System.out.println(obj.brand + " " + obj.price + " " + name);
//     }

// }

// // Encapsulation

// class Human {
//     private String name;
//     private int age;

//     public Human() {
//         name = "John";
//         age = 12;
//         System.out.println("Default Constructor");
//     }

//     public Human(String name, int age) {
//         this.name = name;
//         this.age = age;
//         System.out.println("Parameterised Constructor");
//     }

//     // getters
//     public int getAge(){
//         return age;
//     }

//     public String getName(){
//         return name;
//     }

//     // setters
//     public void setAge(int age){
//         this.age = age;
//     }

//     public void setName(String name){
//         this.name = name;
//     }
// }

// // Inheritance with single and multilevel inheritence

// class Calculator{
//     public int add(int n1, int n2) {
//         return n1 + n2;
//     }
//     public int sub(int n1, int n2) {
//         return n1 - n2;
//     }
// }

// class AdvancedCalculator extends Calculator{
//     public long mul(int n1, int n2) {
//         return n1 * n2;
//     }
//     public double div(int n1, int n2) {
//         return n1 / (double)n2;
//     }
// }

// class VeryAdvancedCalculator extends AdvancedCalculator{
//     public double power(int n1, int n2) {
//         return Math.pow(n1, n2);
//     }
    
// }

// this and super keyword

// class A{
//     public A(){
//         super();
//         System.out.println("In A");
//     }
//     public A(int n){
//         super();
//         System.out.println("In A int");
//     }
// }

// class B extends A{
//     public B(){
//         super();
//         System.out.println("in B");
//     }
//     public B(int n){
//         this();
//         // super(n);
//         System.out.println("in B int");
//     }
// }

// Method Overriding (Runtime Polymorphism)

// Method Overloading (Compile time Polymorphism)

// class A {
//     public void show() {
//         System.out.println("In A show");
//     }
// }

// class B extends A {
//     public void show() {
//         System.out.println("In B show");
//     }
// }

// // Example Dynamic Method Dispatch

// class A{
//     public void show() {
//         System.out.println("in A show");
//     }
// }

// class B extends A{
//     public void show() {
//         System.out.println("in B show");
//     }
// }

// class C extends A{
//     public void show() {
//         System.out.println("in C show");
//     }
// }

// // Object class methods demo

// class Laptop{
//     String model;
//     int price;

//     @Override
//     public String toString() {
//         return "Laptop [model=" + model + ", price=" + price + "]";
//     }

//     @Override
//     public int hashCode() {
//         final int prime = 31;
//         int result = 1;
//         result = prime * result + ((model == null) ? 0 : model.hashCode());
//         result = prime * result + price;
//         return result;
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj)
//             return true;
//         if (obj == null)
//             return false;
//         if (getClass() != obj.getClass())
//             return false;
//         Laptop other = (Laptop) obj;
//         if (model == null) {
//             if (other.model != null)
//                 return false;
//         } else if (!model.equals(other.model))
//             return false;
//         if (price != other.price)
//             return false;
//         return true;
//     }

//     // public boolean equals(Laptop l) {
//     //     return this.model == l.model && this.price == l.price;
//     // }
// }

// Upcasting and Downcasting

// class A{
//     public void show1() {
//         System.out.println("in A show");
//     }
// }

// class B extends A{
//     public void show2() {
//         System.out.println("in B show");
//     }
// }

// // abstract keyword

// abstract class Car{
//     // creates abstract class which we don't want to implement in the car class, but will describe in the child classes
//     public abstract void drive();
//     public abstract void fly();
//     public void playmusic(){
//         System.out.println("play music");
//     }
// }

// abstract class Nexon extends Car{
//     public void drive() {
//         System.out.println("Driving Nexon");
//     }
// }

// class AdvNexon extends Nexon{ // concrete class
//     public void fly() {
//         System.out.println("flying Nexon");
//     }
// }

// Inner class

// class A {
//     int age;
//     public void show(){
//         System.out.println("in A class");
//     }
//     // Inner class
//     class B {
//         public void config(){
//             System.out.println("In B config");
//         }
//     }
// }

// class A2 {
//     int age;
//     public void show(){
//         System.out.println("in A2 class");
//     }
//     // Inner class
//     // we can define inner class as static but not the outer class
//     static class B2 {
//         public void config(){
//             System.out.println("In B2 config");
//         }
//     }
// }

// Anonymous Inner Class 
// class A{
//     public void show(){
//         System.out.println("In A show");
//     }
// }

// Anonymous inner class for an abstract class defining the abstract method

// abstract class A{
//     public abstract void show();
// }

// Interfaces examples

// Implementation 1 using abstract classes

// abstract class Computer{
//     public abstract void code();
// }

// class Laptop extends Computer{
//     public void code(){
//         System.out.println("code, compile and run in Laptop");
//     }
// }

// class Desktop extends Computer{
//     public void code(){
//         System.out.println("code, compile and run in Desktop");
//     }
// }

// class Developer{
//     public void devapp(Computer c){
//         c.code();
//     }
// }

// Implementation 2 using Interfaces


// interface Computer{
//     void code();
// }

// class Laptop implements Computer{
//     public void code(){
//         System.out.println("code, compile and run in Laptop");
//     }
// }

// class Desktop implements Computer{
//     public void code(){
//         System.out.println("code, compile and run in Desktop");
//     }
// }

// class Developer{
//     public void devapp(Computer c){
//         c.code();
//     }
// }

// More interfaces examples

// interface  A{

//     int age=23; // by default they are final and static
//     String area="Bangalore";

//     void show();
//     void config();
// }

// interface  X {
//     void run();
// }

// interface  Y extends X {
//     void gym();
// }

// // We can implement multiple interfaces in one class also

// class B implements A,Y{

//     public void show() {
//         System.out.println("In B show");
//     }

//     public void config() {
//         System.out.println("In B config");
//     }

//     public void run() {
//         System.out.println("In B running");
//     }

//     public void gym() {
//         System.out.println("In B gym..");
//     }
    
// }

// enums = they are like classes, and the values are the objects

// enum Status{
//     Running, Failed, Pending, Success
// }

// enum Laptop{
//     Macbook(2000), XPS(1500), Lenovo(1000), ThinkPad(1800), Surface;
//     private int price;

//     private Laptop(){

//     }

//     private Laptop(int price) {
//         this.price = price;
//     }

//     public int getPrice() {
//         return price;
//     }

//     public void setPrice(int price) {
//         this.price = price;
//     }
// }

// this is used to declare only single method interfaces, otherwise throws errors
// can use lambda expression with only FunctionalInterface
// @FunctionalInterface
// interface A {
//     void show(int i);
// }

// interface B {
//     int add(int i, int j);
// }

// Custom Exception

// class MyException extends RuntimeException{
//     MyException(String str){
//         super(str);
//     }
// }

// Threads
// class A extends Thread{
//     public void run(){
//         for(int i = 1; i <= 10; i++) {
//             System.out.println("Hi");
//             try {
//                 Thread.sleep(10);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }

// class B extends Thread{
//     public void run(){
//         for(int i = 1; i <= 10; i++) {
//             System.out.println("Hello");
//             try {
//                 Thread.sleep(10);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }

// Runnable vs Thread

// class A implements Runnable{
//     public void run(){
//         for(int i = 1; i <= 10; i++) {
//             System.out.println("Hi");
//             try {
//                 Thread.sleep(10);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }

// class B implements Runnable{
//     public void run(){
//         for(int i = 1; i <= 10; i++) {
//             System.out.println("Hello");
//             try {
//                 Thread.sleep(10);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }

// Race Condition

// class Counter{
//     int count;
//     public synchronized void increment(){
//         count++;
//     }
// }

public class Demo {
    public static void main(String[] args) throws NumberFormatException, IOException{
        try{
            Class.forName("Demo");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Class not found : " + e);
        }
        // int num[] = {1,2,3};
        // int num2[] = new int[4]; // by default all values are zeros, fixed sized array
        // for(int i = 0; i < num.length; i++) {
        //     System.out.println(num2[i]);
        // }

        // 2D array
        // int num3[][] = new int[3][4];

        // for(int i = 0; i < num3.length; i++) {
        //     for(int j = 0; j < num3[i].length; j++) {
        //         num3[i][j] = (int)(Math.random() * 100);
        //         System.out.print(num3[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // for(int n[]: num3) {
        //     for(int m: n) {
        //         System.out.print(m + " ");
        //     }
        //     System.out.println();
        // }

        // jagged array with variable second dimention
        // int num4[][] = new int[3][];

        // for(int i = 0; i < num4.length; i++) {
        //     num4[i] = new int[(int)(Math.random() * 10) + 1];
        // }

        // for(int n[]: num4) {
        //     for(int m: n) {
        //         System.out.print(m + " ");
        //     }
        //     System.out.println();
        // }

        // object array
        // Student students[] = new Student[4]; // initialised with null address
        // String name[] = {"ramesh", "suresh", "nitin", "rajesh"};

        // for (int i = 0; i < students.length; i++) {
        //     Student s = new Student();
        //     s.rollno = i + 1;
        //     s.marks = (int) (Math.random() * 100);
        //     s.name = name[i];
        //     students[i] = s;
        //     System.out.println(students[i]);
        // }
        
        // Strings
        // They are immutable by default
        // to create mutable strings use StringBuffer or StringBuilder
        // String name = new String("navin");

        // System.out.println(name);
        // System.out.println(name.hashCode());
        // System.out.println("Hello " + name);
        // System.out.println(name.charAt(0));
        // System.out.println(name.concat(" kumar"));

        // name = name + " kumar"; // works mutable string, but it is not the same object
        // System.out.println(name);

        // // here both variables are pointing to same addresses, only one object is there
        // String s1 = "Navin";
        // String s2 = "Navin";
        // System.out.println(s1 == s2);

        // String Buffer
        // Difference between StringBuilder and StringBuffer is that StringBuilder is slow but threadsafe, but StringBuffer is not threadsafe, usually faster than StringBuilder 

        // StringBuffer sb = new StringBuffer("Navin");

        // sb.append(" Reddy");
        // sb.insert(6, "Java ");
        // sb.setLength(30);
        // sb.ensureCapacity(100);

        // String s = sb.toString();

        // System.out.println(s);

        // System.out.println(sb);

        // static variables

        // Mobile m1 = new Mobile();
        // m1.brand = "Apple";
        // m1.price = 1500;
        // Mobile m2 = new Mobile();
        // m2.brand = "Samsung";
        // m2.price = 1700;
        // // m1.name = "SmartPhone";
        // Mobile.name = "SmartPhone";
        // Mobile.name = "Phone";
        // m1.show();
        // m2.show();
        // static method
        // Mobile.show1(m1);
        // m1.show1();

        // static block, variables are intialised only once, when new objects are created
        // class loader in jvm loads the class once and thereafter objects are created
        // so to load the class without object creation we can use Class.forName() method
        
        // Class.forName("Mobile");
        // Mobile m3 = new Mobile();
        // Mobile m4 = new Mobile();
        // Mobile m5 = new Mobile();

        // Encapsulation, getters and setters and this keyword

        // Human h1 = new Human();
        // h1.setAge(11);
        // h1.setName("akshat");

        // System.out.println(h1.getName() + " : " + h1.getAge());
        

        // Default and Parameterised Constructor

        // Human h2 = new Human();
        // Human h3 = new Human("Navin",13);
        
        // System.out.println(h2.getName() + " : " + h2.getAge());
        // System.out.println(h3.getName() + " : " + h3.getAge());

        // Anonymous Object, we can directly call methods as well, no way to use the object again

        // new Human();
        // new Mobile().show();

        // Inheritance examples

        // AdvancedCalculator obj = new AdvancedCalculator();
        
        // System.out.println( obj.add(2, 3) + " " + obj.sub(5, 2) + " " + obj.mul(2, 8) + " " + obj.div(15,4));

        // VeryAdvancedCalculator obj2 = new VeryAdvancedCalculator();

        // System.out.println( obj2.add(2, 3) + " " + obj2.sub(5, 2) + " " + obj2.mul(2, 8) + " " + obj2.div(15,4) + " " + obj2.power(2, 4));


        // this() => calls current class constructor and super() => calls parent class constructor

        // B b = new B(5);
        // In A int
        // in B int

        // B b = new B(5);
        // In A
        // in B
        // in B int

        // Method Overriding 
        // if same function is in both class child and parent then the method in the child class is always preferrable otherwise it will look for the method in the parent class

        // B b = new B();
        // b.show();

        // Dynamic Method Dispatch 
        // this works only in case of inheritence not the non-sub classes

        // A obj = new A();
        // obj.show(); 

        // obj = new B();
        // obj.show();  

        // obj = new C();
        // obj.show();   

        // output
        // in A show
        // in B show
        // in C show


        // // object class demo

        // Laptop l = new Laptop();
        // l.model = "Lenovo";
        // l.price = 1000;
        // // System.out.println(l.toString());

        // Laptop l2 = new Laptop();
        // l2.model = "Lenovo";
        // l2.price = 1000;

        // System.out.println(l); // it will invoke the toString() method from Object class which we can override in the child class

        // boolean res = l.equals(l2); // by default it will return false but we can override this method as well
        // System.out.println(res); // will print yes due to method overriding
        // // generate them using IDE source actions


        // Upcasting and Downcasting

        // A obj = (A) new B(); // Upcasting to a super class happens implicitly
        // obj.show1();
        // // obj.show2(); // cannot do this

        // B obj2 = (B) obj; // Downcasting obj to sub class to access show2 method
        // obj2.show1();
        // obj2.show2();

        // Wrapper classes => primitive to object classes

        // int num = 7;
        // Integer num1 = num; // this is called autoboxing means storing a primitive variable value in an corresponding wrapper object 
        // int num2 = num1.intValue(); // unboxing
        // num2 = num1; // autounboxing
        // System.out.println(num2); 

        // String str = "12";
        // int num3 = Integer.parseInt(str);
        // System.out.println(num3 * 2);


        // abstract keyword
        // can't create of an instance of abstract class, however we can create a reference of the class

        // Car c = new Car(); // Not possible
        // Car n = new Nexon(); // possible 
        // n.drive();
        // n.playmusic();
        // Nexon nxc = new Nexon();
        // nxc.drive();
        // nxc.playmusic();
        // AdvNexon advnx = new AdvNexon();
        // advnx.fly();
        // advnx.drive();
        // advnx.playmusic();

        // Inner Class 
        // A obj = new A();
        // obj.show();

        // A.B obj1 = obj.new B();
        // obj1.config();

        // A2.B2 obj2 = new A2.B2();
        // obj2.config();

        // Anonymous Inner Class
        // Useful to modify or override a method output for once without inheritance 
        // A obj = new A(){
        //     public void show(){
        //         System.out.println("In new Inner show");
        //     }
        // };
        // obj.show();

        // Anonymous inner class for an abstract class defining the abstract method

        // A obj = new A(){
        //     public void show(){
        //         System.out.println("In A show");
        //     }
        // };
        // obj.show();

        // Interfaces example
        // to create loosely coupled code, like here developer can develop app in desktop as well as laptop

        // Computer lap = new Laptop();
        // Computer desk = new Desktop();
        // Developer d = new Developer();
        // d.devapp(lap);
        // d.devapp(desk);

        // Interfaces examples

        // A obj = new B();
        // obj.show();
        // obj.config();
        
        // Y obj1 = (Y) obj;
        // obj1.run();
        // obj1.gym();
        // System.out.println(A.area);

        // enums
        // Status s = Status.Running;
        // System.out.println(s);
        // System.out.println(s.ordinal()); // gives the positional index in enum

        // Status[] ss = Status.values(); // gives all the values in a list
        // System.out.println(ss); // [LStatus;@7ad041f3
        // for(Status i : ss){
        //     System.out.println(i + " : " + i.ordinal()); // will give the output or ss[i] where i is array index value
        // }

        // Laptop lap = Laptop.Macbook;
        // // lap.setPrice(2990);
        // System.out.println(lap + " : " + lap.getPrice());

        // Laptop lap1 = Laptop.Surface;
        // lap1.setPrice(1500);
        // for(Laptop lap : Laptop.values()) {
        //     System.out.println(lap + " : " + lap.getPrice());
        // }

        // Use Annotations to get compiler directives and remove silly mistakes in coding 
        // like @Override to the method you are overriding

        // FunctionalInterface and Lambda expressions
        // A obj = () -> {
        //     System.out.println("In A show");
        // };
        // int i = 5;
        // A obj = x -> System.out.println("In A show : " + x);
        // obj.show(i);

        // B obj2 = (x,y) -> (x + y);
        // System.out.println(obj2.add(4,3));

        // int i = 20, j = 0;
        // int a[] = new int[5];
        // String str = null;
        // try {
        //     // System.out.println(str.length());
        //     j = 18 / i;
        //     if(j == 0)
        //         // throw new ArithmeticException();
        //         throw new MyException("Please select a divisor value less than 20");

        //     // System.out.println(a[5]);
        // }
        // catch(MyException e) {
        //     System.out.println(e);
        // }
        // catch(ArithmeticException e){
        //     // System.out.println("Cannot Divide by zero");
        //     j = 1;
        //     System.out.println("This is default value of j");
        // }
        // catch(ArrayIndexOutOfBoundsException e) {
        //     // System.out.println("Index out of bound, length of array is " + a.length);
        // }
        // catch(Exception e) {
        //     System.out.println("Error: " + e);
        // }
        // System.out.println(j);
        // // System.out.println("Division Done");


        // User input using BufferedReader and Scanner reading an integer value

        // single character read
        // System.out.println("Enter a number:");
        // try {
        //     int num = System.in.read(); // takes only one charater typed
        //     // gives ascii value of the character typed
        //     System.out.println(num);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        // Using BufferedReader
        // InputStreamReader in = new InputStreamReader(System.in);
        // BufferedReader bf = new BufferedReader(in);
        // System.out.println(bf.readLine());
        // int num = Integer.parseInt(bf.readLine());
        // System.out.println(num);
        // bf.close();

        // Using Scanner
        // Scanner sc = new Scanner(System.in);
        // int num = sc.nextInt();
        // System.out.println(num);
        // sc.close();

        // using finally

        // int i = 0, j = 0;
        // int num = 0;
        // Scanner sc = null;
        // try{
        //     // j = 20/i;
        //     System.out.println("Enter an integer:");
        //     sc = new Scanner(System.in);
        //     num = sc.nextInt();
        // }
        // catch(Exception e){
        //     System.out.println(e);
        // }
        // finally{
        //     // this is printed irrespective of whether the try or catch i.e exception has occurred
        //     // this is useful when we are closing the resources(file,input,connections etc.) like Input resource like bufferedreader or scanner objects
        //     sc.close();
        //     System.out.println("Your Entered Number: " + num);
        // }
        
        // try with resources
        // System.out.println("Enter an integer:");
        // try(Scanner sc = new Scanner(System.in)){
        //     num = sc.nextInt();
        // }
        // catch(Exception e){
        //     System.out.println(e);
        // }
        // System.out.println("Your Entered Number: " + num);

        // Threads 
        // A a = new A();
        // B b = new B();
        // get the thread priority
        // System.out.println(a.getPriority());
        // we can set the thread priority also
        // start method starts a new thread, and classes must have the run method
        // a.start();
        // try {
        //     Thread.sleep(5);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // b.start();

        // Thread vs Runnable

        // Thread is a class which implements Runnable interface which has the method run so if a class implements Runnable, it can use the run method

        // Runnable a = new A();
        // Runnable b = new B();

        // Thread t1 = new Thread(a); // thread can take runnable task
        // Thread t2 = new Thread(b);

        // t1.start();
        // t2.start();

        // using lambda expression
        // Runnable a = () -> {
        //     for(int i = 1; i <= 10; i++) {
        //         System.out.println("Hi");
        //         try {
        //             Thread.sleep(10);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //     }
        // };

        // Runnable b = () -> {
        //     for(int i = 1; i <= 10; i++) {
        //         System.out.println("Hello");
        //         try {
        //             Thread.sleep(10);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //     }
        // };

        // Thread t1 = new Thread(a);
        // Thread t2 = new Thread(b);

        // t1.start();
        // t2.start();

        // Race Condition

        // So here the main reason behind different output each time is because of the fact that threads did not completed their task and main outputs the count variable 
        // even the execution of the threads is not completed, even after waiting for the threads to stop and then output the count the value is not what we expect, it varies this is 
        // because sometimes both threads try to execute the increment operation at the same time and then increment happens only once so the output becomes less than 2000.
        // one solution is to use synchronised before the increment method to ensure only one thread can work on the method
        
        
        // Counter c = new Counter();

        // Runnable a = () -> {
        //     for(int i = 1; i <= 10000; i++) {
        //         c.increment();
        //     }
        // };

        // Runnable b = () -> {
        //     for(int i = 1; i <= 10000; i++) {
        //         c.increment();
        //     }
        // };

        // Thread t1 = new Thread(a);
        // Thread t2 = new Thread(b);

        // t1.start();
        // t2.start();
        // try {
        //     t1.join();
        //     t2.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // System.out.println(c.count);

        
    }
    
}