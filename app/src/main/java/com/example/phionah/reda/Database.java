package com.example.phionah.reda;

public class Database {
    public static final String NAME = "Users";
    public static final int VERSION =1;

    //Users Table
    public static final class User{
        public static final String NAME = "Users"; //Table Name

        //Following are column names
        public static final String UID = "uid";
        public static final String FirstNAME = "firstname";
        public static final String LastNAME = "lastname";
        public static final String Phone = "phone";
        public static final String Email = "email";

        //Create Query For this Table
        public static final String CREATE_QUERY =
                "CREATE TABLE IF NOT EXISTS " +
                        User.NAME + " (" +
                        User.UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        User.FirstNAME + " TEXT, " +
                        User.LastNAME + " TEXT, " +
                        User.Phone + " PHONE " +
                        User.Email + " EMAIL " +
                        ")";
    }
}

