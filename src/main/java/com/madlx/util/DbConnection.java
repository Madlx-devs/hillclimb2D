package com.madlx.util;

public class DbConnection {

    public static DbConnection connection=null;

    private DbConnection(){
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static DbConnection getInstance() {
        if (connection == null) {
            connection = new DbConnection();
        }
        return connection;
    }
}
