package com.divyalekha.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper{


    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME ="detail.db";
    public static final String TABLE_NAME = "detail" ;
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME ="name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "pwd";
    SQLiteDatabase db;
    public static final String TABLE_CREATE = "CREATE TABLE" + TABLE_NAME + "(" +
            COLUMN_ID + "Integer primary key "+
            COLUMN_NAME + "text not null " +
            COLUMN_EMAIL + "text not null " +
            COLUMN_PASSWORD + "text not null" + ");";
    public DBHelper(Context context)
        {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
        }

    public void insertDetail(detail d)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from  detail ";
        Cursor cursor = db.rawQuery(query ,null );
        int count = cursor.getCount();
        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME,d.getName());
        values.put(COLUMN_EMAIL,d.getEmail());
        values.put(COLUMN_PASSWORD,d.getPwd());


        db.insert(TABLE_NAME,null,values);
        db.close();


    }
    public String searchpwd(String name)
    {
        db = this.getReadableDatabase();
        String query = "select name, pwd from " + TABLE_NAME ;
        Cursor cursor= db.rawQuery(query,null);
        String a ,b  ;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do
            {
                a = cursor.getString(0);
                if(a.equals(name))
                {
                    b = cursor.getString(1);
                    break;
                }

            }while(cursor.moveToNext());
        }
        return b;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       String query =  "CREATE TABLE" + TABLE_NAME + "(" +
                COLUMN_ID + "Integer primary key "+
                COLUMN_NAME + "text not null " +
                COLUMN_EMAIL + "text not null " +
                COLUMN_PASSWORD + "text not null" + ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
