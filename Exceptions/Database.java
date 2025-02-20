package Exceptions;

import java.sql.SQLException;

public class Database {
    void executeQuery() throws SQLException{
        System.out.println("Everything went well");
        //50 lines of code
    }

    void performMath() throws ArithmeticException{
        System.out.println(1/0);
    }
}
