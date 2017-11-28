package com.example.hpfolio.myui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP FOLIO on 11/23/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Friends";
    private static final String TABLE_NAME = "friendsP";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(name VARCHAR , email VARCHAR, id (INT (3))PRIMARY KEY )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    public long insertFriend(String name, String email) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);

        long insertFriendData = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        return insertFriendData;

    }

    public Cursor getFriends(String name) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE name='" + name + "'", null);
        return c;
    }

    public void deleteFriend(String email) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, "email = '" + email + "'", null);
    }

    public void updateFriend(String email,String name)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        sqLiteDatabase.update(TABLE_NAME,contentValues,"email = '"+email+"'",null);
    }
}