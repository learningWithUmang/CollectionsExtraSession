package Exceptions;

import java.sql.SQLException;

public class Client {

    /*
    Exceptions:- unwanted or unexpected behaviour that happens during the
    execution of your program.

    1
    2
    3 --> an exception occured, entire execution will stop here until this exception is handled.
    4
    5
    6
     */
    public static void main(String[] args) {
        Student student = new Student(0);

        try {
            student.findByRoll();
        } catch (SQLException sqlException){
            System.out.println("Some SQL Exception has occured");
        } catch (ClassNotFoundException classNotFoundException){
            System.out.println("Class not found exception has occured");
        }
    }
}
/*

traverse(root){
    if(root == null) return;

    access root.left & root.right
}
Types of exceptions
1. RunTime exceptions/Unchecked  - That happen at run time, they are unknown at compile time. Java doesn't
enfocre you to handle these exceptions.

Ex - artihmetic exception, Index out of bound exception, etc.

2. Checked exceptions - That are visible at compile time. Java enforces you to handle or throw further
such types of exceptions. Java will ask you to do something about it.

Ex - SQLEXception, ClassNotFoundException, etc.


IndexOfOutBoundException ---> RunTimeException ---> Exception ---> Throwable
ArithmeticException ---> RunTimeException ---> Exception ---> Throwable


All RTE inherit from RunTimeException class
whereas all checked exception directly inherits from Exception
 */