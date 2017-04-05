package main.java.dao;

import java.sql.ResultSet;

/**
 * Created by rahul on 4/5/2017.
 */
public class DataBaseQuery {

    ResultSet rs;

    //------------------------------------------------------------------------------------------------------------------

    public ResultSet getAvailableShops()throws Exception{
        rs=DataBaseConnect.getStatement().executeQuery("SELECT * from SHOPDETAILS");

        return rs;
    }
}
