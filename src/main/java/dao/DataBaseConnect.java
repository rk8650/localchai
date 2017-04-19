package main.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by rahul on 4/5/2017.
 */

//import java.sql.*;
public class DataBaseConnect {

    public static Statement getStatement()throws SQLException
    {
        Connection con=null;
        Statement st=null;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rahul");
            st=con.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("do handle the exceptions");
        }
        return st;
    }
}
