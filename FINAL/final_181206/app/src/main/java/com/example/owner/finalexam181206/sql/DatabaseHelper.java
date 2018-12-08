package com.example.owner.finalexam181206.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.owner.finalexam181206.Beer;
import com.example.owner.finalexam181206.model.Favorite;
import com.example.owner.finalexam181206.model.User;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";

    // User table name
    private static final String TABLE_USER = "user";
    private static final String TABLE_FAVOR = "favorite";
    public static final String TABLE_BEER = "beer";
    // User Table Columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    private static final String COLUMN_FAVOR_NUM = "favor_num";
    private static final String COLUMN_FAVOR_ID = "favor_id";
    private static final String COLUMN_FAVOR_BEER = "favor_beer";
    private static final String COLUMN_BEER_ID = "id";
    private static final String COLUMN_BEER_BEERNAME = "beername";
    private static final String COLUMN_BEER_BRAND = "barnd";
    private static final String COLUMN_BEER_ARCOHOL = "arcohol";
    private static final String COLUMN_BEER_RATING = "rating";
    private static final String COLUMN_BEER_KEY = "key";

    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";

    private String CREATE_FAVOR_TABLE = "CREATE TABLE " + TABLE_FAVOR  + "(" + COLUMN_FAVOR_NUM
            + " INTEGER PRIMARY KEY AUTOINCREMENT,  " +  COLUMN_FAVOR_ID + " INTEGER NOT NULL,"
            + COLUMN_FAVOR_BEER + " TEXT NOT NULL, FOREIGN KEY(favor_id) REFERENCES user(user_id))";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    /**
     * Constructor
     * 
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_FAVOR_TABLE);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);
        String sqlFavor = "DROP TABLE IF EXISTS tracks";
        db.execSQL(sqlFavor);

        // Create tables again
        onCreate(db);

    }
    public void addFavor(Favorite favorite) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FAVOR_BEER, favorite.getNum());
        values.put(COLUMN_FAVOR_BEER, favorite.getId());
        values.put(COLUMN_FAVOR_BEER, favorite.getBeer());
        db.insert(TABLE_FAVOR, null, values);
        db.close();
    }

    public void addbeer(Beer beer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_BEER_BEERNAME, beer.getBeername());
        values.put(COLUMN_BEER_BRAND, beer.getBrand());
        values.put(COLUMN_BEER_ARCOHOL, beer.getArcohol());
        values.put(COLUMN_BEER_RATING, beer.getRating());
        values.put(COLUMN_BEER_KEY, beer.getKey());
        db.insert(TABLE_BEER, null, values);
        db.close();
    }
    /**
     * This method is to create user record
     *
     * @param user
     */
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    /**
     모든 사용자를 가져와 사용자 레코드 목록을 반환
     *
       */
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_EMAIL,
                COLUMN_USER_NAME,
                COLUMN_USER_PASSWORD
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * 여기서 쿼리 기능은 사용자 테이블에서 레코드를 가져오기 위해 사용된다. 이 기능은 우리가 sql 쿼리를 사용하는 것처럼 작동한다.
         * 이 쿼리 기능과 동등한 SQL 쿼리
         * SELECT user_id,user_name,user_email,user_password by user_name 사용자 ORDER by user_name
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    /**
     * This method to update user record
     *
     * @param user
     */
    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * This method is to delete user record
     *
     * @param user
     */
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @return true/false
     */
    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @param password
     * @return true/false
     */
    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // 선택 기준
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // 변수 선택
        String[] selectionArgs = {email, password};

            // 특정 사용자 테이블 쿼리
        /**
         * 여기서 쿼리 기능은 사용자 테이블에서 레코드를 가져오기 위해 사용된다. 이 기능은 우리가 sql 쿼리를 사용하는 것처럼 작동한다.
         * 이 쿼리 기능과 동등한 SQL 쿼리
         * user_email = 'jack@androidtutorialshub.com' 및 user_password = 'qwerty'인 사용자로부터 user_id 선택
         * */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

}
