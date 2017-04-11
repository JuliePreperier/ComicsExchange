package BDD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static BDD.Contract.SQL_CREATE_AUTHORS;
import static BDD.Contract.SQL_CREATE_BOOKS;
import static BDD.Contract.SQL_CREATE_OWNERBOOKS;
import static BDD.Contract.SQL_CREATE_SERIES;
import static BDD.Contract.SQL_CREATE_USERS;
import static BDD.Contract.SQL_DELETE_AUTHORS;
import static BDD.Contract.SQL_DELETE_BOOKS;
import static BDD.Contract.SQL_DELETE_OWNERBOOKS;
import static BDD.Contract.SQL_DELETE_SERIES;
import static BDD.Contract.SQL_DELETE_USERS;

/**
 * Created by Julie on 11.04.2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Comics.db";

    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_AUTHORS);
        db.execSQL(SQL_CREATE_BOOKS);
        db.execSQL(SQL_CREATE_OWNERBOOKS);
        db.execSQL(SQL_CREATE_SERIES);
        db.execSQL(SQL_CREATE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_AUTHORS);
        db.execSQL(SQL_DELETE_BOOKS);
        db.execSQL(SQL_DELETE_OWNERBOOKS);
        db.execSQL(SQL_DELETE_SERIES);
        db.execSQL(SQL_DELETE_USERS);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }

    
}
