package com.example.tha_app_184172h.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String ITEM = "Item";
    public static final String ID = "_id";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String PRICE = "price";
    static final String DB_NAME = " YummyFoods.DB";
    static final int DB_VERSION = 1;
    private static final String CREATE_TABLE_ITEM = "create table " + ITEM + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, " + DESCRIPTION + " TEXT, " + PRICE + " FLOAT);";
    private static final String CREATE_TABLE_Order = "create table " + ITEM + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, " + DESCRIPTION + " TEXT, " + PRICE + " FLOAT);";

    //user table name
    private static final String USER_INFOR = "User_Infor";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_ITEM);
        String user_info_Table = "CREATE TABLE " + USER_INFOR + "("
                + "name" + " TEXT,"
                + "email" + " TEXT,"
                + "mobile" + " TEXT,"
                + "password" + " TEXT" + ")";


        sqLiteDatabase.execSQL(user_info_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ITEM);
        onCreate(sqLiteDatabase);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + USER_INFOR);
        onCreate(sqLiteDatabase);
    }

    public boolean insertUserData(String name, String email, String mobile_no, String password) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cValues = new ContentValues();
        cValues.put("name", name);

        cValues.put("email", email);
        cValues.put("mobile", mobile_no);
        cValues.put("password", password);

        long result = db.insert(USER_INFOR, null, cValues);
        db.close();

        if (result == -1) {
            Log.d("error message", "error in user Data insert");
            return false;
        } else {
            return true;
        }

    }


    //login
    public boolean loginUser(String name, String password) {
        String[] columns = {"name"};
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = "name=? and password = ?";
        String[] selectionArgs = {name, password};

        Cursor cursor = db.query(USER_INFOR, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        Log.d("RESULTTTTTTTTTTTTTTTT", cursor.toString());
        cursor.close();
        db.close();

        return count > 0;
    }

    public boolean addItem(String item, String des, String price) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cValues = new ContentValues();

        cValues.put("NAME", item);
        cValues.put("DESCRIPTION", des);
        cValues.put("PRICE", price);

        long result = db.insert(ITEM, null, cValues);
        Log.d("RESULTTTTTTTTTTTTTTTT", String.valueOf(result));
//        db.close();

        if (result == -1) {
            Log.d("error message", "error in user Data insert");
            return false;
        } else {
            return true;
        }

    }

    public boolean updateItem( String name, String des, String price) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
//        contentValues.put("ID", id);
        contentValues.put("NAME", name);
        contentValues.put("DESCRIPTION", des);
        contentValues.put("PRICE", price);
        // When you want to update only name field


        // UPDATE query
        db.update(ITEM, contentValues, "NAME= ?", new String[]{name});
        return true;
    }

    //Delete data from the databse using ID (Primary Key)
    public void deleteItem(String name) {

        SQLiteDatabase db = getWritableDatabase();
        db.delete(ITEM, "NAME = ?", new String[]{name});
    }

    //get user information
    public Cursor getItemDetails() {
        String selectQuery = "SELECT * FROM " + ITEM;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result_Detail = db.rawQuery(selectQuery, null);
        Log.d("RESULTTTTTTTTTTTTTTTT", result_Detail.toString());

        return result_Detail;
    }

    /*public Cursor getUserDetails() {
        String selectQuery = "SELECT  name,email,mobile,password FROM  User_Infor WHERE name='" + LoginActivity.user_index + "'";
        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery(selectQuery, null);
    }*/
}
