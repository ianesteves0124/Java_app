package com.noob.crudapp;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DB {
    
    private static final String DB_USER_NAME = "postgres";
    private static final String DB_PASSWORD = "stinggreen";
    private static String DB_URL = "jdbc://postgresql://localhost/";
    private Connection conn = null;
    private ResultSet res = null;
    private int recordCount = 0;
    
    
    public boolean connectProject (String Java_DB){
        boolean retValue = false;
        
        switch(Java_DB){
            case "postgres":
            try{
                conn = DriverManager.getConnection(DB_URL + Java_DB,DB_USER_NAME,DB_PASSWORD);
            }catch(SQLException e){
                System.err.println(e);
                retValue = false;
            }
        }
        return retValue;
    }
    
    public ResultSet query(PreparedStatement ps){
        ResultSet retValue = null;
        
        try {
            ResultSet thisRes = ps.executeQuery();
            res = thisRes;
            retValue = thisRes;
            
            res.last();
            recordCount = res.getRow();
            res.absolute(0);
            
            return retValue;
            
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return retValue;
    }
    
    public int fetchRecordCount(){
        return recordCount;
    }
    
    public void closeConnection(){
        try{
            conn.close();
        }catch(SQLException ex){
            System.err.println(ex);
        }
    }
    
    public Connection getConn(){
        return conn;
    }
}
