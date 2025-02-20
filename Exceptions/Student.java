package Exceptions;

import java.sql.SQLException;
import java.util.ArrayList;

public class Student {
    int rollNo;
    Database database;
    private ArrayList<Integer> ls;
    public Student(int rollNo){
        this.rollNo = rollNo;
        database = new Database();
        ls = new ArrayList<>();
    }
    void findByRoll() throws SQLException, ClassNotFoundException{
        //the student data is present in the db => Student
        //executeQuery()
        if(rollNo > 10){
            //
            database.executeQuery(); //Checked exception
        }else if(rollNo < 8){
            database.performMath();
            throw new ClassNotFoundException();
            //System.out.println(100/0);
        }else{
            if(rollNo > 0 && rollNo < ls.size()) {
                ls.get(rollNo); //5, 7
            }
//            throw new ArithmeticException();
//            throw ClassNotFoundException
        }


    }

    void checkOddEven() {
        if(rollNo % 2 == 0){
            try {
                throw new EvenNumberException("The roll no is even");
            }catch (EvenNumberException e){

            }
        }else if(rollNo % 2 == 1){
            throw new OddNumberException("The roll no is odd");
        }
    }


    void doSomething() {
        try {
            database.executeQuery();
        }catch (SQLException sqlException){
            //I will retry logic
            //handle the exception
            //throw new ClassNotFoundException();
        }
    }
}


/*
Application code ----> Database


an exception comes
 */