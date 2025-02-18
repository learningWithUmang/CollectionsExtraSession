import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambdas {
    /*
    Lambdas
    Streams

    1. Lambdas

    Runnable
    Callable
    Comparator
    Comparable

    All the above interfaces requires 1 method to be implemented.
    Functional interfaces - Those interfaces which requires / demands only one method to be implemented by the class.

    <<I>>
        abstract m1
                 m2
                 m3
        default m4
    Class ---> <<I>>
        implement m1,m2,m3

    Abstract method - incomplete method which requires implementation.

    Lambdas should come to your mind when you see a functional interface.

    Lambda expression:- () -> {}
    (input params) -> {output}

     */
    public static void main(String[] args) {
        Student std1 = new Student("Umang", 26, 2);
        Student std2 = new Student("Anmol", 30, 6);
        Student std3 = new Student("Vishnu", 29, 3);

        List<Student> lsStudents = new ArrayList<>(List.of(std1, std2, std3));


        Collections.sort(lsStudents); //sorted as per the natural ordering defined inside the class

        Collections.sort(lsStudents, new AgeComparator()); //sort as per the age.

        //sort as per the roll.
        Collections.sort(lsStudents, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if(s1.roll < s2.roll){
                    return -1;
                }else{
                    return 1;
                }
            }
        });

        // () -> {}
        Collections.sort(lsStudents, (Student s1, Student s2) -> s1.roll - s2.roll);

        Collections.sort(lsStudents, (Student s1, Student s2) -> s1.name.compareTo(s2.name));

        /*
        Lambdas are just to make your code brief
        It's just a syntactical sugar to your code

         */

        /*
        Runnable
        I want to define a task to print Hello World.
         */

        //1 way

        HelloWorldTask helloWorldTask = new HelloWorldTask();
        Thread t1 = new Thread(helloWorldTask); //helloWorldTask an object of runnable??
        t1.start();

        //2 way

        Runnable r2 = new HelloWorldTask();
        Runnable r = () -> {
            System.out.println("Hello world from runnable");
        };
        Thread t3 = new Thread(r);
        t3.start();

        //3 way
        Thread t2 = new Thread(() -> System.out.println("Hello from the lambda task"));
        t2.start();

        //() -> { } if you have multiple lines in the impl, you use curly braces, otherwise
        //() -> mention the line

        /*
        Problem statement: - I want to perform basic arithmetic operations on 2 variables
        addition
        subtraction
        multiplication
        etc
         */

        ArithmeticOperation arithmeticOperation = new Addition();
        int res = arithmeticOperation.operate(2,5);
        System.out.println(res);

        ArithmeticOperation arithmeticOperation2 = new Subtraction();
        int res2 = arithmeticOperation2.operate(2,4);
        System.out.println(res2);

        ArithmeticOperation arithmeticOperation3 = (a, b) -> {
            return a + b;
        };

        ArithmeticOperation arithmeticOperation4 = (a, b) -> {
            return a*b;
        };

        System.out.println(arithmeticOperation3.operate(7,9));
        System.out.println(arithmeticOperation4.operate(2,8));

        ArithmeticOperation complexOp = (a, b) -> {
            if(a < b) return a - b;
            else if(a > b) return a + b;
            else return a / b;
        };

        System.out.println(complexOp.operate(2,9));

        //Clear??
        //Lambdas are helpful when you see objects of classes implementing functional interfaces
        //directly provide the method implementation in the form of a lambda expression
        //5 minutes
        //Streams
    }
}

