package com.kb.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private final String TAG = MyDatabaseHelper.class.getSimpleName();

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "user_db";
    private static final String TABLE_USER = "user_details";
    private static final String ID = "id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";


    //Create Tables
    String CREATE_USER_TABLE = "CREATE TABLE "
            + TABLE_USER
            + "("
            + ID
            + " INTEGER PRIMARY KEY,"
            + FIRST_NAME
            + " TEXT,"
            + LAST_NAME
            + " TEXT,"
            + EMAIL
            + " TEXT,"
            + PASSWORD
            + " TEXT"
            + ")";


    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void saveUser(UserDataModel userDataModel) {
        Log.e(TAG, "saveUser: ");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FIRST_NAME, userDataModel.getFirstName());
        values.put(LAST_NAME, userDataModel.getLastName());
        values.put(EMAIL, userDataModel.getEmail());
        values.put(PASSWORD, userDataModel.getPassword());
        db.insert(TABLE_USER, null, values);
    }


    public boolean isValidUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String whereColumns = EMAIL + "= ?" + " AND " + PASSWORD + "= ?";
        String[] whereArguments = {email, password};
        Cursor cursor = db.query(TABLE_USER, null, whereColumns, whereArguments, null, null, null, null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.close();
                return true;
            }
        }
        return false;
    }


    public UserDataModel getUser(String email, String password) {
        UserDataModel userDataModel = new UserDataModel();
        SQLiteDatabase db = this.getReadableDatabase();
        String whereColumns = EMAIL + "= ?" + " AND " + PASSWORD + "= ?";
        String[] whereArguments = {email, password};
        Cursor cursor = db.query(TABLE_USER, null, whereColumns, whereArguments, null, null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            userDataModel.setFirstName(cursor.getString(cursor.getColumnIndexOrThrow(FIRST_NAME)));
            userDataModel.setFirstName(cursor.getString(cursor.getColumnIndexOrThrow(LAST_NAME)));
            userDataModel.setFirstName(cursor.getString(cursor.getColumnIndexOrThrow(EMAIL)));
            userDataModel.setFirstName(cursor.getString(cursor.getColumnIndexOrThrow(PASSWORD)));
            cursor.close();
        }
        return userDataModel;
    }


    public ArrayList<UserDataModel> getAllUsers() {
        ArrayList<UserDataModel> userDataModelArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER, null, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                UserDataModel userDataModel = new UserDataModel();
                userDataModel.setFirstName(cursor.getString(cursor.getColumnIndexOrThrow(FIRST_NAME)));
                userDataModel.setFirstName(cursor.getString(cursor.getColumnIndexOrThrow(LAST_NAME)));
                userDataModel.setFirstName(cursor.getString(cursor.getColumnIndexOrThrow(EMAIL)));
                userDataModel.setFirstName(cursor.getString(cursor.getColumnIndexOrThrow(PASSWORD)));
                userDataModelArrayList.add(userDataModel);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return userDataModelArrayList;
    }

    public void updateUserName(String email, String newFirstName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FIRST_NAME, newFirstName);
        String whereColumns = EMAIL + "= ?";
        String[] whereArguments = {email};
        db.update(TABLE_USER, values, whereColumns, whereArguments);
    }

    public void deleteUser(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        String whereColumns = EMAIL + "= ?";
        String[] whereArguments = {email};
        db.delete(TABLE_USER, whereColumns, whereArguments);
    }
}