import java.util.*;

public class Client {
    /*
    Collections interface
    1. List interface - ordered collection of elements.
        i. ArrayList - Resizable-array implementation of the List interface.
        ii. LinkedList - Doubly-linked list implementation of the List and Deque interfaces.
        iii. Vector - thread safe DS, preferable in multithreaded environment
        iv. Stack - thread safe

    2. Set interface - unique elements, constant time operations for add/remove/find/etc, not synchronised
        i. Hashset - random order
        ii. LinkedHashSet - insertion order
        iii. TreeSet - natural ordering/ increasing / sorted

    3. Queue interface - FIFO(First In first out)
        i. Priority Queue - Min heap(default).
        2. Array Deque - going to act like a doubly ended queue

        access first element
        access last element
        remove first element
        remove last element
        O(1) - Deque

        access min element - O(1)
        remove min element   - O(logN)
        Heap(Min heap)

     */
    public static void main(String[] args) {
        //Animal <--- Dog (Animal a = new Dog())
        List<String> ls1 = new ArrayList<>();

        ls1.add("Umang");
        ls1.add("Anmol");
        ls1.add("Uma");
        ls1.add("Vishnu");

        /*
        [1,2,4,5]
        [1-->2--->4--->5]
        remove/delete
        finding the element
         */

        System.out.println(ls1);

        List<String> ls2 = new LinkedList<>();
        ls2.add("Anmol");
        ls2.add("Uma");
        ls2.add("Umang");
        ls2.add("Vishnu");

        System.out.println(ls2);

        /*
        LinkedList - collection of nodes
        Singly linked list :- value, ptr
        1 --> 2 ---> 3
        Doubly linked list: - value, ptr to next node, ptr to prev node
                 1--->2--->3--->NULL
         NULL<---- <--- <---






         Implement arrays using DLL - LinkedList
         */


        List<String> ls3 = new Vector<>();
        //[1,2,3,4,5,]
        List<String> ls4 = new Stack<>();
        /*
        LIFO principle
        push
        pop
        top
        empty
        size
        etc
         */

        /*
        No order confirmation, the elements could be random
         */
        Set<String> st1 = new HashSet<>();

        st1.add("Umang");
        st1.add("Rajneesh");
        st1.add("Anmol");
        st1.add("Ashish");
        st1.add("Tanya");

        System.out.println(st1);

        /*
        Order is retained, ordered collection
         */
        Set<String> st2 = new LinkedHashSet<>();

        st2.add("Umang");
        st2.add("Rajneesh");
        st2.add("Anmol");
        st2.add("Ashish");
        st2.add("Tanya");

        System.out.println(st2);

        /*
        Sorted as per lexicographical order
         */
        Set<String> st3 = new TreeSet<>();

        st3.add("Umang");
        st3.add("Rajneesh");
        st3.add("Anmol");
        st3.add("Ashish");
        st3.add("Tanya");

        System.out.println(st3);


        Queue<String> q1 = new PriorityQueue<>(); //min heap by default
        q1.offer("Umang");
        q1.offer("Rajneesh");
        q1.offer("Anmol");

        //natural ordering of strings - lexicographical/ dictionary

        System.out.println(q1.peek()); //root // O(1) operation

        Queue<String> q2 = new ArrayDeque<>();
        q2.offer("Umang");
        q2.offer("Rajneesh");
        q2.offer("Anmol");

        /*
        ---> Anmol Rajneesh Umang --->
         */
        System.out.println(q2.peek());

        /*
        Min heap
        gives you smallest element in O(1)

        Max Heap
        gives you max element in O(1)

        Internally heap is a complete binary tree
        where the root is either min/max based on heap type
         */

        /*
        Comparable and Comparator interface
         */

        String s1 = "Umang";
        String s2 = "Anmol";
        System.out.println("Testing compareto method " + s1.compareTo(s2)); // +ive
        System.out.println("Testing compareto method " + s2.compareTo(s1)); //-ive

        Queue<String> q3 = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) { //s1 = "Umang", s2 = "Anmol"
                //you tell your order
                //if you want s1 to come first, return negative value
                //if you want s2 to come first, return positive value
                //return zero - order doesn't matter
                //if s1 < s2 => -ive else +ive s1 = Umang, s2 = Anmol
                return s2.compareTo(s1);

                //if s1 < s2 => -ive => s1 will come first
            }
        });

        q3.offer("Umang");
        q3.offer("Rajneesh");
        q3.offer("Anmol");
        //< > <= >= Lexicographically

        while(!q3.isEmpty()){
            System.out.println(q3.peek());
            q3.poll();
        }

        //Whenever you want to disturb/distort the natural ordering of elements, you should think about comparator
        //Custom sorting - Comparators


        Student std1 = new Student("Umang", 26);
        Student std2 = new Student("Anmol", 30);
        Student std3 = new Student("Vishnu", 29);

        List<Student> lsStudents = new ArrayList<>();
        lsStudents.add(std1);
        lsStudents.add(std2);
        lsStudents.add(std3);



        /*

         */
        System.out.println("Before sorting");
        for(Student st: lsStudents){
            System.out.println(st.name + " " + st.age);
        }

        Collections.sort(lsStudents);

        System.out.println("After sorting without comparators");
        for(Student st: lsStudents){
            System.out.println(st.name + " " + st.age);
        }




        Collections.sort(lsStudents, new AgeComparator());


        System.out.println("Sorted using age comparator");




        for(Student st: lsStudents){
            System.out.println(st.name + " " + st.age);
        }

        List<Integer> lsIntegers = new ArrayList<>();
        lsIntegers.add(1);
        lsIntegers.add(5);
        lsIntegers.add(2);
        System.out.println(lsIntegers);

        Collections.sort(lsIntegers, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                //a to come first when a > b => decreasing order
                if(a > b){
                    return -1;
                }else if(b > a){
                    return 1;
                }else {
                    return 0;
                }
            }
        });

        System.out.println(lsIntegers);
    }

    /*
    Comparable is used to define the natural ordering of any class.
    Comparator is used to define custom sorting to override the natural ordering.
     */

    Map<Integer, Integer > mp1 = new HashMap<>(); //HW1
    Map<Integer, String> mp2 = new TreeMap<>(); //HW2

    //Read the difference between hashmap and treemap
    //Hint - hashset and treeset
}


/*
Selection sort

for(){
    for(){
        if(comapre(a[i], a[j]){



Merge sort

void merge(int[], int[]){
    p1 p2


    if(comapre(a[p1], b[p2])){
       ...
 */