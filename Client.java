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
        //Break of 10 min - 10:31 PM
    }
}
