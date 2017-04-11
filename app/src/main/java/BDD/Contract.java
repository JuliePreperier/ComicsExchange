package BDD;

import android.icu.lang.UScript;
import android.provider.BaseColumns;

/**
 * Created by Julie on 11.04.2017.
 */

public final class Contract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private Contract() {}

    /*Inner class that defines the table contents*/

    // inner class dataTable Authors
    public static class Authors implements BaseColumns{
        public static final String TABLE_NAME = "Authors";
        public static final String COLUMN_NAME_FIRSTNAME = "First name";
        public static final String COLUMN_NAME_LASTNAME = "Last name";
    }
    // method create datatable Authors
    public static final String SQL_CREATE_AUTHORS =
            "CREATE TABLE " + Authors.TABLE_NAME + "(" +
                    Authors._ID + " int NOT NULL PRIMARY KEY, " +
                    Authors.COLUMN_NAME_FIRSTNAME + " varchar(255), " +
                    Authors.COLUMN_NAME_LASTNAME + " varchar(255)" +
                    ")";

    // Method delete dataTable Authors
    public static final String SQL_DELETE_AUTHORS =
            "DROP TABLE IF EXISTS " + Authors.TABLE_NAME;

    // inner class dataTable Series
    public static class Series implements BaseColumns{
        public static final String TABLE_NAME = "Series";
        public static final String COLUMN_NAME_SERIENAME = "Name";
        public static final String COLUMN_NAME_EDITION_HOUSE = "Edition house";
        public static final String COLUMN_NAME_IDAUTHOR = "Id author";
    }

    // method create datatable Series
    public static final String SQL_CREATE_SERIES =
            "CREATE TABLE " + Series.TABLE_NAME + "(" +
                    Series._ID + " int NOT NULL PRIMARY KEY, " +
                    Series.COLUMN_NAME_SERIENAME + " varchar(255), " +
                    Series.COLUMN_NAME_EDITION_HOUSE + " varchar(255), " +
                    Series.COLUMN_NAME_IDAUTHOR + " int NOT NULL, " + // FOREIGN KEY
                    "FOREIGN KEY (" + Series.COLUMN_NAME_IDAUTHOR+")" +
                    " REFERENCES "+Authors.TABLE_NAME+"("+Authors._ID+")" +
                    ")";

    // Method delete dataTable Series
    public static final String SQL_DELETE_SERIES =
            "DROP TABLE IF EXISTS " + Series.TABLE_NAME;

    // inner class dataTable Books
    public static class Books implements BaseColumns{
        public static final String TABLE_NAME = "Books";
        public static final String COLUMN_NAME_IDAUTHOR = "Id author";
        public static final String COLUMN_NAME_IDSERIE = "Id serie";
        public static final String COLUMN_NAME_LANGUAGE = "Language";
        public static final String COLUMN_NAME_PHOTO = "Photo";
    }

    // Method create dataTable Books
    public static final String SQL_CREATE_BOOKS =
            "CREATE TABLE " + Books.TABLE_NAME + " ( " +
                    Books._ID + " int NOT NULL PRIMARY KEY, " +
                    Books.COLUMN_NAME_IDAUTHOR + " int NOT NULL, " + //FOREIGN KEY
                    Books.COLUMN_NAME_IDSERIE + " int NOT NULL, " + // FOREIGN KEY
                    Books.COLUMN_NAME_LANGUAGE + " varchar(255), " +
                    Books.COLUMN_NAME_PHOTO + " varchar(255), " +
                    "FOREIGN KEY (" + Books.COLUMN_NAME_IDSERIE+")" +
                    " REFERENCES " + Series.TABLE_NAME + "("+Series._ID+"), " +
                    "FOREIGN KEY (" + Books.COLUMN_NAME_IDAUTHOR+")" +
                    " REFERENCES " + Authors.TABLE_NAME + "("+Authors._ID+")" +
                    ")"; // PHOTO

    // Method delete dataTable Books
    public static final String SQL_DELETE_BOOKS =
            " DROP TABLE IF EXISTS "+ Books.TABLE_NAME;

    // inner class dataTable Users
    public static class Users implements BaseColumns{
        public static final String TABLE_NAME = "Users";
        public static final String COLUMN_NAME_FIRSTNAME = "First name";
        public static final String COLUMN_NAME_LASTNAME = "Last name";
        public static final String COLUMN_NAME_USERNAME = "Username";
        public static final String COLUMN_NAME_PASSWORD = "Password";
        public static final String COLUMN_NAME_LANGUAGE = "Language";
    }

    // Method create dataTable Users
    public static final String SQL_CREATE_USERS =
            " CREATE TABLE " + Users.TABLE_NAME + " ( " +
                    Users._ID + " int NOT NULL PRIMARY KEY, " +
                    Users.COLUMN_NAME_FIRSTNAME + " varchar(255), " +
                    Users.COLUMN_NAME_LASTNAME + " varchar(255), " +
                    Users.COLUMN_NAME_USERNAME + " varchar(255), " +
                    Users.COLUMN_NAME_PASSWORD + " varchar(255), " +
                    Users.COLUMN_NAME_LANGUAGE + " varchar(255)" +
                    ")";

    // Method delete dataTable Users
    public static final String SQL_DELETE_USERS =
            "DROP TABLE IF EXISTS "+ Users.TABLE_NAME;

    // inner class dataTable OwnerBooks
    public static class Ownerbooks implements BaseColumns{
        public static final String TABLE_NAME = "Ownerbooks";
        public static final String COLUMN_NAME_IDUSER = "Id user";
        public static final String COLUMN_NAME_IDBOOK = "Id book";
    }

    // Method create dataTable OwnerBooks
    public static final String SQL_CREATE_OWNERBOOKS =
            " CREATE TABLE " + Ownerbooks.TABLE_NAME + " ( " +
                    Ownerbooks._ID + " int PRIMARY KEY, " +
                    Ownerbooks.COLUMN_NAME_IDUSER + " int NOT NULL, " + // FOREIGN KEY
                    Ownerbooks.COLUMN_NAME_IDBOOK + " int NOT NULL, " + // FOREIGN KEY
                    "FOREIGN KEY (" +Ownerbooks.COLUMN_NAME_IDBOOK+")" +
                    " REFERENCES "+Books.TABLE_NAME+"("+Books._ID+")," +
                    "FOREIGN KEY (" + Ownerbooks.COLUMN_NAME_IDUSER+")"+
                    " REFERENCES "+Users.TABLE_NAME+"("+Users._ID+")" +
                    ")";

    public static final String SQL_DELETE_OWNERBOOKS =
            " DROP TABLE IF EXISTS " + Ownerbooks.TABLE_NAME;





}
