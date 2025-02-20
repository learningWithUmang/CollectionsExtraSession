import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        /*
        Stream - data flow like a river

        Data source (DB)
        1. Bring all the products from the database(disk) to your memory
        2. 10k products in your memory

        products = [] , 10k products in your memory
        for(Product p : products){
        //3000th products, 2999 previous
            print(p.getName());
        }

        Stream attached to a data source
         */

        List<Integer> ls1 = List.of(1,5,2,3,9,8,6);

        Stream<Integer> s1 = ls1.stream(); //pipeline
        //System.out.println(s1.limit(2).count());

        //s1.sorted();

        //On top of a stream, you can run multiple methods
        //[------] ----> m1 -----> m2 ----> m3 ---> mn ---> output
        //intermediate, terminal methods
        //you can use lambdas to implement the method code inside the streams
        s1.forEach((elem) -> {
            System.out.print(elem + " ");
        });
        System.out.println();

        //filter, map, reduce, limit, forEach are stream methods

        List<Integer> filteredElements = ls1
                .stream()
                .filter((elem) -> elem % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(filteredElements);


        Long countOfEvenElements = ls1
                .stream()
                .filter((elem) -> elem % 2 == 0)
                .count();

        System.out.println(countOfEvenElements);

        Stream<Integer> s4 = ls1.stream();

        List<Integer> filteredElementsSquares =
                s4
                .filter((elem) -> elem % 2 == 0)
                .map((elem) -> elem * elem)
                .collect(Collectors.toList());

        //s4.sorted();



        System.out.println(filteredElementsSquares);

        //HW - I can get for every element, what's the frequency
        //entrySet
        //forEach
        //groupbY

        List<Integer> filteredElementsSquaresSorted = ls1
                .stream()
                .filter((elem) -> elem % 2 == 0)
                .map((elem) -> elem * elem)
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());

        System.out.println(filteredElementsSquaresSorted);

        Optional<Integer> filteredElementsSquaresSortedFirstElem = ls1
                .stream()
                .filter((elem) -> elem % 2 == 0)
                .map((elem) -> elem * elem)
                .sorted((a, b) -> b - a)
                .findFirst();

        //optional variables are used when it can be null

        if(filteredElementsSquaresSortedFirstElem.isPresent()){
            System.out.println(filteredElementsSquaresSortedFirstElem.get());
        }else{
            System.out.println("All elements were odd in the list");
        }

        //reduce - decrease
        //takes a collection of elements and reduces it to a single value

        Integer sum = 0;
        for(Integer elem: ls1){
            sum += elem;
        }

        System.out.println("Sum of all elements : " + sum);

        Optional<Integer> sum2 = ls1
                .stream()
                .reduce((a, b) -> a + b);

        if(sum2.isPresent()) {
            System.out.println(sum2.get());
        }else{
            System.out.println("List was empty");
        }

        Optional<Integer> sumOfallfilteredElements = ls1
                .stream()
                .filter((elem) -> elem % 2 == 0)
                .map((elem) -> elem * elem)
                .sorted((a, b) -> b - a)
                .reduce((a,b) -> a + b);

        Integer sumOfallfilteredElements2 = ls1
                .stream()
                .filter((elem) -> elem % 2 == 0)
                .map((elem) -> elem * elem)
                .sorted((a, b) -> b - a)
                .reduce(0, (a,b) -> a + b);







        if(sumOfallfilteredElements.isPresent()){
            System.out.println(sumOfallfilteredElements.get());
        }

        //Streams -> optimises the time as well as memory usage internally
        //streams

        Optional<Integer> minOfAll = ls1
                .stream()
                .filter((elem) -> elem % 2 == 0)
                .map((elem) -> elem * elem)
                .sorted((a, b) -> b - a)
                .reduce((a,b) -> Math.min(a,b));

        System.out.println(minOfAll.get());

        Integer minOfAll2 = ls1
                .stream()
                .filter((elem) -> elem % 2 == 0)
                .map((elem) -> elem * elem)
                .sorted((a, b) -> b - a)
                .reduce(Integer.MAX_VALUE, (a,b) -> Math.min(a,b));

        System.out.println(minOfAll2);

        /*
        1. Readability and Conciseness : Java introduced various methods also with the streams that we will be seeing after some time which makes the code much readable and concise too.

        2. Parallel Execution : Streams make it very easy to implement parallelism we can have parallel lines to managae the data fastly and efficiently.

        3. Lazy Evaluvation : Stream will not evaluvate an operation unless needed. For example: I can have a list and using the streams I can multiply all the elements by 2 without evaluvation then remove some element with some condition and Streams will do the evaluvation only once we call it. This reuslts in huge performace gains.
        done with the class

         */

        /*
        Beautifying your code.
        keep learning/reading
        
         */

    }
}

